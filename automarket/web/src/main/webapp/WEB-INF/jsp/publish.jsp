<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
<script src=<c:url value="/webjars/jquery/1.11.1/jquery.min.js"/>></script>
<script src=<c:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"/>></script>
<link rel="stylesheet" href=<c:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>/>
<title><spring:message code="label.publish-title" /></title>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/" />"><spring:message code="label.menu-home-button" /></a>
			</div>
			<ul class="nav navbar-nav">
				<sec:authorize access="isAnonymous()">
					<li><a href="<c:url value="/login" />"><spring:message code="label.menu-login-button" /></a></li>
					<li><a href="<c:url value="/register" />"><spring:message code="label.menu-register-button" /></a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li><a href="<c:url value="/messages" />"><spring:message code="label.menu-messages-button" /></a></li>
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
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
   		</form>	
	</sec:authorize>    				
	
	<div class="container">
		<h2>
			<spring:message code="label.insert-register-data" />
		</h2>
		<form name="publish-form" action="/publish" method="post" onsubmit="return validateForm()">
			<div class="form-group">
				<div class="form-group">
					<label for="email"><spring:message code="label.register-email" /></label>
					<div class="form-inline">
						<input name="brand" id="brand" class="form-control" type="text">
					</div>
				</div>
				<div class="form-group" id="username-form-group">
					<label for="username"><spring:message code="label.register-username" /></label>
					<div class="form-inline">
						<input name="username" class="form-control" type="text" id="username">
						<span id="username-error"></span>
					</div>
				</div>
				<div class="form-group" id="password-form-group">
					<label for="password"><spring:message code="label.register-password" /></label>
					<div class="form-inline">
						<input name="password" class="form-control" type="password" id="password">
						<span id="password-error"></span>
					</div>
				</div>
				<div class="form-group" id="confirm-form-group">
					<label for="confirm-password"><spring:message code="label.confirm-password" /></label>
					<div class="form-inline">
						<input name="confirm-password" class="form-control" type="password" id="confirm-password">
						<span id="confirm-error"></span>
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