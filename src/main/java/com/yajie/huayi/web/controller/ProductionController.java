package com.yajie.huayi.web.controller;

import com.yajie.huayi.config.myinterface.RequestJson;
import com.yajie.huayi.constant.Constants;
import com.yajie.huayi.service.ProductionService;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Production.ProductionVo;
import com.yajie.huayi.vo.Production.SchedulingVo;
import com.yajie.huayi.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/4 10:18
 */
@RestController
@Slf4j
@RequestMapping("/production")
public class ProductionController {
    @Autowired
    private ProductionService productionService;

    /**
     * 添加生产单
     *
     * @param productionVo
     * @return
     */
    @PostMapping("/add")
    public ReturnVO addProduction(@RequestBody ProductionVo productionVo) {
        productionService.addProduction(productionVo);
        return ReturnVO.getSuccess();
    }

    /**
     * 项目管理
     *
     * @param productNum
     * @param projectNum
     * @param status
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ReturnVO getProductionPage(String productNum,
                                      String projectNum,
                                      Integer status,
                                      @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                      @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(productionService.getProductionPage(productNum, projectNum, status, pageRequest));
    }

    /**
     * 批量排单
     */
    @PostMapping("/scheduling")
    public ReturnVO Scheduling(@RequestBody SchedulingVo schedulingVo) {
        productionService.Scheduling(schedulingVo);
        return ReturnVO.getSuccess();
    }

    /**
     * 查看历史进度
     *
     * @param id
     * @return
     */
    @GetMapping("/progress")
    public ReturnVO getProgressPage(Long id) {
        return ReturnVO.getSuccess(productionService.getProgressPage(id));
    }

    /**
     * 按照时间查看生产排单
     *
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/date")
    public ReturnVO getProduceDate(String startDate, String endDate) {
        return ReturnVO.getSuccess(productionService.getProduceDate(startDate, endDate));
    }

    /**
     * 任务详情页
     * @param operationId
     * @param operationStatus
     * @param operationType
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/task")
    public ReturnVO getTodayTasks(
                                  Long operationId,
                                  Integer operationStatus,
                                  Integer operationType,
                                  @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                  @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(productionService.getTodayTasks(operationId, operationStatus, operationType,  pageRequest));
    }

    /**
     * 操作工完成任务
     * @param id
     * @param operationId
     * @param remark
     * @param imgUrl
     * @return
     */
    @PostMapping("/operationTaskOver")
    public ReturnVO operationTaskOver(@RequestJson("id") Long id, @RequestJson("operationId") Long operationId, @RequestJson("remark") String remark, @RequestJson("imgUrl") String imgUrl) {
        productionService.operationTaskOver(id, operationId, remark, imgUrl);
        return ReturnVO.getSuccess();
    }

    /**
     * 构件列表分页
     */
    @GetMapping("/component/list")
    public ReturnVO getComponentPage(String number,
                                     Long projectId,
                                     Long componentTypeId,
                                     Integer buildingNo,
                                     Integer floorNoStart,
                                     Integer floorNoEnd,
                                     @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                     @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(productionService.getComponentPage(number, projectId, componentTypeId, buildingNo, floorNoStart, floorNoEnd, pageRequest));
    }

    /**
     * 根据关键字模糊查询获取构件类型分页
     *
     * @param key
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/componentType/list")
    public ReturnVO getComponentTypePage(
            String key,
            @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
            @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(productionService.getComponentTypePage(key, pageRequest));
    }

    /**
     * 查看项目明细
     *
     * @param id
     * @return
     */
    @GetMapping("/info")
    public ReturnVO getProjectInfo(Long id) {
        return ReturnVO.getSuccess(productionService.getProjectInfo(id));
    }
}
