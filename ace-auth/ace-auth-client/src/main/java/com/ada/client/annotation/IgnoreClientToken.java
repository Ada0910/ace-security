package com.ada.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName:IgnoreClientToken
 * @author:Ada
 * @date 2019/10/2316:42
 * @Description:
 */
/**
 * @Target 此注解的作用目标，括号里METHOD的意思说明此注解只能加在方法上面,TYPE意思是可注解于类上
 * @Retention 注解的保留位置，括号里RUNTIME的意思说明注解可以存在于运行时，可以用于反射
 * @Documented 说明该注解将包含在javadoc中
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface IgnoreClientToken {
}