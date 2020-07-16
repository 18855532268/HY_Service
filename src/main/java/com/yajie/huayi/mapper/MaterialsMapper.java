package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.Materials;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import com.yajie.huayi.util.PageRequest;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface MaterialsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Materials record);

    int insertSelective(Materials record);

    Materials selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Materials record);

    int updateByPrimaryKey(Materials record);

    Long findCount(@Param("id") Long id, @Param("name") String name, @Param("specifications") String specifications, @Param("unit") String unit, @Param("countMin") Integer countMin, @Param("countMax") Integer countMax, @Param("type") Integer type);

    List<Materials> findPage(@Param("id") Long id, @Param("name") String name, @Param("specifications") String specifications, @Param("unit") String unit, @Param("countMin") Integer countMin, @Param("countMax") Integer countMax, @Param("type") Integer type, @Param("pageRequest") PageRequest pageRequest);
}