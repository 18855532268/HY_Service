package com.yajie.huayi.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.yajie.huayi.config.myinterface.RequestJson;
import com.yajie.huayi.constant.Constants;
import com.yajie.huayi.service.UserService;
import com.yajie.huayi.util.CommonUtil;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.ReturnVO;
import com.yajie.huayi.vo.User.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/1 17:44
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 条件查询用户分页
     * @param
     * @param createId
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ReturnVO getUserPage(String key,
                                Long role,
                                Long createId,
                                String startTime,
                                String endStartTime,
                                @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(userService.getUserPage(key, role, createId, startTime, endStartTime,  pageRequest));
    }
    @PostMapping("/login")
    public ReturnVO login(@RequestJson("username") String username, @RequestJson("password")String password) {
        CommonUtil.checkParameters(username, password);
        return ReturnVO.getSuccess(userService.login(username, password));
    }
    /**
     * 添加用户
     * @param userVo
     * @return
     */
    @PostMapping("/add")
    public ReturnVO addUser(@RequestBody UserVo userVo) {
        userService.addUser(userVo);
        log.info("添加用户:{}", JSONObject.toJSONString(userVo));
        return ReturnVO.getSuccess();
    }

    @PostMapping("/delete")
    public ReturnVO addUser(@RequestJson("id")Long id) {
        userService.deleteUser(id);
        return ReturnVO.getSuccess();
    }
    /**
     * 获取角色列表
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/role/list")
    public ReturnVO getRolePage(@RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(userService.getRolePage(pageRequest));
    }

}
