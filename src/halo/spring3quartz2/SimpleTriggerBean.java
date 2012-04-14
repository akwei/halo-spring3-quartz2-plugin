package halo.spring3quartz2;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.Trigger;

/**
 * 循环调用触发器
 * 
 * @author akwei
 */
public class SimpleTriggerBean extends MethodInvokerTriggerBean {

    private long startDelay;

    private long repeatInterval;

    public long getStartDelay() {
        return startDelay;
    }

    /**
     * 设置触发器启动延迟时间,单位为毫秒
     * 
     * @param startDelay
     */
    public void setStartDelay(long startDelay) {
        this.startDelay = startDelay;
    }

    public long getRepeatInterval() {
        return repeatInterval;
    }

    /**
     * 设置触发器循环间隔时间,单位为毫秒
     * 
     * @param repeatInterval
     */
    public void setRepeatInterval(long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    @Override
    public Trigger createTrigger() {
        try {
            return newTrigger()
                    .withIdentity(
                            "trigger" + Math.random()
                                    + System.currentTimeMillis()
                                    + Math.random(), "group1")
                    .startAt(
                            new Date(System.currentTimeMillis()
                                    + this.startDelay))
                    .withSchedule(
                            simpleSchedule().withIntervalInMilliseconds(
                                    this.repeatInterval).repeatForever())
                    .forJob(this.createJobDetail()).build();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}