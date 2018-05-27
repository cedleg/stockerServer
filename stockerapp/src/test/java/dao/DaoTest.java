package dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import fr.cedleg.model.Product;


public class DaoTest extends JpaBaseRolledBackTestCase {

	@Test
	public void persit() {
		assertFalse(false);
		Product p = (Product) em.find(Product.class, 2L);
		assertTrue(p != null);
	}
}
