package dao;

import database.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class AbstractDao<T> {
    private final Class<T> clazz;

    protected AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void add(T record) {
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(record);
        transaction.commit();
        session.close();
    }

    public void remove(T record) {
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(record);
        transaction.commit();
        session.close();
    }

    public void update(T record) {
        Session session = SessionProvider.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(record);
        transaction.commit();
        session.close();
    }


    public T findById(int id) {
        Session session = SessionProvider.getSession();
        T record = session.find(clazz, id);
        session.close();
        return record;
    }

    public List<T> findAll() {
        Session session = SessionProvider.getSession();
        List<T> records = session.createQuery("from " + clazz.getCanonicalName(), clazz).list();
        session.close();
        return records;
    }


}
