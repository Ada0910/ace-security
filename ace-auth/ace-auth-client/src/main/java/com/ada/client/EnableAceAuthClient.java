package com.ada.client;

import com.ada.client.config.AutoConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoConfig.class)
@Documented
@Inherited
public @interface EnableAceAuthClient {
}
