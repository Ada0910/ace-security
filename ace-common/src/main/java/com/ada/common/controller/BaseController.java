package com.ada.common.controller;

import com.ada.common.biz.BaseBiz;
import com.ada.common.context.BaseContext;
import com.ada.common.response.ObjectRestResponse;
import com.ada.common.response.TableResultResponse;
import com.ada.common.util.QueryUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<Entity> get(@PathVariable int id) {
        ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
        Object object = baseBiz.selectById(id);
        entityObjectRestResponse.data((Entity) object);
        return entityObjectRestResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse<Entity> update(@RequestBody Entity entity) {
        baseBiz.updateSelectiveById(entity);
        return new ObjectRestResponse<Entity>();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ObjectRestResponse<Entity> remove(@PathVariable int id) {
        baseBiz.deleteById(id);
        return new ObjectRestResponse<Entity>();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Entity> all() {
        return baseBiz.selectListAll();
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        QueryUtil queryUtil = new QueryUtil(params);
        return baseBiz.selectByQuery(queryUtil);
    }

    public String getCurrentUsername() {
        return BaseContext.getUsername();
    }
}
