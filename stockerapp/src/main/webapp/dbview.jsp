<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="bootstrap-4.0.0/dist/css/bootstrap.min.css">
<title>DatabaseView</title>
<style>
th {
	text-align: center;
}

div.btn-group {
    margin: 0 auto; 
    text-align: center;
    width: inherit;
    display: inline-block;
}

#table_form{
    margin: 0 auto; 
    text-align: center;
    width: inherit;
    display: inline-block;
}

caption {
  caption-side: top;
}
</style>
</head>
<body>
	<div class="container">
		<c:if test = "${sessionScope.view != 'all'}">
        	<jsp:include page="/WEB-INF/jsp/views/alpha.jsp"></jsp:include>
        </c:if>
		<br>

		<div id="table_form" class="row">
		<form id="myForm" action="/stockerapp/dbview" method="post">
			<div class="btn-group btn-group-toggle col-md-12 text-center center-block" data-toggle="buttons">
				<label class="btn btn btn-outline-primary"> <input id="all" type="radio"
					name="options" value="all" onChange="submitForm()" autocomplete="off">
					All
				</label>
				<label class="btn btn btn-outline-primary"> <input id="batch" type="radio"
					name="options" value="batch" onChange="submitForm()" autocomplete="off">
					Batch
				</label> <label class="btn btn btn-outline-primary"> <input id="product" type="radio"
					name="options" value="product" onChange="submitForm()" autocomplete="off"> Product
				</label> <label class="btn btn btn-outline-primary"> <input id="matter" type="radio"
					name="options" value="matter" onChange="submitForm()" autocomplete="off"> Matter
				</label> <label class="btn btn btn-outline-primary"> <input id="category" type="radio"
					name="options" value="category" onChange="submitForm()" autocomplete="off" > category
				</label> <label class="btn btn btn-outline-primary"> <input id="unit" type="radio"
					name="options" value="unit" onChange="submitForm()" autocomplete="off"> Unit
				</label>
			</div>
			</form>
		</div>
		<br>
		<c:choose> 
         <c:when test = "${ sessionScope.view == 'product'}">
            <jsp:include page="/WEB-INF/jsp/views/table_product.jsp"/>
         </c:when>
         
         <c:when test = "${sessionScope.view == 'batch'}">
            <jsp:include page="/WEB-INF/jsp/views/table_batch.jsp"/>
         </c:when>
         
         <c:when test = "${sessionScope.view == 'category'}">
            <jsp:include page="/WEB-INF/jsp/views/table_category.jsp"/>
         </c:when>
                  
         <c:when test = "${sessionScope.view == 'matter'}">
            <jsp:include page="/WEB-INF/jsp/views/table_matter.jsp"/>
         </c:when>     
         
         <c:when test = "${sessionScope.view == 'unit'}">
            <jsp:include page="/WEB-INF/jsp/views/table_unitstock.jsp"/>
         </c:when>     
         
         <c:otherwise>
					<jsp:include page="/WEB-INF/jsp/views/table_product.jsp"/>
				<br>
					<jsp:include page="/WEB-INF/jsp/views/table_batch.jsp"/>
				<br>
					<jsp:include page="/WEB-INF/jsp/views/table_category.jsp"/>
				<br>
					<jsp:include page="/WEB-INF/jsp/views/table_matter.jsp"/>
				<br>
					<jsp:include page="/WEB-INF/jsp/views/table_unitstock.jsp"/>
         </c:otherwise>
      </c:choose>
      
	</div>

	<script src="jquery/jquery-3.1.1.min.js"></script>
	<script src="bootstrap-4.0.0/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$( document ).ready(function() {
		var opt = "${sessionScope.view}";
		$("#"+opt).parent('.btn').addClass('focus');
		$("#"+opt).parent('.btn').addClass('active');
		//$("#"+opt).button('toggle');
	});
	
	function submitForm() {
	     document.getElementById("myForm").submit();
	}
	</script>
</body>
</html>