package com.yajie.huayi.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yajie.huayi.constant.ConstantsForDomain;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.domain.UserRole;
import com.yajie.huayi.exception.ErrorMessageException;
import com.yajie.huayi.exception.ErrorRollbackException;
import com.yajie.huayi.mapper.UserMapper;
import com.yajie.huayi.mapper.UserRoleMapper;
import com.yajie.huayi.util.CommonUtil;
import com.yajie.huayi.util.Page;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.User.UserInfoVo;
import com.yajie.huayi.vo.User.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/1 17:31
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class, noRollbackFor = {ErrorMessageException.class})
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;


    public Page<UserInfoVo> getUserPage(String username, Long createId, PageRequest pageRequest) {
        Long count = userMapper.findCount(username, createId);
        List<User> list = new ArrayList<>();
        if (count > 0) {
            list = userMapper.findUserPage(username, createId, pageRequest);

        }
        return new Page<>(pageRequest, UserInfoVo.of(list), count);
    }

    public void addUser(UserVo userVo) {

        CommonUtil.checkParameters(userVo.getUsername(), userVo.getPassword(), userVo.getCreateId());
        Integer count = userMapper.selectCount(Wrappers.<User>lambdaQuery().eq(User::getUsername, userVo.getUsername()).ne(User::getStatus, ConstantsForDomain.DELETE));
        if (count > 0) {
            throw new ErrorMessageException("用户名已占用！");
        }
        User createUser = userMapper.selectByPrimaryKey(userVo.getCreateId());
        if (createUser == null) {
            throw new ErrorMessageException("该创建人不存在");
        }

        User user = new User();
        user.setCreateId(userVo.getCreateId());
        user.setUsername(userVo.getUsername());
        user.setPassword(userVo.getPassword());
        user.setName(userVo.getName());
        user.setTelephone(userVo.getTelephone());
        user.setWeChat(userVo.getWeChat());
        user.setCompany(user.getCompany());
        user.setCompanyAddress(user.getCompanyAddress());
        user.setUserCode(userVo.getUserCode());
        user.setRemark(userVo.getRemark());
        user.setCreateAt(new Date());
        user.setUpdateAt(new Date());
        user.setStatus(ConstantsForDomain.NORMAL);
        userMapper.insert(user);

        for (Long l: userVo.getRole()){
            UserRole userRole = new UserRole();
            userRole.setRoleId(l);
            userRole.setUserId(user.getId());
            userRoleMapper.insert(userRole);
        }
    }

    public UserInfoVo login(String username, String password) {
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username).eq(User::getPassword, password).ne(User::getStatus, ConstantsForDomain.DELETE));
        if (user == null) {
            throw new ErrorRollbackException("该人员不存在或密码错误");
        }
        List<UserRole> roles = userRoleMapper.selectList(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getId()));
        log.info("返回：{}", JSONObject.toJSONString(roles));
        return UserInfoVo.of(user, roles);
    }
}
