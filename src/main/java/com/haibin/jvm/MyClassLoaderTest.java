package com.haibin.jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * 自定义类加载器示例一
 * 自定义类加载器只需要继承java.lang.ClassLoader类，该类有两个核心方法，一个是loadClass(String,boolean),实现了双亲委派机制。
 * 还有一个方法是findClass,默认实现是空方法，所以我们自定义类加载器主要是重写findClass方法。
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath){
            this.classPath = classPath;
        }

        private byte[] getByte(String name) throws Exception{
            name = name.replaceAll("\\.","/");
            FileInputStream fileInputStream = new FileInputStream(classPath + "/" + name + ".class");
            int len = fileInputStream.available();
            byte[] data = new byte[len];
            fileInputStream.read(data);
            fileInputStream.close();
            return data;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException{
            try{
                byte[] data = getByte(name);
                //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
                return defineClass(name,data,0,data.length);
            }catch (Exception e){
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();

                    if (c == null) {
                        // If still not found, then invoke findClass in order
                        // to find the class.
                        long t1 = System.nanoTime();
                       if (!name.startsWith("com.haibin.jvm")){
                            c = this.getParent().loadClass(name);
                        }else{
                            c = findClass(name);
                        }
                        // this is the defining class loader; record the stats
                        sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                        sun.misc.PerfCounter.getFindClasses().increment();
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    public static void main(String args[]) throws Exception{
        //初始化自定义类加载器，会先初始化父类ClassLoader,其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
        MyClassLoader classLoader = new MyClassLoader("D:/test");
        //D盘创建test/com/haibin/jvm 几级目录，将User类的复制类User1.class丢入该目录
        Class clazz = classLoader.loadClass("com.haibin.jvm.User");
        Object obj = clazz.newInstance();
        //调用say方法
        Method method = clazz.getDeclaredMethod("say",null);
        method.invoke(obj,null);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }

}
