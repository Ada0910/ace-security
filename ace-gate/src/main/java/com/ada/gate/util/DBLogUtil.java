package com.ada.gate.util;

import com.ada.api.vo.log.LogInfo;
import com.ada.gate.feign.ILogServiceFeign;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName:DBLog
 * @author: Ada
 * @date 2019/11/14 11:03
 * @Description:
 */
@Slf4j
public  class DBLogUtil extends Thread {
    private static DBLogUtil dblog = null;
    private static BlockingDeque<LogInfo> logInfoQueue = new LinkedBlockingDeque<>(1024);
    private ILogServiceFeign logServiceFeign;

    private DBLogUtil() {
        super("CLogOracleWriterThread");
    }

    public static synchronized DBLogUtil getInstance() {
        if (dblog == null) {
            dblog = new DBLogUtil();
        }
        return dblog;
    }

    public DBLogUtil setLogService(ILogServiceFeign logService) {
        if (this.logServiceFeign == null) {
            this.logServiceFeign = logService;
        }
        return this;
    }

    public ILogServiceFeign getLogService() {
        return logServiceFeign;
    }

    public void offerQueue(LogInfo logInfo) {
        try {
            logInfoQueue.offer(logInfo);
        } catch (Exception e) {
            log.error("日志写入失败", e);
        }
    }

    @Override
    public void run() {
        //缓存队列
        List<LogInfo> bufferLogList = new ArrayList<>();
        while (true) {
            try {
                bufferLogList.add(logInfoQueue.take());
                logInfoQueue.drainTo(bufferLogList);
                if (bufferLogList != null && bufferLogList.size() > 0) {
                    //写入日志
                    for (LogInfo log : bufferLogList) {
                        logServiceFeign.saveLog(log);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                // 防止缓冲队列填充数据出现异常时不断刷屏
                try {
                    Thread.sleep(1000);
                } catch (Exception eee) {
                }
            } finally {
                if (bufferLogList != null && bufferLogList.size() > 0) {
                    try {
                        bufferLogList.clear();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}
