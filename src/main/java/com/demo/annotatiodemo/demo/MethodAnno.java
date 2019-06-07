package com.demo.annotatiodemo.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MethodAnno:对方法做注解
 *
 * @author zhangxiaoxiang
 * @date: 2019/06/07
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnno {
    /**
     * 色泽
     * @return
     */
    String color();

    /**
     * 个数
     * @return
     */
    String number();
}
