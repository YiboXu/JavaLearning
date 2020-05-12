package tk.billhu.scw.project.service.impl;

import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.UserException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.billhu.scw.enums.ProjectStatusEnume;
import tk.billhu.scw.enums.UserExceptionEnum;
import tk.billhu.scw.project.entities.*;
import tk.billhu.scw.project.mapper.*;
import tk.billhu.scw.project.service.TProjectService;
import tk.billhu.scw.project.vo.request.ProjectRedisStorageVo;
import tk.billhu.scw.project.vo.response.*;
import tk.billhu.scw.util.AppDateUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TProjectServiceImpl implements TProjectService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TProjectMapper tProjectMapper;

    @Autowired
    private TProjectImagesMapper tProjectImagesMapper;

    @Autowired
    private TReturnMapper tReturnMapper;

    @Autowired
    private TProjectTypeMapper tProjectTypeMapper;

    @Autowired
    private TProjectTagMapper tProjectTagMapper;

    @Autowired
    private TProjectInitiatorMapper tProjectInitiatorMapper;

    @Autowired
    private TProjectLegalMapper tProjectLegalMapper;

    @Autowired
    private TTypeMapper tTypeMapper;

    @Autowired
    private TTagMapper tTagMapper;

    @Transactional
    @Override
    public void save(ProjectRedisStorageVo projectRedisStorageVo, ProjectStatusEnume projectStatusEnume) {
        //创建项目DO
        TProject tProject = new TProject();
        //保存项目
        tProject.setName(projectRedisStorageVo.getName());
        tProject.setRemark(projectRedisStorageVo.getRemark());
        tProject.setMoney(projectRedisStorageVo.getMoney());
        tProject.setDay(projectRedisStorageVo.getDay());
        tProject.setStatus(projectStatusEnume.getCode()+"");
        tProject.setDeploydate(AppDateUtils.getFormatTime());
        tProject.setSupportmoney(0L);
        tProject.setSupporter(0);
        tProject.setCompletion(0);
        String memberId = stringRedisTemplate.opsForValue().get(projectRedisStorageVo.getAccessToken());
        tProject.setMemberid(Integer.parseInt(memberId));
        tProject.setCreatedate(AppDateUtils.getFormatTime());
        tProject.setFollower(0);

        //主键回填, 在对应的mapper中添加 useGeneratedKeys="true" keyProperty="id"
        tProjectMapper.insertSelective(tProject);
        Integer projectId = tProject.getId();

        log.debug("项目保存成功-{}",projectId);

        //保存头部图片
        TProjectImages tProjectHeaderImages = new TProjectImages();
        tProjectHeaderImages.setProjectid(projectId);
        tProjectHeaderImages.setImgtype((byte)0);
        tProjectHeaderImages.setImgurl(projectRedisStorageVo.getHeaderImage());
        tProjectImagesMapper.insertSelective(tProjectHeaderImages);

        //保存详细图片
        List<String> imgUrls = projectRedisStorageVo.getDetailsImage();
        for(String imgUrl : imgUrls){
            TProjectImages tProjectImages = new TProjectImages();
            tProjectImages.setProjectid(projectId);
            tProjectImages.setImgtype((byte)1);
            tProjectImages.setImgurl(imgUrl);
            tProjectImagesMapper.insertSelective(tProjectImages);
        }

        log.debug("项目图片保存完毕-{}",projectId);
        //保存回报
        List<TReturn> tReturns = projectRedisStorageVo.getProjectReturns();
        for(TReturn tReturn : tReturns){
            tReturn.setProjectid(projectId);
            tReturnMapper.insertSelective(tReturn);
        }

        //保存项目和类别关系
        List<Integer> typeIds = projectRedisStorageVo.getTypeIds();
        for(Integer typeId : typeIds){
            TProjectType tProjectType = new TProjectType();
            tProjectType.setProjectid(projectId);
            tProjectType.setTypeid(typeId);
            tProjectTypeMapper.insertSelective(tProjectType);
        }

        log.debug("项目分类关系保存成功-{}",projectId);

        //保存项目和标签关系
        List<Integer> typeTags = projectRedisStorageVo.getTagIds();
        for(Integer tagId : typeTags){
            TProjectTag tProjectTag = new TProjectTag();
            tProjectTag.setProjectid(projectId);
            tProjectTag.setTagid(tagId);
            tProjectTagMapper.insertSelective(tProjectTag);
        }

        log.debug("项目标签关系保存成功-{}", projectId);

        //保存项目和发起人关系
        TProjectInitiator tProjectInitiator = new TProjectInitiator();
        tProjectInitiator.setProjectid(projectId);
        tProjectInitiator.setSelfintroduction(projectRedisStorageVo.getSelfintroduction());
        tProjectInitiator.setDetailselfintroduction(projectRedisStorageVo.getDetailselfintroduction());
        tProjectInitiator.setTelphone(projectRedisStorageVo.getTelphone());
        tProjectInitiator.setHotline(projectRedisStorageVo.getHotline());

        tProjectInitiatorMapper.insertSelective(tProjectInitiator);

        log.debug("项目发起人信息保存成功-{}",projectId);

        //保存项目和法人关系
        TProjectLegal tProjectLegal = new TProjectLegal();
        tProjectLegal.setProjectid(projectId);
        tProjectLegal.setAccount(projectRedisStorageVo.getAccount());
        tProjectLegal.setCardnum(projectRedisStorageVo.getCardnum());

        tProjectLegalMapper.insertSelective(tProjectLegal);

        log.debug("项目法人信息保存成功-{}",projectId);

        //清理redis
        stringRedisTemplate.delete(projectRedisStorageVo.getProjectToken());
    }

    @Override
    public List<ProjectGeneralInfoVo> getProjectGeneralInfoList() {
        //获取项目信息
        TProjectExample tProjectExample = new TProjectExample();
        tProjectExample.createCriteria().andIdIsNotNull().andStatusBetween("5","8");
        List<TProject> tProjectList = tProjectMapper.selectByExample(tProjectExample);

        //复制项目信息
        List<ProjectGeneralInfoVo> projectGeneralInfoVoList = new ArrayList<>();
        for(TProject tProject : tProjectList){
            ProjectGeneralInfoVo projectGeneralInfoVo = new ProjectGeneralInfoVo();
            BeanUtils.copyProperties(tProject,projectGeneralInfoVo);

            //获取图片信息
            TProjectImagesExample tProjectImagesExample = new TProjectImagesExample();
            tProjectImagesExample.createCriteria().andProjectidEqualTo(tProject.getId()).andImgtypeEqualTo((byte)0);
            List<TProjectImages> tProjectImagesList = tProjectImagesMapper.selectByExample(tProjectImagesExample);
            if(tProjectImagesList.size() > 0){
                projectGeneralInfoVo.setHeaderImage(tProjectImagesList.get(0).getImgurl());
            }

            projectGeneralInfoVoList.add(projectGeneralInfoVo);
        }

        return projectGeneralInfoVoList;
    }

    @Override
    public List<ProjectTypeVo> getProjectTypeList() {
        //获取项目分类信息
        TTypeExample tTypeExample = new TTypeExample();
        tTypeExample.createCriteria().andIdIsNotNull();
        List<TType> tTypeList = tTypeMapper.selectByExample(tTypeExample);

        //复制项目分类信息
        List<ProjectTypeVo> projectTypeVoList = new ArrayList<>();
        for(TType tType : tTypeList){
            ProjectTypeVo projectTypeVo = new ProjectTypeVo();
            BeanUtils.copyProperties(tType,projectTypeVo);
            projectTypeVoList.add(projectTypeVo);
        }

        return projectTypeVoList;
    }

    @Override
    public List<ProjectTagVo> getProjectTagList() {
        //获取项目标签信息
        TTagExample tTagExample = new TTagExample();
        tTagExample.createCriteria().andIdIsNotNull();
        List<TTag> tTagList = tTagMapper.selectByExample(tTagExample);

        //复制项目标签信息
        List<ProjectTagVo> projectTagVoList = new ArrayList<>();
        for(TTag tTag : tTagList){
            ProjectTagVo projectTagVo = new ProjectTagVo();
            BeanUtils.copyProperties(tTag,projectTagVo);
            projectTagVoList.add(projectTagVo);
        }

        return projectTagVoList;
    }

    @Override
    public ProjectDetailVo getProjectDetailInfo(String projectId) {
        //获取项目信息
        TProjectExample tProjectExample = new TProjectExample();
        tProjectExample.createCriteria().andIdEqualTo(Integer.parseInt(projectId));
        List<TProject> tProjectList = tProjectMapper.selectByExample(tProjectExample);

        //复制项目信息
        ProjectDetailVo projectDetailVo = new ProjectDetailVo();
        if(tProjectList.size() > 0){
            TProject tProject = tProjectList.get(0);
            BeanUtils.copyProperties(tProject,projectDetailVo);

            //获取详细图片信息
            TProjectImagesExample tProjectImagesExample = new TProjectImagesExample();
            tProjectImagesExample.createCriteria().andProjectidEqualTo(tProject.getId()).andImgtypeEqualTo((byte)1);
            List<TProjectImages> tProjectImagesList = tProjectImagesMapper.selectByExample(tProjectImagesExample);

            if(tProjectImagesList.size() > 0) {
                List<String> detailsImage = new ArrayList<>();
                tProjectImagesList.stream().forEach(x -> detailsImage.add(x.getImgurl()));
                projectDetailVo.setDetailsImage(detailsImage);
            }

            //获取项目回报信息
            TReturnExample tReturnExample = new TReturnExample();
            tReturnExample.createCriteria().andProjectidEqualTo(tProject.getId());
            List<TReturn> tReturnList = tReturnMapper.selectByExample(tReturnExample);
            if(tReturnList.size()>0){
                projectDetailVo.setReturns(tReturnList);
            }
        }

        return projectDetailVo;
    }

    @Override
    public ReturnPayConfirmVo confirmReturnInfo(String projectId, String returnId) {
        //获取项目回报信息
        TReturn tReturn = tReturnMapper.selectByPrimaryKey(Integer.parseInt(returnId));

        //获取项目信息
        TProject tProject = tProjectMapper.selectByPrimaryKey(tReturn.getProjectid());

        //获取项目发起人信息
        TProjectInitiatorExample tProjectInitiatorExample = new TProjectInitiatorExample();
        tProjectInitiatorExample.createCriteria().andProjectidEqualTo(tProject.getId());
        List<TProjectInitiator> tProjectInitiatorList = tProjectInitiatorMapper.selectByExample(tProjectInitiatorExample);

        TProjectInitiator tProjectInitiator = tProjectInitiatorList.get(0);

        //复制信息
        ReturnPayConfirmVo returnPayConfirmVo = new ReturnPayConfirmVo();
        returnPayConfirmVo.setProjectId(tProject.getId().toString());
        returnPayConfirmVo.setProjectName(tProject.getName());
        returnPayConfirmVo.setRemark(tProject.getRemark());

        returnPayConfirmVo.setMemberid(tProject.getMemberid());
        returnPayConfirmVo.setMemberName(tProjectInitiator.getSelfintroduction());

        returnPayConfirmVo.setReturnId(tReturn.getId().toString());
        returnPayConfirmVo.setContent(tReturn.getContent());
        returnPayConfirmVo.setNum(1);
        returnPayConfirmVo.setPrice(tReturn.getSupportmoney());
        returnPayConfirmVo.setSignalpurchase(tReturn.getSignalpurchase());
        returnPayConfirmVo.setFreight(tReturn.getFreight());
        returnPayConfirmVo.setTotalPrice(
                BigDecimal.valueOf(returnPayConfirmVo.getNum() * returnPayConfirmVo.getPrice() + returnPayConfirmVo.getFreight()));

        return returnPayConfirmVo;
    }
}
