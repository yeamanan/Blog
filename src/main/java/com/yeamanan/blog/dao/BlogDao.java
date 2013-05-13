package com.yeamanan.blog.dao;

import com.yeamanan.blog.util.HibernateUtil;
import org.hibernate.Session;

/**
 * TODO.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
public class BlogDao {

    /**
     * TODO.
     */
    private Session session;

    /**
     * Constructor.
     */
    public BlogDao() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     * TODO.
     */
    protected final void getCurrentSession() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     * TODO.
     * @return TODO.
     */
    protected final Session getSession() {
        return session;
    }

    /**
     * TODO.
     * @param argSession TODO.
     */
    protected final void setSession(final Session argSession) {
        this.session = argSession;
    }

}
