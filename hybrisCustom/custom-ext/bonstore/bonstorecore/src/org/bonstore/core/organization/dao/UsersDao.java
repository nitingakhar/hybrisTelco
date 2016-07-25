/**
 *
 */
package org.bonstore.core.organization.dao;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;

import org.bonstore.core.model.OrganizationModel;


/**
 * DAO Interface to show the list of users in the organization
 */
public interface UsersDao
{

	/**
	 * Return a list of Organizations
	 *
	 * @return all organizations in the system.
	 */
	List<OrganizationModel> getOrganizations();

	List<OrganizationModel> getOrganizationByID(final String organizationId);

	void editOrganization(final OrganizationModel organizationModel);

	void removeOrganization(final CustomerModel customerModel, final OrganizationModel organizationModel);

	void addOrganization(OrganizationModel organizationModel);

}
