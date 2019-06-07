package com.demo.annotatiodemo.demo;

import java.lang.annotation.*;

/**
 * ParameterAnno:对方法内参数做注解
 *
 * @author zhangxiaoxiang
 * @date: 2019/06/07
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParameterAnno {
    /**
     * 只有一个注释属性,那么直接默认为value,这是规范
     * @return
     */
    String value();
}
