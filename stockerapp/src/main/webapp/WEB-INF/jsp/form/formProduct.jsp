<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/assets/bootstrap-3.3.7/dist/css/bootstrap.css">
<title>Form Product</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="jumbotron text-center">
				<h1 class="h2-responsive">Product settings</h1>
				<p class="lead">Server Interface Database</p>
				<hr class="my-2">
			</div>
			<h2>Product</h2>
		</div>
		<div class="row">
			<form method="post" action="/stockerapp/FormServlet">
					<div class="form-group">
						<label for="p_id">Id</label>
							<input type="text" id="p_id" name="p_id" class="form-control" 
							value="<c:out value="${ product.id }" default="-1"/>" readonly>
					</div>
				<div class="form-group">
					<label for="p_ref">Ref:</label> <input type="text"
						class="form-control" id="p_ref" name="p_ref"
						value="<c:out value="${ product.reference }" default="Unknow"/>" required>
				</div>
				<div class="form-group">
					<label for="p_name">Name:</label> <input type="text"
						class="form-control" id="p_name" name="p_name"
						value="<c:out value="${ product.name }" default="Unknow"/>" required>
				</div>
				<div class="form-group">
					<label for="p_desc">Desc:</label> <input type="text"
						class="form-control" id="p_desc" name="p_desc"
						value="<c:out value="${ product.description }" default="Unknow"/>" required>
				</div>
				<div class="form-group">
					<label for="p_price">Price:</label> <input type="number" step=".01"
						class="form-control" id="p_price" name="p_price"
						value="<c:out value="${ product.price }" default="0"/>">
				</div>
				<div class="form-group">
					<label for="p_cat">Category:</label> 
					<select class="form-control" id="p_cat" name="p_cat">
						<c:forEach items="${ categories }" var="cat" varStatus="status">								
							<c:choose>
							    <c:when test="${cat == product.category }">
									<option value="<c:out value="${ cat.id }" default="-1" />" selected ><c:out value="${ cat.name }"/></option>
							    </c:when>
							    <c:otherwise>
									<option value="<c:out value="${ cat.id }" default="-1" />" ><c:out value="${ cat.name }"/></option>
							    </c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="p_stock">Stock</label> <input type="number" step="1"
						class="form-control" id="p_stock" name="p_stock"
						value="<c:out value="${ product.stock.amount }" default="0"/>">
				</div>
				
				<div class="form-group">
					<label for="p_unit">Unit</label> 
					<select class="form-control" id="p_unit" name="p_unit">
						<c:forEach items="${ units }" var="unit" varStatus="status">								
							<c:choose>
							    <c:when test="${unit == product.stock.unit }">
									<option value="<c:out value="${ unit.id }" default="-1" />" selected ><c:out value="${ unit.type }"/></option>
							    </c:when>
							    <c:otherwise>
									<option value="<c:out value="${ unit.id }" default="-1" />" ><c:out value="${ unit.type }"/></option>
							    </c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label for="p_composes">Compo:</label> <select multiple
						class="form-control" id="p_composes" name="p_composes">
						<c:forEach items="${ matters }" var="matter" varStatus="status">
							<option value="<c:out value="${ matter.id }"/>"
								<c:forEach items="${ product.composes }" var="p_comp" varStatus="status">
								 	${p_comp.matter == matter ? 'selected' : ' '}
								 </c:forEach>><c:out value="${matter}"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>
				<br> <br>
				<c:if test = "${param.prod_id == 'new'}"><button type="submit" class="btn btn-success" name="btn_p_create">Create</button></c:if>
				<c:if test = "${param.prod_id != 'new'}"><button type="submit" class="btn btn-warning" name="btn_p_update">Update</button></c:if>
				<c:if test = "${param.prod_id != 'new'}"><button type="submit" class="btn btn-danger" name="btn_p_delete">Delete</button></c:if>
			</form>
		</div>
	</div>

  <script src="jquery/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/assets/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>