package com.yajie.huayi.constant;

/**
 * ConstantsForDomain class
 * @author yaoby
 * @version 1.0
 * @date 2020/6/29 9:58
 */
public class ConstantsForDomain {
    /**
     * 通用状态
     */
    public final static int NORMAL = 1;
    public final static int DELETE = 9;

    /**
     * 项目状态
     */
    public final static int PROJECT_CUSTOMER_UNAUDIT = 1; // 客户待审核
    public final static int PROJECT_CUSTOMER_AUDIT = 2; // 客户已审核
    public final static int PROJECT_PRODUCTION = 3;    // 项目生产中
    public final static int PROJECT_FINISHED = 4;   // 项目已完成
    public final static int PROJECT_DELETE = 9;
    /**
     * 生产单状态
     */
    public final static int PRODUCTION_UNAUDIT = 1; // 待审核

    /**
     * 构件状态
     */
    public final static int COMPONENT_STATUS_NORMAL =1;
    public final static int COMPONENT_STATUS_PRODUCTION=2;
    public final static int COMPONENT_STATUS_FINISHED=3;
    /**
     * 材料类型
     */
    public final static int MATERIALS_TYPE_STEEL = 1; // 钢筋
    public final static int MATERIALS_TYPE_PART = 2; // 预埋件
//    public final static int MATERIALS_TYPE_MOULD = 3; // 水泥

    /**
     * 材料状态
     */
    public final static int MATERIALS_RECORD_STATUS_NORMAL = 1; // 正常

    /**
     * 模具状态
     */
    public final static int MOLD_STATUS_NORMAL = 1; // 正常
    public final static int MOLD_STATUS_OFF_SHELF = 2; // 下架
    public final static int MOLD_STATUS_UNSHELVES = 3; // 暂不上架

    /**
     * 原材料状态
     *
     */
    public final static int MATERIALS_STATUS_NORMAL = 1;
    public final static int MATERIALS_STATUS_DELETE = 9;

    /**
     * 进度明细
     */
    public final static String COMPONENT_PROGRESS_STEEL = "扎钢筋";
    public final static String COMPONENT_PROGRESS_MOLD = "搭模";
    public final static String COMPONENT_PROGRESS_POUR = "浇筑";
    public final static String COMPONENT_PROGRESS_DEMOULD = "脱模";
    /**
     * 进度状态
     */
    public final static int COMPONENT_PROGRESS_STATUS_NORMAL = 1;
    public final static int COMPONENT_PROGRESS_STATUS_FINISHED = 2;
    public final static int COMPONENT_PROGRESS_STATUS_DELETE = 9;
    /**
     * 操作类型
     */
    public final static int COMPONENT_PROGRESS_STEEL_TYPE = 1;
    public final static int COMPONENT_PROGRESS_MOLD_TYPE = 2;
    public final static int COMPONENT_PROGRESS_POUR_TYPE = 3;
    public final static int COMPONENT_PROGRESS_DEMOULD_TYPE = 4;
}
