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
package org.bonstore.core.organization;

import java.util.List;

import org.bonstore.core.model.OrganizationModel;


/**
 * Service layer interface to get all organizations
 */
public interface OrgUserService
{

	List<OrganizationModel> getOrganizations();
}
