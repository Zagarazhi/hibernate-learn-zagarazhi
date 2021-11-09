package ru.zagarazhi.hibernate.dao;

import java.util.List;

import ru.zagarazhi.hibernate.model.persistence.Autor;

public interface AutorDAO extends GenericDAO<Autor, Long>{
    List<Autor> findByCountOfArticles(int count);
}
