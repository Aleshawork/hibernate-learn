package org.example;
import org.example.services.DbEntityInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello Hibernate!
 *
 */
@ComponentScan
public class App {

    public static void main( String[] args ) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(App.class);
        DbEntityInfoService dbEntityInfoService = appContext.getBean(DbEntityInfoService.class);
        dbEntityInfoService.allEntityName();
    }
}
