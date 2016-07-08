/**
 *
 */
package org.bonstore.storefront.security;

import de.hybris.platform.acceleratorstorefrontcommons.security.AbstractAcceleratorAuthenticationProvider;
import de.hybris.platform.core.model.user.CustomerModel;

import org.apache.commons.lang.StringUtils;


/**
 * @author Nitin_Gakhar
 *
 */
public class BonStoreLoginSuccessHandler extends AbstractAcceleratorAuthenticationProvider
{
	public void registerSuccessLogin(final String uid)
	{
		if (StringUtils.isNotEmpty(uid))
		{
			final CustomerModel customerModel = (CustomerModel) getUserService().getUserForUID(StringUtils.lowerCase(uid));
			final int attemptCount = customerModel.getAttemptCount();
			if (attemptCount > 0 && attemptCount < 3)
			{
				customerModel.setAttemptCount(0);
				getModelService().save(customerModel);
			}

		}

	}

}
