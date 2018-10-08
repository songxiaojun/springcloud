package com.hfuu.springcloud.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@JobHandler(value = "SyncUserJob")
@Component
@Slf4j
public class SyncUserJob extends IJobHandler implements Serializable {


    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("测试开始");
        XxlJobLogger.log("测试运行");
        XxlJobLogger.log("测试结束");
        return ReturnT.SUCCESS;
    }
}
