package org.bonstore.storefront.facade;


import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

import de.hybris.platform.commerceservices.customer.CustomerAccountService;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.commerceservices.strategies.CustomerNameStrategy;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.TitleModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.impl.DefaultOrgUserService;
import org.bonstore.data.BonStoreRegisterData;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component("bonStoreFrontCustomerFacade")
public class BonStoreFrontCustomerFacade
{

	private UserService userService;
	private CustomerAccountService customerAccountService;
	private CommonI18NService commonI18NService;
	private ModelService modelService;
	private CustomerNameStrategy customerNameStrategy;

	private DefaultOrgUserService defaultOrgUserService;



	/**
	 * @return the defaultOrgUserService
	 */
	public DefaultOrgUserService getDefaultOrgUserService()
	{
		return defaultOrgUserService;
	}

	/**
	 * @param defaultOrgUserService
	 *           the defaultOrgUserService to set
	 */
	public void setDefaultOrgUserService(final DefaultOrgUserService defaultOrgUserService)
	{
		this.defaultOrgUserService = defaultOrgUserService;
	}

	public void register(final BonStoreRegisterData bonstoreRegisterData) throws DuplicateUidException
	{

		validateParameterNotNullStandardMessage("registerData", bonstoreRegisterData);
		Assert.hasText(bonstoreRegisterData.getFirstName(), "The field [FirstName] cannot be empty");
		Assert.hasText(bonstoreRegisterData.getLastName(), "The field [LastName] cannot be empty");
		Assert.hasText(bonstoreRegisterData.getLogin(), "The field [Login] cannot be empty");

		final CustomerModel newCustomer = getModelService().create(CustomerModel.class);
		newCustomer
				.setName(getCustomerNameStrategy().getName(bonstoreRegisterData.getFirstName(), bonstoreRegisterData.getLastName()));

		if (StringUtils.isNotBlank(bonstoreRegisterData.getFirstName())
				&& StringUtils.isNotBlank(bonstoreRegisterData.getLastName()))
		{
			newCustomer.setName(
					getCustomerNameStrategy().getName(bonstoreRegisterData.getFirstName(), bonstoreRegisterData.getLastName()));
		}
		final TitleModel title = getUserService().getTitleForCode(bonstoreRegisterData.getTitleCode());
		newCustomer.setTitle(title);
		newCustomer.setOrganizations(getListOfOrganizationModels(bonstoreRegisterData.getOrganizationIds()));

		newCustomer.setUid(bonstoreRegisterData.getLogin().toLowerCase());
		newCustomer.setOriginalUid(bonstoreRegisterData.getLogin());
		newCustomer.setSessionLanguage(getCommonI18NService().getCurrentLanguage());
		newCustomer.setSessionCurrency(getCommonI18NService().getCurrentCurrency());
		getCustomerAccountService().register(newCustomer, bonstoreRegisterData.getPassword());

	}

	/*
	 * private List<OrganizationModel> getListOfOrganizationModels(final List<String> list) { final
	 * List<OrganizationModel> listOfOrganizationModels = new ArrayList<>(list.size()); for (final String organizationId
	 * : list) { final OrganizationModel organizationModel = getModelService().create(OrganizationModel.class);
	 * organizationModel.setId(Integer.parseInt(organizationId)); listOfOrganizationModels.add(organizationModel); }
	 * return listOfOrganizationModels; }
	 */

	private List<OrganizationModel> getListOfOrganizationModels(final List<String> organizations)
	{
		final List<OrganizationModel> listOfOrganizationModels = new ArrayList<>(organizations.size());
		for (final String organizationId : organizations)
		{
			final OrganizationModel organizationModel = defaultOrgUserService.getOrganizationByID(organizationId).get(0);
			listOfOrganizationModels.add(organizationModel);
		}
		return listOfOrganizationModels;
	}

	public UserService getUserService()
	{
		return userService;
	}

	public void setUserService(final UserService userService)
	{
		this.userService = userService;
	}

	public CustomerAccountService getCustomerAccountService()
	{
		return customerAccountService;
	}

	public void setCustomerAccountService(final CustomerAccountService customerAccountService)
	{
		this.customerAccountService = customerAccountService;
	}

	public CommonI18NService getCommonI18NService()
	{
		return commonI18NService;
	}

	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}

	public ModelService getModelService()
	{
		return modelService;
	}

	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}

	public CustomerNameStrategy getCustomerNameStrategy()
	{
		return customerNameStrategy;
	}

	public void setCustomerNameStrategy(final CustomerNameStrategy customerNameStrategy)
	{
		this.customerNameStrategy = customerNameStrategy;
	}
}
