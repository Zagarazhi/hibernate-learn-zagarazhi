package ru.zagarazhi.hibernate.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.zagarazhi.hibernate.dao.ReaderDAO;
import ru.zagarazhi.hibernate.model.persistence.Reader;
import ru.zagarazhi.hibernate.util.SessionUtil;

public class ReaderDAOImpl implements ReaderDAO {

    private final int MAX_COUNT_OF_ARTICLES = 10;

    private boolean isCorrect(Reader reader) {
        if(reader.getArticles() != null){
            return reader.getArticles().size() <= MAX_COUNT_OF_ARTICLES;
        }
        return true;
    }

    @Override
    public Optional<Reader> findById(Long id) {
        Session session = SessionUtil.createSession();
        Optional<Reader> reader = session
                                .createQuery("from Reader u where u.id = " + id, Reader.class)
                                .uniqueResultOptional();
        session.close();
        return reader;
    }

    @Override
    public List<Reader> findAll() {
        Session session = SessionUtil.createSession();
        List<Reader> readers = session
                                    .createQuery("from Reader", Reader.class)
                                    .getResultList();
        session.close();
        return readers;
    }

    @Override
    public Reader save(Reader item) {
        if(!isCorrect(item)) return item;
        Session session = SessionUtil.createSession();
        Transaction transaction = session.beginTransaction();

        session.save(item);

        transaction.commit();
        session.close();

        return item;
    }

    @Override
    public Optional<Reader> update(Long key, Reader item) {
        if(!isCorrect(item)) return Optional.empty();
        return Optional.empty();
    }

    @Override
    public Optional<Reader> deleteById(Long key) {
        Optional<Reader> byID = findById(key);
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
}
