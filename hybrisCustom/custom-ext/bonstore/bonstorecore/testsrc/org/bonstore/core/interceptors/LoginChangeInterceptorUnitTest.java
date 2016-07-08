/**
 *
 */
package org.bonstore.core.interceptors;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * @author Nitin_Gakhar
 *
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class LoginChangeInterceptorUnitTest
{
	private static final int MAX_ATTEMPT_COUNT = 3;

	@InjectMocks
	private LoginChangeInterceptor loginChangeInterceptor;
	@Mock
	private CustomerModel customerModel;
	@Mock
	InterceptorContext ctx;
	@Mock
	private LoginInterceptorUtil loginInterceptorUtil;

	@Before
	public void setUp()
	{
		when(customerModel.getAttemptCount()).thenReturn(MAX_ATTEMPT_COUNT);
	}

	@Test
	public void testOnPrepareWhenCustomerLoginStatusIsDisabled() throws InterceptorException
	{
		when(customerModel.isLoginDisabled()).thenReturn(false);
		doNothing().when(loginInterceptorUtil).changeCustomerDetails(customerModel);
		loginChangeInterceptor.onPrepare(customerModel, ctx);
	}

	@Test
	public void testOnPrepareWhenCustomerLoginStatusIsNotDisabled() throws InterceptorException
	{
		when(customerModel.isLoginDisabled()).thenReturn(true);
		loginChangeInterceptor.onPrepare(customerModel, ctx);
	}

}