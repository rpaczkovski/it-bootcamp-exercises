package application.repositories;

import application.models.entities.Item;
import application.repositories.intefaces.IRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements IRepository<String, Item> {

    private final static List<Item> items = new ArrayList<>();

    @Override
    public Item create(Item obj) {
        items.add(obj);
        return obj;
    }

    @Override
    public Item findById(String code) {
        return items.stream().filter(i -> i.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(String code) {
        items.remove(items.stream().filter(i -> i.getCode().equals(code)).findFirst().orElse(null));
    }

    @Override
    public List<Item> findAll() {
        return items;
    }
}
