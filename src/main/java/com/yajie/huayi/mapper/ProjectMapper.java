package com.yajie.huayi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yajie.huayi.domain.Project;
import com.yajie.huayi.util.PageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
    int deleteByPrimaryKey(Long id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    Long findCount(@Param("key") String key, @Param("signStartDate") String signStartDate, @Param("signEndDate") String signEndDate, @Param("status") Integer status);

    List<Project> findPage(@Param("key") String key, @Param("signStartDate") String signStartDate, @Param("signEndDate") String signEndDate, @Param("status") Integer status, @Param("pageRequest") PageRequest pageRequest);
}