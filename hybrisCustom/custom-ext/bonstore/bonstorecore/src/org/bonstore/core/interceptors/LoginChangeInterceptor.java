/**
 *
 */
package org.bonstore.core.interceptors;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;


/**
 * @author Nitin_Gakhar
 *
 */
public class LoginChangeInterceptor implements PrepareInterceptor
{
	private static final int MAX_ATTEMPT_COUNT = 3;
	private LoginInterceptorUtil loginInterceptorUtil;

	@Override
	public void onPrepare(final Object model, final InterceptorContext ctx) throws InterceptorException
	{

		if (model instanceof CustomerModel)
		{
			final CustomerModel customerModel = (CustomerModel) model;
			if (checkLoginDisabledStatus(customerModel))
			{
				loginInterceptorUtil.changeCustomerDetails(customerModel);
			}
		}
	}

	private boolean checkLoginDisabledStatus(final CustomerModel customerModel)
	{
		return !customerModel.isLoginDisabled() && customerModel.getAttemptCount() >= MAX_ATTEMPT_COUNT;
	}


	/**
	 * @return the loginInterceptorUtil
	 */
	public LoginInterceptorUtil getLoginInterceptorUtil()
	{
		return loginInterceptorUtil;
	}

	/**
	 * @param loginInterceptorUtil
	 *           the loginInterceptorUtil to set
	 */
	public void setLoginInterceptorUtil(final LoginInterceptorUtil loginInterceptorUtil)
	{
		this.loginInterceptorUtil = loginInterceptorUtil;
	}

}
