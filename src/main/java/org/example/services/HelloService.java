package org.example.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public void hello() {
        System.out.println("Hello Hibernate!");
    }
}
