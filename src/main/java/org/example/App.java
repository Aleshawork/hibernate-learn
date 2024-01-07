package org.example;
import javassist.NotFoundException;
import org.example.model.Client;
import org.example.services.ClientService;
import org.example.services.DbEntityInfoService;
import org.example.services.HibernateStatistic;
import org.example.services.LogicalService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;


/**
 * Hello Hibernate!
 *
 */
@ComponentScan
public class App {

    public static void main( String[] args ) throws NotFoundException {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(App.class);
        ClientService clientService = appContext.getBean(ClientService.class);
        LogicalService logicalService = appContext.getBean(LogicalService.class);


        logicalService.doFirstOperation();
        ((ConfigurableApplicationContext)appContext).close();
    }
}
