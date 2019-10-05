package com.ada.common.controller;

import com.ada.common.biz.BaseBiz;
import com.ada.common.response.ObjectRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ada
 * @ClassName :BaseController
 * @date 2019/10/3 15:55
 * @Description:
 */
@Slf4j
public class BaseController<Biz extends BaseBiz, Entity> {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected Biz baseBiz;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity) {
        baseBiz.insertSelective(entity);
        return new ObjectRestResponse<Entity>();
    }

}
