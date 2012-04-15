package halo.spring3quartz2;

import org.quartz.JobDetail;
import org.quartz.Trigger;

/**
 * 触发器
 * 
 * @author akwei
 */
public abstract class TriggerBean {

    protected String jobClassName = MethodInvokerJobBean.class.getName();

    /**
     * 设置触发器调用的job类型，默认类型为 {@link MethodInvokerJobBean}
     * 
     * @param jobClassName
     */
    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    /**
     * 创建触发器
     * 
     * @return
     */
    public abstract Trigger createTrigger();

    public abstract JobDetail getJobDetail();
}
