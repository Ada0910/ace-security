package com.ada.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Ada
 * @ClassName :GateLog
 * @date 2019/10/3 10:34
 * @Description:
 */
@Getter
@Setter
@Table(name = "gate_log")
public class GateLog {
    @Id
    private Integer id;

    private String menu;

    private String option;

    private String uri;

    private String body;

    @Column(name = "crt_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Column(name = "crt_host")
    private String crtHost;
}
