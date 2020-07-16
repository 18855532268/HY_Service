package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.ComponentInspectionRecord;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ComponentInspectionRecordMapper extends BaseMapper<ComponentInspectionRecord> {
    int deleteByPrimaryKey(Long id);

    int insert(ComponentInspectionRecord record);

    int insertSelective(ComponentInspectionRecord record);

    ComponentInspectionRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComponentInspectionRecord record);

    int updateByPrimaryKey(ComponentInspectionRecord record);

    Long findCount(@Param("id")Long id, @Param("componentId")Long componentId, @Param("status")Integer status, @Param("inspectorId")Long inspectorId, @Param("remark")String remark, @Param("type")Integer type);
}