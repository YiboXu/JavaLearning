package tk.billhu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tk.billhu.gulimall.common.utils.PageUtils;
import tk.billhu.gulimall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author billhu
 * @email billtt@163.com
 * @date 2020-05-19 17:23:08
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

