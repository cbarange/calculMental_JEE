<!DOCTYPE html>
<html class="no-js" lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Accueil - Tableau des scores</title>
		<link rel="stylesheet" type="text/css"
		      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
		<link rel="stylesheet" type="text/css"
		      href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css"/>
	</head>
	<body>
		<div class="callout large primary">
			<div class="row column text-center">
				<h1>Accueil - Tableau des scores</h1>
			</div>
		</div>
		<div class="row small-8 small-centered">
		<div>
			<form action="calcul" method="get">
				<button action="" class="button expanded">Jouer</button>
			</form>
		</div>
		<table>
			<thead>
				<tr>
					<th>Pseudo</th>
					<th>Score</th>
				</tr>
			</thead>
			<tbody>
				<form id="delete-form" action="persons" method="POST">
					<input id="form-method" type="hidden" name="form-method"
						value="DELETE" /> <input id="form-id" type="hidden" name="form-id"
						value="" />
				</form>
				<c:forEach var="user" items="${ sessionScope.userList }"
					varStatus="status">
					<tr>
						<td>${user.login}</td>
						<td>${user.maxScore}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
		<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
		<script>
			$(document).foundation();
			document.documentElement.setAttribute('data-useragent', navigator.userAgent);
			$(document).ready(function () {
				$("a.delete-link").on("click", function () {
					$("#form-id").attr("value", $(this).attr("data-id-to-del"));
					$("form#delete-form").submit();
				});
			});
		</script>
	</body>
</html>
