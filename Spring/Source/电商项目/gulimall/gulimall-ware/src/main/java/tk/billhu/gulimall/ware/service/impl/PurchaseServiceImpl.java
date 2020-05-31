package tk.billhu.gulimall.ware.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.common.utils.Query;

import tk.billhu.gulimall.ware.dao.PurchaseDao;
import tk.billhu.gulimall.ware.entity.PurchaseDetailEntity;
import tk.billhu.gulimall.ware.entity.PurchaseEntity;
import tk.billhu.gulimall.ware.service.PurchaseDetailService;
import tk.billhu.gulimall.ware.service.PurchaseService;
import tk.billhu.gulimall.ware.vo.MergeVo;


@Service("purchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseDao, PurchaseEntity> implements PurchaseService {

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取查询参数
        String keyValue = (String) params.get("key");
        String status = (String) params.get("status");

        QueryWrapper<PurchaseEntity> queryWrapper = new QueryWrapper<>();

        if(!StringUtils.isEmpty(status)){
            queryWrapper.eq("status",status);
        }

        if(!StringUtils.isEmpty(keyValue)){
            queryWrapper.and(obj -> {
                obj.eq("id",keyValue).or().eq("assignee_id",keyValue)
                        .or().like("assignee_name",keyValue)
                        .or().like("phone",keyValue);
            });
        }

        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils listUnreceivePerchase(Map<String, Object> params) {

        QueryWrapper<PurchaseEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("status",0).or().eq("status",1);

        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public void merge(MergeVo mergeVo) {
        //如果采购单号为空，创建一个新的采购单
        Long purchaseId = mergeVo.getPurchaseId();

        if(purchaseId == null){
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setCreateTime(new Date());
            purchaseEntity.setUpdateTime(new Date());

            this.save(purchaseEntity);

            purchaseId = purchaseEntity.getId();
        }

        //合并采购单和采购需求
        //1 更新采购需求中的采购单号
        UpdateWrapper<PurchaseDetailEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("id",mergeVo.getItems()).set("purchase_id",purchaseId).set("status",1);
        purchaseDetailService.update(updateWrapper);

        //2 更新采购单的更新时间
        UpdateWrapper<PurchaseEntity> updateWrapper1 = new UpdateWrapper<>();
        updateWrapper1.eq("id",purchaseId).set("update_time",new Date());
        this.update(updateWrapper1);
    }
}