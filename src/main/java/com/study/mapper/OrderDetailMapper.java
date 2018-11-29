package com.study.mapper;

import com.study.model.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String detail_id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String detail_id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}