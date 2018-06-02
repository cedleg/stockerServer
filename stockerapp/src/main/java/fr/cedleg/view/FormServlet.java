package fr.cedleg.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cedleg.model.BatchProducts;
import fr.cedleg.model.Category;
import fr.cedleg.model.ComposeProduct;
import fr.cedleg.model.Matter;
import fr.cedleg.model.Product;
import fr.cedleg.model.Stock;
import fr.cedleg.model.Unit;
import fr.cedleg.service.DatasourceService;

/**
 * Servlet implementation class FormServlet
 * Path = /Form or /FomServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DatasourceService dsService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
			switch (request.getParameterNames().nextElement()) {
				case "prod_id" :	
					List<Category> cats = dsService.getAllCategories();
					request.setAttribute("categories", cats);
					List<Unit> units = dsService.getAllUnits();
					request.setAttribute("units", units);
					List<Matter> matters = dsService.getAllMatters();
					request.setAttribute("matters", matters);
					
					if(!request.getParameter("prod_id").equals("new")) {
						Product prod = dsService.getEntityManager().find(Product.class, Long.parseLong(request.getParameter("prod_id")));		
						request.setAttribute("product", prod);
					}
					this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/form/formProduct.jsp" ).forward( request, response );
					break;	
					
				case "batch_id" :
					if(request.getParameter("batch_id").equals("new")) {
						List<Product> products = dsService.getAllProducts();
						request.setAttribute("products", products);
					}else {
						BatchProducts batch = dsService.getEntityManager().find(BatchProducts.class, Long.parseLong(request.getParameter("batch_id")));
						request.setAttribute("batch", batch);
						List<Product> products = dsService.getAllProducts();
						request.setAttribute("products", products);
					}
					this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/form/formBatch.jsp" ).forward( request, response );
					break;
					
				case "cat_id" :
					if(request.getParameter("cat_id").equals("new")) {
					
					}else {
						Category category = dsService.getEntityManager().find(Category.class, Long.parseLong(request.getParameter("cat_id")));
						request.setAttribute("category", category);			
					}
					this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/form/formCategory.jsp" ).forward( request, response );
					break;
					
				case "matter_id" :
					if(request.getParameter("matter_id").equals("new")) {
						List<Unit> unitsToMatter = dsService.getAllUnits();
						request.setAttribute("units", unitsToMatter);
					}else {
						Matter matter = dsService.getEntityManager().find(Matter.class, Long.parseLong(request.getParameter("matter_id")));
						request.setAttribute("matter", matter);
						List<Unit> unitsToMatter = dsService.getAllUnits();
						request.setAttribute("units", unitsToMatter);
					}
					this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/form/formMatter.jsp" ).forward( request, response );
					break;
					
				case "unit_id" :
					if(request.getParameter("unit_id").equals("new")) {
						
					}else {
						Unit unit = dsService.getEntityManager().find(Unit.class, Long.parseLong(request.getParameter("unit_id")));
						request.setAttribute("unit", unit);	
					}
					this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/form/formUnitStock.jsp" ).forward( request, response );
					break;
				default :
					response.getWriter().append("Malformed url! ").append(request.getContextPath());
					break;
			}
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//Enumeration<String> attrNames = (Enumeration<String>) request.getSession()request.getAttributeNames();
		
		/* CATEGORY FORMULAIRE */
		if(null != request.getParameter("btn_c_update") || null != request.getParameter("btn_c_create")
											|| null != request.getParameter("btn_c_delete")){		
			
			Category cat = new Category(request.getParameter("c_name"), request.getParameter("c_desc"));
			if(null!=request.getParameter("btn_c_create")) {
				dsService.persit(cat);
			}
			if(null!=request.getParameter("btn_c_update")) {
				cat.setId(Long.parseLong((String) request.getParameter("c_id")));
				dsService.merge(cat);
			}
			if(null!=request.getParameter("btn_c_delete")) {
				dsService.removeDetachedById(Category.class, Long.parseLong(request.getParameter("c_id")));
			}

		}
		/* PRODUCT FORMULAIRE */
		if(null != request.getParameter("btn_p_update") || null != request.getParameter("btn_p_create")
										|| null != request.getParameter("btn_p_delete")){
			Product prod = new Product(request.getParameter("p_name"), Double.parseDouble(request.getParameter("p_price")));
			Category cat = (Category) dsService.find(Category.class, Long.parseLong(request.getParameter("p_cat")));
			Unit unit = (Unit) dsService.find(Unit.class, Long.parseLong(request.getParameter("p_unit")));
			
			if(null!=request.getParameter("btn_p_create")) {
				prod.setReference(request.getParameter("p_ref"));
				prod.setDescription(request.getParameter("p_desc"));
				prod.setPrice(Double.parseDouble(request.getParameter("_price")));
				prod.setCategory(cat);
				Stock stockProd = new Stock(Double.parseDouble(request.getParameter("p_stock")), unit);
				prod.setStock(stockProd);
				String[] compoStr = request.getParameterValues("p_composes");
				List<ComposeProduct> compoList = new ArrayList<>();
				if(compoStr != null) {
					for(int i = 0; i < compoStr.length; i++) {
						Matter m = (Matter) dsService.find(Matter.class, Long.parseLong(compoStr[i]));
						ComposeProduct c = new ComposeProduct(1L, m);
						compoList.add(c);
					}				
					prod.setComposes(compoList);
				}
				dsService.persit(prod);
			}
			if(null!=request.getParameter("btn_p_update")) {
				long id = Long.parseLong((String) request.getParameter("p_id"));		
				prod = (Product) dsService.find(Product.class, id);
				prod.setId(id);
				prod.setReference(request.getParameter("p_ref"));
				prod.setDescription(request.getParameter("p_desc"));
				prod.setPrice(Double.parseDouble(request.getParameter("p_price")));
				prod.setCategory(cat);
				if(prod.getStock()!=null) {
					prod.getStock().setAmount(Double.parseDouble(request.getParameter("p_stock")));
					prod.getStock().setUnit(unit);
				}else {
					Stock stockProd = new Stock(Double.parseDouble(request.getParameter("p_stock")), unit);
					prod.setStock(stockProd);
				}
				
				String[] compoStr = request.getParameterValues("p_composes");
				List<ComposeProduct> compoList = new ArrayList<>();
				if(compoStr != null) {
					for(int i = 0; i < compoStr.length; i++) {
						Matter m = (Matter) dsService.find(Matter.class, Long.parseLong(compoStr[i]));
						ComposeProduct c = new ComposeProduct(1L, m);
						compoList.add(c);
					}				
					prod.setComposes(compoList);
				}
					
				dsService.merge(prod);
			}
			if(null!=request.getParameter("btn_p_delete")) {
				dsService.removeDetachedById(Product.class, Long.parseLong((String) request.getParameter("p_id")));
			}
		}
		/* BATCH FORMULAIRE */
		if(null != request.getParameter("btn_b_update") || null != request.getParameter("btn_b_create")
														|| null != request.getParameter("btn_b_delete")) {
			long id = Long.parseLong((String) request.getParameter("b_id"));
			BatchProducts batch = new BatchProducts();
			batch.setReference(request.getParameter("b_ref"));
			batch.setName(request.getParameter("b_name"));
			batch.setDescription(request.getParameter("b_desc"));
			batch.setPrice(Double.parseDouble(request.getParameter("b_price")));
			String[] pStr = request.getParameterValues("b_cat");
			//response.getWriter().append(pStr.toString());
			List<Product> pList = new ArrayList<>();
			if(pStr != null) {
				for(int i = 0; i < pStr.length; i++) {
					Product p = (Product) dsService.find(Product.class, Long.parseLong(pStr[i]));
					pList.add(p);
				}				
				batch.setProducts(pList);
			}
			
			if(null!=request.getParameter("btn_b_create")) {
				dsService.persit(batch);
			}
			if(null!=request.getParameter("btn_b_update")) {
				batch.setId(id);
				dsService.merge(batch);
			}
			if(null!=request.getParameter("btn_b_delete")) {
				dsService.removeDetachedById(BatchProducts.class, Long.parseLong(request.getParameter("b_id")));
			}

		}
		/* MATTER FORMULAIRE */
		if(null != request.getParameter("btn_m_update") || null != request.getParameter("btn_m_create")
										|| null != request.getParameter("btn_m_delete")) {

			Unit unit = (Unit) dsService.find(Unit.class, Long.parseLong(request.getParameter("m_unit")));
			
			Matter matter = new Matter();
			if(null!=request.getParameter("btn_m_create")) {
				matter.setReference(request.getParameter("m_ref"));
				matter.setName(request.getParameter("m_name"));
				matter.setDescription(request.getParameter("m_desc"));
				matter.setPrice(Double.parseDouble(request.getParameter("m_price")));
				Stock stockMatter = new Stock(Double.parseDouble(request.getParameter("m_stock")), unit);
				matter.setStock(stockMatter);
				dsService.persit(matter);
			}
			if(null!=request.getParameter("btn_m_update")) {
				long id = Long.parseLong((String) request.getParameter("m_id"));
				matter = (Matter) dsService.find(Matter.class, id);
				matter.setReference(request.getParameter("m_ref"));
				matter.setName(request.getParameter("m_name"));
				matter.setDescription(request.getParameter("m_desc"));
				matter.setPrice(Double.parseDouble(request.getParameter("m_price")));
				matter.getStock().setAmount(Double.parseDouble(request.getParameter("m_stock")));
				matter.getStock().setUnit(unit);
				dsService.merge(matter);
			}
			if(null!=request.getParameter("btn_m_delete")) {
				dsService.removeDetachedById(Matter.class, Long.parseLong(request.getParameter("m_id")));
			}

		}
		/* UNIT FORMULAIRE */
		if(null != request.getParameter("btn_u_update") || null != request.getParameter("btn_u_create")
											|| null != request.getParameter("btn_u_delete")){

			Unit unit = new Unit();
			unit.setType(request.getParameter("u_type"));
			if(null!=request.getParameter("btn_u_create")) {
				dsService.persit(unit);
			}
			if(null!=request.getParameter("btn_u_update")) {
				unit.setId(Long.parseLong(request.getParameter("u_id")));
				dsService.merge(unit);
			}
			if(null!=request.getParameter("btn_u_delete")) {
				dsService.removeDetachedById(Unit.class, Long.parseLong(request.getParameter("u_id")));
			}
		}
		
		response.sendRedirect(getServletContext().getContextPath() + "/dbview");
	}

}
