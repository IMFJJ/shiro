package com.study.service;

import com.study.model.OrderMaster;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrderMasterService {
    public Integer add(OrderMaster orderMaster);
    public Integer set(OrderMaster orderMaster);
    public OrderMaster find(String id);

}
