/**
 *
 */
package org.bonstore.core.organization.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.ArrayList;
import java.util.List;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.dao.UsersDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * @author Nitin_Gakhar
 *
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultOrgUserServiceUnitTest
{

	@InjectMocks
	private DefaultOrgUserService defaultOrgUserService;
	@Mock
	private UsersDao usersDao;
	@Mock
	private OrganizationModel organizationModel;
	@Mock
	private CustomerModel firstCustomerModel;
	@Mock
	private CustomerModel secondCustomerModel;

	List<OrganizationModel> organizationModels;
	List<CustomerModel> customerModels;


	@Before
	public void setUp()
	{
		organizationModels = new ArrayList<OrganizationModel>();
		customerModels = new ArrayList<CustomerModel>();
	}

	@Test
	public void testGetOrganizationsListIsEmpty()
	{
		when(usersDao.getOrganizations()).thenReturn(organizationModels);
		final List<OrganizationModel> orgsList = defaultOrgUserService.getOrganizations();
		assertEquals("Number of organizations should be 0", 0, orgsList.size());
	}

	@Test
	public void testGetOrganizationsListWhenCustomerListIsEmpty()
	{
		organizationModels.add(organizationModel);
		when(usersDao.getOrganizations()).thenReturn(organizationModels);
		final List<OrganizationModel> organizationModelsList = defaultOrgUserService.getOrganizations();
		assertEquals("Number of organizations should be 0", 0, organizationModelsList.get(0).getCustomers().size());
	}

	@Test
	public void testCustomersListWhenCustomerListIsNotEmpty()
	{
		customerModels.add(firstCustomerModel);
		customerModels.add(secondCustomerModel);
		organizationModel.setCustomers(customerModels);
		organizationModels.add(organizationModel);
		when(usersDao.getOrganizations()).thenReturn(organizationModels);
		when(usersDao.getOrganizations().get(0).getCustomers()).thenReturn(customerModels);
		final List<OrganizationModel> orgsList = defaultOrgUserService.getOrganizations();
		assertEquals("Number of customers should be 2", 2, orgsList.get(0).getCustomers().size());
	}

}
