/**
 *
 */
package org.bonstore.core.jobs;

import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.model.email.EmailMessageModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;

import java.util.List;

import org.apache.log4j.Logger;
import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.impl.DefaultOrgUserService;
import org.springframework.beans.factory.annotation.Required;


/**
 * @author Nitin_Gakhar
 *
 */
public class SendUsersListJob extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(SendUsersListJob.class);
	private static final String USER_LIST = "Users list in ";

	private EmailService emailService;
	private DefaultOrgUserService defaultOrgUserService;
	private CommonI18NService commonI18NService;
	private Converter<OrganizationModel, EmailMessageModel> emailMessageModelConverter;

	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		final LanguageModel languageModel = cronJob.getSessionLanguage();
		PerformResult performResult = new PerformResult(CronJobResult.FAILURE, CronJobStatus.ABORTED);
		LOG.info("Sending list of users in organization to all admins");
		final List<OrganizationModel> orgList = defaultOrgUserService.getOrganizations();
		if (orgList.isEmpty())
		{
			LOG.info("There are no organizations in the system");
			performResult = new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}
		else
		{
			for (final OrganizationModel organizationModel : orgList)
			{
				final EmailMessageModel emailMessageModel = emailMessageModelConverter.convert(organizationModel);
				emailMessageModel
						.setSubject(USER_LIST + organizationModel.getName(commonI18NService.getLocaleForLanguage(languageModel)));
				emailService.send(emailMessageModel);

			}
			performResult = new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
		}
		return performResult;
	}

	public void setEmailService(final EmailService emailService)
	{
		this.emailService = emailService;
	}


	public void setDefaultOrgUserService(final DefaultOrgUserService defaultOrgUserService)
	{
		this.defaultOrgUserService = defaultOrgUserService;
	}

	public void setCommonI18NService(final CommonI18NService commonI18NService)
	{
		this.commonI18NService = commonI18NService;
	}


	protected Converter<OrganizationModel, EmailMessageModel> getEmailMessageModelConverter()
	{
		return emailMessageModelConverter;
	}

	@Required
	public void setEmailMessageModelConverter(final Converter<OrganizationModel, EmailMessageModel> emailMessageModelConverter)
	{
		this.emailMessageModelConverter = emailMessageModelConverter;
	}

}
