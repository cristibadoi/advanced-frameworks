<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<script src=<c:url value="/webjars/jquery/1.11.1/jquery.min.js"/>></script>
<script src=<c:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"/>></script>
<link rel="stylesheet" href=<c:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/> />
<script src=<c:url value="/webjars/bootstrap-select/1.12.0/js/bootstrap-select.min.js"/>></script>
<link rel="stylesheet" href=<c:url value="/webjars/bootstrap-select/1.12.0/css/bootstrap-select.min.css"/> />
<script type="text/javascript">
  $(document).ready(
      function() {
        $("#brand").change(
            function() {

              var val = $(this).val();
              var options = "<option value='' selected>"
                  + "<spring:message code="label.default-selection" />"
                  + "</option>";
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
        <li><a href="<c:url value="/publish" />"><spring:message code="label.menu-publish-button" /></a></li>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/account/articles"><spring:message code ="label.menu-my-articles-button" /></a></li>
          <li><a href="#" onclick="document.getElementById('logout-form').submit()"><spring:message
                code="label.menu-logout-button" /></a></li>
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
      <spring:message code="label.search-details" />
    </h2>
    <form name="search-form" action="/search" method="get">
      <div class="form-group">
        <label for="brand"><spring:message code="label.select-brand" /></label> <select data-live-search="true"
          class="selectpicker form-control" id="brand" name="brand">
          <option value='' selected><spring:message code="label.default-selection" /></option>
          <c:forEach items="${brands}" var="element">
            <option><c:out value="${element.name}" /></option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label for="model"><spring:message code="label.select-model" /></label> <select data-live-search="true"
          class="selectpicker form-control" id="model" name="model"
          title="<spring:message code="label.default-selection" />">
          <option value='' selected><spring:message code="label.default-selection" /></option>
        </select>
      </div>
      <div class="form-group">
        <label for="type"><spring:message code="label.select-type" /></label> <select data-live-search="true"
          class="selectpicker form-control" id="type" name="type"
          title="<spring:message code="label.default-selection" />">
          <option value='' selected><spring:message code="label.default-selection" /></option>
          <c:forEach items="${types}" var="element">
            <option><c:out value="${element.name}" /></option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label for="fuel"><spring:message code="label.select-fuel" /></label> <select data-live-search="true"
          class="selectpicker form-control" id="fuel" name="fuel"
          title="<spring:message code="label.default-selection" />">
          <option value='' selected><spring:message code="label.default-selection" /></option>
          <c:forEach items="${fuels}" var="element">
            <option><c:out value="${element.name}" /></option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label><spring:message code="label.select-capacity" /></label>
        <div class="form-inline">
          <input name="minCapacity" type="number" class="form-control" id="minCapacity"
            placeholder="<spring:message code="label.min-capacity" />"> <input name="maxCapacity" type="number"
            class="form-control" id="maxCapacity" placeholder="<spring:message code="label.max-capacity" />">
        </div>
      </div>
      <div class="form-group">
        <label><spring:message code="label.select-year" /></label>
        <div class="form-inline">
          <input name="minYear" type="number" class="form-control" id="minYear"
            placeholder="<spring:message code="label.min-year" />"> <input name="maxYear" type="number"
            class="form-control" id="maxYear" placeholder="<spring:message code="label.max-year" />">
        </div>
      </div>
      <div class="form-group">
        <label><spring:message code="label.select-mileage" /></label>
        <div class="form-inline">
          <input name="minMileage" type="number" class="form-control" id="minMileage"
            placeholder="<spring:message code="label.min-mileage" />"> <input name="maxMileage" type="number"
            class="form-control" id="maxMileage" placeholder="<spring:message code="label.max-mileage" />">
        </div>
      </div>
      <div class="form-group">
        <label><spring:message code="label.select-price" /></label>
        <div class="form-inline">
          <input name="minPrice" type="number" class="form-control" id="minPrice"
            placeholder="<spring:message code="label.min-price" />"> <input name="maxPrice" type="number"
            class="form-control" id="maxPrice" placeholder="<spring:message code="label.max-price" />">
        </div>
      </div>
      <div class="form-group">
        <label for="city"><spring:message code="label.select-city" /></label> <select data-live-search="true"
          class="selectpicker form-control" id="city" name="city"
          title="<spring:message code="label.default-selection" />">
          <option value='' selected><spring:message code="label.default-selection" /></option>
          <c:forEach items="${cities}" var="element">
            <option><c:out value="${element.name}" /></option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <button type="submit" class="btn btn-primary btn-lg btn-block">
          <spring:message code="label.submit-search" />
        </button>
      </div>
    </form>
  </div>
</body>

</html>