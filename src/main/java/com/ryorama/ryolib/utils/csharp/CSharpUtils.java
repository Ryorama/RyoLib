package com.ryorama.ryolib.utils.csharp;

import net.sf.jni4net.Bridge;

import java.io.IOException;

public class CSharpUtils {

    public static boolean initialized = false;

    /**
     * @throws IOException
     *
     * Initializes libraries to allow use of CSharp utilities
     */
    public static void setupCSharpUtils() throws IOException {
        Bridge.setVerbose(true);
        Bridge.init();
        initialized = true;
    }

    /**
     * @param lib
     * @param path
     * @throws IOException
     *
     * Loads a CSharp related library such as a Dll
     */
    public static void loadCSharpLibrary(CSharpLibraries lib, String path) throws IOException {
        //Make sure everything has been initialized properly before proceeding
        if (!initialized) {
            setupCSharpUtils();
        }

        if (lib == CSharpLibraries.DLL) {
            //TODO
        }
    }
}
