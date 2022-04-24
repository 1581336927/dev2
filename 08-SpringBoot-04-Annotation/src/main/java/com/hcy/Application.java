package com.hcy;

import com.hcy.config.TestConfig;
import com.hcy.entity.Car;
import com.hcy.entity.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import com.hcy.entity.User;
@SpringBootApplication
public class Application {

    public static void main(String[] args) {


        //用来启动springboot项目
        //用于获取spring容器
        ApplicationContext applicationContext = SpringApplication.run(Application.class);

        //用来获取容器中所有的名字
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        //从容其中获取bean对象
        TestConfig testConfig = applicationContext.getBean(TestConfig.class);

        System.out.println("hashcode值"+testConfig.hashCode());
        System.out.println("地址"+testConfig);

        User user1 = applicationContext.getBean(User.class);
        User user2 = applicationContext.getBean(User.class);
        System.out.println("容器中的两个对象"+(user1==user2));

        User user3 = testConfig.getUser();
        User user4 = testConfig.getUser();
        System.out.println("new出来的两个对象"+(user3==user4));
        System.out.println("容器中的对象和new出来的对象"+(user1==user4));


        Car car = applicationContext.getBean("car2", Car.class);
        System.out.println(car);


        System.out.println("========================");

        Cat cat = applicationContext.getBean("com.hcy.entity.Cat",Cat.class);

        System.out.println("从容其中拿到的猫"+cat);
    }

}
