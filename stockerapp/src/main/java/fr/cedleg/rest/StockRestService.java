package fr.cedleg.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.cedleg.model.BatchProducts;
import fr.cedleg.model.Category;
import fr.cedleg.model.Matter;
import fr.cedleg.model.Product;
import fr.cedleg.model.Unit;
import fr.cedleg.service.DatasourceService;

/* STOCKER API REST : stockerapp/rest/stock */
@Path("/stock")
@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
public class StockRestService {
	
	@EJB
	private DatasourceService dsService;
	
    @GET()
    @Path("product/all")
    public Response getProducts() {	
    	List<Product> list = dsService.getAllProducts();
    	return spreadResponse(list);
    }
    
    @GET()
    @Path("product/{id}")
    public Response getProduct(@PathParam("id") Long id) {
    	Product p = (Product) dsService.find(Product.class, id);
    	return spreadResponse(p);
    }
    
    @GET()
    @Path("productbycat/{name}")
    public Response getProducts(@PathParam("name") String name) {
    	List<Product> list = dsService.getProductsByCategory(name);
    	return spreadResponse(list);
    }
    
    @GET()
    @Path("batch/all")
    public Response getBathProducts() {	
    	List<BatchProducts> list = dsService.getAllBathProducts();
    	return spreadResponse(list);
    }
    
    @GET()
    @Path("batch/{id}")
    public Response getBatch(@PathParam("id") Long id) {
    	BatchProducts b = (BatchProducts) dsService.find(BatchProducts.class, id);
    	return spreadResponse(b);
    }
    
    @GET
    @Path("category/all")
    public Response getCategories(){
    	List<Category> list = dsService.getAllCategories();
    	return spreadResponse(list);
    }
    
    @GET
    @Path("category/{id}")
    public Response getCategories(@PathParam("id") Long id) {
    	Category c = (Category) dsService.find(Category.class, id);
    	return spreadResponse(c);
    }
    
    @GET
    @Path("matter/all")
    public Response getMatters(){
    	List<Matter> list = dsService.getAllMatters();
    	return spreadResponse(list);
    }
    
    @GET
    @Path("matter/{id}")
    public Response getMatter(@PathParam("id") Long id) {
    	Matter m = (Matter) dsService.find(Matter.class, id);
    	if(m!=null) {
    		return Response.status(200).entity(m).build();
    	} else {
    		return Response.status(400).build();
    	}
    }
    
    @GET
    @Path("unit/all")
    public Response getUnits(){
    	List<Unit> list = dsService.getAllUnits();
    	return spreadResponse(list);
    }
    
    @GET
    @Path("unit/{id}")
    public Response getUnit(@PathParam("id") Long id) {
    	Unit u = (Unit) dsService.find(Unit.class, id);
    	return spreadResponse(u);
    }
    
    private Response spreadResponse(Object obj) {
    	if(obj!=null) {
    		return Response.status(200).entity(obj).build();
    	} else {
    		return Response.status(400).build();
    	}
    }

}
