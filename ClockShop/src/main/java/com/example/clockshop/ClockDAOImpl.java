package com.example.clockshop;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClockDAOImpl {

    public clockInterface findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(clockInterface.class, id);
    }

    public void save(clockInterface clock) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(clock);
        tx1.commit();
        session.close();
    }

    public void update(clockInterface clock) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(clock);
        //tx1.commit();
        session.close();
    }

    public void delete(clockInterface clock) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(clock);
        tx1.commit();
        session.close();
    }

    public List<clockInterface> findAll() {
        List<clockInterface> clocks = (List<clockInterface>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from ClockHM ").list();
        return clocks;
    }
}