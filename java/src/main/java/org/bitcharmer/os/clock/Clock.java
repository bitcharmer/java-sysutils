package org.bitcharmer.os.clock;

import org.bitcharmer.SysUtils;

public class Clock {

    static {
        SysUtils.loadNativeLib();
    }

    public enum Type {
        REALTIME                (0),
        MONOTONIC               (1),
        PROCESS_CPUTIME_ID      (2),
        THREAD_CPUTIME_ID       (3),
        MONOTONIC_RAW           (4),
        REALTIME_COARSE         (5),
        MONOTONIC_COARSE        (6),
        BOOTTIME                (7),
        REALTIME_ALARM          (8),
        BOOTTIME_ALARM          (9),
        TAI                     (11);

        final int intValue;

        Type(int intValue) {
            this.intValue = intValue;
        }
    }

    public static long clock_gettime(final Type type) {
        return clock_gettime_internal(type.intValue);
    }

    private static native long clock_gettime_internal(int type);

}
