package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/test.xml" })
public class Happy {

    public void invoke() {
        System.out.println("happy invoke");
    }

    public void invoke2() {
        System.out.println("happy invoke2222");
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