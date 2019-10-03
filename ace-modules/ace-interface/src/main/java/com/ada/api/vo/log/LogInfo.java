package com.ada.api.vo.log;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ada
 * @ClassName :LogInfo
 * @date 2019/10/3 11:29
 * @Description:
 */
@Getter
@Setter
public class LogInfo implements Serializable {
    private String menu;

    private String opt;

    private String uri;

    private Long crtTime;

    private String crtUser;

    private String crtName;

    private String crtHost;

    private String body;

    public LogInfo(String menu, String option, String uri, Date crtTime, String crtUser, String crtName, String crtHost, String body) {
        this.menu = menu;
        this.opt = option;
        this.uri = uri;
        this.crtTime = crtTime.getTime();
        this.crtUser = crtUser;
        this.crtName = crtName;
        this.crtHost = crtHost;
        this.body = body;
    }

    public LogInfo() {
    }
}
