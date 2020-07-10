package com.yajie.huayi.web.controller;

import com.yajie.huayi.config.myinterface.RequestJson;
import com.yajie.huayi.constant.Constants;
import com.yajie.huayi.service.ProjectService;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Project.ProjectVo;
import com.yajie.huayi.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/6/29 16:26
 */
@RestController
@Slf4j
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * 添加或修改项目
     *
     * @param projectVo
     * @return
     */
    @PostMapping("/addOrModify")
    public ReturnVO addOrModifyProject(@RequestBody ProjectVo projectVo) {
        projectService.addOrModifyProject(projectVo);
        return ReturnVO.getSuccess();
    }

    /**
     * 更新项目状态
     */
    @PostMapping("/update/status")
    public ReturnVO updateProjectStatus(@RequestJson("id") Long id, @RequestJson("status") Integer status) {
        projectService.updateProjectStatus(id, status);
        return ReturnVO.getSuccess();
    }

    /**
     * 项目列表
     *
     * @param key
     * @param signStartDate
     * @param signEndDate
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ReturnVO getProjectPage(String key,
                                   String signStartDate,
                                   String signEndDate,
                                   Integer status,
                                   @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                   @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(projectService.getProjectPage(key, signStartDate, signEndDate, status, pageRequest));
    }

}
