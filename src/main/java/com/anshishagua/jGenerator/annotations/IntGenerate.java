package com.anshishagua.jGenerator.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: lixiao
 * Date: 2018/4/2
 * Time: 下午11:42
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface IntGenerate {
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;
}
