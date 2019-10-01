package org.bitcharmer;

import org.scijava.nativelib.NativeLoader;

import java.io.IOException;

public class SysUtils {

    private static boolean loaded;

    public static synchronized void loadNativeLib() {
        if (loaded) return;

        try {
            NativeLoader.loadLibrary("sysutils");
            loaded = true;
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
