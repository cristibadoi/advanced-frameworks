<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
  <script src=<c:url value="/webjars/jquery/1.11.1/jquery.min.js"/>></script>
  <script src=<c:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"/>></script>
  <link rel="stylesheet" href=<c:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>/>
  <title><spring:message code="label.results-title"/></title>
</head>

<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/" />"><spring:message code="label.menu-home-button"/></a>
    </div>
    <ul class="nav navbar-nav">
      <sec:authorize access="isAnonymous()">
        <li><a href="<c:url value="/login" />"><spring:message code="label.menu-login-button"/></a></li>
        <li><a href="<c:url value="/register" />"><spring:message code="label.menu-register-button"/></a></li>
      </sec:authorize>
      <sec:authorize access="isAuthenticated()">
        <li><a href="<c:url value="/messages" />"><spring:message code="label.menu-messages-button"/></a></li>
      </sec:authorize>
      <li><a href="<c:url value="/publish" />"><spring:message code="label.menu-publish-button"/></a></li>
      <sec:authorize access="isAuthenticated()">
        <li>
          <a href="#" onclick="document.getElementById('logout-form').submit()"><spring:message
              code="label.menu-logout-button"/></a>
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

  <h1><spring:message code="label.results-header"/></h1>
  <h2 class="lead"><strong class="text-danger">3</strong> results were found for the search for <strong
      class="text-danger">Lorem</strong></h2>

  <section class="col-xs-12 col-sm-6 col-md-12">

    <c:forEach items="${results}" var="element">
      <article class="search-result row">
        <div class="col-xs-12 col-sm-12 col-md-3">
          <a href="#" title="Lorem ipsum" class="thumbnail"><img src="http://lorempixel.com/250/140/people"
                                                                 alt="Lorem ipsum"/></a>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-2">
          <ul class="meta-search">
            <li><i class="glyphicon glyphicon-calendar"></i> <span>02/15/2014</span></li>
            <li><i class="glyphicon glyphicon-time"></i> <span>4:28 pm</span></li>
            <li><i class="glyphicon glyphicon-tags"></i> <span>People</span></li>
          </ul>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
          <h3><a href="#" title="">Voluptatem, exercitationem, suscipit, distinctio</a></h3>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatem, exercitationem, suscipit, distinctio,
            qui sapiente aspernatur molestiae non corporis magni sit sequi iusto debitis delectus doloremque.</p>
          <span class="plus"><a href="#" title="Lorem ipsum"><i class="glyphicon glyphicon-plus"></i></a></span>
        </div>
        <span class="clearfix borda"></span>
      </article>
    </c:forEach>

  </section>
</div>

</body>

</html>
