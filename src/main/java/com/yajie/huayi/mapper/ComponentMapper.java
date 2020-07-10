package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.Component;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.yajie.huayi.util.PageRequest;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface ComponentMapper extends BaseMapper<Component>{
    int deleteByPrimaryKey(Long id);

    int insert(Component record);

    int insertSelective(Component record);

    Component selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Component record);

    int updateByPrimaryKey(Component record);

    Long findCount(@Param("number") String number, @Param("projectId") Long projectId, @Param("componentTypeId") Long componentTypeId, @Param("buildingNo") Integer buildingNo, @Param("floorNoStart") Integer floorNoStart, @Param("floorNoEnd") Integer floorNoEnd, @Param("projectNum") String projectNum, @Param("status") Integer status);

    List<Component> findPage(@Param("number") String number, @Param("projectId") Long projectId, @Param("componentTypeId") Long componentTypeId, @Param("buildingNo") Integer buildingNo, @Param("floorNoStart") Integer floorNoStart, @Param("floorNoEnd") Integer floorNoEnd, @Param("projectNum") String projectNum, @Param("status") Integer status, @Param("pageRequest") PageRequest pageRequest);
}