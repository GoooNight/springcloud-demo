package designMode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 雨天留恋
 * 单例模式
 */
public class SingleInstance {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<LazySingleInstance> constructor = LazySingleInstance.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleInstance lazySingleInstance = constructor.newInstance();
        LazySingleInstance instance = LazySingleInstance.getInstance();
        System.out.println(lazySingleInstance == instance);
    }
}

/**
 * 懒汉模式
 */
class LazySingleInstance{
    /**
     * volatile防止指令重排序
     */
    private volatile static LazySingleInstance instance;

    /**
     * 防止反射获取构造方法创建实例，但是由于没有初始化，需要调用getInstance()之后才会初始化，所以无法防止反射
     */
    private  LazySingleInstance(){
        if (instance != null) {
            throw new RuntimeException("单例不允许多例");
        }
    }

    public static  LazySingleInstance getInstance() {
        if (instance == null) {
            synchronized (LazySingleInstance.class){
                if (instance == null) {
                    instance = new LazySingleInstance();
                }
            }
        }
        return instance;
    }
}

/**
 * 饿汉模式
 */
class HungrySingleInstance{
    private static HungrySingleInstance instance = new HungrySingleInstance();

    // 防止反射获取构造方法创建实例
    private HungrySingleInstance() {
        if (instance != null) {
            throw new RuntimeException("单例不允许多例");
        }
    }

    public static HungrySingleInstance getInstance() {
        return instance;
    }
}

/**
 * 静态内部类
 */
class InnerClassSingleInstance{
    private static class InnerClassHolder{
        private static InnerClassSingleInstance instance = new InnerClassSingleInstance();
    }
    // 防止反射获取构造方法创建实例
    private InnerClassSingleInstance() {
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例不允许多例");
        }
    }

    public static InnerClassSingleInstance getInstance() {
        return InnerClassHolder.instance;
    }

}
