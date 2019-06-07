package com.demo.annotatiodemo.test;

import com.demo.annotatiodemo.demo.FieldAnno;
import com.demo.annotatiodemo.demo.MethodAnno;
import com.demo.annotatiodemo.demo.ParameterAnno;
import com.demo.annotatiodemo.demo.TypeAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * TestAnno:测试类上的注解
 * 这个类就是注解"注释"的类,就是对Test这个类进行解释说明一下
 *
 * @author zhangxiaoxiang
 * @date: 2019/06/07
 */
//类上注解
@TypeAnno(getName = "我是类上注解值1", getValue = "我是类上注解值2")
public class TestAnno {
    /**
     * 属性上注解
     */
    @FieldAnno(length = "我是属性注解上的值1", price = "我是属性注解上的值2")
    private String fieldVal = "我是打酱油的属性,通过注解可以获取到我这个属性上注解的值";

    /**
     * 方法上注解
     */
    @MethodAnno(color = "我是方法上注解值1", number = "我是方法上注解值2")
    public void method1() {
        System.out.println("我是该类的方法,上面的注解标识的就是方法注解");
    }

    /**
     * 方法参数内的注解
     *
     * @param param1
     * @param param2
     */
    public void method2(@ParameterAnno("我是方法参数param1") String param1, @ParameterAnno("我是方法参数param2") String param2) {
        System.out.println("我是方法参数注解" + param1 + param2);
    }


    public static void main(String[] args) throws NoSuchMethodException {

        Class<TestAnno> clazz = TestAnno.class;
        //isAnnotationPresent --- 检测该元素是否被对应注解修饰
        if (clazz.isAnnotationPresent(TypeAnno.class)) {
            //获取类上的注释
            TypeAnno annotation = clazz.getAnnotation(TypeAnno.class);
            System.out.println("1类上注解,值为===>" + annotation.getName() + "  " + annotation.getValue());
        }

        //获取"属性变量"上的注解的值(先反射获取所有,当然就包括注解了赛,都是老套路)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {

            if (field.isAnnotationPresent(FieldAnno.class)) {
                FieldAnno fieldAnnotation = field.getAnnotation(FieldAnno.class);
                System.out.println("2属性上注解,值为===>" + fieldAnnotation.length() + "  " + fieldAnnotation.price());
            }
        }

        //获取方法上的注解的值
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodAnno.class)) {
                MethodAnno methodAnnotation = method.getAnnotation(MethodAnno.class);
                System.out.println("3方法上注解,值为===>" + methodAnnotation.color() + "  " + methodAnnotation.number());
            }

        }


        //获取注解方法内的注解参数值
        Method method = clazz.getDeclaredMethod("method2", String.class, String.class);
        String[] paremsNameByAnno = getMethodParemsNameByAnno(method);
        System.out.println("4获取方法内部的注解的参数值(列表),值为===>" + Arrays.toString(paremsNameByAnno));


    }

    /**
     * 反射获取方法注解内部的参数列表
     *
     * @param method
     * @return
     */
    static String[] getMethodParemsNameByAnno(Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations == null || parameterAnnotations.length == 0) {
            return null;
        }
        String[] params = new String[parameterAnnotations.length];
        Integer i = 0;
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof ParameterAnno) {
                    ParameterAnno param = ((ParameterAnno) annotation);
                    params[i++] = param.value();
                }

            }
        }
        return params;


    }

}
