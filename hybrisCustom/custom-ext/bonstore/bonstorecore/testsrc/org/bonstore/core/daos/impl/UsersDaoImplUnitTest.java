/**
 *
 */
package org.bonstore.core.daos.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Arrays;
import java.util.List;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.dao.impl.UsersDaoImpl;
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
public class UsersDaoImplUnitTest
{

	@InjectMocks
	private UsersDaoImpl userDaoImpl;
	@Mock
	private FlexibleSearchService flexibleSearchService;
	@Mock
	private OrganizationModel organizationModel;
	@Mock
	private CustomerModel customerModel;
	@Mock
	private SearchResult<Object> searchResultObject;
	@Mock
	private FlexibleSearchQuery flexibleSearchQuery;
	@Mock
	private ModelService modelService;
	@Mock
	List<OrganizationModel> organizationModelList;

	private static final String ORG_ID = "1";


	@Before
	public void setUp()
	{
		//organizationModelList = new ArrayList<>();
		organizationModelList.add(organizationModel);
	}

	@Test
	public void testGetOrganizationList()
	{
		final String queryString = "SELECT {o:" + OrganizationModel.PK + "} " + "FROM {" + OrganizationModel._TYPECODE + " AS o}";
		final List<OrganizationModel> models = Arrays.asList(organizationModel);
		when(flexibleSearchService.search(queryString)).thenReturn(searchResultObject);
		when(searchResultObject.getResult()).thenReturn(Arrays.asList(organizationModel));
		assertEquals(models, userDaoImpl.getOrganizations());
	}

	@Test
	public void testEditOrganization()
	{
		userDaoImpl.editOrganization(organizationModel);
		verify(modelService).saveAll(organizationModel);
	}

	@Test
	public void testRemoveOrganizationWhenCustomerHasOrganization()
	{
		when(customerModel.getOrganizations()).thenReturn(organizationModelList);
		when(organizationModelList.contains(organizationModel)).thenReturn(true);
		userDaoImpl.removeOrganization(customerModel, organizationModel);
		verify(modelService).remove(organizationModel);
		verify(modelService).refresh(customerModel);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveOrganizationSHouldThrowException()
	{
		when(customerModel.getOrganizations()).thenReturn(organizationModelList);
		when(organizationModelList.contains(organizationModel)).thenReturn(false);
		userDaoImpl.removeOrganization(customerModel, organizationModel);
	}

	@Test
	public void testAddOrganization()
	{
		userDaoImpl.addOrganization(organizationModel);
		verify(modelService).saveAll(organizationModel);
	}

}
