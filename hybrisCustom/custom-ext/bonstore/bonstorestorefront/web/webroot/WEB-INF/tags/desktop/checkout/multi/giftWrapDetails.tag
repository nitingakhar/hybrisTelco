<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="giftWrap" required="true" type="org.bonstore.data.GiftWrapData" %>
<%-- <%@ attribute name="isSelected" required="false" type="java.lang.Boolean" %> --%>

<li class="gift_wrap_item">
	<input type="checkbox" name="gift_wrap" id="${giftWrap.code}" value="${giftWrap.name}"/>
	<label for="${giftWrap.code}">${giftWrap.name}</label>
</li>
