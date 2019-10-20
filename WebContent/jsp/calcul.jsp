<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>CALCUL</title>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath()%>/css/style.css" />
</head>
<body>
	<div class="callout large primary">
		<div class="row column text-center">
			<h1>Calcul</h1>
		</div>
	</div>
	<div class="row small-8 small-centered">
	<p>Calcul : ${ sessionScope.calcul.calcul}</p>
	<p>NE PAS REGARDER :<span id="resultat">SOLUTION: ${ sessionScope.calcul.resultat}</span></p>
	
	<form method="POST" action="calcul">
		<input name="form-reponse" type="number" step="any">
		<button class="button expanded">Suivant</button>
	</form>
	
		<!-- <table>
			<thead>
				<tr>
					<th>Resultat</th>
					<th>Calcul</th>
				</tr>
			</thead>
			<c:forEach var="calcul" items="${ sessionScope.calculList}"
				varStatus="status">
				<tr>
					<td>${calcul.resultat}</td>
					<td>${calcul.calcul}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table> -->

	</div>
	<script
		src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
	<script
		src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
	<script>
			$(document).foundation();
			document.documentElement.setAttribute('data-useragent', navigato*r.userAgent);
			$(document).ready(function () {
				$("a.delete-link").on("click", function () {
					$("#form-id").attr("value", $(this).attr("data-id-to-del"));
					$("form#delete-form").submit();
				});
			});
		</script>
		<style>
		#resultat{
			background-color: gray;
			color:gray;
		}
		#resultat:hover{
			background-color: white;
		}
		</style>
</body>
</html>
