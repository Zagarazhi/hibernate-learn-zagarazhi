package ru.zagarazhi.hibernate.DAO;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<Item, Id> {
    Optional<Item> findById(Id key);
    List<Item> findAll();
    Item save(Item item);
    Optional<Item> update(Id key, Item item);
    Optional<Item> deleteById(Id key);
}
