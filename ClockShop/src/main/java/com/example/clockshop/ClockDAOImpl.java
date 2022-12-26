package com.example.clockshop;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClockDAOImpl {

    public ClockShopEnt findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ClockShopEnt.class, id);
    }

    public void save(ClockShopEnt clock) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(clock);
        tx1.commit();
        session.close();
    }

    /*public void update(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update();
        //tx1.commit();
        session.close();
    }*/

    /*public void delete(ClockShop clock) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(clock);
        tx1.commit();
        session.close();
    }*/

    /*public List<ClockShop> findAll() {
        List<ClockShop> clocks = (List<ClockShop>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from").list();
        return clocks;
    }*/
}