<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/assets/bootstrap-3.3.7/dist/css/bootstrap.css">
<title>Form Batch</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="jumbotron text-center">
				<h1 class="h2-responsive">Batch settings</h1>
				<p class="lead">Server Interface Database</p>
				<hr class="my-2">
			</div>
			<h2>Batch</h2>
		</div>
		<div class="row">
			<form method="post" action="/stockerapp/FormServlet">
					<div class="form-group">
						<label for="b_id">Id</label> <input type="text"
							id="b_id" name="b_id" class="form-control"
							value="<c:out value="${ batch.id }" default="-1"/>" readonly>
					</div>
				<div class="form-group">
					<label for="b_ref">Ref:</label> <input type="text"
						class="form-control" id="b_ref" name="b_ref"
						value="<c:out value="${ batch.reference }" default="Unknow"/>" required>
				</div>
				<div class="form-group">
					<label for="b_name">Name:</label> <input type="text"
						class="form-control" id="b_name" name="b_name"
						value="<c:out value="${ batch.name }" default="Unknow"/>" required>
				</div>
				<div class="form-group">
					<label for="b_desc">Decription:</label> <input type="text"
						class="form-control" id="b_desc" name="b_desc"
						value="<c:out value="${ batch.description }" default="Unknow"/>">
				</div>
				<div class="form-group">
					<label for="b_price">Price:</label> <input type="number" step=".01"
						class="form-control" id="b_price" name="b_price"
						value="<c:out value="${ batch.price }" default="0"/>">
				</div>
				<div class="form-group">
					<label for="b_cat">Products:</label> <select multiple
						class="form-control" id="b_cat" name="b_cat">
						<c:forEach items="${ products }" var="prod" varStatus="status">
							<option value="<c:out value="${ prod.id }"/>"
								<c:forEach items="${ batch.products }" var="b_prod" varStatus="status">
								 	${b_prod == prod ? 'selected' : ' '}
								 </c:forEach>><c:out
									value="${prod.name} (${prod.price })"></c:out>
							</option>
						</c:forEach>
					</select>
				</div>
				<br> <br>
				<c:if test = "${param.batch_id == 'new'}"><button type="submit" class="btn btn-success" name="btn_b_create">Create</button></c:if>
				<c:if test = "${param.batch_id != 'new'}"><button type="submit" class="btn btn-warning" name="btn_b_update">Update</button></c:if>
				<c:if test = "${param.batch_id != 'new'}"><button type="submit" class="btn btn-danger" name="btn_b_delete">Delete</button></c:if>
			</form>
		</div>
	</div>

  <script src="jquery/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/assets/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>