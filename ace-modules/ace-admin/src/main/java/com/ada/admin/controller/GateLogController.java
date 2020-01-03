package com.ada.admin.controller;

import com.ada.admin.biz.GateLogBiz;
import com.ada.admin.entity.GateLog;
import com.ada.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * @ClassName:GateLogController
 * @author: Ada
 * @date 2019/10/23 15:09
 * @Description:
 */
@Controller
@RequestMapping("gateLog")
public class GateLogController extends BaseController<GateLogBiz, GateLog> {
}
