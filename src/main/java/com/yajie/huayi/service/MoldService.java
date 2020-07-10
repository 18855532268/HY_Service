package com.yajie.huayi.service;

import com.yajie.huayi.domain.other.MoldRecordEntity;
import com.yajie.huayi.exception.ErrorMessageException;
import com.yajie.huayi.mapper.MoldMapper;
import com.yajie.huayi.util.Page;
import com.yajie.huayi.util.PageRequest;
import com.yajie.huayi.vo.Materials.MoldRecordPageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/8 10:17
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class, noRollbackFor = {ErrorMessageException.class})
public class MoldService {
    @Autowired
    private MoldMapper moldMapper;


    public Page<MoldRecordPageVo> getMolds(String moldNum, Integer status, Long projectId, String componentNum, PageRequest pageRequest) {
        Long count = moldMapper.findCount(moldNum, status, projectId, componentNum);
        List<MoldRecordEntity> list = new ArrayList<>();
        if (count > 0){
             list = moldMapper.findPage(moldNum, status, projectId, componentNum, pageRequest);
        }
        return new Page<>(pageRequest, MoldRecordPageVo.of(list), count);
    }
}
