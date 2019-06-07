package com.demo.annotatiodemo.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FieldAnno:对属性做注解
 *
 * @author zhangxiaoxiang
 * @date: 2019/06/07
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnno {
    /**
     * 长度
     * @return
     */
    String length();

    /**
     * 价格
     * @return
     */
    String price();
}
