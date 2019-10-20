<!DOCTYPE html>
<html class="no-js" lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Gestion des salariés - Détail d'une fiche</title>
		<link rel="stylesheet" type="text/css"
		      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
		<link rel="stylesheet" type="text/css"
		      href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
		<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
	</head>
	<body>
		<div class="callout large primary">
			<div class="row column text-center">
				<h1>Gestion des salariés - Détail d'une fiche</h1>
			</div>
		</div>
		<div class="row small-5 small-centered">
			<form method="POST" action="persons">
				<input type="hidden" value="${requestScope.currentPerson.id}" name="form-id"/>
				<div class="form-icons">
					<h4>Fiche salarié</h4>
					<div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-user"></i>
						</span>
						<input class="input-group-field" type="text" placeholder="Nom complet" name="form-name"
						       value="${requestScope.currentPerson.name}"/>
					</div>
					<div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-envelope"></i>
						</span>
						<input class="input-group-field" type="text" placeholder="Email" name="form-email"
						       value="${requestScope.currentPerson.email}"/>
					</div>
					<div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-dollar-sign"></i>
						</span>
						<input class="input-group-field" type="text" placeholder="Salaire" name="form-salary"
						       value="${requestScope.currentPerson.salary}"/>
					</div>
				</div>
				<button class="button expanded">Valider</button>
			</form>
		
		
		</div>
		<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
		<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
		<script>
			$(document).foundation();
			document.documentElement.setAttribute('data-useragent', navigator.userAgent);
		</script>
	</body>
</html>