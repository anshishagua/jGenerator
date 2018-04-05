package com.anshishagua.jGenerator;

import com.anshishagua.jGenerator.annotations.BooleanGenerate;
import com.anshishagua.jGenerator.annotations.ByteGenerate;
import com.anshishagua.jGenerator.annotations.CharGenerate;
import com.anshishagua.jGenerator.annotations.DoubleGenerate;
import com.anshishagua.jGenerator.annotations.EnumGenerate;
import com.anshishagua.jGenerator.annotations.FloatGenerate;
import com.anshishagua.jGenerator.annotations.Generate;
import com.anshishagua.jGenerator.annotations.IntGenerate;
import com.anshishagua.jGenerator.annotations.LocalDateGenerate;
import com.anshishagua.jGenerator.annotations.LocalDateTimeGenerate;
import com.anshishagua.jGenerator.annotations.LocalTimeGenerate;
import com.anshishagua.jGenerator.annotations.LongGenerate;
import com.anshishagua.jGenerator.annotations.ShortGenerate;
import com.anshishagua.jGenerator.annotations.Size;
import com.anshishagua.jGenerator.annotations.StringGenerate;
import com.anshishagua.jGenerator.datetime.DateGenerator;
import com.anshishagua.jGenerator.datetime.DateTimeGenerator;
import com.anshishagua.jGenerator.datetime.TimeGenerator;
import com.anshishagua.jGenerator.enumeration.EnumGenerator;
import com.anshishagua.jGenerator.primitive.BooleanGenerator;
import com.anshishagua.jGenerator.primitive.ByteGenerator;
import com.anshishagua.jGenerator.primitive.CharGenerator;
import com.anshishagua.jGenerator.primitive.DoubleGenerator;
import com.anshishagua.jGenerator.primitive.FloatGenerator;
import com.anshishagua.jGenerator.primitive.IntGenerator;
import com.anshishagua.jGenerator.primitive.LongGenerator;
import com.anshishagua.jGenerator.primitive.ShortGenerator;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * User: lixiao
 * Date: 2018/4/4
 * Time: 上午9:16
 */

public class ObjectGenerator <T> implements Generator<T> {
    private Class<T> objectClass;
    private boolean genAllFields = false;

    public ObjectGenerator(Class<T> objectClass) {
        this.objectClass = objectClass;
    }

