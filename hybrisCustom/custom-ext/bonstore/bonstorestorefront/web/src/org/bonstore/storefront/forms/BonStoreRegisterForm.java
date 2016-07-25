/**
 *
 */
package org.bonstore.storefront.forms;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author Nitin_Gakhar
 *
 */
public class BonStoreRegisterForm extends de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm
{


	@NotEmpty(message = "{register.organization.empty}")
	private List<String> organizationIds;

	/**
	 * @return the organizationIds
	 */

	public List<String> getOrganizationIds()
	{
		return organizationIds;
	}

	/**
	 * @param organizationIds
	 *           the organizationIds to set
	 */
	public void setOrganizationIds(final List<String> organizationIds)
	{
		this.organizationIds = organizationIds;
	}
}
