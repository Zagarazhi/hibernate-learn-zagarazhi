package ru.zagarazhi.hibernate.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.zagarazhi.hibernate.dao.AutorDAO;
import ru.zagarazhi.hibernate.model.persistence.Autor;
import ru.zagarazhi.hibernate.util.SessionUtil;

public class AutorDAOImpl implements AutorDAO {

    @Override
    public Optional<Autor> findById(Long id) {
        Session session = SessionUtil.createSession();
        Optional<Autor> autor = session
                                .createQuery("from Autor u where u.id = " + id, Autor.class)
                                .uniqueResultOptional();
        session.close();
        return autor;
    }

    @Override
    public List<Autor> findAll() {
        Session session = SessionUtil.createSession();
        List<Autor> autors = session
                                    .createQuery("from Autor", Autor.class)
                                    .getResultList();
        session.close();
        return autors;
    }

    @Override
    public Autor save(Autor item) {
        Session session = SessionUtil.createSession();
        Transaction transaction = session.beginTransaction();

        session.save(item);

        transaction.commit();
        session.close();

        return item;
    }

    @Override
    public Optional<Autor> update(Long key, Autor item) {
        return Optional.empty();
    }

    @Override
    public Optional<Autor> deleteById(Long key) {
        Optional<Autor> byID = findById(key);
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
    public List<Autor> findByCountOfArticles(int count) {
        // TODO Auto-generated method stub
        return null;
    }
}
