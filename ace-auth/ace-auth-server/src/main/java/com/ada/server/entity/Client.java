package com.ada.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Ada
 * @ClassName :Client
 * @date 2019/9/27 23:10
 * @Description:
 */
@Setter
@Getter
@Table(name = "auth_client")
public class Client {
    @Id
    private Integer id;

    private String code;

    private String secret;

    private String locked = "0";

    private String description;

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Column(name = "crt_host")
    private String crtHost;

    @Column(name = "upd_time")
    private Date updTime;

    @Column(name = "upd_user")
    private String updUser;

    @Column(name = "upd_name")
    private String updName;

    @Column(name = "upd_host")
    private String updHost;

    private String attr1;

    private String attr2;

    private String attr3;

    private String attr4;

    private String attr5;

    private String attr6;

    private String attr7;

    private String attr8;


}
