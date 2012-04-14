package halo.spring3quartz2;

/**
 * 设置指定对象的方法
 * 
 * @author akwei
 */
public class MethodHandler {

    private Object targetObject;

    private String targetMethod;

    public Object getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }
}
