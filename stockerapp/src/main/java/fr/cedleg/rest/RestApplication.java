package fr.cedleg.rest;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestApplication extends Application {

	/**
	 * Add classes in Rest Application
	 */
	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(MessageRestService.class);
        s.add(BatchProductController.class);
        s.add(ProductController.class);
        s.add(MatterController.class);
        s.add(CategoryController.class);
        s.add(UnitController.class);
        return s;
	}

	@Override
	public Map<String, Object> getProperties() {
		return super.getProperties();
	}

	@Override
	public Set<Object> getSingletons() {
		return super.getSingletons();
	}

	
}
