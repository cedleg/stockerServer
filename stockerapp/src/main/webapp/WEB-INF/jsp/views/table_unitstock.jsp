<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="row">
	<table class="table table-bordered table-hover text-center">
		<caption>
			Units list <span class="bg-info" style="color: white;"><strong>${fn:length(units)}
					items</strong></span>
		</caption>
		<thead class="text-center thead-dark">
			<tr>
				<th scope="col"><c:out value="#"></c:out></th>
				<th scope="col"><c:out value="unit_type"></c:out></th>
				<th scope="col"><a href="/stockerapp/form?unit_id=new"
					class="btn btn-warning">Create new</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ units }" var="unit" varStatus="status">
				<tr>
					<th scope="row">${ status.count }</th>
					<td><c:out value="${ unit.type }"></c:out></td>
					<td><a href="/stockerapp/form?unit_id=${unit.id}"
						class="btn btn-info">Settings</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>