    @Override
    public T generate() {
        try {
            if (objectClass.isAnnotationPresent(Generate.class)) {
                genAllFields = true;
            }

            T object = objectClass.newInstance();

            Field [] fields = objectClass.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);

                Class<?> type = field.getType();
                Object value = null;

                Generator<?> generator = null;

                if (type == boolean.class || type == Boolean.class) {
                    if (field.isAnnotationPresent(BooleanGenerate.class) || genAllFields) {
                        generator = new BooleanGenerator();

                        value = generator.generate();
                    }
                }
                else if (type == byte.class || type == Byte.class) {
                    if (!field.isAnnotationPresent(ByteGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(ByteGenerate.class)) {
                        ByteGenerate constraint = field.getAnnotation(ByteGenerate.class);
                        generator = new ByteGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new ByteGenerator();
                    }

                    value = generator.generate();
                }
                else if (type == char.class || type == Character.class) {
                    if (!field.isAnnotationPresent(CharGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(CharGenerate.class)) {
                        CharGenerate constraint = field.getAnnotation(CharGenerate.class);
                        generator = new CharGenerator();

                        value = generator.generate();
                    }
                }
                else if (type == short.class || type == Short.class) {
                    if (!field.isAnnotationPresent(ShortGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(ShortGenerate.class)) {
                        ShortGenerate constraint = field.getAnnotation(ShortGenerate.class);
                        generator = new ShortGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new ShortGenerator();
                    }

                    value = generator.generate();
                }
                else if (type == int.class || type == Integer.class) {
                    if (!field.isAnnotationPresent(IntGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(IntGenerate.class)) {
                        IntGenerate constraint = field.getAnnotation(IntGenerate.class);
                        generator = new IntGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new IntGenerator();
                    }

                    value = generator.generate();
                }
                else if (type == long.class || type == Long.class) {
                    if (!field.isAnnotationPresent(LongGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(LongGenerate.class)) {
                        LongGenerate constraint = field.getAnnotation(LongGenerate.class);
                        generator = new LongGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new LongGenerator();
                    }

                    value = generator.generate();
                }
                else if (type == float.class || type == Float.class) {
                    if (!field.isAnnotationPresent(FloatGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(FloatGenerate.class)) {
                        FloatGenerate constraint = field.getAnnotation(FloatGenerate.class);
                        generator = new FloatGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new FloatGenerator();
                    }

                    value = generator.generate();
                }
                else if (type == double.class || type == Double.class) {
                    if (!field.isAnnotationPresent(DoubleGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(DoubleGenerate.class)) {
                        DoubleGenerate constraint = field.getAnnotation(DoubleGenerate.class);
                        generator = new DoubleGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new DoubleGenerator();
                    }

                    value = generator.generate();
                }
                else if (type.isEnum()) {
                    if (!field.isAnnotationPresent(EnumGenerate.class) && !genAllFields) {
                        continue;
                    }

                    generator = new EnumGenerator(type);
                    value = generator.generate();
                }
                else if (type == LocalDate.class) {
                    if (!field.isAnnotationPresent(LocalDateGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(LocalDateGenerate.class)) {
                        LocalDateGenerate constraint = field.getAnnotation(LocalDateGenerate.class);

                        generator = new DateGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new DateGenerator();
                    }

                    value = generator.generate();
                }
                else if (type == LocalTime.class) {
                    if (!field.isAnnotationPresent(LocalTimeGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(LocalTimeGenerate.class)) {
                        LocalTimeGenerate constraint = field.getAnnotation(LocalTimeGenerate.class);

                        generator = new TimeGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new TimeGenerator();
                    }

                    value = generator.generate();
                }
                else if (type == LocalDateTime.class) {
                    if (!field.isAnnotationPresent(LocalDateTimeGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(LocalDateTimeGenerate.class)) {
                        LocalDateTimeGenerate constraint = field.getAnnotation(LocalDateTimeGenerate.class);

                        generator = new DateTimeGenerator(constraint.min(), constraint.max());
                    }
                    else {
                        generator = new DateTimeGenerator();
                    }

                    value = generator.generate();
                }
                else if (type == String.class) {
                    if (!field.isAnnotationPresent(StringGenerate.class) && !genAllFields) {
                        continue;
                    }

                    if (field.isAnnotationPresent(StringGenerate.class)) {
                        StringGenerate constraint = field.getAnnotation(StringGenerate.class);

                        generator = new StringGenerator(constraint.minLength(), constraint.maxLength(), constraint.nullable());
                    }
                    else {
                        generator = new StringGenerator();
                    }

                    value = generator.generate();
                }
                else if (type.isAssignableFrom(List.class)) {
                    if (field.isAnnotationPresent(Size.class)) {
                        Size constraint = field.getAnnotation(Size.class);
                        int size = constraint.value();

                        List<Object> list = new ArrayList<>(size);

                        if (field.getGenericType() instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();

                            ObjectGenerator<?> objectGenerator = new ObjectGenerator<>((Class<?>) parameterizedType.getActualTypeArguments()[0]);

                            for (int i = 0; i < size; ++i) {
                                list.add(objectGenerator.generate());
                            }

                            value = list;
                        }
                    }
                }
                else {
                    if (!field.isAnnotationPresent(Generate.class)) {
                        continue;
                    }

                    ObjectGenerator<?> objectGenerator = new ObjectGenerator<>(type);

                    value = objectGenerator.generate();
                }

                field.set(object, value);
            }

            return object;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}