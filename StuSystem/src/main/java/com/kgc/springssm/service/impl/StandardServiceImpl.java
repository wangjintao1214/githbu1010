package com.kgc.springssm.service.impl;

import com.kgc.springssm.mapper.StandardMapper;
import com.kgc.springssm.pojo.Standard;
import com.kgc.springssm.pojo.StandardExample;
import com.kgc.springssm.service.StandardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-10 20:16
 */
@Service
public class StandardServiceImpl implements StandardService{
    @Resource
    StandardMapper standardMapper;

    @Override
    public List<Standard> selectByExample(StandardExample example) {
        return standardMapper.selectByExample(example);
    }

    @Override
    public int add(Standard standard) {
        int i = standardMapper.insertSelective(standard);
        return i;
    }
}
