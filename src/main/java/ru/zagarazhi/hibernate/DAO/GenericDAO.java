package ru.zagarazhi.hibernate.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<Item, Id> {
    Optional<Item> findById(Id id);
    List<Item> findAll();
    Item save(Item item);
    Optional<Item> update(Id key, Item item);
    Optional<Item> deleteById(Id key);
}
