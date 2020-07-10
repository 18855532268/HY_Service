package com.yajie.huayi.service.ex;

import com.yajie.huayi.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时处理Service
 *
 * @author zhangjicheng
 */
@Component
@Lazy(false)
@Slf4j
public class ScheduledService {

    /**
     * 定时任务   防止crt断开连接
     */
    @Scheduled(cron = "0 0/3 * * * *")
    public void outPut() {
        log.info("定时任务：{}", CommonUtil.dateToStr(new Date()));
    }
}
