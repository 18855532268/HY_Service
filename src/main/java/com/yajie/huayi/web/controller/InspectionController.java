package com.yajie.huayi.web.controller;

import com.yajie.huayi.constant.Constants;
import com.yajie.huayi.service.InspectionService;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Production.InspectionDetailsVo;
import com.yajie.huayi.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/14 11:55
 */
@RestController
@Slf4j
@RequestMapping("/inspection")
public class InspectionController {
    @Autowired
    private InspectionService inspectionService;

    /**
     *
     * @param inspectionDetailsVo
     * @return
     */
    @PostMapping("/add")
    public ReturnVO addInspection(@RequestBody InspectionDetailsVo inspectionDetailsVo){
        inspectionService.addInspection(inspectionDetailsVo);
        return ReturnVO.getSuccess();
    }
    @GetMapping("/list")
    public ReturnVO getInspections(Long id,
                         Long componentId,
                         Integer status,
                         Long inspectorId,
                         String remark,
                         Integer type,
                         @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                         @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize){
        PageRequest pageRequest = new PageRequest(page, pageSize);
        inspectionService.getInspections(id, componentId, status, inspectorId, remark, type, pageRequest);
        return ReturnVO.getSuccess();
    }
}
