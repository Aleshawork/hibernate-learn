package org.example.services;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class DbEntityInfoService {

    @PersistenceContext
    private EntityManager em;

    public void allEntityName(){
        em.getMetamodel().getEntities().forEach(el -> System.out.println(el.getName()));
    }
}
