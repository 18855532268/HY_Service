package com.yajie.huayi.web.controller;

import com.yajie.huayi.config.myinterface.RequestJson;
import com.yajie.huayi.constant.Constants;
import com.yajie.huayi.service.MaterialsService;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Materials.MaterialsVo;
import com.yajie.huayi.vo.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/6 18:00
 */
@RestController
@Slf4j
@RequestMapping("/materials")
public class MaterialsController {
    @Autowired
    private MaterialsService materialsService;

    /**
     * 添加或修改原材料
     *
     * @param materialsVo
     * @return
     */
    @PostMapping("/addOrModify")
    public ReturnVO addOrModifyMaterials(@RequestBody MaterialsVo materialsVo) {
        materialsService.addOrModifyMaterials(materialsVo);
        return ReturnVO.getSuccess();
    }

    /**
     * 删除原材料
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public ReturnVO deleteMaterials(@RequestJson("id") Long id) {
        materialsService.deleteMaterials(id);
        return ReturnVO.getSuccess();
    }

    /**
     * 获取原材料分页
     *
     * @param id
     * @param name
     * @param countMin
     * @param countMax
     * @param type
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ReturnVO getMaterials(Long id,
                                 String name,
                                 Integer countMin,
                                 Integer countMax,
                                 Integer type,
                                 @RequestParam(defaultValue = Constants.PAGE_DEFAULT_START) Integer page,
                                 @RequestParam(defaultValue = Constants.PAGE_DEFAULT_SIZE) Integer pageSize) {
        PageRequest pageRequest = new PageRequest(page, pageSize);
        return ReturnVO.getSuccess(materialsService.getMaterials(id, name, countMin, countMax, type, pageRequest));
    }

}
