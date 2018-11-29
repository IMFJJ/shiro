package com.study.service.impl;

import com.study.mapper.OrderMasterMapper;
import com.study.model.OrderMaster;
import com.study.service.IOrderMasterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IOrderMasterServiceImpl implements IOrderMasterService {
    @Resource
    OrderMasterMapper orderMasterMapper;
    public Integer add(OrderMaster orderMaster) {
       return  orderMasterMapper.insert(orderMaster);
    }

    public Integer set(OrderMaster orderMaster) {

        return orderMasterMapper.updateByPrimaryKey(orderMaster);
    }

    @Override
    public OrderMaster find(String id) {
        return orderMasterMapper.selectByPrimaryKey(id);
    }
}
