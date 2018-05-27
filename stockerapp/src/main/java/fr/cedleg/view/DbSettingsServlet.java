package fr.cedleg.view;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cedleg.model.BatchProducts;
import fr.cedleg.model.Category;
import fr.cedleg.model.Matter;
import fr.cedleg.model.Product;
import fr.cedleg.model.Unit;
import fr.cedleg.service.DatasourceService;

/**
 * Servlet implementation class ProductServlet
 * Url path = /dbview
 */
@WebServlet("/dbview")
public class DbSettingsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DatasourceService dsService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DbSettingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		try {
//			dsService.getUserTransaction().begin();
//		} catch (NotSupportedException | SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//		dsService.getUserTransaction().commit();
//	} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException
//			| HeuristicRollbackException | SystemException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		List<Product> products = dsService.getAllProducts();
		List<BatchProducts> batchs = dsService.getAllBathProducts();
		List<Category> categories = dsService.getAllCategories();
		List<Matter> matters = dsService.getAllMatters();
		List<Unit> units = dsService.getAllUnits();
		
		request.setAttribute("products", products);
		request.setAttribute("batchs", batchs);
		request.setAttribute("categories", categories);
		request.setAttribute("matters", matters);
		request.setAttribute("units", units);

		request.getSession().setAttribute("view", "all");
		request.getSession().setAttribute("searchBy", "*");
	
		request.getRequestDispatcher("dbview.jsp").forward(request, response);
		

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//BatchProducts batchP = null;
		//batchP = batchService.getBatchById(1L);
		//batchP.setProducts(products);
		//batchP = batchService.getBatchById(1L);
//		for(Product p : products) {
//			batchP.addProduct(product);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		if(request.getParameter("options").equals("all")) {
			List<Product> products = dsService.getAllProducts();
			List<BatchProducts> batchs = dsService.getAllBathProducts();
			List<Category> categories = dsService.getAllCategories();
			List<Matter> matters = dsService.getAllMatters();
			List<Unit> units = dsService.getAllUnits();
			
			request.setAttribute("products", products);
			request.setAttribute("batchs", batchs);
			request.setAttribute("categories", categories);
			request.setAttribute("matters", matters);
			request.setAttribute("units", units);
		}

		if(request.getParameter("options").equals("product")) {
			List<Product> products = dsService.getAllProducts();
			//Category cat = new Category("Légumes", "BIO");
			//cat.setId(1L);
			//List<Product> products = dsService.getProductsByCategory("Boissons");
			request.setAttribute("products", products);
		}
		if(request.getParameter("options").equals("batch")) {
			List<BatchProducts> batchs = dsService.getAllBathProducts();
			request.setAttribute("batchs", batchs);
		}		
		if(request.getParameter("options").equals("category")) {
			List<Category> categories = dsService.getAllCategories();
			request.setAttribute("categories", categories);
		}		
		if(request.getParameter("options").equals("matter")) {
			List<Matter> matters = dsService.getAllMatters();
			request.setAttribute("matters", matters);
		}		
		if(request.getParameter("options").equals("unit")) {
			List<Unit> units = dsService.getAllUnits();
			request.setAttribute("units", units);
		}
		if(request.getParameter("options") != null) {
			request.getSession().setAttribute("view", request.getParameter("options"));
		}
		
		
		request.getRequestDispatcher("dbview.jsp").forward(request, response);
	}

}
