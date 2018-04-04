package com.anshishagua.jGenerator;

import com.anshishagua.jGenerator.annotations.EnumConstraint;
import com.anshishagua.jGenerator.annotations.IntConstraint;
import com.anshishagua.jGenerator.annotations.StringConstraint;

import java.lang.reflect.Field;

/**
 * User: lixiao
 * Date: 2018/4/4
 * Time: 上午9:16
 */

public class ObjectGenerator <T> implements Generator<T> {
    private Class<T> objectClass;

    public ObjectGenerator(Class<T> objectClass) {
        this.objectClass = objectClass;
    }

    @Override
    public T generate() {
        try {
            T object = objectClass.newInstance();

            Field [] fields = objectClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                if (field.isAnnotationPresent(StringConstraint.class)) {
                    StringConstraint constraint = field.getAnnotation(StringConstraint.class);
                    StringGenerator generator = new StringGenerator(constraint.minLength(), constraint.maxLength(), constraint.nullable());
                    field.set(object, generator.generate());
                } else if (field.isAnnotationPresent(EnumConstraint.class)) {
                    Class<?> type = field.getType();

                    if (!type.isEnum()) {
                        throw new RuntimeException(type + " is not enum");
                    }

                    EnumGenerator generator = new EnumGenerator(field.getType());
                    field.set(object, generator.generate());
                } else if (field.isAnnotationPresent(IntConstraint.class)) {
                    IntConstraint constraint = field.getAnnotation(IntConstraint.class);

                    IntGenerator generator = new IntGenerator(constraint.min(), constraint.max());
                    field.set(object, generator.generate());
                }
            }

            return object;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}