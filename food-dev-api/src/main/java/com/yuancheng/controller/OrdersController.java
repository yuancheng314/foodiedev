package com.yuancheng.controller;

import com.yuancheng.enums.PayMethod;
import com.yuancheng.pojo.UserAddress;
import com.yuancheng.pojo.bo.AddressBO;
import com.yuancheng.pojo.bo.SubmitOrderBO;
import com.yuancheng.service.AddressService;
import com.yuancheng.service.OrderService;
import com.yuancheng.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.utils.MobileEmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("orders")
@RestController
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public IMOOCJSONResult create(
            @RequestBody SubmitOrderBO submitOrderBO) {
        if (submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type &&
                submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type ) {
            return IMOOCJSONResult.errorMsg("支付方式不支持");
        }
        System.out.println(submitOrderBO.toString());
        // 1.创建订单
        orderService.createOrder(submitOrderBO);
        // 2.创建订单以后，移除购物车中已结算（已提交）的商品
        // 3.向支付中心发送当前订单，用于保存支付中心的订单数据
        return IMOOCJSONResult.ok();
    }


}
