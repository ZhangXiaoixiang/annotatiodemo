package com.demo.annotatiodemo.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TypeAnno:对类做注解
 *
 * @author zhangxiaoxiang
 * @date: 2019/06/07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeAnno {
    String getName();
    String getValue();
}
