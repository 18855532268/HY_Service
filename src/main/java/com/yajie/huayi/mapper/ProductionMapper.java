package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.Production;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface ProductionMapper extends  BaseMapper<Production>{
    int deleteByPrimaryKey(Long id);

    int insert(Production record);

    int insertSelective(Production record);

    Production selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKey(Production record);
}