/**
 *
 */
package org.bonstore.core.organization.dao;

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

}
