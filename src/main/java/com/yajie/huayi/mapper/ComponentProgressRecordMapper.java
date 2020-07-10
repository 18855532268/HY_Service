package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.ComponentProgressRecord;
import com.yajie.huayi.domain.other.ProduceDateEntity;
import com.yajie.huayi.domain.other.TodayTaskEntity;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Production.TodayTaskVo;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ComponentProgressRecordMapper extends BaseMapper<ComponentProgressRecord>{
    int deleteByPrimaryKey(Long id);

    int insert(ComponentProgressRecord record);

    int insertSelective(ComponentProgressRecord record);

    ComponentProgressRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ComponentProgressRecord record);

    int updateByPrimaryKey(ComponentProgressRecord record);

    List<ProduceDateEntity> findProduceDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    Long findCount(@Param("operationId")Long operationId,
                   @Param("operationStatus") Integer operationStatus,
                   @Param("inspectionId")Long inspectionId,
                   @Param("inspectionStatus")Integer inspectionStatus,
                   @Param("type")Integer type);
    List<TodayTaskEntity> findPage(@Param("operationId")Long operationId,
                                   @Param("operationStatus") Integer operationStatus,
                                   @Param("inspectionId")Long inspectionId,
                                   @Param("inspectionStatus")Integer inspectionStatus,
                                   @Param("type")Integer type,
                                   @Param("pageRequest")PageRequest pageRequest);
}