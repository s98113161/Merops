<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:url value="/" var="base" />
<link type="text/css" rel="stylesheet"
	href="${base}webjars/bootstrap/3.0.3/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${base}webjars/jquery/1.9.0/jquery.min.js"></script>
<script type="text/javascript"
	src="${base}webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<title>Merops - dragonfly client app</title>
</head>
<body>
	<div class="container">

		<h1>Welcome to Merops!</h1>

		<p>
			This is a website that will allow you to list your devices that
			you've register to <a href="http://localhost:8080/Dragonfly/">Dragonfly</a>!
			And since this site uses <a href="http://oauth.net">OAuth 2</a> to
			access your photos, we will never ask you for your Dragonfly
			credentials.
		</p>

			<%-- <p>
				<a href="<c:url value="/sparklr/photos"/>">View my Sparklr
					photos</a>
			</p> --%>
			
			<%-- <p>
				<a href="<c:url value="/merops/photos"/>">View my Sparklr / merops
					photos</a>
			</p> --%>
			
			<p>
			Click!
				<a href="<c:out value="/merops/devices"/>">View my Dragonfly / merops
					devices</a>
			</p>
			
			<%-- <p>
				<a href="<c:url value="/logout.do"/>">Logout</a>
			</p> --%>


	</div>
</body>
</html>