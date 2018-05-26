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
				<th scope="col"><a href="/stockerapp/form?batch_id=new"
					class="btn btn-warning">Create new</a></th>
				<th scope="col"><c:out value="batch_products"></c:out></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ batchs }" var="batch" varStatus="status">
				<tr>
					<th rowspan="${fn:length(batch.products)+1}" scope="row">${ status.count }</th>
					<td rowspan="${fn:length(batch.products)+1}"><c:out
							value="${ batch.reference }"></c:out></td>
					<td rowspan="${fn:length(batch.products)+1}"><c:out
							value="${ batch.name }"></c:out></td>
					<td rowspan="${fn:length(batch.products)+1}"><c:out
							value="${ batch.description }"></c:out></td>
					<td rowspan="${fn:length(batch.products)+1}"><c:out
							value="${ batch.price }"></c:out></td>
					<td rowspan="${fn:length(batch.products)+1}"><a
						href="/stockerapp/form?batch_id=${batch.id}" class="btn btn-info">Settings</a></td>
					<c:forEach items="${ batch.products }" var="prod"
						varStatus="status">
						<tr>
							<td><c:out value="${ prod }"></c:out></td>
						</tr>
					</c:forEach>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>