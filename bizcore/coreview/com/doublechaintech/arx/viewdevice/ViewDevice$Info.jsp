
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty viewDevice}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ViewDevice">${userContext.localeMap['view_device']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./viewDeviceManager/view/${viewDevice.id}/"> ${viewDevice.id}</a></li>
<li><span>${userContext.localeMap['view_device.name']}</span> ${viewDevice.name}</li>
<li><span>${userContext.localeMap['view_device.longitude']}</span> ${viewDevice.longitude}</li>
<li><span>${userContext.localeMap['view_device.latitude']}</span> ${viewDevice.latitude}</li>
<li><span>${userContext.localeMap['view_device.height']}</span> ${viewDevice.height}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




