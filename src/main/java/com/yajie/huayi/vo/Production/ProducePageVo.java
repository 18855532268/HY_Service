package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.Component;
import com.yajie.huayi.domain.Mold;
import com.yajie.huayi.domain.Project;
import com.yajie.huayi.domain.User;
import com.yajie.huayi.util.CommonUtil;
import lombok.Builder;
import lombok.Data;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/9 10:02
 */
@Data
@Builder
public class ProducePageVo {
    private String projectNum;
    private String componentNum;
    private Integer status;
    /**
     * 扎钢筋日期
     */
    private String steelBarBindingAt;
    /**
     * 钢筋区域
     */
    private String steelArea;
    /**
     * 钢筋质检员
     */
    private String steeler;
    /**
     * 搭模时间
     */
    private String moldieAt;
    /**
     * 模台
     */
    private String moldNum;
    /**
     * 搭模质检
     */
    private String molder;
    /**
     * 浇筑日期
     */
    private String pourAt;
    /**
     * 脱模日期
     */
    private String demouldAt;
    /**
     * 脱模质检
     */
    private String demoulder;
    /**
     * 成品质检
     */
    private String finisheder;

    public static ProducePageVo of(Project project, Component component,
                                   User steeler, User molder, Mold mold, User demoulder, User finisheder){
        return ProducePageVo.builder()
                .projectNum(project.getNumber())
                .componentNum(component.getNumber())
                .status(component.getStatus())
                .steelBarBindingAt(component.getSteelBarBindingAt()== null ? "": CommonUtil.dateToStr(component.getSteelBarBindingAt()))
                .steelArea(component.getSteelArea())
                .steeler(steeler == null ? "":steeler.getUsername())
                .moldNum(mold== null ? "":mold.getNumber())
                .moldieAt(component.getMoldieAt()== null ? "": CommonUtil.dateToStr(component.getMoldieAt()))
                .molder(molder == null ? "":molder.getUsername())
                .pourAt(component.getPourAt()== null ? "": CommonUtil.dateToStr(component.getPourAt()))
                .demouldAt(component.getDemouldAt()== null ? "": CommonUtil.dateToStr(component.getDemouldAt()))
                .demoulder(demoulder == null ? "":demoulder.getUsername())
                .finisheder(finisheder == null ? "":finisheder.getUsername())
                .build();
    }
}