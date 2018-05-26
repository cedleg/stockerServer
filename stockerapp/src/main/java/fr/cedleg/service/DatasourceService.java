package fr.cedleg.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.cedleg.model.BatchProducts;
import fr.cedleg.model.Category;
import fr.cedleg.model.Matter;
import fr.cedleg.model.Product;
import fr.cedleg.model.Unit;

@Stateless
public class DatasourceService {
	
	@PersistenceContext(unitName="stockerappPU")
	private EntityManager em;

	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public void persit(Object o) {
		em.persist(o);
	}
	
	public void merge(Object o) {
		em.merge(o);
	}
	
	public Object find(Class<?> cls, Long id) {
		return em.find(cls, id);
	}
	
	
	public Object findByName(Class<?> cls, String name) {
		return em.find(cls, name);
	}
	
	public void remove(Object o) {
		em.remove(o);
	}
	
	public void removeDetachedById(Class<?> cls, Long id) {
		Object o = em.find(cls, id);
		if(o != null) {
			em.remove(o);
		}
	}

	public List<BatchProducts>getAllBathProducts(){	
		return em.createNamedQuery(BatchProducts.GET_ALL, BatchProducts.class).getResultList();
	}
	
	public List<Product> getProductsByCategory(String name){
		TypedQuery<Product> query = (TypedQuery<Product>) em.createNamedQuery(Product.GET_PRODUCTS_BY_CAT_NAME, Product.class);
		//Category cat = new Category("Légumes", "BIO");
		//cat.setId(1L);
		query.setParameter("cat", name);
		return query.getResultList();
	}
	
	public List<Product>getAllProducts(){	
		return em.createNamedQuery(Product.GET_ALL_PRODUCTS, Product.class).getResultList();
	}
	
	public List<Category>getAllCategories(){	
		return em.createNamedQuery(Category.GET_ALL_CATEGORIES, Category.class).getResultList();
	}
	
	public List<Matter>getAllMatters(){
		return em.createNamedQuery(Matter.GET_ALL_MATTERS, Matter.class).getResultList();
	}
	
	public List<Unit>getAllUnits(){
		return em.createNamedQuery(Unit.GET_ALL_UNITS, Unit.class).getResultList();
	}
}
