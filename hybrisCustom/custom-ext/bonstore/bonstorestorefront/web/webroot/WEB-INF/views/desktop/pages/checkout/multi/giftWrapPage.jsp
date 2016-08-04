<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="checkout" tagdir="/WEB-INF/tags/desktop/checkout" %>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/desktop/cart" %>
<%@ taglib prefix="multi-checkout" tagdir="/WEB-INF/tags/desktop/checkout/multi" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>

<c:url value="${nextStepUrl}" var="choosePaymentMethodUrl"/>
<c:url value="${previousStepUrl}" var="selectDeliveryMethodUrl"/>
<template:page pageTitle="${pageTitle}" hideHeaderLinks="true">

	<div id="globalMessages">
		<common:globalMessages/>
	</div>

	<multi-checkout:checkoutProgressBar steps="${checkoutSteps}" progressBarId="${progressBarId}"/>
	<div class="span-14 append-1">
		<div id="checkoutContentPanel" class="clearfix">
			<div class="headline"><spring:theme code="checkout.multi.giftWrap.stepHeader"/></div>
			<div class="description"><p><spring:theme code="checkout.multi.selectGiftWrapMessage"/></p></div>
			<form:form id="selectGiftWrapForm" action="${request.contextPath}/checkout/multi/gift-wrap/select" method="get">
				<multi-checkout:giftWrapSelector giftWraps="${giftWraps}" />

				<c:if test="${not empty cartData.deliveryMode.code}">
					<div class="form-actions">
						<a class="button" href="${selectDeliveryMethodUrl}"><spring:theme code="checkout.multi.cancel" text="Cancel"/></a>
						<button id="chooseGiftWrap_continue_button" class="positive right show_processing_message">
							<spring:theme code="checkout.multi.giftWrap.continue" text="Continue"/>
						</button>
					</div>
				</c:if>
			</form:form>
		</div>
	</div>
	<multi-checkout:checkoutOrderDetails cartData="${cartData}" showShipDeliveryEntries="true" showPickupDeliveryEntries="false" showTax="false"/>
 	<cms:pageSlot position="SideContent" var="feature" element="div" class="span-24 side-content-slot cms_disp-img_slot">
		<cms:component component="${feature}"/>
	</cms:pageSlot>

</template:page>