package com.yeamanan.blog.service;

import com.yeamanan.blog.dao.ArticleDao;
import com.yeamanan.blog.dao.ArticleDaoImpl;
import com.yeamanan.blog.model.Article;
import java.util.List;

/**
 * ArticleServiceImpl class is an implementation of ArticleService interface.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
public class ArticleServiceImpl implements ArticleService {

    /**
     * TODO.
     */
    private ArticleDao articleDao;

    /**
     * Constructor.
     */
    public ArticleServiceImpl() {
        setArticleDao(ArticleDaoImpl.getInstance());
    }

    /**
     * getArticleDao() method.
     * @return TODO.
     */
    public final ArticleDao getArticleDao() {
        return articleDao;
    }

    /**
     * setArticleDao(ArticleDao) method.
     * @param argArticleDao TODO.
     */
    private void setArticleDao(final ArticleDao argArticleDao) {
        this.articleDao = argArticleDao;
    }

    /**
     * count() method.
     * @return the number of articles
     */
    @Override
    public final int count() {
        return getArticleDao().count();
    }

    /**
     * containsKey(int) method.
     * @param argId TODO.
     * @return boolean
     */
    @Override
    public final boolean containsKey(final int argId) {
        boolean result;
        if (getArticleDao().get(Integer.valueOf(argId)) == null) {
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
    public final List<Article> get() {
        return getArticleDao().get();
    }

    /**
     * get(int) method.
     * @param argId TODO.
     * @return TODO.
     */
    @Override
    public final Article get(final int argId) {
        return getArticleDao().get(Integer.valueOf(argId));
    }

    /**
     * remove(int) method.
     * @param argId TODO.
     */
    @Override
    public final void remove(final int argId) {
        getArticleDao().remove(Integer.valueOf(argId));
    }

    /**
     * save(Article) method.
     * @param argArticle TODO.
     */
    @Override
    public final void save(final Article argArticle) {
        getArticleDao().save(argArticle);
    }

    /**
     * update(Article) method.
     * @param argArticle TODO.
     */
    @Override
    public final void update(final Article argArticle) {
        getArticleDao().update(argArticle);
    }

}
