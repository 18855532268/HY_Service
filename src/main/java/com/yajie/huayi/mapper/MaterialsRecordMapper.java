package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.MaterialsRecord;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface MaterialsRecordMapper extends BaseMapper<MaterialsRecord>{
    int deleteByPrimaryKey(Long id);

    int insert(MaterialsRecord record);

    int insertSelective(MaterialsRecord record);

    MaterialsRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MaterialsRecord record);

    int updateByPrimaryKey(MaterialsRecord record);
}