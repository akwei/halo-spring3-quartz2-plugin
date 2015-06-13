package halo.spring3quartz2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 工具类
 * 
 * @author akwei
 */
public class ObjectUtil {

    /**
     * 方法缓存 key为className#methodName value为method对象
     */
    private final static Map<String, Method> map = new HashMap<String, Method>();

    /**
     * 创建对象中指定的method,此method必须是无参数形式
     * 
     * @param object
     *            持有method的对象
     * @param methodName
     *            method的名称
     * @return 对象中的方法
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    public static synchronized Method getMethod(Object object, String methodName)
            throws SecurityException, NoSuchMethodException {
        String key = object.getClass().getName() + "#" + methodName;
        Method method = map.get(key);
        if (method == null) {
            method = object.getClass().getMethod(methodName);
            map.put(key, method);
        }
        return method;
    }
}