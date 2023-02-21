/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author macbook
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Hibernate 5:
    private static SessionFactory buildSessionFactory() {
        try {
            // Tạo đối tượng ServiceRegistry từ hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("META-INF/hibernate.cfg.xml").build();

            // Tạo nguồn siêu dữ liệu (metadata) từ ServiceRegistry
            Metadata metadata = new MetadataSources(serviceRegistry)
                    .getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Giải phóng cache và Connection Pools.
        getSessionFactory().close();
    }

}
