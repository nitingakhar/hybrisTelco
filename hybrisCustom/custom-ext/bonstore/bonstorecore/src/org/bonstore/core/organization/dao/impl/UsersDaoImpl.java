/**
 *
 */
package org.bonstore.core.organization.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import java.util.List;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author Nitin_Gakhar
 *
 */
@Component(value = "usersDao")
public class UsersDaoImpl implements UsersDao
{

	/*
	 * (non-Javadoc)
	 *
	 * @see org.bonstore.core.suggestion.dao.UsersDao#getOrganizations()
	 */

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Override
	public List<OrganizationModel> getOrganizations()
	{
		// Build a query for the flexible search.
		final String queryString = //
				"SELECT {o:" + OrganizationModel.PK + "} " + "FROM {" + OrganizationModel._TYPECODE + " AS o}";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		return flexibleSearchService.<OrganizationModel> search(query).getResult();

	}

}
