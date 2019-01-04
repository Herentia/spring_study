import com.pb.entity.Car;
import com.pb.proxy.CarProxy;
import com.pb.test.Clac;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author haohan
 * 12/20/2018 - 04:45 下午
 */
public class test {

    @Test
    public void test() {

    }

    @Test
    public void test1() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Bean.xml");
        Car car = (Car) classPathXmlApplicationContext.getBean("car1");
        System.out.println(car);
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Bean-stereotype");
        Car car = (Car) classPathXmlApplicationContext.getBean("car");
        System.out.println(car);
    }

    @Test
    public void proxyTest() {
    }

    @Test
    public void aAOP() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Bean-stereotype");
        Clac c = (Clac) classPathXmlApplicationContext.getBean("clac");
        int count = c.add(1, 2);
        System.out.println(count);
    }


}
