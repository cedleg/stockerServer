package fr.cedleg.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
    public List<Product> getProducts() {	
    	return dsService.getAllProducts();
    }
    
    @GET()
    @Path("product/{id}")
    public Product getProduct(@PathParam("id") Long id) {
    	return (Product) dsService.find(Product.class, id);
    }
    
    @GET()
    @Path("productbycat/{name}")
    public List<Product> getProducts(@PathParam("name") String name) {
    	return dsService.getProductsByCategory(name);
    }
    
    @GET()
    @Path("batch/all")
    public List<BatchProducts> getBathProducts() {	
    	return dsService.getAllBathProducts();
    }
    
    @GET()
    @Path("batch/{id}")
    public BatchProducts getBatch(@PathParam("id") Long id) {
    	return (BatchProducts) dsService.find(BatchProducts.class, id);	
    }
    
    @GET
    @Path("category/all")
    public List<Category> getCategories(){
    	return dsService.getAllCategories();
    }
    
    @GET
    @Path("category/{id}")
    public Category getCategories(@PathParam("id") Long id) {
    	return (Category) dsService.find(Category.class, id);
    }
    
    @GET
    @Path("matter/all")
    public List<Matter> getMatters(){
    	return dsService.getAllMatters();
    }
    
    @GET
    @Path("matter/{id}")
    public Matter getMatter(@PathParam("id") Long id) {
    	return (Matter) dsService.find(Matter.class, id);
    }
    
    @GET
    @Path("unit/all")
    public List<Unit> getUnits(){
    	return dsService.getAllUnits();
    }
    
    @GET
    @Path("unit/{id}")
    public Unit getUnit(@PathParam("id") Long id) {
    	return (Unit) dsService.find(Unit.class, id);
    }

}
