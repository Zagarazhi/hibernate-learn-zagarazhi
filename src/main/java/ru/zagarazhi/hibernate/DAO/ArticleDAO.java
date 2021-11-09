package ru.zagarazhi.hibernate.dao;

import java.util.List;

import ru.zagarazhi.hibernate.model.persistence.Article;

public interface ArticleDAO extends GenericDAO<Article, Long> {
    List<Article> findByStartsAutorLastName(String starts);
}
