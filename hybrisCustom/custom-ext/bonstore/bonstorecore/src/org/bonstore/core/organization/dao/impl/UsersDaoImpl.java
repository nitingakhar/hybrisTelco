/**
 *
 */
package org.bonstore.core.organization.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Nitin_Gakhar
 *
 */
//@Component(value = "usersDao")
public class UsersDaoImpl implements UsersDao
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;
	private SearchResult<OrganizationModel> searchResult;

	@Override
	public List<OrganizationModel> getOrganizations()
	{
		// Build a query for the flexible search.
		final String queryString = //
				"SELECT {o:" + OrganizationModel.PK + "} " + "FROM {" + OrganizationModel._TYPECODE + " AS o}";
		searchResult = flexibleSearchService.search(queryString);
		return searchResult.getResult();
	}

}
