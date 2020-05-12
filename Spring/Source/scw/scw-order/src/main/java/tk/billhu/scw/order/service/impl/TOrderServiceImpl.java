package tk.billhu.scw.order.service.impl;

import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.billhu.scw.enums.OrderStatusEnumes;
import tk.billhu.scw.order.entities.TOrder;
import tk.billhu.scw.order.mapper.TOrderMapper;
import tk.billhu.scw.order.service.TOrderService;
import tk.billhu.scw.order.service.TProjectServiceFeign;
import tk.billhu.scw.order.vo.request.OrderCreateVo;
import tk.billhu.scw.order.vo.response.ReturnPayConfirmVo;
import tk.billhu.scw.util.AppDateUtils;
import tk.billhu.scw.vo.resp.AppResponse;

import java.util.UUID;

@Service
@Slf4j
@Transactional(readOnly = true)
public class TOrderServiceImpl implements TOrderService {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private TProjectServiceFeign tProjectServiceFeign;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public TOrder save(OrderCreateVo orderCreateVo) {
        TOrder tOrder = new TOrder();

        BeanUtils.copyProperties(orderCreateVo,tOrder);

        String memberId = stringRedisTemplate.opsForValue().get(orderCreateVo.getAccessToken());

        tOrder.setMemberid(Integer.parseInt(memberId));
        tOrder.setOrdernum(UUID.randomUUID().toString().replace("-",""));
        tOrder.setCreatedate(AppDateUtils.getFormatTime());

        AppResponse<ReturnPayConfirmVo> response = tProjectServiceFeign.support(orderCreateVo.getProjectid().toString(),orderCreateVo.getReturnid().toString());

        ReturnPayConfirmVo returnPayConfirmVo = response.getData();
        tOrder.setMoney(returnPayConfirmVo.getPrice() * tOrder.getRtncount() + returnPayConfirmVo.getFreight());

        tOrder.setStatus(OrderStatusEnumes.UNPAY.getCode()+"");

        tOrderMapper.insertSelective(tOrder);

        String orderId = tOrder.getId().toString();

        log.debug("订单创建成功-{}",orderId);

        return tOrder;
    }

    @Override
    public void update() {
        log.info("支付宝调用更新订单支付状态");
    }
}
