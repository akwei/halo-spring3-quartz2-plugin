package halo.spring3quartz2;

import java.util.List;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 通过spring配合使用的辅助类
 * 
 * @author akwei
 */
public class SchedulerFactoryBean implements InitializingBean {

    private List<MethodInvokerTriggerBean> triggers;

    public void setTriggers(List<MethodInvokerTriggerBean> triggers) {
        this.triggers = triggers;
    }

    public List<MethodInvokerTriggerBean> getTriggers() {
        return triggers;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        for (MethodInvokerTriggerBean triggerBean : triggers) {
            sched.scheduleJob(triggerBean.createTrigger());
        }
    }
}
