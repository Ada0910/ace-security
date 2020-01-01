package com.ada.admin.controller;

import com.ada.admin.biz.GateLogBiz;
import com.ada.admin.entity.GateLog;
import com.ada.common.controller.BaseController;
import com.ada.common.response.TableResultResponse;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
/**
 * @ClassName:GateLogController
 * @author: Ada
 * @date 2019/10/23 15:09
 * @Description:
 */
@Controller
@RequestMapping("gateLog")
public class GateLogController extends BaseController<GateLogBiz, GateLog> {

   /* @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<GateLog> page(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1")int offset, String name){
        Example example = new Example(GateLog.class);
        if(StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("menu", "%" + name + "%");
        }
        int count = baseBiz.selectCountByExample(example);
        PageHelper.startPage(offset, limit);
        return new TableResultResponse<GateLog>(count,baseBiz.selectByExample(example));
    }*/
}
