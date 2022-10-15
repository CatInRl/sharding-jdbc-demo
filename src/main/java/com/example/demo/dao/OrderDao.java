package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderDao extends BaseMapper<OrderEntity> {

  @Select("select exists(select * from t_order where order_name=#{orderName} limit 1) as c")
  boolean existsOrderAsByOrderId(@Param("orderName") String orderName);

  @Insert("insert into t_order(order_id, order_name) values(#{orderId}, subStr(#{orderName},1,3))")
  int insertWithSubStr(@Param("orderId") int orderId, @Param("orderName") String orderName);
}
