/**
 *
 */
package org.bonstore.core.organization.populator;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.acceleratorservices.model.email.EmailAddressModel;
import de.hybris.platform.acceleratorservices.model.email.EmailMessageModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bonstore.core.model.OrganizationModel;


/**
 * @author Nitin_Gakhar
 *
 */
public class EmailMessageModelPopulator implements Populator<OrganizationModel, EmailMessageModel>
{
	private static final String NO_USERS = "No users in the organization";
	private static final String NUM_USERS = "List of users in your organization :-";
	private static final String DISPLAY_NAME = "BonStore Admin ";
	private String replyToAddress;
	private ModelService modelService;

	@Override
	public void populate(final OrganizationModel source, final EmailMessageModel target) throws ConversionException
	{
		validateParameterNotNull(source, "Parameter [OrganizationModel] target cannot be null");
		validateParameterNotNull(target, "Parameter [EmailMessageModel] target cannot be null");

		target.setCreationtime(new Date());
		target.setBody(getMailBody(source.getCustomers()));
		target.setReplyToAddress(replyToAddress);
		final EmailAddressModel emailAddressModel = (EmailAddressModel) modelService.create(EmailAddressModel.class);
		emailAddressModel.setEmailAddress(source.getEmail());
		emailAddressModel.setDisplayName(DISPLAY_NAME + Math.random());
		final List<EmailAddressModel> emailAddressModelList = new ArrayList<EmailAddressModel>();
		emailAddressModelList.add(emailAddressModel);

		target.setToAddresses(emailAddressModelList);
		target.setFromAddress(emailAddressModel);
	}

	/**
	 * Utility method which returns the mail body with the list of customer's name
	 *
	 * @param customersList
	 * @return mail body in the form of list of customers.
	 */
	private String getMailBody(final List<CustomerModel> customersList)
	{
		if (customersList.isEmpty())
		{
			return NO_USERS;
		}
		final StringBuilder sBuilder = new StringBuilder();

		final List<CustomerModel> customerModelList = customersList;
		customerModelList.stream().forEach((customerModel) -> {
			sBuilder.append("<br>");
			sBuilder.append(customerModel.getName() + "<br>");
		});

		/*
		 * for (final CustomerModel customerModel : customersList) { sBuilder.append("<br>");
		 * sBuilder.append(customerModel.getName() + "<br>"); }
		 */
		return NUM_USERS + "<br>" + sBuilder.toString();
	}

	public void setReplyToAddress(final String replyToAddress)
	{
		this.replyToAddress = replyToAddress;
	}

	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}


}
