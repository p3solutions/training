<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>D3Sixty</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-user-style-css">
</head>

<body>

	<div id="container">
		<div id="content">
			<label for="itemsPerPage">Show</label>
			<input type="number" id="itemsPerPage" value="5" class="input-box"><br><br>
			<table>
				<tr>
					<th>UserName</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Role</th>
					<th>Action</th>
				</tr>
                                <c:forEach var="tempUser" items="${USER_LIST}">
			
			<c:url var="tempLink" value="StudentControllerServlet">
				<c:param name="command" value="LOAD" />
				<c:param name="userName" value="${tempUser.id }"/>
			</c:url>
			
			<!--  set up a link to delete a student -->
		       <c:url var="deleteLink" value="StudentControllerServlet">
				<c:param name="command" value="DELETE" />
				<c:param name="userName" value="${tempUser.id }"/>
			</c:url>			
			<tr>
			    <td>${tempUser.UserName}</td>
				<td>${tempUser.firstName}</td>
				<td>${tempUser.lastName}</td>
				<td>${tempUser.email} </td>
                <td>${tempUser.role} </td>
                <td>${tempUser.action} </td>



				<td><a href="${tempLink }">Update</a>
				     |
				    <a href="${deleteLink}"
				    
				     onclick="if(!(confirm('Are you sure you want to delete this user?')))return false">
				     Delete</a>
				
				</td>
				     
			</tr>
			</c:forEach>
				
			</table>
			<div id="pagination">
				<select id="pageSelect"></select>
			</div>
		</div>
	</div>
	<script>
		
		const table = document.querySelector('table');
		const rows = Array.from(table.querySelectorAll('tr')).slice(1); // Exclude header row
		const itemsPerPageInput = document.getElementById('itemsPerPage');
		const pageSelect = document.getElementById('pageSelect');
		let itemsPerPage = parseInt(itemsPerPageInput.value); // Number of items to display per page
		let currentPage = 0;

		function displayPage(page) {
			rows.forEach((row, index) => {
				row.style.display = index >= page * itemsPerPage && index < (page + 1) * itemsPerPage ? 'table-row' : 'none';
			});
		}

		function updatePageSelect() {
			pageSelect.innerHTML = '';
			const totalPages = Math.ceil(rows.length / itemsPerPage);
			for (let i = 0; i < totalPages; i++) {
				const pageNumber = i + 1;
				const pageNumberOption = document.createElement('option');
				pageNumberOption.value = i;
				pageNumberOption.textContent = `Page ${pageNumber}`;
				pageSelect.appendChild(pageNumberOption);
			}
			pageSelect.selectedIndex = currentPage;
		}

		pageSelect.addEventListener('change', () => {
			currentPage = parseInt(pageSelect.value);
			displayPage(currentPage);
		});

		itemsPerPageInput.addEventListener('change', () => {
			itemsPerPage = parseInt(itemsPerPageInput.value);
			currentPage = 0;
			displayPage(currentPage);
			updatePageSelect();
		});

		displayPage(currentPage);
		updatePageSelect();
	</script>
</body>

</html>
