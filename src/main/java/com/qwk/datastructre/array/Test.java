package com.qwk.datastructre.array;

import java.net.URL;
import java.util.Enumeration;

public class Test {

    public static void main(String[] args) throws Exception{

        ClassLoader classLoader = Test.class.getClassLoader();
        Enumeration<URL> resources = classLoader.getResources("com/qwk/datastructre/array/");
        while (resources.hasMoreElements()) {
            System.out.println(resources.nextElement());
        }

    }

}
