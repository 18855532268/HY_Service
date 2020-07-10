package com.yajie.huayi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yajie.huayi.domain.ComponentType;
import com.yajie.huayi.util.PageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComponentTypeMapper extends BaseMapper<ComponentType> {
    int deleteByPrimaryKey(Long id);

    int insert(ComponentType record);

    int insertSelective(ComponentType record);

    ComponentType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComponentType record);

    int updateByPrimaryKey(ComponentType record);

    Long findCount(@Param("key") String key);
    List<ComponentType> findPage(@Param("key") String key, @Param("pageRequest") PageRequest pageRequest);
}