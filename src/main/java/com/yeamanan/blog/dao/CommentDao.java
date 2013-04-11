package com.yeamanan.blog.dao;

import com.yeamanan.blog.model.Comment;
import java.util.List;

/**
 * CommentDao interface.
 * @author Camelia
 */
public interface CommentDao {

    /**
     * count() method.
     * @return the number of comments
     */
    int count();

    /**
     * get() method.
     * @return all comments
     */
    List<Comment> get();

    /**
     * get(String) method.
     * @param argId id of the comment to get
     * @return an comment
     */
    Comment get(int argId);

    /**
     * remove(String) method.
     */
    void remove();

    /**
     * remove(String) method.
     * @param argId id of the comment to remove
     */
    void remove(int argId);

    /**
     * save(Comment) method.
     * @param comment the comment to save
     */
    void save(Comment comment);

    /**
     * update(Comment) method.
     * @param comment the comment to update
     */
    void update(Comment comment);

}
