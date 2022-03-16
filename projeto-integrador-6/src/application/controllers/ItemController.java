package application.controllers;

import application.models.entities.Item;
import application.repositories.intefaces.IRepository;

import java.util.List;

public class ItemController {

    private final IRepository<String, Item> repository;

    public ItemController(IRepository<String, Item> repository) {
        this.repository = repository;
    }

    public Item create(Item item) {
        return repository.create(item);
    }

    public Item findById(String code) {
       return repository.findById(code);
    }

    public List<Item> findAll() {
        return repository.findAll();
    }
}
