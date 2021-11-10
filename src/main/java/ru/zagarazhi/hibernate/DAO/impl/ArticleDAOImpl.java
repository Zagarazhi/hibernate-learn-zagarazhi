package ru.zagarazhi.hibernate.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.zagarazhi.hibernate.dao.ArticleDAO;
import ru.zagarazhi.hibernate.model.persistence.Article;
import ru.zagarazhi.hibernate.util.SessionUtil;

public class ArticleDAOImpl implements ArticleDAO{

    private boolean isCorrect(Article article) {
        if(article.getAutor() != null 
                && article.getDate() != null
                && article.getAutor().getBirthday() != null){
            return article.getAutor().getBirthday().isBefore(article.getDate());
        }
        return false;
    }

    @Override
    public Optional<Article> findById(Long id) {
        Session session = SessionUtil.createSession();
        Optional<Article> article = session
                                    .createQuery("from Article u where u.id = " + id, Article.class)
                                    .uniqueResultOptional();
        session.close();
        return article;
    }

    @Override
    public List<Article> findAll() {
        Session session = SessionUtil.createSession();
        List<Article> articles = session
                                    .createQuery("from Article", Article.class)
                                    .getResultList();
        session.close();
        return articles;
    }

    @Override
    public Article save(Article item) {
        System.out.println(item.toString());
        if(!isCorrect(item)) return item;
        Session session = SessionUtil.createSession();
        Transaction transaction = session.beginTransaction();

        session.save(item);

        transaction.commit();
        session.close();

        System.out.println(item.toString());
        return item;
    }

    @Override
    public Optional<Article> update(Long key, Article item) {
        if(!isCorrect(item)) return Optional.empty();;
        return Optional.empty();
    }

    @Override
    public Optional<Article> deleteById(Long key) {
        Optional<Article> byID = findById(key);
        if(!byID.isPresent()) {
            return byID;
        }

        Session session = SessionUtil.createSession();
        Transaction transaction = session.beginTransaction();

        session.delete(byID);

        transaction.commit();
        session.close();

        return byID;
    }

    @Override
    public List<Article> findByStartsAutorLastName(String starts) {
        Session session = SessionUtil.createSession();
        List<Article> articles = session
                                .createQuery("select s from Article s where lastName like ?1", Article.class)
                                .setParameter(1, starts + "%")
                                .getResultList();
        session.close();
        return articles;
    }
}
