package org.example.services;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ClientService {

    @PersistenceContext
    private EntityManager em;

    /*  */

    public ScrollableResults getCursorForAllClient() {
        Session session = em.unwrap(Session.class);
        return session.createQuery("select c from Client c")
                .scroll();
    }
}
