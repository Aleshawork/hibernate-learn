package org.example.services;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ClientService {

    @PersistenceContext
    private EntityManager em;

    /*  */
}
