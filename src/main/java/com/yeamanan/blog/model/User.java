package com.yeamanan.blog.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 * User class.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
@XmlRootElement
@Entity
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(name = "User.count",
        query = "SELECT COUNT(*) FROM User u"),
    @NamedQuery(name = "User.selectAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "User.selectById",
        query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.deleteAll", query = "DELETE FROM User u"),
    @NamedQuery(name = "User.deleteById",
        query = "DELETE FROM User u WHERE u.id = :id")
})
public class User implements Serializable {

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
     * Login of the article.
     */
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;

    /**
     * Password of the article.
     */
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;

    /**
     * User Constructor.
     */
    public User() {
    }

    /**
     * User Constructor.
     * @param argLogin The title to set
     * @param argPassword The content to set
     */
    public User(final String argLogin, final String argPassword) {
        //this.id = 0;
        this.login = argLogin;
        this.password = argPassword;
    }

    /**
     * User Constructor.
     * @param argId The id to set
     * @param argLogin The title to set
     * @param argPassword The content to set
     */
    public User(final int argId, final String argLogin,
            final String argPassword) {
        this.id = argId;
        this.login = argLogin;
        this.password = argPassword;
    }

    /**
     * getId() method.
     * @return The id of the article
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
     * getLogin() method.
     * @return The login of the user
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * setLogin(String) method.
     * @param argLogin The login to set
     */
    public void setLogin(final String argLogin) {
        this.login = argLogin;
    }

    /**
     * getPassord() method.
     * @return The password of the user
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * setPassword(String) method.
     * @param argPassword The password to set
     */
    public void setPassword(final String argPassword) {
        this.password = argPassword;
    }

}
