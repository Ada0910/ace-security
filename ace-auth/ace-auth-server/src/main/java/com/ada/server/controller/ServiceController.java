package com.ada.server.controller;

import com.ada.common.controller.BaseController;
import com.ada.common.response.ObjectRestResponse;
import com.ada.server.biz.ClientBiz;
import com.ada.server.entity.Client;
import com.ada.server.entity.ClientService;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName:ServiceController
 * @author: Ada
 * @date 2019/10/31 11:41
 * @Description:
 */
@RestController
@RequestMapping("service")
public class ServiceController extends BaseController<ClientBiz, Client> {

    @RequestMapping(value = "/{id}/client", method = RequestMethod.PUT)
    @ResponseBody
    public ObjectRestResponse modifyUser(@PathVariable int id, String clients) {
        baseBiz.modifyClientServices(id, clients);
        return new ObjectRestResponse().rel(true);
    }

    @RequestMapping(value = "/{id}/client", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<ClientService> getUsers(@PathVariable int id) {
        return new ObjectRestResponse<ClientService>().rel(true).data(baseBiz.getClientServices(id));
    }
}
