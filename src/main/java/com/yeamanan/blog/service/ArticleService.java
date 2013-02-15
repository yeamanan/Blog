package com.yeamanan.blog.service;

import com.yeamanan.blog.model.Article;
import java.util.List;

/**
 * ArticleService interface.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
public interface ArticleService {

    /**
     * count() method.
     * @return the number of articles
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
    List<Article> get();

    /**
     * get(int) method.
     * @param argId TODO.
     * @return TODO.
     */
    Article get(int argId);

    /**
     * remove(int) method.
     * @param argId TODO.
     */
    void remove(int argId);

    /**
     * save(Article) method.
     * @param argArticle TODO.
     */
    void save(Article argArticle);

    /**
     * update(Article) method.
     * @param argArticle TODO.
     */
    void update(Article argArticle);

}
