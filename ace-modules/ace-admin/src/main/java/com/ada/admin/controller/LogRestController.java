package com.ada.admin.controller;

import com.ada.admin.biz.GateLogBiz;
import com.ada.admin.entity.GateLog;
import com.ada.api.vo.log.LogInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Ada
 * @ClassName :LogRestController
 * @date 2019/10/26 23:24
 * @Description:
 */
@RequestMapping("api")
@RestController
public class LogRestController {
    @Autowired
    private GateLogBiz gateLogBiz;

    @RequestMapping(value = "/log/save", method = RequestMethod.POST)
    public @ResponseBody
    void saveLog(@RequestBody LogInfo info) {
        GateLog log = new GateLog();
        BeanUtils.copyProperties(info, log);
        log.setCrtTime(new Date(info.getCrtTime()));
        gateLogBiz.insertSelective(log);
    }
}
