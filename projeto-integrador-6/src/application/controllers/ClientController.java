package application.controllers;

import application.models.entities.Client;
import application.repositories.intefaces.IRepository;

import java.util.List;

public class ClientController {

    private final IRepository<Integer, Client> repository;

    public ClientController(IRepository<Integer, Client> repository) {
        this.repository = repository;
    }

    public Client create(Client client) {
        return repository.create(client);
    }

    public List<Client> findAll() {
        return  repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Client findById(Integer id) {
       return repository.findById(id);
    }

}
