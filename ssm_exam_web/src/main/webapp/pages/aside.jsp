<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>
                   <security:authentication property="principal.username" />
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index">
                <a href="${pageContext.request.contextPath}/main.jsp">
                    <i class="fa fa-dashboard"></i> <span>首页</span></a>
            </li>
           <c:forEach items="${permissions}" var="permission">
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-cogs"></i>
                        <span>${permission.permissionName}</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <c:forEach items="${permission.permissionList}" var="ps">
                        <li>
                            <a href="${pageContext.request.contextPath}/${ps.url}">
                                <i class="fa fa-circle-o"></i> ${ps.permissionName}
                            </a>
                        </li>
                         </c:forEach>

                        <%--<li>--%>
                            <%--<a href="${pageContext.request.contextPath}/role/findAll">--%>
                                <%--<i class="fa fa-circle-o"></i> 角色管理--%>
                            <%--</a>--%>
                        <%--</li>--%>

                        <%--<li>--%>
                            <%--<a href="${pageContext.request.contextPath}/permission/findAll">--%>
                                <%--<i class="fa fa-circle-o"></i> 资源权限管理--%>
                            <%--</a>--%>
                        <%--</li>--%>

                        <%--<li>--%>
                            <%--<a href="${pageContext.request.contextPath}/syslog/findAll">--%>
                                <%--<i class="fa fa-circle-o"></i> 访问日志--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    </ul>
                </li>
           </c:forEach>
                <%--<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>--%>
                    <%--<span>hhh</span> <span class="pull-right-container"> <i--%>
                            <%--class="fa fa-angle-left pull-right"></i>--%>
                    <%--</span>--%>
                <%--</a>--%>
                    <%--<ul class="treeview-menu">--%>
                        <%--<c:forEach items="${permissions.permissionList}" var="ps">--%>
                        <%--<li>--%>
                            <%--<a href="${pageContext.request.contextPath}/product/findAll">--%>
                                <%--<i class="fa fa-circle-o"></i> ${ps.permissionName}--%>
                        <%--</a>--%>
                        <%--</li>--%>
                        <%--</c:forEach>--%>
                        <%--<li>--%>
                            <%--&lt;%&ndash;?page=1&pageSize=3&ndash;%&gt;--%>
                            <%--<a href="${pageContext.request.contextPath}/orders/findAll">--%>
                                <%--<i class="fa fa-circle-o"></i> 订单管理--%>
                            <%--</a>--%>
                        <%--</li>--%>

                    </ul>

    </section>
    <!-- /.sidebar -->
</aside>