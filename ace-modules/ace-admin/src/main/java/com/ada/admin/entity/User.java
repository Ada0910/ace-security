package com.ada.admin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName:User
 * @author: Ada
 * @date 2019/09/30 10:42
 * @Description:
 */
@Getter
@Setter
@Table(name = "base_user")
public class User {
    @Id
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "email")
    private String email;

    @Column(name = "tel_phone")
    private String telPhone;

    @Column(name = "sex")
    private String sex;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
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

    @Column(name = "attr1")
    private String attr1;

    @Column(name = "attr2")
    private String attr2;

    @Column(name = "attr3")
    private String attr3;

    @Column(name = "attr4")
    private String attr4;

    @Column(name = "attr5")
    private String attr5;

    @Column(name = "attr6")
    private String attr6;

    @Column(name = "attr7")
    private String attr7;

    @Column(name = "attr8")
    private String attr8;


}
