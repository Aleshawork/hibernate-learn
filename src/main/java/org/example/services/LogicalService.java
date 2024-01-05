package org.example.services;

import javassist.NotFoundException;
import org.example.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class LogicalService {

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
            throw new RuntimeException(e);
        }
    }


}
