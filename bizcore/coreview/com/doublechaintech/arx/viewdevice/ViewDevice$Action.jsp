
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty viewDevice}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ViewDevice" style="color: green">${userContext.localeMap['view_device']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['view_device.id']}</span> ${viewDevice.id}</li>
<li><span>${userContext.localeMap['view_device.name']}</span> ${viewDevice.name}</li>
<li><span>${userContext.localeMap['view_device.longitude']}</span> ${viewDevice.longitude}</li>
<li><span>${userContext.localeMap['view_device.latitude']}</span> ${viewDevice.latitude}</li>
<li><span>${userContext.localeMap['view_device.height']}</span> ${viewDevice.height}</li>
<li><span>${userContext.localeMap['view_device.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${viewDevice.createTime}" /></li>

	
	</ul>
</div>



</c:if>


