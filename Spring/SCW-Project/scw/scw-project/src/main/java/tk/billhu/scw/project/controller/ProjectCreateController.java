package tk.billhu.scw.project.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import tk.billhu.scw.enums.ProjectStatusEnume;
import tk.billhu.scw.project.component.OssTemplate;
import tk.billhu.scw.project.entities.TReturn;
import tk.billhu.scw.project.service.TProjectService;
import tk.billhu.scw.project.vo.request.*;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Api(tags = "项目发起模块")
@RequestMapping("/project/create")
@RestController
public class ProjectCreateController {

	@Autowired
	private OssTemplate ossTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	private TProjectService tProjectService;

	@ApiOperation(value = "1 - 项目初始创建")
	@PostMapping("/init")
	public AppResponse<Object> init(@RequestBody BaseVo baseVo) {
		try {
			//获取accessToken
			String accessToken = baseVo.getAccessToken();
			//验证accessToken
			if (StringUtils.isEmpty(accessToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供accessToken");
				return response;
			}

			String memberId = stringRedisTemplate.opsForValue().get(accessToken);
			if (StringUtils.isEmpty(memberId)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("请先登录");
				return response;
			}

			//创建ProjectRedisStorageVo并从bigVo复制accessToken
			ProjectRedisStorageVo bigVo = new ProjectRedisStorageVo();
			BeanUtils.copyProperties(baseVo,bigVo);
			//生成projectToken
			String projectToken = UUID.randomUUID().toString().replace("-", "");
			//将projectToken保存至ProjectRedisStorageVo
			bigVo.setProjectToken(projectToken);
			//将ProjectRedisStorageVo转换为Json字符串
			String value = JSON.toJSONString(bigVo);
			//将projectToken的JSON保存至redis
			stringRedisTemplate.opsForValue().set(projectToken, value);

			log.debug("项目初始化成功-{}",bigVo);
			//返回创建ProjectRedisStorageVo
			return AppResponse.ok(bigVo);
		}catch (Exception e){
			e.printStackTrace();
			log.debug("项目初始化异常-{}",baseVo.getAccessToken());
			return AppResponse.fail(null);
		}
	}

	@ApiOperation(value = "2 - 项目基本信息")
	@PostMapping("/baseInfo")
	public AppResponse<Object> baseInfo(@RequestBody ProjectBaseInfoVo projectBaseInfoVo){

		try {
			//获取accessToken
			String accessToken = projectBaseInfoVo.getAccessToken();
			//验证accessToken
			if (StringUtils.isEmpty(accessToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供accessToken");
				return response;
			}

			String memberId = stringRedisTemplate.opsForValue().get(accessToken);
			if (StringUtils.isEmpty(memberId)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("请先登录");
				return response;
			}

			//验证projectToken
			String projectToken = projectBaseInfoVo.getProjectToken();
			if (StringUtils.isEmpty(projectToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供projectToken");
				return response;
			}

			String bigStr = stringRedisTemplate.opsForValue().get(projectToken);
			if(StringUtils.isEmpty(bigStr)){
				AppResponse response = AppResponse.fail(null);
				response.setMsg("项目未初始化");
				return response;
			}

			//将bigStr转换为ProjectRedisStorageVo
			ProjectRedisStorageVo bigVo = JSON.parseObject(bigStr,ProjectRedisStorageVo.class);
			//将表单数据复制到bigVo
			BeanUtils.copyProperties(projectBaseInfoVo,bigVo);
			//将bigVo重新保存至redis
			bigStr = JSON.toJSONString(bigVo);
			stringRedisTemplate.opsForValue().set(projectToken,bigStr);

			//日志
			log.debug("项目基本信息填写成功-{}",bigVo);
			//返回
			return AppResponse.ok(bigVo);
		}catch (Exception e){
			e.printStackTrace();
			log.debug("项目基本信息创建异常-{}",projectBaseInfoVo.getAccessToken());
			return AppResponse.fail(null);
		}
	}

	@ApiOperation(value = "3 - 添加项目回报档位")
	@PostMapping("/return")
	public AppResponse<Object> returnDetail(@RequestBody List<ProjectReturnVo> projectReturnVos) {

		try {
			//检查projectReturnVos是否未空集合
			if(projectReturnVos.size() == 0){
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有任何回报挡位");
				return response;
			}

			//获取accessToken
			String accessToken = projectReturnVos.get(0).getAccessToken();
			//验证accessToken
			if (StringUtils.isEmpty(accessToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供accessToken");
				return response;
			}

			String memberId = stringRedisTemplate.opsForValue().get(accessToken);
			if (StringUtils.isEmpty(memberId)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("请先登录");
				return response;
			}

			//验证projectToken
			String projectToken = projectReturnVos.get(0).getProjectToken();
			if (StringUtils.isEmpty(projectToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供projectToken");
				return response;
			}

			String bigStr = stringRedisTemplate.opsForValue().get(projectToken);
			if(StringUtils.isEmpty(bigStr)){
				AppResponse response = AppResponse.fail(null);
				response.setMsg("项目未初始化");
				return response;
			}

			//将bigStr转换为ProjectRedisStorageVo
			ProjectRedisStorageVo bigVo = JSON.parseObject(bigStr,ProjectRedisStorageVo.class);
			//将回报挡位复制到bigVo
			List<TReturn> tReturns = new ArrayList<>();
			for(ProjectReturnVo projectReturnVo : projectReturnVos){
				TReturn tReturn = new TReturn();
				BeanUtils.copyProperties(projectReturnVo, tReturn);
				tReturns.add(tReturn);
			}
			bigVo.setProjectReturns(tReturns);
			//将bigVo重新保存至redis
			bigStr = JSON.toJSONString(bigVo);
			stringRedisTemplate.opsForValue().set(projectToken,bigStr);

			//日志
			log.debug("项目回报信息填写成功-{}",bigVo);
			//返回
			return AppResponse.ok(bigVo);
		}catch (Exception e){
			e.printStackTrace();
			log.debug("项目回报信息创建异常-{}",projectReturnVos.get(0).getAccessToken());
			return AppResponse.fail(null);
		}
	}
	
	@ApiOperation(value = "删除项目回报档位")
	@DeleteMapping("/return")
	public AppResponse<Object> deleteReturnDetail() {
		return AppResponse.ok("ok");
	}

	/**
	 * 文件上传表单要求:
	 * -method="post"
	 * -enctype="multipart/form-data"
	 * -type="file"
	 *
	 * SpringMVC框架集成commons-fileupload和commons-io组件，完成文件上传操作.
	 * SpringMVC提供文件上传解析器.
	 * Controller处理文件上传时, 通过MultipartFile接受文件.
	 * @param uploadFiles
	 * @return
	 */
	@ApiOperation(value = "批量上传图片")
	@PostMapping("/multiUpload")
	public AppResponse<List<String>> multiUpload(@RequestPart(name = "uploadFiles") MultipartFile[] uploadFiles) {

		List<String> fileList = new ArrayList<>();

		try {
			for (MultipartFile file : uploadFiles) {
				String fileName = file.getOriginalFilename();
				fileName = UUID.randomUUID().toString().replace("-","")+"_"+fileName;
				String filePath = ossTemplate.upload(file.getInputStream(), fileName);
				fileList.add(filePath);
			}

			log.debug("文件上传路径={}",fileList);
			return AppResponse.ok(fileList);
		}catch (Exception e){
			e.printStackTrace();
			log.debug("文件上传发生异常");
			return AppResponse.fail(null);
		}
	}

	/**
	 * 文件上传表单要求:
	 * -method="post"
	 * -enctype="multipart/form-data"
	 * -type="file"
	 *
	 * SpringMVC框架集成commons-fileupload和commons-io组件，完成文件上传操作.
	 * SpringMVC提供文件上传解析器.
	 * Controller处理文件上传时, 通过MultipartFile接受文件.
	 * @param uploadFile
	 * @return
	 */
	@ApiOperation(value = "单个上传图片")
	@PostMapping("/upload")
	public AppResponse<String> upload(@RequestPart(name = "uploadFile") MultipartFile uploadFile) {

		try {
			String fileName = uploadFile.getOriginalFilename();
			fileName = UUID.randomUUID().toString().replace("-","")+"_"+fileName;
			String filePath = ossTemplate.upload(uploadFile.getInputStream(), fileName);

			log.debug("文件上传路径={}",filePath);
			return AppResponse.ok(filePath);
		}catch (Exception e){
			e.printStackTrace();
			log.debug("文件上传发生异常");
			return AppResponse.fail(null);
		}
	}

	@ApiOperation(value = "4 - 确认项目法人信息")
	@PostMapping("/confirm/legal")
	public AppResponse<Object> legal(@RequestBody ProjectLegalVo projectLegalVo) {
		try {
			//获取accessToken
			String accessToken = projectLegalVo.getAccessToken();
			//验证accessToken
			if (StringUtils.isEmpty(accessToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供accessToken");
				return response;
			}

			String memberId = stringRedisTemplate.opsForValue().get(accessToken);
			if (StringUtils.isEmpty(memberId)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("请先登录");
				return response;
			}

			//验证projectToken
			String projectToken = projectLegalVo.getProjectToken();
			if (StringUtils.isEmpty(projectToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供projectToken");
				return response;
			}

			String bigStr = stringRedisTemplate.opsForValue().get(projectToken);
			if(StringUtils.isEmpty(bigStr)){
				AppResponse response = AppResponse.fail(null);
				response.setMsg("项目未初始化");
				return response;
			}

			//将bigStr转换为ProjectRedisStorageVo
			ProjectRedisStorageVo bigVo = JSON.parseObject(bigStr,ProjectRedisStorageVo.class);
			//将表单数据复制到bigVo
			BeanUtils.copyProperties(projectLegalVo,bigVo);
			//将bigVo重新保存至redis
			bigStr = JSON.toJSONString(bigVo);
			stringRedisTemplate.opsForValue().set(projectToken,bigStr);

			//日志
			log.debug("项目法人信息填写成功-{}",bigVo);
			//返回
			return AppResponse.ok(bigVo);
		}catch (Exception e){
			e.printStackTrace();
			log.debug("项目法人信息创建异常-{}",projectLegalVo.getAccessToken());
			return AppResponse.fail(null);
		}
	}
	
	@ApiOperation(value = "项目草稿保存")
	@PostMapping("/tempsave")
	public AppResponse<Object> tempsave() {
		return AppResponse.ok("ok");
	}
	
	@ApiOperation(value = "项目提交审核申请")
	@PostMapping("/submit")
	public AppResponse<Object> submit(String accessToken, String projectToken, String operation) {
		try {
			//验证accessToken
			if (StringUtils.isEmpty(accessToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供accessToken");
				return response;
			}

			String memberId = stringRedisTemplate.opsForValue().get(accessToken);
			if (StringUtils.isEmpty(memberId)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("请先登录");
				return response;
			}

			//验证projectToken
			if (StringUtils.isEmpty(projectToken)) {
				AppResponse response = AppResponse.fail(null);
				response.setMsg("没有提供projectToken");
				return response;
			}

			String bigStr = stringRedisTemplate.opsForValue().get(projectToken);
			if(StringUtils.isEmpty(bigStr)){
				AppResponse response = AppResponse.fail(null);
				response.setMsg("项目未初始化");
				return response;
			}

			//将bigStr转换为ProjectRedisStorageVo
			ProjectRedisStorageVo bigVo = JSON.parseObject(bigStr,ProjectRedisStorageVo.class);

			//验证operation
			//将ProjectRedisStorageVo写入数据库
			switch (operation){
				case "0":
					tProjectService.save(bigVo, ProjectStatusEnume.DRAFT);
					break;
				case "1":
					tProjectService.save(bigVo, ProjectStatusEnume.SUBMIT_AUTH);
					break;
				default:
					log.debug("非法表单操作-{}",operation);
					return AppResponse.fail(null);
			}

			//日志
			log.debug("项目提交成功-{}",bigVo);

			//返回
			return AppResponse.ok(bigVo);
		}catch (Exception e){
			e.printStackTrace();
			log.debug("项目提交异常-{}",accessToken);
			return AppResponse.fail(null);
		}
	}
	
}
