<%--
    Document   : public profile
    Created on : 2-mei-2016, 20:15:02
    Author     : Michel
--%>

<%@page import="java.util.List"%>
<%@page import="com.parallax.server.blocklyprop.db.generated.tables.records.FriendRequestRecord"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/include.jsp"%>

<html>
    <head>
        <meta name="base" content="<url:getUrl url="/"/>">
        <%@ include file="/WEB-INF/includes/pageparts/head/basic.jsp"%>
        <link rel="stylesheet" href="<url:getCdnUrl url="/lib/bootstrap/plugins/bootstrap-table.min.css"/>" />
        <link type="text/css" rel="stylesheet" href="<url:getCdnUrl url="/style.css"/>" />
        <script src="<url:getCdnUrl url="/lib/jquery.form.min.js"/>" ></script>
        <script src="<url:getCdnUrl url="/lib/bootstrap/plugins/bootstrap-table.min.js"/>" ></script>
        <script src="<url:getCdnUrl url="/lib/simplemde.min.js"/>" ></script>
        <script src="<url:getCdnUrl url="/project.js"/>" ></script>
    </head>
    <body>
        <%@ include file="/WEB-INF/includes/pageparts/menu.jsp"%>

        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-12">
                    <h2><fmt:message key="public-profile.title" />: <span class="user"><%= request.getAttribute("screenname")%></span></h2>
                    <div>
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active"><a data-toggle="tab" href="#profile"><fmt:message key="public-profile.nav.profile" /></a></li>
                                <shiro:authenticated>
                                    <% if ((boolean) request.getAttribute("you")) { %>
                                <li role="presentation" class="active"><a data-toggle="tab" href="#other-friends"><fmt:message key="public-profile.nav.profile.other-friends" /></a></li>
                                    <% } %>
                                </shiro:authenticated>
                                <% if (!(boolean) request.getAttribute("you")) { %>
                            <li role="presentation"><a data-toggle="tab" href="#projects"><fmt:message key="public-profile.nav.projects" /></a></li>
                                <% }%>
                        </ul>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="profile">
                                <h3><fmt:message key="public-profile.friends" />
                                    <shiro:authenticated>
                                        <% if (!(boolean) request.getAttribute("you")) { %>
                                        <a href="#" class="btn btn-default">Invite</a>
                                        <% }%>
                                    </shiro:authenticated>
                                </h3>

                            </div>
                            <shiro:authenticated>
                                <% if ((boolean) request.getAttribute("you")) { %>
                                <div role="tabpanel" class="tab-pane" id="other-friends">
                                    <h3><fmt:message key="public-profile.friends.other" /></h3>
                                </div>
                                <% }%>
                            </shiro:authenticated>
                            <% if (!(boolean) request.getAttribute("you")) {%>
                            <div role="tabpanel" class="tab-pane" id="projects">
                                <h3><fmt:message key="public-profile.projects" /></h3>

                                <%
                                    Long idUser = (Long) request.getAttribute("isUser");
                                %>
                                <div id="project-table-container" class="collapse">
                                    <jsp:include page="/WEB-INF/includes/pageparts/projecttable.jsp">
                                        <jsp:param name="url" value="/rest/shared/project/userlist/${idUser}" />
                                        <jsp:param name="showuser" value="false" />
                                    </jsp:include>
                                </div>

                                <jsp:include page="/WEB-INF/includes/pageparts/projectform.jsp">
                                    <jsp:param name="mine" value="false" />
                                    <jsp:param name="shared" value="false" />
                                </jsp:include>
                            </div>
                            <% }%>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <%@ include file="/WEB-INF/includes/pageparts/footer.jsp"%>

    </body>
</html>