package halo.spring3quartz2;

import java.lang.reflect.Method;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 通过反射调用方法进行任务调度
 * 
 * @author akwei
 */
public class MethodInvokerJobBean implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        try {
            MethodHandler methodHandler = (MethodHandler) context
                    .getJobDetail().getJobDataMap().get("methodHandler");
            Method method = ObjectUtil.getMethod(
                    methodHandler.getTargetObject(),
                    methodHandler.getTargetMethod());
            method.invoke(methodHandler.getTargetObject());
        }
        catch (Exception e) {
            throw new MethodInvokeException(e);
        }
    }
}