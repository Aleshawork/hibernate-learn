package org.example.services;

import javassist.NotFoundException;
import org.example.model.Adress;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class LogicalService2 extends HibernateStatistic{

    @PersistenceContext
    EntityManager em;


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {NotFoundException.class})
    public void doSecondOperation(String clientName) throws NotFoundException {
        Adress adress = new Adress();
        adress.setAdress(clientName);
        em.persist(adress);
        sOutStatistics(((Session) em.getDelegate()).getSessionFactory().getStatistics(), "В конце выполнения 2-ой операции");
        throw new NotFoundException("");

    }


}
