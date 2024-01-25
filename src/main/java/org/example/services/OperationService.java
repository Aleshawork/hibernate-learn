package org.example.services;

import org.example.model.Client;
import org.hibernate.ScrollableResults;
import org.springframework.stereotype.Service;

@Service
public class OperationService {

    private final ClientService clientService;

    public OperationService(ClientService clientService) {
        this.clientService = clientService;
    }

    public void doOperation() {
        ScrollableResults cursorForAllClient = clientService.getCursorForAllClient();
        try {
            while (cursorForAllClient.next()) {
                Client client = (Client) cursorForAllClient.get(0);
                System.out.println(String.format("Считан пользователь:%s", client.getName()));
            }

        } catch(RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            cursorForAllClient.close();
        }

    }
}
