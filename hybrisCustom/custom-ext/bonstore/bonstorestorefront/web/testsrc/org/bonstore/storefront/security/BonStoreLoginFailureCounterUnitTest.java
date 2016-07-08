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
public class BonStoreLoginFailureCounterUnitTest
{

	private static final String uid = "bonstoretest@test.com";
	private static final int ATTEMPT_COUNT_LESSTHAN_3 = 0;
	private static final int ATTEMPT_COUNT = 2;
	private static final int ATTEMPT_COUNT_GREATERTHAN_3 = 4;
	@InjectMocks
	private BonStoreLoginFailureCounter bonStoreLoginFailureCounter;
	@Mock
	private CustomerModel customerModel;
	@Mock
	private UserService userService;
	@Mock
	private ModelService modelService;

	@Before
	public void setup()
	{
		when(userService.getUserForUID(StringUtils.lowerCase(uid))).thenReturn(customerModel);
	}

	@Test
	public void testregisterFailedLoginWhenAttemptCountIsLessThanThree()
	{
		when(customerModel.getAttemptCount()).thenReturn(ATTEMPT_COUNT_LESSTHAN_3);
		doNothing().when(modelService).save(customerModel);
		bonStoreLoginFailureCounter.registerFailedLogin(uid);
	}

	@Test
	public void testregisterFailedLoginWhenAttemptCountEqualsThree()
	{
		when(customerModel.getAttemptCount()).thenReturn(ATTEMPT_COUNT);
		doNothing().when(modelService).save(customerModel);
		bonStoreLoginFailureCounter.registerFailedLogin(uid);
	}

	@Test
	public void testregisterFailedLoginWhenAttemptCountIsGreaterThanThree()
	{
		when(customerModel.getAttemptCount()).thenReturn(ATTEMPT_COUNT_GREATERTHAN_3);
		doNothing().when(modelService).save(customerModel);
		bonStoreLoginFailureCounter.registerFailedLogin(uid);
	}

}
