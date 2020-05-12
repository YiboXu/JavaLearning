package tk.billhu.scw.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.billhu.scw.order.entities.TOrder;
import tk.billhu.scw.order.service.TOrderService;
import tk.billhu.scw.order.vo.request.OrderCreateVo;
import tk.billhu.scw.vo.resp.AppResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Slf4j
@Api(tags = "订单模块")
@RequestMapping("/order")
@RestController
public class OrderCreateController {

    @Autowired
    private TOrderService tOrderService;

    @ApiOperation(value = "创建订单")
    @PostMapping("/create")
    public AppResponse<TOrder> create(@RequestBody OrderCreateVo orderCreateVo) {
        TOrder order;

        try{
            order = tOrderService.save(orderCreateVo);
        }catch (Exception e){
            e.printStackTrace();
            log.debug("订单创建异常-{}",orderCreateVo.toString());
            return AppResponse.fail(null);
        }

        return AppResponse.ok(order);
    }

    @ApiOperation(value = "立即付款")
    @PostMapping("/pay")
    public AppResponse<Object> pay() {

        return AppResponse.ok("ok");
    }

    @ApiOperation(value = "取消订单")
    @PostMapping("/cancle")
    public AppResponse<Object> cancle() {
        return AppResponse.ok("ok");
    }

    @RequestMapping("/updateStatus")
    public String updateOrderStatus(HttpServletRequest request) throws UnsupportedEncodingException {
        tOrderService.update();
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println("************");
        System.out.println(params);
        return "success";  //必须返回支付宝一个"success"
    }
}
