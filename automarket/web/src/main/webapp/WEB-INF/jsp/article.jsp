<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src=<c:url value="/webjars/jquery/1.11.1/jquery.min.js"/>></script>
<script src=<c:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"/>></script>
<link rel="stylesheet" href=<c:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/> />
<title><spring:message code="label.home-title" /></title>
</head>

<body>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#topNavbar">
          <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="<c:url value="/" />"><spring:message code="label.menu-home-button" /></a>
      </div>
      <div class="collapse navbar-collapse" id="topNavbar">
        <ul class="nav navbar-nav">
          <sec:authorize access="isAnonymous()">
            <li><a href="<c:url value="/login" />"><spring:message code="label.menu-login-button" /></a></li>
            <li><a href="<c:url value="/register" />"><spring:message code="label.menu-register-button" /></a></li>
          </sec:authorize>
          <li><a href="<c:url value="/publish" />"><spring:message code="label.menu-publish-button" /></a></li>
          <sec:authorize access="isAuthenticated()">
            <li><a href="/account/articles"><spring:message code="label.menu-my-articles-button" /></a></li>
            <li><a href="#" onclick="document.getElementById('logout-form').submit()"><spring:message
                  code="label.menu-logout-button" /></a></li>
          </sec:authorize>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="?locale=ro_RO">RO</a></li>
          <li><a href="?locale=en_US">EN</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <sec:authorize access="isAuthenticated()">
    <form id="logout-form" action="/logout" method="post">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
  </sec:authorize>

  <div class="container">
    <ul class="list-inline">
      <c:forEach items="${article.imageLinks}" var="item">
        <li><a href="/images/${item}"><img class="img-responsive" src="/images/${item}" width="300"></a></li>
      </c:forEach>
    </ul>

    <ul class="list-group">
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-price" /></strong>&nbsp${article.price}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-brand" /></strong>&nbsp${article.brandName}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-model" /></strong>&nbsp${article.modelName}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-year" /></strong>&nbsp${article.modelYear}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-mileage" /></strong>&nbsp${article.mileage}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-fuel" /></strong>&nbsp${article.fuelName}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message
            code="label.article-capacity" /></strong>&nbsp${article.cylindricalCapacity}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-type" /></strong>&nbsp${article.typeName}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message
            code="label.article-description" /></strong>&nbsp${article.description}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-city" /></strong>&nbsp${article.cityName}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-phone" /></strong>&nbsp${article.phoneNumber}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-email" /></strong>&nbsp${article.email}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-user" /></strong>&nbsp${article.userName}</li>
      <li class="list-group-item"><strong class="text-danger"><spring:message code="label.article-date" /></strong>&nbsp${article.publicationDate}</li>
    </ul>
  </div>

</body>

</html>
