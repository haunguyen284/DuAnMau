/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import javax.persistence.TypedQuery;
import model.CuaHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import common.util.HibernateUtil;
import java.util.UUID;

/**
 *
 * @author macbook
 */
public class CuaHangRepository {

    public List<CuaHang> findAll(int position, int pageSize) {
        List<CuaHang> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM CuaHang c";
            TypedQuery<CuaHang> query = session.createQuery(hql, CuaHang.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            listModel = query.getResultList();
        }
        return listModel;
    }

    public CuaHang findById(UUID id) {
        CuaHang model;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM CuaHang c WHERE c.id = :id";
            TypedQuery<CuaHang> query = session.createQuery(hql, CuaHang.class);
            query.setParameter("id", id);
            model = query.getSingleResult();
        }
        return model;
    }

    public CuaHang findByMa(String ma) {
        List<CuaHang> listModel;
        CuaHang model = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM CuaHang c WHERE c.ma = :ma";
            TypedQuery<CuaHang> query = session.createQuery(hql, CuaHang.class);
            query.setParameter("ma", ma);
            listModel = query.getResultList();
        }
        if (!listModel.isEmpty()) {
            model = listModel.get(0);
        }
        return model;
    }

    public CuaHang save(CuaHang model) {
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
                String hql = "DELETE CuaHang c WHERE c.id = :id";
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
            String statement = "SELECT COUNT(c.id) FROM CuaHang c";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            total = query.getSingleResult();
        }
        return total;
    }

    public List<CuaHang> findAll() {
        List<CuaHang> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT c FROM CuaHang c";
            TypedQuery<CuaHang> query = session.createQuery(hql, CuaHang.class);
            listModel = query.getResultList();
        }
        return listModel;
    }
}
