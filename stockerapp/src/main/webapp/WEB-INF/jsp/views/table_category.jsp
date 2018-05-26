<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="row">
	<table class="table table-bordered table-hover text-center">
		<caption>
			Categories list <span class="bg-info" style="color: white;"><strong>${fn:length(categories)}
					items</strong></span>
		</caption>
		<thead class="text-center thead-dark">
			<tr>
				<th scope="col"><c:out value="#"></c:out></th>
				<th scope="col"><c:out value="cat_name"></c:out></th>
				<th scope="col"><c:out value="cat_desc"></c:out></th>
				<th scope="col"><a href="/stockerapp/form?cat_id=new"
					class="btn btn-warning">Create new</a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ categories }" var="cat" varStatus="status">
				<tr>
					<th scope="row"><c:out value="${ status.count }"></c:out></th>
					<td><c:out value="${ cat.name }"></c:out></td>
					<td><c:out value="${ cat.description }"></c:out></td>
					<td><a href="/stockerapp/form?cat_id=${cat.id}"
						class="btn btn-info">Settings</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>