/**
 *
 */
package org.bonstore.core.daos.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Arrays;
import java.util.List;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.dao.impl.UsersDaoImpl;
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
	private SearchResult<Object> searchResultObject;


	@Test
	public void testGetOrganizationList()
	{

		final String queryString = //
				"SELECT {o:" + OrganizationModel.PK + "} " + "FROM {" + OrganizationModel._TYPECODE + " AS o}";
		final List<OrganizationModel> models = Arrays.asList(organizationModel);
		when(flexibleSearchService.search(queryString)).thenReturn(searchResultObject);
		when(searchResultObject.getResult()).thenReturn(Arrays.asList(organizationModel));
		assertEquals(models, userDaoImpl.getOrganizations());
	}


}
