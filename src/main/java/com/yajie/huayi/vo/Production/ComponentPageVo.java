package com.yajie.huayi.vo.Production;

import com.yajie.huayi.domain.Component;
import com.yajie.huayi.domain.ComponentType;
import com.yajie.huayi.domain.Project;
import com.yajie.huayi.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yaoby
 * @version 1.0
 * @date 2020/7/3 17:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentPageVo {
    private Long id;
    /**
     * 构件编号
     */
    private String number;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 楼号
     */
    private Integer buildingNo;
    /**
     * 层号
     */
    private Integer floorNo;
    /**
     * 类型
     */
    private ComponentType type;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 创建时间
     */
    private String createAt;
    private Integer status;

    public static ComponentPageVo of(Component component, ComponentType type, Project project){
        return ComponentPageVo.builder()
                .id(component.getId())
                .number(component.getNumber())
                .projectName(project.getName())
                .buildingNo(component.getBuildingNo())
                .floorNo(component.getFloorNo())
                .type(type)
                .createName(component.getCreateName())
                .createAt(CommonUtil.dateToStr(component.getCreateAt()))
                .status(component.getStatus())
                .build();
    }

}
