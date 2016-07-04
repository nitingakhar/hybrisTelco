/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package org.bonstore.storefront.security;

import de.hybris.platform.acceleratorstorefrontcommons.security.GUIDCookieStrategy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 * Default implementation of {@link AuthenticationSuccessHandler}
 */
public class GUIDAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
	private GUIDCookieStrategy guidCookieStrategy;
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	private BonStoreLoginSuccessHandler bonStoreLoginSuccessHandler;



	/**
	 * @return the bonStoreLoginSuccessHandler
	 */
	public BonStoreLoginSuccessHandler getBonStoreLoginSuccessHandler()
	{
		return bonStoreLoginSuccessHandler;
	}

	/**
	 * @param bonStoreLoginSuccessHandler
	 *           the bonStoreLoginSuccessHandler to set
	 */
	public void setBonStoreLoginSuccessHandler(final BonStoreLoginSuccessHandler bonStoreLoginSuccessHandler)
	{
		this.bonStoreLoginSuccessHandler = bonStoreLoginSuccessHandler;
	}

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication) throws IOException, ServletException
	{
		getBonStoreLoginSuccessHandler().registerSuccessLogin(request.getParameter("j_username"));
		getGuidCookieStrategy().setCookie(request, response);
		getAuthenticationSuccessHandler().onAuthenticationSuccess(request, response, authentication);
	}

	protected GUIDCookieStrategy getGuidCookieStrategy()
	{
		return guidCookieStrategy;
	}

	/**
	 * @param guidCookieStrategy
	 *           the guidCookieStrategy to set
	 */
	@Required
	public void setGuidCookieStrategy(final GUIDCookieStrategy guidCookieStrategy)
	{
		this.guidCookieStrategy = guidCookieStrategy;
	}

	protected AuthenticationSuccessHandler getAuthenticationSuccessHandler()
	{
		return authenticationSuccessHandler;
	}

	/**
	 * @param authenticationSuccessHandler
	 *           the authenticationSuccessHandler to set
	 */
	@Required
	public void setAuthenticationSuccessHandler(final AuthenticationSuccessHandler authenticationSuccessHandler)
	{
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}
}
