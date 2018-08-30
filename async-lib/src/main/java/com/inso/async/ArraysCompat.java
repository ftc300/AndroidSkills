package com.inso.async;

import java.lang.reflect.Array;

/**
 * Comment:兼容旧版本Android的 {@link Arrays}。
 * Author: ftc300
 * Date: 2018/8/30
 * Blog: www.ftc300.pub
 * GitHub: https://github.com/ftc300
 */
public class ArraysCompat {

    @SuppressWarnings("unchecked")
    public static <T> T[] copyOf(T[] original, int newLength) {
        return (T[]) copyOf(original, newLength, original.getClass());
    }

    public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        T[] copy = ((Object) newType == (Object) Object[].class) ? (T[]) new Object[newLength] : (T[]) Array
                .newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }
}
