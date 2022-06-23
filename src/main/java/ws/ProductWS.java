/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dao.Product;
import dao.ProductDAO;
import dao.Video;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author DELL
 */
@Path("/products")
public class ProductWS {
    ProductDAO productDAO = ProductDAO.getInstance();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsByType(@QueryParam("type") String type) {
        return productDAO.getAllByType(type);
    }
    
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductsByName(@QueryParam("q") String name) {
        return productDAO.getByName(name);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addOneProduct(Product product) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(productDAO.addOneProduct(product));
            return json;
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String editOneProduct(@PathParam("id") String id, Product product) {

        product.setId(id);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(productDAO.editOneProduct(product));
            return json;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @DELETE
    @Path("{id}")
    public String deleteOneProduct(@PathParam("id") String id) {
        
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(productDAO.deleteOneProduct(id));
            return json;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
