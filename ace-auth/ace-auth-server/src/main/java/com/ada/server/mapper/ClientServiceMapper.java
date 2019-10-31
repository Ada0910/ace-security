package com.ada.server.mapper;

import com.ada.server.entity.ClientService;
import tk.mybatis.mapper.common.Mapper;


/**
 * @ClassName:ClientServiceMapper
 * @author:Ada
 * @date 2019/10/3111:49
 * @Description:
 */
public interface ClientServiceMapper extends Mapper<ClientService> {

    void deleteByServiceId(int id);
}
