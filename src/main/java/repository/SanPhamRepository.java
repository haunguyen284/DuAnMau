/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.util.HibernateUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author macbook
 */
public class SanPhamRepository {

    public List<SanPham> findAll(int position, int pageSize) {
        List<SanPham> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM SanPham n";
            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            listModel = query.getResultList();
        }
        return listModel;
    }

    public SanPham findById(UUID id) {
        SanPham model;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM SanPham n WHERE n.id = :id";
            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
            query.setParameter("id", id);
            model = query.getSingleResult();
        }
        return model;
    }

    public SanPham save(SanPham model) {
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
                String hql = "DELETE SanPham n WHERE n.id = :id";
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
            String statement = "SELECT COUNT(n.id) FROM SanPham n";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            total = query.getSingleResult();
        }
        return total;
    }

    public SanPham findByMa(String ma) {
        List<SanPham> listModel;
        SanPham model = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM SanPham n WHERE n.ma = :ma";
            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
            query.setParameter("ma", ma);
            listModel = query.getResultList();
        }
        if (!listModel.isEmpty()) {
            model = listModel.get(0);
        }
        return model;
    }

    public List<SanPham> findAll() {
        List<SanPham> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM SanPham n";
            TypedQuery<SanPham> query = session.createQuery(hql, SanPham.class);
            listModel = query.getResultList();
        }
        return listModel;
    }
}
