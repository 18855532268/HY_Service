package com.yajie.huayi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yajie.huayi.domain.Mold;
import com.yajie.huayi.domain.other.MoldRecordEntity;
import com.yajie.huayi.util.PageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MoldMapper extends BaseMapper<Mold> {
    int deleteByPrimaryKey(Long id);

    int insert(Mold record);

    int insertSelective(Mold record);

    Mold selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Mold record);

    int updateByPrimaryKey(Mold record);

    Long findCount(@Param("moldNum") String moldNum, @Param("status")Integer status, @Param("projectId")Long projectId, @Param("componentNum")String componentNum);
    List<MoldRecordEntity> findPage(@Param("moldNum") String moldNum, @Param("status")Integer status, @Param("projectId")Long projectId, @Param("componentNum")String componentNum, @Param("pageRequest")PageRequest pageRequest);
}