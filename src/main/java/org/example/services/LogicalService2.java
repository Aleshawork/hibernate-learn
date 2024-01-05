package org.example.services;

import javassist.NotFoundException;
import org.example.model.Adress;
import org.example.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class LogicalService2 {

    @PersistenceContext
    EntityManager em;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void doSecondOperation(String clientName) throws NotFoundException {
        Adress adress = new Adress();
        adress.setAdress(clientName);
        em.persist(adress);
        throw new NotFoundException("");

    }
}
