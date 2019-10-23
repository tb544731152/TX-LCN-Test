package com.d2c.order.business.controller;

import com.alibaba.fastjson.JSONObject;
import com.d2c.order.business.model.Order;
import com.d2c.order.business.service.OrderService;
import com.d2c.order.elasticsearch.document.OrderSearch;
import com.d2c.order.mongodb.document.OrderMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestCtrl {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/api/order", method = RequestMethod.GET)
    public Order findBySn(@RequestParam(value = "sn", required = true) String sn) {
        return orderService.findBySn(sn);
    }

    @RequestMapping(value = "/api/order/cache", method = RequestMethod.GET)
    public Order findCacheBySn(@RequestParam(value = "sn", required = true) String sn) {
        return orderService.findCacheBySn(sn);
    }

    @RequestMapping(value = "/api/order/mongo", method = RequestMethod.GET)
    public List<OrderMongo> findMongoBySn(@RequestParam(value = "sn", required = true) String sn) {
        return orderService.findMongoBySn(sn);
    }

    @RequestMapping(value = "/api/order/search", method = RequestMethod.GET)
    public List<OrderSearch> findSearchBySn(@RequestParam(value = "sn", required = true) String sn) {
        return orderService.findSearchBySn(sn);
    }

    @RequestMapping(value = "/api/order/updatePwd", method = RequestMethod.GET)
    public JSONObject updatePwd(@RequestParam(value = "memberId")Long memberId) {
        int result = orderService.updatePwdById(memberId);
        JSONObject obj = new JSONObject();
        obj.put("result", result);
        return obj;
    }

    @RequestMapping(value = "/api/order/user", method = RequestMethod.GET)
    public String findUser(@RequestParam(value = "username", required = true) String username) {
        return orderService.findName(username);
    }

    @RequestMapping(value = "/api/order/tx1", method = RequestMethod.GET)
    public JSONObject doSomeThing1(String sn, Long productId, Long memberId) {
        int result = orderService.doSomeThing(sn, productId, memberId);
        JSONObject obj = new JSONObject();
        obj.put("result", result);
        return obj;
    }




}
