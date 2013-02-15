package com.yeamanan.blog.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * TODO.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
public final class HibernateUtil {

    /**
     *
     */
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    /**
     * Constructor.
     */
    private HibernateUtil() {
    }

    /**
     * TODO.
     * @return TODO.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * TODO.
     * @return TODO.
     */
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

}
