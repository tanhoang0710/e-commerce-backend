/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.Video;
import dao.VideoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author DELL
 */
@Path("/videos")
public class VideoWS {
    VideoDAO dao = VideoDAO.getInstance();
    @Context
    UriInfo ui;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getVideos() {
        return dao.getAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addOneVideo(Video video) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(dao.addOneVideo(video));
            return json;
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public String deleteOne(@PathParam("id") String id) {
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(dao.deleteOneVideo(id));
            return json;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
