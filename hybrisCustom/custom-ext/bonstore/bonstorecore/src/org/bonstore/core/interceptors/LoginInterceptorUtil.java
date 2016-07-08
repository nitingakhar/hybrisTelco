/**
 *
 */
package org.bonstore.core.interceptors;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Nitin_Gakhar
 *
 */
public class LoginInterceptorUtil
{
	@Autowired
	private ModelService modelService;

	protected void changeCustomerDetails(final CustomerModel customer)
	{
		customer.setAttemptCount(0);
		customer.setStatus(false);
		modelService.save(customer);

	}
}
