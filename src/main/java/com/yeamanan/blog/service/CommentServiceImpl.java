package com.yeamanan.blog.service;

import com.yeamanan.blog.dao.CommentDao;
import com.yeamanan.blog.dao.CommentDaoImpl;
import com.yeamanan.blog.model.Comment;
import java.util.List;

/**
 * CommentServiceImpl class is an implementation of CommentService interface.
 * @author Camelia
 */
public class CommentServiceImpl implements CommentService {

    /**
     * Comment Dao.
     */
    private CommentDao commentDao;

    /**
     * Constructor.
     */
    public CommentServiceImpl() {
        setCommentDao(CommentDaoImpl.getInstance());
    }

    /**
     * getCommentDao() method.
     * @return TODO.
     */
    public final CommentDao getCommentDao() {
        return commentDao;
    }

    /**
     * setCommentDao(CommentDao) method.
     * @param argCommentDao TODO.
     */
    private void setCommentDao(final CommentDao argCommentDao) {
        this.commentDao = argCommentDao;
    }

    /**
     * count() method.
     * @return the number of comments
     */
    @Override
    public final int count() {
        return getCommentDao().count();
    }

    /**
     * containsKey(int) method.
     * @param argId TODO.
     * @return boolean
     */
    @Override
    public final boolean containsKey(final int argId) {
        boolean result;
        if (getCommentDao().get(Integer.valueOf(argId)) == null) {
            result =  false;
        } else {
            result = true;
        }
        return result;
    }

    /**
     * get() method.
     * @return TODO.
     */
    @Override
    public final List<Comment> get() {
        return getCommentDao().get();
    }

    /**
     * get(int) method.
     * @param argId TODO.
     * @return TODO.
     */
    @Override
    public final Comment get(final int argId) {
        return getCommentDao().get(Integer.valueOf(argId));
    }

    /**
     * remove(int) method.
     * @param argId TODO.
     */
    @Override
    public final void remove(final int argId) {
        getCommentDao().remove(Integer.valueOf(argId));
    }

    /**
     * save(Comment) method.
     * @param argComment TODO.
     */
    @Override
    public final void save(final Comment argComment) {
        getCommentDao().save(argComment);
    }

    /**
     * update(Comment) method.
     * @param argComment TODO.
     */
    @Override
    public final void update(final Comment argComment) {
        getCommentDao().update(argComment);
    }

}
