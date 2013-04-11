package com.yeamanan.blog.resource;

import com.yeamanan.blog.model.Comment;
import com.yeamanan.blog.service.CommentService;
import com.yeamanan.blog.service.CommentServiceImpl;
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
 * CommentsResource class.
 * @author Yeam Anan (yeamanan@gmail.com)
 */
@Path("/comments")
public class CommentsResource {

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
    public final List<Comment> getHTML() {
        final List<Comment> comments = new ArrayList<Comment>();
        final CommentService commentService = new CommentServiceImpl();
        comments.addAll(commentService.get());
        return comments;
    }

    /**
     * getXML() method.
     * @return TODO.
     */
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public final List<Comment> getXML() {
        final List<Comment> comments = new ArrayList<Comment>();
        final CommentService commentService = new CommentServiceImpl();
        comments.addAll(commentService.get());
        return comments;
    }

    /**
     * getCount() method.
     * @return the number of comments
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public final String getCount() {
        final CommentService commentService = new CommentServiceImpl();
        return String.valueOf(commentService.count());
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
    public final void newComment(@FormParam("content") final String argContent,
            @Context final HttpServletResponse servletResponse)
            throws IOException {
        final CommentService commentService = new CommentServiceImpl();
        commentService.save(new Comment(argContent));
        servletResponse.sendRedirect("../create_todo.html");
    }

    /**
     * TODO.
     * Defines that the next path parameter after todos is
     * treated as a parameter and passed to the TodoResources
     * Allows to type http://localhost:8080/blog/rest/comment/1
     * 1 will be treaded as parameter todo and passed to TodoResource
     * @param  argId TODO.
     * @return TODO.
     */
    @Path("{comment}")
    public final CommentResource getComment(
            @PathParam("comment") final String argId) {
        final int locId = Integer.valueOf(argId);
        return new CommentResource(uriInfo, request, locId);
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
