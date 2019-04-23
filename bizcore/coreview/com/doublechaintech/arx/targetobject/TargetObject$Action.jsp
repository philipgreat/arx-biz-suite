
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty targetObject}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A TargetObject" style="color: green">${userContext.localeMap['target_object']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['target_object.id']}</span> ${targetObject.id}</li>
<li><span>${userContext.localeMap['target_object.name']}</span> ${targetObject.name}</li>
<li><span>${userContext.localeMap['target_object.longitude']}</span> ${targetObject.longitude}</li>
<li><span>${userContext.localeMap['target_object.latitude']}</span> ${targetObject.latitude}</li>
<li><span>${userContext.localeMap['target_object.height']}</span> ${targetObject.height}</li>
<li><span>${userContext.localeMap['target_object.text_content']}</span> ${targetObject.textContent}</li>
<li><span>${userContext.localeMap['target_object.image_path']}</span> ${targetObject.imagePath}</li>

	
	</ul>
</div>



</c:if>


