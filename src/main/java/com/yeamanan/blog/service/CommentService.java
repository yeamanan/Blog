package com.yeamanan.blog.service;

import com.yeamanan.blog.model.Comment;
import java.util.List;

/**
 * CommentService interface.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
public interface CommentService {

    /**
     * count() method.
     * @return the number of comments
     */
    int count();

    /**
     * containsKey(int) method.
     * @param argId TODO.
     * @return boolean
     */
    boolean containsKey(int argId);

    /**
     * get() method.
     * @return TODO.
     */
    List<Comment> get();

    /**
     * get(int) method.
     * @param argId TODO.
     * @return TODO.
     */
    Comment get(int argId);

    /**
     * remove(int) method.
     * @param argId TODO.
     */
    void remove(int argId);

    /**
     * save(Comment) method.
     * @param argComment TODO.
     */
    void save(Comment argComment);

    /**
     * update(Comment) method.
     * @param argComment TODO.
     */
    void update(Comment argComment);

}
