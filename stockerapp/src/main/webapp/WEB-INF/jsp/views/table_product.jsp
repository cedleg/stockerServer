<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="row">
	<table class="table table-bordered table-hover text-center">
		<caption>
			Products list <span class="bg-info" style="color: white;"><strong>${fn:length(products)}
					items</strong></span>
		</caption>
		<thead class="text-center thead-dark">
			<tr>
				<th scope="col"><c:out value="#"></c:out></th>
				<th scope="col"><c:out value="product_ref"></c:out></th>
				<th scope="col"><c:out value="product_name"></c:out></th>
				<th scope="col"><c:out value="product_desc"></c:out></th>
				<th scope="col"><c:out value="product_price"></c:out></th>
				<th scope="col"><c:out value="product_stock"></c:out></th>
				<th scope="col"><c:out value="product_mat"></c:out></th>
				<th scope="col"><c:out value="product_cat"></c:out></th>
				<th scope="col"><a href="/stockerapp/form?prod_id=new"
					class="btn btn-warning">Create new</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ products }" var="product" varStatus="status">
				<tr>
					<th scope="row">${ status.count }</th>
					<td><c:out value="${ product.reference }"></c:out></td>
					<td><c:out value="${ product.name }"></c:out></td>
					<td><c:out value="${ product.description }"></c:out></td>
					<td><c:out value="${ product.price }"></c:out></td>
					<td><c:out value="${ product.stock }"></c:out></td>
					<td>
					<c:forEach items="${ product.matters }" var="matter"
						varStatus="status">					
							<p><c:out value="${ matter }"></c:out></p>					
					</c:forEach>
					</td>
					<td><c:out value="${ product.category }"></c:out></td>
					<td><a href="/stockerapp/form?prod_id=${product.id}"
						class="btn btn-info">Settings</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>