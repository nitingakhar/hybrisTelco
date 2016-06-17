/**
 *
 */
package org.bonstore.core.jobs;

import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.model.email.EmailAddressModel;
import de.hybris.platform.acceleratorservices.model.email.EmailMessageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.util.Config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.impl.DefaultOrgUserService;


/**
 * @author Nitin_Gakhar
 *
 */
public class SendUsersListJob extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(SendUsersListJob.class);
	private static final String NO_USERS = "No users in the organization";
	private static final String NUM_USERS = "List of users in your organization :-";
	private static final String DISPLAY_NAME = "BonStore Admin ";
	private static final String USER_LIST = "Users list in ";

	private EmailService emailService;
	private DefaultOrgUserService defaultOrgUserService;


	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		LOG.info("Sending list of users in organization to all admins");

		final List<OrganizationModel> orgList = defaultOrgUserService.getOrganizations();

		if (orgList.isEmpty())
		{
			LOG.info("There are no organizations in the system");
			return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}

		for (final OrganizationModel organizationModel : orgList)
		{
			final List<CustomerModel> customersList = organizationModel.getCustomers();
			emailService.send(setMessageModel(customersList, organizationModel));
		}

		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);

	}

	public void setEmailService(final EmailService emailService)
	{
		this.emailService = emailService;
	}


	public void setDefaultOrgUserService(final DefaultOrgUserService defaultOrgUserService)
	{
		this.defaultOrgUserService = defaultOrgUserService;
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
		for (final CustomerModel customerModel : customersList)
		{
			sBuilder.append("<br>");
			sBuilder.append(customerModel.getName() + "<br>");
		}
		return NUM_USERS + "<br>" + sBuilder.toString();
	}

	/**
	 * Utility method which sets Email message model with all details like body, creation time, subject, display name,
	 * address details etc
	 *
	 * @param customersList
	 * @param organizationModel
	 * @return EmailMessageModel
	 */
	private EmailMessageModel setMessageModel(final List<CustomerModel> customersList, final OrganizationModel organizationModel)
	{

		final EmailMessageModel emailMessageModel = (EmailMessageModel) modelService.create(EmailMessageModel.class);
		emailMessageModel.setBody(getMailBody(customersList));
		emailMessageModel.setCreationtime(new Date());
		emailMessageModel.setSubject(USER_LIST + organizationModel.getName(Locale.getDefault()));
		emailMessageModel.setReplyToAddress(Config.getParameter("mail.replyto"));

		final EmailAddressModel emailAddressModel = (EmailAddressModel) modelService.create(EmailAddressModel.class);
		emailAddressModel.setEmailAddress(organizationModel.getEmail());
		emailAddressModel.setDisplayName(DISPLAY_NAME + organizationModel.getId());
		final List<EmailAddressModel> emailAddressModelList = new ArrayList<EmailAddressModel>();
		emailAddressModelList.add(emailAddressModel);

		emailMessageModel.setToAddresses(emailAddressModelList);
		emailMessageModel.setFromAddress(emailAddressModel);

		return emailMessageModel;
	}
}
