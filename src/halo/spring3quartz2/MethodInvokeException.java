package halo.spring3quartz2;

/**
 * 方法调用失败的异常
 * 
 * @author akwei
 */
public class MethodInvokeException extends RuntimeException {

    private static final long serialVersionUID = 8047998022578960623L;

    public MethodInvokeException() {
    }

    public MethodInvokeException(String arg0) {
        super(arg0);
    }

    public MethodInvokeException(Throwable arg0) {
        super(arg0);
    }

    public MethodInvokeException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
