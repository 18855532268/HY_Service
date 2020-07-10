package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.VolumeGap;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface VolumeGapMapper extends BaseMapper<VolumeGap>{
    int deleteByPrimaryKey(Long id);

    int insert(VolumeGap record);

    int insertSelective(VolumeGap record);

    VolumeGap selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VolumeGap record);

    int updateByPrimaryKey(VolumeGap record);
}