package com.yajie.huayi.web.controller;

import com.yajie.huayi.constant.Constants;
import com.yajie.huayi.service.MoldService;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/8 10:16
 */
@RestController
@Slf4j
@RequestMapping("/mold")
public class MoldController {

    @Autowired
    private MoldService moldService;

    /**
     * 模具列表
     * @param moldNum
     * @param status
     * @param projectId
     * @param componentNum
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ReturnVO getMolds(
            String moldNum,
            Integer status,
            Long projectId,
            String componentNum,
            @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
            @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(moldService.getMolds(moldNum, status, projectId, componentNum, pageRequest));
    }

}
