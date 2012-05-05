package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/test.xml" })
public class Happy {

    private final Log log = LogFactory.getLog(Happy.class);

    public void invoke() {
        log.info("happy invoke");
    }

    public void invoke2() {
        log.info("happy invoke2");
    }

    @Test
    public void test() {
        while (true) {
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}