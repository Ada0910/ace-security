package com.ada.client;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfig.class)
@Documented
@Inherited
public @interface EnableAceAuthClient {
}
