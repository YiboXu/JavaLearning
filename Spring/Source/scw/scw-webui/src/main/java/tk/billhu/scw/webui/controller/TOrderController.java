package tk.billhu.scw.webui.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.billhu.scw.vo.resp.AppResponse;
import tk.billhu.scw.webui.config.AlipayConfig;
import tk.billhu.scw.webui.entities.TOrder;
import tk.billhu.scw.webui.service.TOrderServiceFeign;
import tk.billhu.scw.webui.vo.request.OrderCreateVo;
import tk.billhu.scw.webui.vo.request.OrderSubmitVo;
import tk.billhu.scw.webui.vo.response.ReturnPayConfirmVo;
import tk.billhu.scw.webui.vo.response.UserResponseVo;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
@Slf4j
public class TOrderController {

    @Autowired
    private TOrderServiceFeign tOrderServiceFeign;

    @PostMapping("/pay")
    @ResponseBody
    public String payOrder(OrderSubmitVo orderSubmitVo, HttpSession session){
        //检查是否登录
        UserResponseVo userResponseVo = (UserResponseVo) session.getAttribute("loginmember");
        if(userResponseVo == null){
            return "redirect:/login";
        }

        //1.创建订单
        OrderCreateVo orderCreateVo = new OrderCreateVo();
        BeanUtils.copyProperties(orderSubmitVo, orderCreateVo);

        orderCreateVo.setAccessToken(userResponseVo.getAccessToken());
        ReturnPayConfirmVo returnPayConfirmVo = (ReturnPayConfirmVo) session.getAttribute("returnPayConfirmVo");
        orderCreateVo.setProjectid(Integer.parseInt(returnPayConfirmVo.getProjectId()));
        orderCreateVo.setReturnid(Integer.parseInt(returnPayConfirmVo.getReturnId()));
        orderCreateVo.setRtncount(returnPayConfirmVo.getNum());

        AppResponse<TOrder> response = tOrderServiceFeign.create(orderCreateVo);
        TOrder order = response.getData();

        //2.支付订单
        try {
            String result = payOrder(order.getOrdernum(),order.getMoney().toString(),returnPayConfirmVo.getProjectName(),order.getRemark());
            return result;  //这是一个表单，自动提交，生成支付二维码
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //需要用redirect,否则以刷新浏览器就又提交了一次订单
        return null;
    }

    private String payOrder(String out_trade_no, String total_amount, String subject, String body) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //付款金额，必填
        //订单名称，必填
        //商品描述，可空

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }
}
