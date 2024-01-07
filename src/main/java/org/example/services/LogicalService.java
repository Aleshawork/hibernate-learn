package org.example.services;

import javassist.NotFoundException;
import org.example.model.Client;
import org.hibernate.Session;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class LogicalService extends HibernateStatistic implements DisposableBean {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private LogicalService2 logicalService2;

    @Autowired
    private ClientService clientService;



    @Transactional
    public void doFirstOperation() {
        Client client = clientService.findById(1L);
        client.setName(client.getName() + "1");
        client = em.merge(client);
        try {
            logicalService2.doSecondOperation(client.getName());
        } catch (NotFoundException e) {
            //do nothing
        } finally {
            em.flush();
            sOutStatistics(((Session)em.getDelegate()).getSessionFactory().getStatistics(), "После выполнения 2 опреации" );
        }
    }

    @Override
    public void destroy() throws Exception {
        sOutStatistics(((Session)em.getDelegate()).getSessionFactory().getStatistics(), "В самом конце при уничтожении сервиса");
    }


//    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {NotFoundException.class})
//    public void doSecondOperation(String clientName) throws NotFoundException {
//        Adress adress = new Adress();
//        adress.setAdress(clientName);
//        em.persist(adress);
//        System.out.println("LogicalService2 - " + ((Session)em.getDelegate()).getSessionFactory().getStatistics().getTransactionCount());
//        throw new NotFoundException("");
//
//    }


}
