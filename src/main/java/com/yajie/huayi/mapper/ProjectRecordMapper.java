package com.yajie.huayi.mapper;

import com.yajie.huayi.domain.ProjectRecord;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface ProjectRecordMapper extends BaseMapper<ProjectRecord>{
    int deleteByPrimaryKey(Long id);

    int insert(ProjectRecord record);

    int insertSelective(ProjectRecord record);

    ProjectRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectRecord record);

    int updateByPrimaryKey(ProjectRecord record);
}