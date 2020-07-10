package com.yajie.huayi.vo;

import lombok.*;

import java.util.ArrayList;

/**
 * 返回的内容为分页时的VO
 *
 * @author zhangjicheng
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@Builder
public class ReturnPageVO {
    private Long totalElement;
    private Integer totalPage;
    private String name;
    private Boolean isOnline;
    private Object items;

    public static ReturnPageVO of(Long totalElement, Integer totalPage,Object items){
        return ReturnPageVO.builder().totalElement(totalElement).totalPage(totalPage).items(items).build();
    }

    public static ReturnPageVO of(Long totalElement, Integer totalPage, String name, Boolean isOnline, Object items) {
        return ReturnPageVO.builder().totalElement(totalElement).totalPage(totalPage).name(name).isOnline(isOnline).items(items).build();
    }

    public static ReturnPageVO ofDefault(){
        return ReturnPageVO.builder().totalElement(0L).totalPage(0).items(new ArrayList<>()).build();
    }
}
