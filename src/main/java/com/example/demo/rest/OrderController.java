package com.example.demo.rest;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
@Slf4j
public class OrderController {

  @Autowired
  OrderDao orderDao;

  @GetMapping(path = "order/exists")
  public boolean orderExists(@RequestParam("orderName") String orderName){
    return orderDao.existsOrderAsByOrderId(orderName);
  }

  @GetMapping(path = "order/new")
  public int orderNew(@RequestParam("orderId") int orderId, @RequestParam("orderName") String orderName){
    return orderDao.insertWithSubStr(orderId, orderName);
  }
}
