<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />
<title><spring:message code="label.home-title" /></title>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/" />"><spring:message code="label.menu-home-button" /></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/login" />"><spring:message code="label.menu-login-button" /></a></li>
				<li><a href="<c:url value="/publish" />"><spring:message code="label.menu-publish-button" /></a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h2>
			<spring:message code="label.search-details" />
		</h2>
		<form name="search-form" action="/search" method="get">
			<div class="form-group">
				<label for="brand"><spring:message code="label.select-brand" /></label>
				<select data-live-search="true" class="form-control" id="brand" name="brand">
					<option value='' selected><spring:message code="label.default-selection" /></option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
			<div class="form-group">
				<label for="model"><spring:message code="label.select-model" /></label>
				<select data-live-search="true" class="form-control" id="model" name="model">
					<option value='' selected><spring:message code="label.default-selection" /></option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
			<div class="form-group">
				<label for="type"><spring:message code="label.select-type" /></label>
				<select data-live-search="true" class="form-control" id="type" name="type">
					<option value='' selected><spring:message code="label.default-selection" /></option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
			<div class="form-group">
				<label for="fuel"><spring:message code="label.select-fuel" /></label>
				<select data-live-search="true" class="form-control" id="fuel" name="fuel">
					<option value='' selected><spring:message code="label.default-selection" /></option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
			<div class="form-group">
				<label><spring:message code="label.select-capacity" /></label>
				<div class="form-inline"> 
					<input name="minCapacity" type="number" class="form-control"	id="minCapacity" placeholder="<spring:message code="label.min-capacity" />"> 
					<input name="maxCapacity" type="number" class="form-control" id="maxCapacity" placeholder="<spring:message code="label.max-capacity" />">
				</div>
			</div>
			<div class="form-group">
				<label><spring:message code="label.select-year" /></label>
				<div class="form-inline"> 
					<input name ="minYear" type="number" class="form-control"	id="minYear" placeholder="<spring:message code="label.min-year" />"> 
					<input name ="maxYear" type="number" class="form-control" id="maxYear" placeholder="<spring:message code="label.max-year" />">
				</div>
			</div>
			<div class="form-group">
				<label><spring:message code="label.select-mileage" /></label>
				<div class="form-inline"> 
					<input name="minMileage" type="number" class="form-control"	id="minMileage" placeholder="<spring:message code="label.min-mileage" />"> 
					<input name="maxMileage" type="number" class="form-control" id="maxMileage" placeholder="<spring:message code="label.max-mileage" />">
				</div>
			</div>
			<div class="form-group">
				<label><spring:message code="label.select-price" /></label>
				<div class="form-inline"> 
					<input name="minPrice" type="number" class="form-control"	id="minPrice" placeholder="<spring:message code="label.min-price" />"> 
					<input name="maxPrice" type="number" class="form-control" id="maxPrice" placeholder="<spring:message code="label.max-price" />">
				</div>
			</div>
			<div class="form-group">
				<label for="currency"><spring:message code="label.select-currency" /></label> 
				<select name="currency" data-live-search="true"	class="form-control" id="currency">
					<option value='' selected><spring:message code="label.default-selection" /></option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
			<div class="form-group">
				<label for="city"><spring:message code="label.select-city" /></label>
				<select name="city" data-live-search="true" class="form-control" id="city">
					<option value='' selected><spring:message code="label.default-selection" /></option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
			<div class="form-group"> <!-- Submit button !-->
				<button type="submit" class="btn btn-primary btn-lg btn-block"><spring:message code="label.submit-search" /></button>
			</div>	
		</form>
	</div>
</body>

</html>