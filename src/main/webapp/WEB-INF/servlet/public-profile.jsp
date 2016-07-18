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
        <%@ include file="/WEB-INF/includes/pageparts/head/basic.jsp"%>
    </head>
    <body>
        <%@ include file="/WEB-INF/includes/pageparts/menu.jsp"%>

        <div class="container">
            <div class="row">
                <div class="col-md-9 col-sm-12">
                    <h2><fmt:message key="public-profile.title" />: <span class="user"><%= request.getAttribute("screenname")%></span></h2>
                    <div>
                        <ul class="nav nav-pills" role="tablist">
                            <li role="presentation" class="active"><a data-toggle="tab" href="#profile"><fmt:message key="public-profile.nav.profile" /></a></li>
                                <shiro:authenticated>
                                    <% if ((boolean) request.getAttribute("you")) { %>
                                <li role="presentation" class="active"><a data-toggle="tab" href="#profile"><fmt:message key="public-profile.nav.profile.other-friends" /></a></li>
                                    <% }%>
                                </shiro:authenticated>
                            <li role="presentation"><a data-toggle="tab" href="#projects"><fmt:message key="public-profile.nav.projects" /></a></li>
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
                                <div role="tabpanel" class="tab-pane" id="projects">
                                    <h3><fmt:message key="public-profile.friends.other" /></h3>
                                </div>
                                <% }%>
                            </shiro:authenticated>
                            <div role="tabpanel" class="tab-pane" id="projects">
                                <h3><fmt:message key="public-profile.projects" /></h3>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <%@ include file="/WEB-INF/includes/pageparts/footer.jsp"%>

    </body>
</html>