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
<script src=<c:url value="/webjars/bootstrap-select/1.12.0/js/bootstrap-select.min.js"/>></script>
<link rel="stylesheet" href=<c:url value="/webjars/bootstrap-select/1.12.0/css/bootstrap-select.min.css"/>/>
<script src="<c:url value="/webjars/bootstrap-form-helpers/2.3.0/js/bootstrap-formhelpers-phone.js"/>"></script>
<script type="text/javascript">
$(document).ready(function(){
  $("#brand").change(function() {
    
    $("#model").html("");
    var val = $(this).val();
    var options = "";
    <c:forEach items="${models}" var="item">
    	if ("${item.brand.name}" == val) {
    	  var modelName = "${item.name}";
    	  options += "<option>" + modelName + "</option>";
    	} 	
    </c:forEach>
    $("#model").html(options);
    $("#model").selectpicker("refresh");
  });
});
</script>
<title><spring:message code="label.home-title" /></title>
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
			<spring:message code="label.publish-form-header" />
		</h2>
		<form name="publish-form" action="/publish" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="brand"><spring:message code="label.publish-brand" /></label>
				<select data-live-search="true" class="selectpicker form-control" id="brand" name="brand" 
					title="<spring:message code="label.publish-choose" />" required>
					<c:forEach items="${brands}" var="element">
						<option><c:out value="${element.name}"/></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="model"><spring:message code="label.publish-model" /></label>
				<select data-live-search="true" class="selectpicker form-control" id="model" name="model"
					title="<spring:message code="label.publish-choose" />" required>
				</select>
			</div>
			<div class="form-group">
				<label for="type"><spring:message code="label.publish-type" /></label>
				<select data-live-search="true" class="selectpicker form-control" id="type" name="type"
					title="<spring:message code="label.publish-choose" />" required>
					<c:forEach items="${types}" var="element">
						<option><c:out value="${element.name}"/></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="fuel"><spring:message code="label.publish-fuel" /></label>
				<select data-live-search="true" class="selectpicker form-control" id="fuel" name="fuel"
					title="<spring:message code="label.publish-choose" />" required>
					<c:forEach items="${fuels}" var="element">
						<option><c:out value="${element.name}"/></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label><spring:message code="label.publish-year" /></label>
				<select data-live-search="true" class="selectpicker form-control" id="year" name="year"
					title="<spring:message code="label.publish-choose" />" required>
					<c:forEach begin="1970" end="2017" varStatus="loop">
						<option>${loop.index}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label><spring:message code="label.publish-capacity" /></label>
				<div class="form-inline"> 
					<input type="number" name="capacity" id="capacity" class="form-control" required> 
				</div>
			</div>
			<div class="form-group">
				<label><spring:message code="label.publish-mileage" /></label>
				<div class="form-inline"> 
					<input type="number" name="mileage" id="mileage" class="form-control" required> 
				</div>
			</div>
			<div class="form-group">
  				<label for="description"><spring:message code="label.publish-description" /></label>
  				<textarea class="form-control" rows="5" id="description" name="description" required></textarea>
			</div>
			<div class="form-group">
  				<label for="images"><spring:message code="label.publish-images" /></label>
  				<input type="file" accept=".jpg, .png" class="form-control"  id="images" name="images" multiple required>
			</div>
			<div class="form-group">
				<label><spring:message code="label.publish-price" /></label>
				<div class="form-inline"> 
					<input type="number" name="price" id="price" class="form-control" required>
				</div>
			</div>
			<div class="form-group">
				<label for="city"><spring:message code="label.publish-city" /></label>
				<select data-live-search="true" class="selectpicker form-control" id="city" name="city"
					title="<spring:message code="label.publish-choose" />" required>
					<c:forEach items="${cities}" var="element">
						<option><c:out value="${element.name}"/></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
  				<label for="phone"><spring:message code="label.publish-phone-number" /></label>
  				<div class="form-inline">
  					<input type="text" class="form-control bfh-phone" data-format="+40ddddddddd" name="phone" id="phone">
  				</div>
			</div>
			<div class="form-group">
  				<label for="email"><spring:message code="label.publish-email" /></label>
  				<input type="email" class="form-control"  id="email" name="email" required>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg btn-block"><spring:message code="label.publish-button" /></button>
			</div>	
		</form>
	</div>
</body>

</html>