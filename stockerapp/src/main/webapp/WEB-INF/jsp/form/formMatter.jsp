<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/assets/bootstrap-3.3.7/dist/css/bootstrap.css">
<title>Form Matter</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="jumbotron text-center">
				<h1 class="h2-responsive">Matter settings</h1>
				<p class="lead">Server Interface Database</p>
				<hr class="my-2">
			</div>
			<h2>Matter</h2>
		</div>
		<div class="row">
			<form method="post" action="/stockerapp/FormServlet">
					<div class="form-group">
						<label for="m_id">Id</label>
							<input type="text" id="m_id" name="m_id" class="form-control" 
							value="<c:out value="${ matter.id }" default="-1"/>" readonly>
					</div>
				<div class="form-group">
					<label for="m_ref">Ref</label> <input type="text"
						class="form-control" id="m_ref" name="m_ref"
						value="<c:out value="${ matter.reference }" />" required>
				</div>
				<div class="form-group">
					<label for="m_name">Name</label> <input type="text"
						class="form-control" id="m_name" name="m_name"
						value="<c:out value="${ matter.name }" />" required>
				</div>
				<div class="form-group">
					<label for="m_desc">Description</label> <input type="text"
						class="form-control" id="m_desc" name="m_desc"
						value="<c:out value="${ matter.description }" />" >
				</div>
				<div class="form-group">
					<label for="m_price">Price</label> <input type="number" step=".01"
						class="form-control" id="m_price" name="m_price"
						value="<c:out value="${ matter.price }" default="0"/>">
				</div>
				<div class="form-group">
					<label for="m_stock">Stock</label> <input type="number" step="1"
						class="form-control" id="m_stock" name="m_stock"
						value="<c:out value="${ matter.stock.amount }" default="0"/>">
				</div>
				
				<div class="form-group">
					<label for="m_unit">Unit</label> 
					<select class="form-control" id="m_unit" name="m_unit" required>
						<c:forEach items="${ units }" var="unit" varStatus="status">								
							<c:choose>
							    <c:when test="${unit == matter.stock.unit }">
									<option value="<c:out value="${ unit.id }" default="-1" />" selected ><c:out value="${ unit.type }"/></option>
							    </c:when>
							    <c:otherwise>
									<option value="<c:out value="${ unit.id }" default="-1" />" ><c:out value="${ unit.type }"/></option>
							    </c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<br> <br>
				<c:if test = "${param.matter_id == 'new'}"><button type="submit" class="btn btn-success" name="btn_m_create">Create</button></c:if>
				<c:if test = "${param.matter_id != 'new'}"><button type="submit" class="btn btn-warning" name="btn_m_update">Update</button></c:if>
				<c:if test = "${param.matter_id != 'new'}"><button type="submit" class="btn btn-danger" name="btn_m_delete">Delete</button></c:if>
			</form>
		</div>
	</div>

  <script src="jquery/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/assets/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>