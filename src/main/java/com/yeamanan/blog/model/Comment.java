/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Comment class.
 * @author Camelia
 */
@XmlRootElement(name = "comment")
@XmlType(propOrder = { "id", "content", "author" })
@Entity
@Table(name = "COMMENTS")
@NamedQueries({
    @NamedQuery(name = "Comment.getAll", query = "select c from Comment c"),
    @NamedQuery(name = "Comment.selectById",
        query = "SELECT c FROM Comment c WHERE c.id = :id"),
    @NamedQuery(name = "Comment.deleteAll", query = "DELETE FROM Comment c"),
    @NamedQuery(name = "Comment.deleteById",
        query = "DELETE FROM Comment c WHERE c.id = :id")
})
public class Comment implements Serializable {
    
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
     * Content of the comment.
     */
    @Basic(optional = false)
    @Column(name = "CONTENT")
    private String content;

    /**
     * Author of the comment.
     */
    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    /**
     * Comment Constructor.
     */
    public Comment() {
    }

    /**
     * Comment Constructor.
     * @param argContent The content to set
     */
    public Comment(final String argContent) {
        //this.id = 0;
        this.content = argContent;
    }

    /**
     * Comment Constructor.
     * @param argId The id to set
     * @param argContent The content to set
     */
    public Comment(final int argId, 
            final String argContent) {
        this.id = argId;
        this.content = argContent;
    }

    /**
     * getId() method.
     * @return The id of the comment
     */
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
     * getContent() method.
     * @return The content of the comment
     */
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
     * @return The author of the comment
     */
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
