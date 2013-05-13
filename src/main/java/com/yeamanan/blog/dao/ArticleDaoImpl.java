package com.yeamanan.blog.dao;

import com.yeamanan.blog.model.Article;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * ArticleDaoImpl class is an implementation of ArticleDao interface.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
@Repository
public class ArticleDaoImpl extends BlogDao
    implements ArticleDao {

    /**
     * Constructor.
     */
//    public ArticleDaoImpl() {
//        super();
//    }

    /**
     * count() method.
     * @return the number of articles
     */
    @Override
    public final int count() {
        int result;
        getCurrentSession();
        getSession().beginTransaction();
        result = (Integer) getSession().getNamedQuery("Article.getAll")
                .list().size();
        getSession().getTransaction().commit();
        return result;
    }

    /**
     * get() method implementation.
     * @return all articles
     */
    @Override
    public final List<Article> get() {
        getCurrentSession();
        getSession().beginTransaction();
        List<Article> articles;
        articles = getSession().getNamedQuery("Article.getAll").list();
        getSession().getTransaction().commit();
        return articles;
    }

    /**
     * get(String) method implementation.
     * @param argId id of the article to get
     * @return an article
     */
    @Override
    public final Article get(final int argId) {
        final String locId = String.valueOf(argId);
        getCurrentSession();
        getSession().beginTransaction();
        Article article;
        article = (Article) getSession().getNamedQuery("Article.getById")
                .setString("id", locId).uniqueResult();
        getSession().getTransaction().commit();
        return article;
    }

    /**
     * remove(String) method implementation.
     */
    @Override
    public final void remove() {
        getCurrentSession();
        getSession().beginTransaction();
        getSession().getNamedQuery("Article.deleteAll");
        getSession().getTransaction().commit();
    }

    /**
     * remove(String) method implementation.
     * @param argId id of the article to remove
     */
    @Override
    public final void remove(final int argId) {
        final String locId = String.valueOf(argId);
        getCurrentSession();
        getSession().beginTransaction();
        getSession().getNamedQuery("Article.deleteById").setString("id", locId);
        getSession().getTransaction().commit();
    }

    /**
     * save(Article) method implementation.
     * @param argArticle the article to save
     */
    @Override
    public final void save(final Article argArticle) {
        getCurrentSession();
        getSession().beginTransaction();
        getSession().save(argArticle);
        getSession().getTransaction().commit();
    }

    /**
     * update(Article) method implementation.
     * @param argArticle the article to update
     */
    @Override
    public final void update(final Article argArticle) {
        getCurrentSession();
        getSession().beginTransaction();
        getSession().update(argArticle);
        getSession().getTransaction().commit();
    }

}
