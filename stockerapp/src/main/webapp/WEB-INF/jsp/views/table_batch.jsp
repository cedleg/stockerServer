<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="row">
	<table class="table table-bordered table-hover text-center">
		<caption>
			Batch list <span class="bg-info" style="color: white;"><strong>${fn:length(batchs)}
					items</strong></span>
		</caption>
		<thead class="text-center thead-dark">
			<tr>
				<th scope="col"><c:out value="#"></c:out></th>
				<th scope="col"><c:out value="batch_ref"></c:out></th>
				<th scope="col"><c:out value="batch_name"></c:out></th>
				<th scope="col"><c:out value="batch_desc"></c:out></th>
				<th scope="col"><c:out value="batch_price"></c:out></th>
				<th scope="col"><c:out value="batch_products"></c:out></th>
				<th scope="col"><a href="/stockerapp/form?batch_id=new"
					class="btn btn-warning">Create new</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ batchs }" var="batch" varStatus="status">
				<tr>
					<th scope="row">${ status.count }</th>
					<td><c:out
							value="${ batch.reference }"></c:out></td>
					<td><c:out
							value="${ batch.name }"></c:out></td>
					<td><c:out
							value="${ batch.description }"></c:out></td>
					<td><c:out
							value="${ batch.price }"></c:out></td>
					<td>
					<c:forEach items="${ batch.products }" var="prod"
						varStatus="status">
							<p><c:out value="${ prod }"></c:out></p>
					</c:forEach>
					</td>
					<td rowspan="${fn:length(batch.products)+1}"><a
						href="/stockerapp/form?batch_id=${batch.id}" class="btn btn-info">Settings</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>