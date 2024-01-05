package org.example.services;

import org.example.model.Client;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ClientService {

    @PersistenceContext
    private EntityManager em;

    public Client findById(Long id) {
        return  em.find(Client.class, id);
    }
}
