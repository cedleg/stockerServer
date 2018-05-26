<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="bootstrap/assets/bootstrap-3.3.7/dist/css/bootstrap.css">
<title>Form Category</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="jumbotron text-center">
				<h1 class="h2-responsive">Category settings</h1>
				<p class="lead">Server Interface Database</p>
				<hr class="my-2">
			</div>
			<h2>Category</h2>
		</div>
		<div class="row">
			<form method="post" action="/stockerapp/FormServlet">
					<div class="form-group">
						<label for="c_id">Id</label> <input type="text"
							id="c_id" name="c_id" class="form-control"
							value="<c:out value="${ category.id }" default="-1"/>" readonly>
					</div>
				<div class="form-group">
					<label for="c_name">Name:</label> <input type="text"
						class="form-control" id="c_name" name="c_name"
						value="<c:out value="${ category.name }" default="Unknow"/>" required
						placeholder="Please enter a name!">
				</div>
				<div class="form-group">
					<label for="c_desc">Description:</label> <input type="text"
						class="form-control" id="c_desc" name="c_desc"
						value="<c:out value="${ category.description }" default="Unknow"/>">
				</div>
				<br> <br>
				<c:if test = "${param.cat_id == 'new'}"><button type="submit" class="btn btn-success" name="btn_c_create">Create</button></c:if>
				<c:if test = "${param.cat_id != 'new'}"><button type="submit" class="btn btn-warning" name="btn_c_update">Update</button></c:if>
				<c:if test = "${param.cat_id != 'new'}"><button type="submit" class="btn btn-danger" name="btn_c_delete">Delete</button></c:if>
			</form>
		</div>
	</div>

  <script src="jquery/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/assets/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>