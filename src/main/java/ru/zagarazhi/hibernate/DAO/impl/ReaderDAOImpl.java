package ru.zagarazhi.hibernate.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.zagarazhi.hibernate.dao.ReaderDAO;
import ru.zagarazhi.hibernate.model.persistence.Reader;
import ru.zagarazhi.hibernate.util.SessionUtil;

public class ReaderDAOImpl implements ReaderDAO {

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
        Session session = SessionUtil.createSession();
        Transaction transaction = session.beginTransaction();

        session.save(item);

        transaction.commit();
        session.close();

        return item;
    }

    @Override
    public Optional<Reader> update(Long key, Reader item) {
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
