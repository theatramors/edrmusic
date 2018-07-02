package amors;

import amors.service.api.MainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        MainService mainService = (MainService) applicationContext.getBean("mainServiceImpl");
        System.out.println(mainService.sendHttpRequest("Hello from Amors!"));
    }
}
