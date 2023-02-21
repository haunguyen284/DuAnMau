/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.util.HibernateUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import model.DongSanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author macbook
 */
public class DongSanPhamRepository {
    public List<DongSanPham> findAll(int position, int pageSize) {
        List<DongSanPham> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM DongSP n";
            TypedQuery<DongSanPham> query = session.createQuery(hql, DongSanPham.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            listModel = query.getResultList();
        }
        return listModel;
    }

    public DongSanPham findById(UUID id) {
        DongSanPham model;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM DongSP n WHERE n.id = :id";
            TypedQuery<DongSanPham> query = session.createQuery(hql, DongSanPham.class);
            query.setParameter("id", id);
            model = query.getSingleResult();
        }
        return model;
    }

    public DongSanPham save(DongSanPham model) {
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
                String hql = "DELETE DongSP n WHERE n.id = :id";
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
            String statement = "SELECT COUNT(n.id) FROM DongSP n";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            total = query.getSingleResult();
        }
        return total;
    }

    public DongSanPham findByMa(String ma) {
        DongSanPham model;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM DongSP n WHERE n.ma = :ma";
            TypedQuery<DongSanPham> query = session.createQuery(hql, DongSanPham.class);
            query.setParameter("ma", ma);
            model = query.getSingleResult();
        }
        return model;
    }

    public List<DongSanPham> findAll() {
        List<DongSanPham> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM DongSP n";
            TypedQuery<DongSanPham> query = session.createQuery(hql, DongSanPham.class);
            listModel = query.getResultList();
        }
        return listModel;
    }
}
