<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/register.js"></script>
<title><spring:message code="label.register-title" /></title>
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/" />"><spring:message
						code="label.menu-home-button" /></a>
			</div>
			<ul class="nav navbar-nav">
				<sec:authorize access="isAnonymous()">
					<li><a href="<c:url value="/login" />"><spring:message code="label.menu-login-button" /></a></li>
					<li><a href="<c:url value="/register" />"><spring:message code="label.menu-register-button" /></a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li><a href="<c:url value="/messages" />"><spring:message
								code="label.menu-messages-button" /></a></li>
				</sec:authorize>
				<li><a href="<c:url value="/publish" />"><spring:message code="label.menu-publish-button" /></a></li>
				<sec:authorize access="isAuthenticated()">	
    				<li>
    					<a href="#" onclick="document.getElementById('logout-form').submit()"><spring:message code="label.menu-logout-button" /></a>
    				</li>
				</sec:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
      			<li><a href="?locale=ro_RO">RO</a></li>
      			<li><a href="?locale=en_US">EN</a></li>
    		</ul>
		</div>
	</nav>

	<sec:authorize access="isAuthenticated()">
		<form id="logout-form" action="/logout" method="post">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   		</form>	
	</sec:authorize>    

	<div class="container">
		<h2>
			<spring:message code="label.insert-register-data" />
		</h2>
		<div id="errorPanel"></div>
		<form name="register-form" action="/register" method="post" onsubmit="return validateForm()">
			<div class="form-group">
				<div class="form-group" id="email-form-group">
					<label for="email"><spring:message code="label.register-email" /></label>
					<div class="form-inline">
						<input name="email" class="form-control" type="text" id="email">
					</div>
				</div>
				<div class="form-group">
					<label for="username"><spring:message code="label.register-username" /></label>
					<div class="form-inline">
						<input name="username" class="form-control" type="text" id="username">
					</div>
				</div>
				<div class="form-group">
					<label for="password"><spring:message code="label.register-password" /></label>
					<div class="form-inline">
						<input name="password" class="form-control" type="password" id="password">
					</div>
				</div>
				<div class="form-group">
					<label for="confirm-password"><spring:message code="label.confirm-password" /></label>
					<div class="form-inline">
						<input name="confirm-password" class="form-control" type="password" id="confirm-password">
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg"><spring:message code="label.submit-register" /></button>
			</div>
		</form>
	</div>
	
</body>

</html>