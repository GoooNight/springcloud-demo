package com.wei.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

/**
 * @author 雨天留恋
 * @date 2023-06-25 10:45
 */
public class WeiSpringApplicationContext {
    private Class appConfig;

    public WeiSpringApplicationContext(Class appConfig) {
        this.appConfig = appConfig;

        // 扫描
        if (appConfig.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) appConfig.getAnnotation(ComponentScan.class);
            String path1 = componentScan.value(); //

            String path = path1.replace(".", "/");

            ClassLoader classLoader = WeiSpringApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            assert resource != null;
            File file = new File(resource.getFile());
            System.out.println(file);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    String name = f.getName();
                    System.out.println(name);
                    String className = path1 + "." + name.substring(0, name.indexOf(".class"));
                    System.out.println(className);
                    if (name.endsWith(".class")) {
                        try {
                            Class<?> aClass = classLoader.loadClass(className);

                            if (aClass.isAnnotationPresent(ComponentScan.class)) {
                                // Bean

                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        }
    }

    public Object getBean(String beanName) {
        return null;
    }
}
