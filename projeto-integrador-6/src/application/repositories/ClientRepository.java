package application.repositories;

import application.models.entities.Client;
import application.repositories.intefaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IRepository<Integer, Client> {

    private final static List<Client> clients = new ArrayList<>();

    @Override
    public Client create(Client obj) {
        clients.add(obj);
        return obj;
    }

    @Override
    public Client findById(Integer id) {
        return clients.stream().filter(c -> c.getID().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        clients.remove(clients.stream().filter(c -> c.getID().equals(id)).findFirst().orElse(null));
    }

    @Override
    public List<Client> findAll() {
        return clients;
    }

}