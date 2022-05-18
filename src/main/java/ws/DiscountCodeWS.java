/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.DiscountCode;
import dao.DiscountCodeDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/discountCodes")
public class DiscountCodeWS {

    DiscountCodeDAO dao = DiscountCodeDAO.getInstance();
    @Context
    UriInfo ui;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DiscountCode> getDiscountCodes() {
        return dao.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addOneDiscountCode(DiscountCode discountCode) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(dao.addOneDiscountCode(discountCode));
            return json;
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String updateOne(@PathParam("id") String id, DiscountCode discountCode) {

        discountCode.setId(id);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(dao.editOneDiscountCode(discountCode));
            return json;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    public String deleteOneDiscountCode(@PathParam("id") String id) {
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(dao.deleteOneDiscountCode(id));
            return json;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
