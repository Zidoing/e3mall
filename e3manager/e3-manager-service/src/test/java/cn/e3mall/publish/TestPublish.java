package cn.e3mall.publish;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 29/08/2018
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TestPublish {

    @Test
    public void publishService() throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

        while (true) {
            Thread.sleep(1000);
        }
    }

}