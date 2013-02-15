package com.yeamanan.blog.dao;

import com.yeamanan.blog.model.Article;
import java.util.List;

/**
 * ArticleDao interface.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
public interface ArticleDao {

    /**
     * count() method.
     * @return the number of articles
     */
    int count();

    /**
     * get() method.
     * @return all articles
     */
    List<Article> get();

    /**
     * get(String) method.
     * @param argId id of the article to get
     * @return an article
     */
    Article get(int argId);

    /**
     * remove(String) method.
     */
    void remove();

    /**
     * remove(String) method.
     * @param argId id of the article to remove
     */
    void remove(int argId);

    /**
     * save(Article) method.
     * @param article the article to save
     */
    void save(Article article);

    /**
     * update(Article) method.
     * @param article the article to update
     */
    void update(Article article);

}
