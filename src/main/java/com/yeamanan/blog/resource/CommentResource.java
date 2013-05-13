package com.yeamanan.blog.resource;

import com.yeamanan.blog.model.Comment;
import com.yeamanan.blog.service.CommentService;
import com.yeamanan.blog.service.CommentServiceImpl;
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
 * CommentResource class.
 * @author Camelia
 */
public class CommentResource {

    /**
     * TODO.
     */
    private CommentService commentService;

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
     * @param argCommentService TODO.
     * @param argUriInfo TODO.
     * @param argRequest TODO.
     * @param argId TODO.
     */
    public CommentResource(final CommentService argCommentService,
            final UriInfo argUriInfo,
            final Request argRequest,
            final int argId) {
        this.commentService = argCommentService;
        this.uriInfo = argUriInfo;
        this.request = argRequest;
        this.id = argId;
    }

    /**
     * TODO.
     */
    @DELETE
    public final void delete() {
        commentService.remove(id);
    }

    /**
     * TODO.
     * @return TODO.
     */
    @GET
    @Produces({ MediaType.TEXT_XML })
    public final Comment getHTML() {
        return commentService.get(id);
    }

    /**
     * TODO.
     * @return TODO.
     */
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public final Comment getXML() {
        return commentService.get(id);
    }

    /**
     * TODO.
     * @param element TODO.
     * @return TODO.
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public final Response post(final JAXBElement<Comment> element) {
        final Comment comment = element.getValue();
        return putAndGetResponse(comment);
    }

    /**
     * TODO.
     * @param element TODO.
     * @return TODO.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public final Response put(final JAXBElement<Comment> element) {
        final Comment comment = element.getValue();
        return putAndGetResponse(comment);
    }

    /**
     * TODO.
     * @param comment TODO.
     * @return TODO.
     */
    private Response putAndGetResponse(final Comment comment) {
        Response response;
        if (commentService.containsKey(comment.getId())) {
            response = Response.noContent().build();
            commentService.update(comment);
        } else {
            response = Response.created(uriInfo.getAbsolutePath()).build();
            commentService.save(comment);
        }
        return response;
    }

    /**
     * getCommentService() method.
     * @return TODO.
     */
    public final CommentService getCommentService() {
        return commentService;
    }

    /**
     * setCommentService(CommentService) method.
     * @param argArticleService TODO.
     */
    public void setCommentService(final CommentService argCommentService) {
        this.commentService = argCommentService;
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