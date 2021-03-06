<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="row">
	<table class="table table-bordered table-hover text-center">
		<caption>
			Matters list <span class="bg-info" style="color: white;"><strong>${fn:length(matters)}
					items</strong></span>
		</caption>
		<thead class="text-center thead-dark">
			<tr>
				<th scope="col"><c:out value="#"></c:out></th>
				<th scope="col"><c:out value="mat_ref"></c:out></th>
				<th scope="col"><c:out value="mat_name"></c:out></th>
				<th scope="col"><c:out value="mat_desc"></c:out></th>
				<th scope="col"><c:out value="mat_price"></c:out></th>
				<th scope="col"><c:out value="mat_stock"></c:out></th>
				<th scope="col"><a href="/stockerapp/form?matter_id=new"
					class="btn btn-warning">Create new</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ matters }" var="matter" varStatus="status">
				<tr>
					<th scope="row">${ status.count }</th>
					<td><c:out value="${ matter.reference }"></c:out></td>
					<td><c:out value="${ matter.name }"></c:out></td>
					<td><c:out value="${ matter.description }"></c:out></td>
					<td><c:out value="${ matter.price }"></c:out></td>
					<td><c:out value="${ matter.stock }"></c:out></td>
					<td><a href="/stockerapp/form?matter_id=${matter.id}"
						class="btn btn-info">Settings</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>