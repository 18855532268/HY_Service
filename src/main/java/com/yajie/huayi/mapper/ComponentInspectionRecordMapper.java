package com.yajie.huayi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yajie.huayi.domain.ComponentInspectionRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ComponentInspectionRecordMapper extends BaseMapper<ComponentInspectionRecord> {
    int deleteByPrimaryKey(Long id);

    int insert(ComponentInspectionRecord record);

    int insertSelective(ComponentInspectionRecord record);

    ComponentInspectionRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComponentInspectionRecord record);

    int updateByPrimaryKey(ComponentInspectionRecord record);
}