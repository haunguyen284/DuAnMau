/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.util.HibernateUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author macbook
 */
public class KhachHangRepository {

    public List<KhachHang> findAll(int position, int pageSize) {
        List<KhachHang> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT k FROM KhachHang k";
            TypedQuery<KhachHang> query = session.createQuery(hql, KhachHang.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            listModel = query.getResultList();
        }
        return listModel;
    }

    public KhachHang findById(UUID id) {
        KhachHang model;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM KhachHang n WHERE n.id = :id";
            TypedQuery<KhachHang> query = session.createQuery(hql, KhachHang.class);
            query.setParameter("id", id);
            model = query.getSingleResult();
        }
        return model;
    }
    

    public KhachHang save(KhachHang model) {
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
                String hql = "DELETE KhachHang n WHERE n.id = :id";
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
            String statement = "SELECT COUNT(n.id) FROM KhachHang n";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            total = query.getSingleResult();
        }
        return total;
    }

    public KhachHang findByMa(String ma) {
        List<KhachHang> listModel;
        KhachHang model = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM KhachHang n WHERE n.ma = :ma";
            TypedQuery<KhachHang> query = session.createQuery(hql, KhachHang.class);
            query.setParameter("ma", ma);
            listModel = query.getResultList();
        }
        if (!listModel.isEmpty()) {
            model = listModel.get(0);
        }
        return model;
    }

    public List<KhachHang> findAll() {
        List<KhachHang> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT k FROM KhachHang k";
            TypedQuery<KhachHang> query = session.createQuery(hql, KhachHang.class);
            listModel = query.getResultList();
        }
        return listModel;
    }
}
