package com.anshishagua.jGenerator.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: lixiao
 * Date: 2018/4/5
 * Time: 下午5:50
 */

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface LongGenerate {
    long min() default Long.MIN_VALUE;
    long max() default Long.MAX_VALUE;
}
