/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2016 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package org.bonstore.core.organization.impl;



import java.util.List;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.OrgUserService;
import org.bonstore.core.organization.dao.UsersDao;
import org.springframework.beans.factory.annotation.Required;


/**
 * Default implementation of {@link OrgUserService}.
 */
public class DefaultOrgUserService implements OrgUserService
{

	private UsersDao usersDao;

	@Override
	public List<OrganizationModel> getOrganizations()
	{
		return usersDao.getOrganizations();
	}

	@Required
	public void setUsersDao(final UsersDao usersDao)
	{
		this.usersDao = usersDao;
	}


}
