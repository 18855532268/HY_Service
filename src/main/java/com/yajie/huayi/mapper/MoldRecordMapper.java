package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.MoldRecord;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface MoldRecordMapper extends BaseMapper<MoldRecord>{
    int deleteByPrimaryKey(Long id);

    int insert(MoldRecord record);

    int insertSelective(MoldRecord record);

    MoldRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MoldRecord record);

    int updateByPrimaryKey(MoldRecord record);
}