package com.activevideo.bookmarks.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.PathParam;

import com.activevideo.bookmarks.persistentStorage.Redis;

@Path("/bookmarks")
public class BookmarkResource {
    
    // TODO send clientid
   private String clientId = "123";
    
    /* LIST: GET to /bookmarks lists all bookmarks  */
    @GET
    @Produces({"application/json"})
    public String getBookmark() {
    	String response = Redis.getInstance().get(clientId);
    	System.out.println("response: "+ response);
    	return response;
    }

    /* SHOW: GET to /bookmarks/:id shows the details of a specific bookmark  */
    @GET @Path("/{key}")
    @Produces({"application/json"})
    public String getBookmark(@PathParam("key") String key) {
        String response = Redis.getInstance().get(clientId, key);
        System.out.println("response: "+ response);
    	return response;
    }
    
    /*  CREATE: POST to /bookmarks creates a new bookmark */
    @POST @Path("/{key}")
    @Consumes({"application/json"})
    public void setBookmark(@PathParam("key") String key, String value) {
        Redis.getInstance().set(clientId, key, value);
    }
    
    /* DELETE: DELETE to /bookmarks/:id deletes a specific bookmark */
    @DELETE @Path("/{key}")
    @Consumes({"application/json"})
    public void deleteBookmark(@PathParam("key") String key) {
        Redis.getInstance().delete(clientId, key);
    }
    
}
