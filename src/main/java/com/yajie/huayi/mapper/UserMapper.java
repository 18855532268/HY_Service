package com.yajie.huayi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.util.PageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Long findCount(@Param("username") String username, @Param("createId") Long createId);

    List<User> findUserPage(@Param("username") String username, @Param("createId") Long createId, @Param("pageRequest") PageRequest pageRequest);
}