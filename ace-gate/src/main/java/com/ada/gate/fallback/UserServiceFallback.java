package com.ada.gate.fallback;

import com.ada.api.vo.authority.PermissionInfo;
import com.ada.gate.feign.IUserServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:UserServiceFallback
 * @author: Ada
 * @date 2019/11/14 16:32
 * @Description:
 */
@Service
@Slf4j
public class UserServiceFallback implements IUserServiceFeign {
    @Override
    public List<PermissionInfo> getPermissionByUserName(String userName) {
        log.error("调用{}异常{}", "getPermissionByUserName", userName);
        return null;
    }

    @Override
    public List<PermissionInfo> getAllPermissionInfo() {
        log.error("调用{}异常", "getPermissionByUserName");
        return null;
    }
}
