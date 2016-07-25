/**
 *
 */
package org.bonstore.core.facades;

import java.util.List;

import org.bonstore.data.OrganizationData;


/**
 * @author Nitin_Gakhar
 *
 */
public interface BonStoreCustomerFacade
{
	public List<OrganizationData> getOrganizations();

	public List<OrganizationData> getOrganizationsForCurrentUser();

	public void editOrganization(OrganizationData organizationData);

	public void removeOrganization(OrganizationData organizationData);

	public void addOrganization(OrganizationData organizationData);

}
