package com.yeamanan.blog.resource;

import com.yeamanan.blog.model.Article;
import com.yeamanan.blog.service.ArticleService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

/**
 * ArticleResource class.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
public class ArticleResource {

    /**
     * TODO.
     */
    private ArticleService articleService;

    /**
     * TODO.
     */
    @Context
    private UriInfo uriInfo;

    /**
     * TODO.
     */
    @Context
    private Request request;

    /**
     * TODO.
     */
    private int id;

    /**
     * TODO.
     * @param argArticleService TODO.
     * @param argUriInfo TODO.
     * @param argRequest TODO.
     * @param argId TODO.
     */
    public ArticleResource(final ArticleService argArticleService,
            final UriInfo argUriInfo,
            final Request argRequest,
            final int argId) {
        this.articleService = argArticleService;
        this.uriInfo = argUriInfo;
        this.request = argRequest;
        this.id = argId;
    }

    /**
     * TODO.
     */
    @DELETE
    public final void delete() {
        articleService.remove(id);
    }

    /**
     * TODO.
     * @return TODO.
     */
    @GET
    @Produces({ MediaType.TEXT_XML })
    public final Article getHTML() {
        return articleService.get(id);
    }

    /**
     * TODO.
     * @return TODO.
     */
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public final Article getXML() {
        return articleService.get(id);
    }

    /**
     * TODO.
     * @param element TODO.
     * @return TODO.
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public final Response post(final JAXBElement<Article> element) {
        final Article article = element.getValue();
        return putAndGetResponse(article);
    }

    /**
     * TODO.
     * @param element TODO.
     * @return TODO.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public final Response put(final JAXBElement<Article> element) {
        final Article article = element.getValue();
        return putAndGetResponse(article);
    }

    /**
     * TODO.
     * @param article TODO.
     * @return TODO.
     */
    private Response putAndGetResponse(final Article article) {
        Response response;
        if (articleService.containsKey(article.getId())) {
            response = Response.noContent().build();
            articleService.update(article);
        } else {
            response = Response.created(uriInfo.getAbsolutePath()).build();
            articleService.save(article);
        }
        return response;
    }

    /**
     * getArticleService() method.
     * @return TODO.
     */
    public final ArticleService getArticleService() {
        return articleService;
    }

    /**
     * setArticleService(ArticleService) method.
     * @param argArticleService TODO.
     */
    public void setArticleService(final ArticleService argArticleService) {
        this.articleService = argArticleService;
    }

    /**
     * getUriInfo() method.
     * @return uriInfo
     */
    public final UriInfo getUriInfo() {
        return this.uriInfo;
    }

    /**
     * setUriInfo(UriInfo) method.
     * @param argUriInfo TODO.
     */
    public final void setUriInfo(final UriInfo argUriInfo) {
        this.uriInfo = argUriInfo;
    }

    /**
     * getRequest() method.
     * @return request
     */
    public final Request getRequest() {
        return this.request;
    }

    /**
     * setRequest(UriInfo) method.
     * @param argRequest TODO.
     */
    public final void setRequest(final Request argRequest) {
        this.request = argRequest;
    }

    /**
     * getId() method.
     * @return id
     */
    public final int getId() {
        return this.id;
    }

    /**
     * setId(String) method.
     * @param argId TODO.
     */
    public final void setId(final int argId) {
        this.id = argId;
    }

}