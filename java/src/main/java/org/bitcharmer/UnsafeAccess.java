package org.bitcharmer;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public class UnsafeAccess {

    public static final Unsafe UNSAFE = getUnsafe();

    private static Unsafe getUnsafe() {
        Unsafe unsafe;
        try {
            unsafe = AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>) () ->  {
                Field field = Unsafe.class.getDeclaredField("theUnsafe");
                field.setAccessible(true);
                return (Unsafe) field.get(null);
            });
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return unsafe;
    }

}