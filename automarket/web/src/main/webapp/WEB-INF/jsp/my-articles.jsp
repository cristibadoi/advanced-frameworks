<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>
<script src=<c:url value="/webjars/jquery/1.11.1/jquery.min.js"/>></script>
<script src=<c:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"/>></script>
<link rel="stylesheet" href=<c:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/> />
<title><spring:message code="label.account-articles-title" /></title>
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
  </nav>

  <sec:authorize access="isAuthenticated()">
    <form id="logout-form" action="/logout" method="post">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
  </sec:authorize>

  <div class="container">
    <h1>
      <spring:message code="label.account-articles-header" />
    </h1>
    <h2 class="lead">
      <strong class="text-danger"><spring:message code="label.account-current" /></strong> ${username}
    </h2>
    <h4>
      <spring:message code="label.account-info" />
      <br>
      <spring:message code="label.account-please" />
    </h4>
    <h2 class="lead">
      <spring:message code="label.account-your-articles" />
    </h2>

    <section class="col-xs-12 col-sm-6 col-md-12">
      <c:forEach items="${articles}" var="element">
        <fmt:formatDate value="${element.publicationDate}" type="both" dateStyle="medium" timeStyle="short"
          var="publicationDate"></fmt:formatDate>
        <article class="search-result row">
          <div class="col-xs-12 col-sm-12 col-md-3">
            <a href="/article/${element.id}" title="${element.imageLink.split(" /")[1]}" class="thumbnail"><img
              src="/images/${element.imageLink}" alt="${element.imageLink.split(" /")[1]}"/></a>
          </div>
          <div class="col-xs-12 col-sm-12 col-md-7">
            <h3>
              <a href="/article/${element.id}"><strong class="text-danger">${element.price}&nbspEUR</strong>&nbsp;-&nbsp;${element.brandName}&nbsp;${element.modelName}
              </a>
            </h3>
            <ul class="list-inline">
              <li>
                <ul class="list-unstyled">
                  <li><strong><spring:message code="label.results-date" /></strong>&nbsp${publicationDate}</li>
                  <li><strong><spring:message code="label.results-year" /></strong>&nbsp${element.modelYear}</li>
                  <li><strong><spring:message code="label.results-body-type" /></strong>&nbsp${element.type}</li>
                </ul>
              </li>
              <li>
                <ul class="list-unstyled">
                  <li><strong><spring:message code="label.results-mileage" /></strong>&nbsp${element.mileage}&nbsp;km</li>
                  <li><strong><spring:message code="label.results-capacity" /></strong>&nbsp${element.cylindricalCapacity}&nbsp;cc
                  </li>
                  <li><strong><spring:message code="label.results-fuel" /></strong>&nbsp${element.fuelName}</li>
                </ul>
              </li>
              <li>
                  <ul class="list-unstyled">
                    <li><a href="/account/articles/delete/${element.id}?action=delete" onclick="return confirm('Are you sure?')"><button type="button"
                          class="btn btn-primary">
                          <spring:message code="label.account-delete-button" />
                        </button></a></li>
                    <li><a href="/account/articles/delete/${element.id}?action=sold" onclick="return confirm('Are you sure?')"><button type="button"
                          class="btn btn-success">
                          <spring:message code="label.account-sold-button" />
                        </button></a></li>
                  </ul>
              </li>
            </ul>
          </div>
        </article>
      </c:forEach>

    </section>
  </div>
</body>

</html>