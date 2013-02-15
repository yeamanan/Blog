package com.yeamanan.blog.resource;

import com.yeamanan.blog.model.Article;
import com.yeamanan.blog.service.ArticleService;
import com.yeamanan.blog.service.ArticleServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 * ArticlesResource class.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
@Path("/articles")
public class ArticlesResource {

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
     * getHTML() method.
     * @return TODO.
     */
    @GET
    @Produces(MediaType.TEXT_XML)
    public final List<Article> getHTML() {
        final List<Article> articles = new ArrayList<Article>();
        final ArticleService articleService = new ArticleServiceImpl();
        articles.addAll(articleService.get());
        return articles;
    }

    /**
     * getXML() method.
     * @return TODO.
     */
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public final List<Article> getXML() {
        final List<Article> articles = new ArrayList<Article>();
        final ArticleService articleService = new ArticleServiceImpl();
        articles.addAll(articleService.get());
        return articles;
    }

    /**
     * getCount() method.
     * @return the number of articles
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public final String getCount() {
        final ArticleService articleService = new ArticleServiceImpl();
        return String.valueOf(articleService.count());
    }

    /**
     * TODO.
     * @param argTitle TODO.
     * @param argContent TODO.
     * @param servletResponse TODO.
     * @throws java.io.IOException TODO.
     */
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public final void newArticle(@FormParam("title") final String argTitle,
            @FormParam("content") final String argContent,
            @Context final HttpServletResponse servletResponse)
            throws IOException {
        final ArticleService articleService = new ArticleServiceImpl();
        articleService.save(new Article(argTitle, argContent));
        servletResponse.sendRedirect("../create_todo.html");
    }

    /**
     * TODO.
     * Defines that the next path parameter after todos is
     * treated as a parameter and passed to the TodoResources
     * Allows to type http://localhost:8080/blog/rest/article/1
     * 1 will be treaded as parameter todo and passed to TodoResource
     * @param  argId TODO.
     * @return TODO.
     */
    @Path("{article}")
    public final ArticleResource getArticle(
            @PathParam("article") final String argId) {
        final int locId = Integer.valueOf(argId);
        return new ArticleResource(uriInfo, request, locId);
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

}
