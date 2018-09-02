<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ page import="java.util.Objects" %>

<%@page import= "com.autodetservice.comparator.AutoDetailComparator"%>
<%@page import= "com.autodetservice.comparator.AutoDetailComparatorByYear"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>




<liferay-theme:defineObjects />

<portlet:defineObjects />