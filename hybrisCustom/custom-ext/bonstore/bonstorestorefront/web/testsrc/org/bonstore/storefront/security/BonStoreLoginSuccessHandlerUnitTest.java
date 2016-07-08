/**
 *
 */
package org.bonstore.storefront.security;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import org.apache.commons.lang.StringUtils;
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
public class BonStoreLoginSuccessHandlerUnitTest
{
	private static final String uid = "bonstoretest@test.com";
	@InjectMocks
	private BonStoreLoginSuccessHandler bonStoreLoginSuccessHandler;
	@Mock
	private CustomerModel customerModel;
	@Mock
	private UserService userService;
	@Mock
	private ModelService modelService;


	@Before
	public void setUp()
	{
		when(userService.getUserForUID(StringUtils.lowerCase(uid))).thenReturn(customerModel);
	}

	@Test
	public void testRegisterSuccessLoginAttemptCountWithInRange()
	{
		when(customerModel.getAttemptCount()).thenReturn(1);
		doNothing().when(modelService).save(customerModel);
		bonStoreLoginSuccessHandler.registerSuccessLogin(uid);

	}

	@Test
	public void testRegisterSuccessLoginAttemptCountOutsideRange()
	{

		when(customerModel.getAttemptCount()).thenReturn(4);
		bonStoreLoginSuccessHandler.registerSuccessLogin(uid);
	}
}
