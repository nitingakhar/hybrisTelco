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
	List<OrganizationData> getOrganizations();

	List<OrganizationData> getOrganizationsForCurrentUser();

	void editOrganization(OrganizationData organizationData);

	boolean removeOrganization(String organizationId);

	void addOrganization(OrganizationData organizationData);

}
