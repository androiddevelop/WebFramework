package me.codeboy.common.framework.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 获取sessionFactory
 *
 * @author yuedong.li
 */
public class CBHibernateSessionFactory {
    private static SessionFactory sessionFactory;

    /**
     * 返回单例模式中的sessionFactory
     *
     * @return sessionFactory
     */
    public static SessionFactory getInstance() {
        if (sessionFactory == null) {
            Configuration cfg = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
                    .build();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}