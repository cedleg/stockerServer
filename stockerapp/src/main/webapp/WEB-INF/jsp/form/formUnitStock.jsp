<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/assets/bootstrap-3.3.7/dist/css/bootstrap.css">
<title>Form Unit</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="jumbotron text-center">
				<h1 class="h2-responsive">Unit settings</h1>
				<p class="lead">Server Interface Database</p>
				<hr class="my-2">
			</div>
			<h2>Unit</h2>
		</div>
		<div class="row">
			<form method="post" action="/stockerapp/FormServlet">
				<div class="form-group">
					<label for="u_id">Id</label> <input type="text" id="u_id"
						name="u_id" class="form-control"
						value="<c:out value="${ unit.id }" default="-1"/>" readonly>
				</div>
				<div class="form-group">
					<label for="u_type">Type:</label> <input type="text"
						class="form-control" id="u_type" name="u_type"
						value="<c:out value="${ unit.type }" default="Unknow"/>" required
						placeholder="Please enter a Type!">
				</div>
				<br> <br>
				
				<c:if test = "${param.unit_id == 'new'}"><button type="submit" class="btn btn-success" name="btn_u_create">Create</button></c:if>
				<c:if test = "${param.unit_id != 'new'}"><button type="submit" class="btn btn-warning" name="btn_u_update">Update</button></c:if>
				<c:if test = "${param.unit_id != 'new'}"><button type="submit" class="btn btn-danger" name="btn_u_delete">Delete</button></c:if>
			</form>
		</div>
	</div>

  <script src="jquery/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/assets/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>>
</body>
</html>