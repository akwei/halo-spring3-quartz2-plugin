package halo.spring3quartz2;

import static org.quartz.JobBuilder.newJob;

import org.quartz.Job;
import org.quartz.JobDetail;

/**
 * 方法调用的触发器辅助类,可以设置指定对象的方法，方便创建jobdetail，便于触发器调用
 * 
 * @author akwei
 */
public abstract class MethodInvokerTriggerBean extends TriggerBean {

    protected MethodHandler methodHandler;

    /**
     * 设置方法调用JobDetail
     * 
     * @param methodHandler
     */
    public void setMethodHandler(MethodHandler methodHandler) {
        this.methodHandler = methodHandler;
    }

    @Override
    public JobDetail getJobDetail() {
        try {
            return this.createJobDetail();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建JobDetail
     * 
     * @return
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public JobDetail createJobDetail() throws ClassNotFoundException {
        Class<? extends Job> clazz;
        if (this.jobClassName == null || this.jobClassName.trim().length() == 0) {
            clazz = MethodInvokerJobBean.class;
        }
        else {
            clazz = (Class<? extends Job>) (this.getClass().getClassLoader()
                    .loadClass(this.jobClassName));
        }
        JobDetail jobDetail = newJob(clazz).withIdentity("job" + Math.random(),
                "group1").build();
        jobDetail.getJobDataMap().put("methodHandler", this.methodHandler);
        return jobDetail;
    }
}