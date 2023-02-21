/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.util.HibernateUtil;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import model.NhaSanXuat;
import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author macbook
 */
public class NhaSanXuatRepository {

    public List<NhaSanXuat> findAll(int position, int pageSize) {
        List<NhaSanXuat> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM NSX n";
            TypedQuery<NhaSanXuat> query = session.createQuery(hql, NhaSanXuat.class);
            query.setFirstResult(position);
            query.setMaxResults(pageSize);
            listModel = query.getResultList();
        }
        return listModel;
    }

    public NhaSanXuat findById(UUID id) {
        NhaSanXuat model;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM NSX n WHERE n.id = :id";
            TypedQuery<NhaSanXuat> query = session.createQuery(hql, NhaSanXuat.class);
            query.setParameter("id", id);
            model = query.getSingleResult();
        }
        return model;
    }

    public NhaSanXuat save(NhaSanXuat model) {
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
                String hql = "DELETE NSX n WHERE n.id = :id";
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
            String statement = "SELECT COUNT(n.id) FROM NSX n";
            TypedQuery<Long> query = session.createQuery(statement, Long.class);
            total = query.getSingleResult();
        }
        return total;
    }

    public NhaSanXuat findByMa(String ma) {
        List<NhaSanXuat> listModel;
        NhaSanXuat model = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM NSX n WHERE n.ma = :ma";
            TypedQuery<NhaSanXuat> query = session.createQuery(hql, NhaSanXuat.class);
            query.setParameter("ma", ma);
            listModel = query.getResultList();
        }
        if (!listModel.isEmpty()) {
            model = listModel.get(0);
        }
        return model;
    }

    public List<NhaSanXuat> findAll() {
        List<NhaSanXuat> listModel;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT n FROM NSX n";
            TypedQuery<NhaSanXuat> query = session.createQuery(hql, NhaSanXuat.class);
            listModel = query.getResultList();
        }
        return listModel;
    }

}
