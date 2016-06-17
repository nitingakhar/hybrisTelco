/**
 *
 */
package org.bonstore.core.daos.impl;

import static org.junit.Assert.assertNotNull;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;

import java.util.List;

import javax.annotation.Resource;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.dao.UsersDao;
import org.junit.Test;


/**
 * @author Nitin_Gakhar
 *
 */
@IntegrationTest
public class UsersDaoImplIntegrationTest extends ServicelayerTransactionalTest
{
	@Resource
	private UsersDao usersDao;

	@Test
	public void testOrganizations()
	{
		final List<OrganizationModel> orgList = usersDao.getOrganizations();
		assertNotNull(orgList);
	}
}
