/**
 *
 */
package org.bonstore.core.organization.dao.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
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
public class UsersDaoImpl implements UsersDao
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Autowired
	private ModelService modelService;


	@Override
	public List<OrganizationModel> getOrganizations()
	{
		// Build a query for the flexible search.
		final String queryString = //
				"SELECT {o:" + OrganizationModel.PK + "} " + "FROM {" + OrganizationModel._TYPECODE + " AS o}";
		final SearchResult<OrganizationModel> searchResult = flexibleSearchService.search(queryString);
		return searchResult.getResult();
	}

	@Override
	public List<OrganizationModel> getOrganizationByID(final String id)
	{
		final String queryString = "SELECT {o:" + OrganizationModel.PK + "}" + "FROM {" + OrganizationModel._TYPECODE + " AS o}"
				+ "WHERE {o:" + OrganizationModel.ID + "}=?id";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("id", id);
		final SearchResult<OrganizationModel> searchResult = flexibleSearchService.search(query);
		return searchResult.getResult();
	}


	@Override
	public void editOrganization(final OrganizationModel organizationModel)
	{
		modelService.saveAll(organizationModel);

	}

	@Override
	public void removeOrganization(final CustomerModel customerModel, final OrganizationModel organizationModel)
	{
		validateParameterNotNull(customerModel, "Customer model cannot be null");
		validateParameterNotNull(organizationModel, "Organization model cannot be null");

		if (customerModel.getOrganizations().contains(organizationModel))
		{
			modelService.remove(organizationModel);
			modelService.refresh(customerModel);
		}
		else
		{
			throw new IllegalArgumentException("Organization " + organizationModel + " does not belong to the customer "
					+ organizationModel + " and will not be removed.");
		}
	}

	@Override
	public void addOrganization(final OrganizationModel organizationModel)
	{
		modelService.saveAll(organizationModel);
	}

}
