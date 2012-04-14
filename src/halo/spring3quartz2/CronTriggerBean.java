package halo.spring3quartz2;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.Trigger;

/**
 * cron触发器
 * 
 * @author akwei
 */
public class CronTriggerBean extends MethodInvokerTriggerBean {

    private String cronExpression;

    /**
     * cron表达式
     * 
     * @param cronExpression
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Override
    public Trigger createTrigger() {
        try {
            return newTrigger()
                    .withIdentity(
                            "trigger" + Math.random()
                                    + System.currentTimeMillis()
                                    + Math.random(), "group1")
                    .withSchedule(cronSchedule(cronExpression))
                    .forJob(this.createJobDetail()).build();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
