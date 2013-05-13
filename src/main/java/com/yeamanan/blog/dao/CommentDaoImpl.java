package com.yeamanan.blog.dao;

import com.yeamanan.blog.model.Comment;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * CommentDaoImpl class is an implementation of CommentDao interface.
 * @author Camelia
 */
@Repository
public class CommentDaoImpl extends BlogDao
    implements CommentDao {

    /**
     * Constructor.
     */
//    public CommentDaoImpl() {
//        super();
//    }

    /**
     * count() method.
     * @return the number of comment
     */
    @Override
    public final int count() {
        int result;
        getCurrentSession();
        getSession().beginTransaction();
        result = (Integer) getSession().getNamedQuery("Comment.getAll")
                .list().size();
        getSession().getTransaction().commit();
        return result;
    }

    /**
     * get() method implementation.
     * @return all comments
     */
    @Override
    public final List<Comment> get() {
        getCurrentSession();
        getSession().beginTransaction();
        List<Comment> comments;
        comments = getSession().getNamedQuery("Comment.getAll").list();
        getSession().getTransaction().commit();
        return comments;
    }

    
    @Override
    public Comment get(int argId) {
        final String locId = String.valueOf(argId);
        getCurrentSession();
        getSession().beginTransaction();
        Comment comment;
        comment = (Comment) getSession().getNamedQuery("Comment.getById")
                .setString("id", locId).uniqueResult();
        getSession().getTransaction().commit();
        return comment;
    }

    @Override
    public void remove() {
        getCurrentSession();
        getSession().beginTransaction();
        getSession().getNamedQuery("Comment.deleteAll");
        getSession().getTransaction().commit();
    }

     /**
     * remove(String) method implementation.
     * @param argId id of the comment to remove
     */
    @Override
    public void remove(final int argId) {
        final String locId = String.valueOf(argId);
        getCurrentSession();
        getSession().beginTransaction();
        getSession().getNamedQuery("Comment.deleteById").setString("id", locId);
        getSession().getTransaction().commit();
    }

    /**
     * save(Comment) method implementation.
     * @param argComment the comment to save
     */
    @Override
    public final void save(final Comment argComment) {
        getCurrentSession();
        getSession().beginTransaction();
        getSession().save(argComment);
        getSession().getTransaction().commit();
    }

    /**
     * update(Comment) method implementation.
     * @param argComment the comment to update
     */
    @Override
    public final void update(final Comment argComment) {
        getCurrentSession();
        getSession().beginTransaction();
        getSession().update(argComment);
        getSession().getTransaction().commit();
    }
}
