/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.CategoryDAO;
import dao.Category;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author DELL
 */

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryWS {
    CategoryDAO dao = CategoryDAO.getInstance();
    @Context
    UriInfo ui;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {
        return dao.getAll();
    }
}
