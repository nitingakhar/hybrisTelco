/**
 *
 */
package org.bonstore.core.organization.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.dao.UsersDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

	private DefaultOrgUserService defaultOrgUserService;

	@Mock
	private UsersDao usersDao;

	private OrganizationModel organizationModel;
	private CustomerModel customerModel1;
	private CustomerModel customerModel2;

	private List<CustomerModel> customerModelList;

	@Before
	public void setUp()
	{
		defaultOrgUserService = new DefaultOrgUserService();
		defaultOrgUserService.setUsersDao(usersDao);

		organizationModel = new OrganizationModel();
		organizationModel.setId(1);
		organizationModel.setName("TestName", new Locale("en"));
		organizationModel.setPhonenumber("180018001234");
		organizationModel.setEmail("testadmin@bonstore.com");

		customerModel1 = new CustomerModel();
		customerModel2 = new CustomerModel();
		organizationModel.setCustomers(getCustomerModelList());
	}

	/**
	 * Utility method for getting customer models list
	 *
	 * @return List<CustomerModel>
	 */
	private List<CustomerModel> getCustomerModelList()
	{
		customerModel1.setCustomerID("CustID1");
		customerModel1.setName("TestCustomer1");
		customerModel1.setCreationtime(new Date());
		customerModel1.setStatus(false);
		customerModel1.setAttemptCount(0);

		customerModel2.setCustomerID("CustID2");
		customerModel2.setName("TestCustomer2");
		customerModel2.setCreationtime(new Date());
		customerModel2.setStatus(false);
		customerModel2.setAttemptCount(0);

		customerModelList = new ArrayList<CustomerModel>();
		customerModelList.add(customerModel1);
		customerModelList.add(customerModel2);
		return customerModelList;
	}

	@Test
	public void testGetOrganizations()
	{
		final List<OrganizationModel> organizationModels = Arrays.asList(organizationModel);
		when(usersDao.getOrganizations()).thenReturn(organizationModels);
		final List<OrganizationModel> orgsList = defaultOrgUserService.getOrganizations();
		assertEquals("Number of organizations should be 1", 1, orgsList.size());
	}

	@Test
	public void testCustomersList()
	{
		final List<OrganizationModel> organizationModels = Arrays.asList(organizationModel);
		when(usersDao.getOrganizations()).thenReturn(organizationModels);
		final List<OrganizationModel> orgsList = defaultOrgUserService.getOrganizations();
		assertEquals("Number of customers should be 2", 2, orgsList.get(0).getCustomers().size());
	}

}
