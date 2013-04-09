package com.yeamanan.blog.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Article class.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
@XmlRootElement(name = "article")
@XmlType(propOrder = { "id", "title", "content", "author" })
@Entity
@Table(name = "ARTICLES")
@NamedQueries({
    @NamedQuery(name = "Article.getAll", query = "select a from Article a"),
    @NamedQuery(name = "Article.getById",
        query = "select a from Article a where a.id = :id"),
    @NamedQuery(name = "Article.deleteAll", query = "delete from Article a"),
    @NamedQuery(name = "Article.deleteById",
        query = "delete from Article a where a.id = :id")
})
public class Article implements Serializable {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id of the article.
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")
    private int id;

    /**
     * Title of the article.
     */
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;

    /**
     * Content of the article.
     */
    @Basic(optional = false)
    @Column(name = "CONTENT")
    private String content;

    /**
     * Author of the article.
     */
    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    /**
     * Article Constructor.
     */
    public Article() {
    }

    /**
     * Article Constructor.
     * @param argTitle The title to set
     * @param argContent The content to set
     */
    public Article(final String argTitle, final String argContent) {
        //this.id = 0;
        this.title = argTitle;
        this.content = argContent;
    }

    /**
     * Article Constructor.
     * @param argId The id to set
     * @param argTitle The title to set
     * @param argContent The content to set
     */
    public Article(final int argId, final String argTitle,
            final String argContent) {
        this.id = argId;
        this.title = argTitle;
        this.content = argContent;
    }

    /**
     * getId() method.
     * @return The id of the article
     */
    @XmlAttribute
    public int getId() {
        return this.id;
    }

    /**
     * setId(int) method.
     * @param argId The id to set
     */
    public void setId(final int argId) {
        this.id = argId;
    }

    /**
     * getTitle() method.
     * @return The title of the article
     */
    @XmlElement
    public String getTitle() {
        return this.title;
    }

    /**
     * setTitle(String) method.
     * @param argTitle The title to set
     */
    public void setTitle(final String argTitle) {
        this.title = argTitle;
    }

    /**
     * getContent() method.
     * @return The content of the article
     */
    @XmlElement
    public String getContent() {
        return this.content;
    }

    /**
     * setContent(String) method.
     * @param argContent The content to set
     */
    public void setContent(final String argContent) {
        this.content = argContent;
    }

    /**
     * getAuthor() method.
     * @return The author of the article
     */
    @XmlElement
    public User getAuthor() {
        return this.author;
    }

    /**
     * setAuthor(String) method.
     * @param argAuthor The author to set
     */
    public void setAuthor(final User argAuthor) {
        this.author = argAuthor;
    }
}
