/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.TypedQuery;
import model.ChucVu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import common.util.HibernateUtil;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public class ChucVuRepository {

    public List<ChucVu> findAll(int position, int pageSize) {
        List<ChucVu> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM ChucVu c";
            TypedQuery<ChucVu> query = session.createQuery(hql, ChucVu.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            listModel = query.getResultList();
        }
        return listModel;
    }

    public ChucVu findById(UUID id) {
        ChucVu model;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM ChucVu c WHERE c.id = :id";
            TypedQuery<ChucVu> query = session.createQuery(hql, ChucVu.class);
            query.setParameter("id", id);
            model = query.getSingleResult();
        }
        return model;
    }

    public ChucVu findByMa(String ma) {
        ChucVu model = null;
        List<ChucVu> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM ChucVu c WHERE c.ma = :ma";
            TypedQuery<ChucVu> query = session.createQuery(hql, ChucVu.class);
            query.setParameter("ma", ma);
            listModel = query.getResultList();
        }
        if (!listModel.isEmpty()) {
            model = listModel.get(0);
        }
        return model;
    }

    public ChucVu save(ChucVu model) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                session.saveOrUpdate(model);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
                model = null;
            }
        } finally {
            return model;
        }
    }

    public boolean delete(UUID id) {
        int result = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            try {
                String hql = "DELETE ChucVu c WHERE c.id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                result = query.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result > 0;
    }

    public long totalCount() {
        long total = 0;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String statement = "SELECT COUNT(c.id) FROM ChucVu c";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            total = query.getSingleResult();
        }
        return total;
    }

    public List<ChucVu> findAll() {
        List<ChucVu> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM ChucVu c";
            TypedQuery<ChucVu> query = session.createQuery(hql, ChucVu.class);
            listModel = query.getResultList();
        }
        return listModel;
    }
}
