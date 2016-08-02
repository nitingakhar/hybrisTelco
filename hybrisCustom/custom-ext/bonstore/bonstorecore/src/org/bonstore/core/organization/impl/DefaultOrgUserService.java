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



import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.OrgUserService;
import org.bonstore.core.organization.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;


/**
 * Default implementation of {@link OrgUserService}.
 */
public class DefaultOrgUserService implements OrgUserService
{

	private UsersDao usersDao;

	@Autowired
	private ModelService modelService;

	@Override
	public List<OrganizationModel> getOrganizations()
	{
		return usersDao.getOrganizations();
	}

	@Override
	public List<OrganizationModel> getOrganizationByID(final String organizationId)
	{
		return usersDao.getOrganizationByID(organizationId);
	}

	@Override
	public void editOrganization(final OrganizationModel organizationModel)
	{
		modelService.save(organizationModel);
	}

	@Override
	public boolean removeOrganization(final CustomerModel customerModel, final String organizationId)
	{
		boolean customerContainsOrganization = customerModel.getOrganizations().stream()
				.anyMatch(organization -> organizationId.equals(String.valueOf(organization.getId())));

		final List<OrganizationModel> organizationsToBeRemoved = customerModel.getOrganizations().stream()
				.filter(organization -> organizationId.equals(String.valueOf(organization.getId()))).collect(Collectors.toList());

		if (CollectionUtils.isNotEmpty(organizationsToBeRemoved) && organizationsToBeRemoved.size() == 1)
		{
			modelService.remove(organizationsToBeRemoved.get(0));
		}
		else
		{

			customerContainsOrganization = false;

		}
		return customerContainsOrganization;
	}

	@Override
	public void addOrganization(final OrganizationModel organizationModel)
	{
		modelService.save(organizationModel);
	}

	@Required
	public void setUsersDao(final UsersDao usersDao)
	{
		this.usersDao = usersDao;
	}


}
