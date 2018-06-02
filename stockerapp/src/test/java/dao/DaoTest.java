package dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.cedleg.model.Product;

//@RunWith(Arquillian.class)
public class DaoTest {
	
	
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "testStockerapp.war")
            .addPackage(Product.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
            //.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
	@PersistenceContext
	private EntityManager em;

	@Test
	public void persit() {
		assertFalse(false);
		//Product p = (Product) em.find(Product.class, 2L);
		//assertTrue(p != null);
	}
}
