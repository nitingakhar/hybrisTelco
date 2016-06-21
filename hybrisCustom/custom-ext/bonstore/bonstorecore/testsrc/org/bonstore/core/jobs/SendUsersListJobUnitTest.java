/**
 *
 */
package org.bonstore.core.jobs;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.model.email.EmailAddressModel;
import de.hybris.platform.acceleratorservices.model.email.EmailMessageModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.Locale;

import org.bonstore.core.model.OrganizationModel;
import org.bonstore.core.organization.impl.DefaultOrgUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


/**
 * @author Nitin_Gakhar
 *
 */
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class SendUsersListJobUnitTest
{

	@Mock
	private DefaultOrgUserService defaultOrgUserService;
	@Mock
	private EmailService emailService;
	@Mock
	private ModelService modelService;
	@Mock
	private CommonI18NService commonI18NService;
	@Mock
	private OrganizationModel organizationModel;
	@Mock
	private CustomerModel customerModel;
	@Mock
	private LanguageModel languageModel;
	@Mock
	private CronJobModel cronJobModel;
	@Mock
	private EmailMessageModel emailMessageModel;
	@Mock
	private EmailAddressModel emailAddressModel;
	@Mock
	private Converter<OrganizationModel, EmailMessageModel> emailMessageModelConverter;

	private SendUsersListJob sendUsersListJob;
	private Locale loc;



	@Before
	public void setup()
	{
		loc = new Locale("en");
		sendUsersListJob = new SendUsersListJob();

		when(cronJobModel.getSessionLanguage()).thenReturn(languageModel);
		when(commonI18NService.getLocaleForLanguage(languageModel)).thenReturn(loc);
		when(modelService.create(EmailMessageModel.class)).thenReturn(emailMessageModel);
		when(modelService.create(EmailAddressModel.class)).thenReturn(emailAddressModel);
		when(emailMessageModelConverter.convert(organizationModel)).thenReturn(emailMessageModel);

		sendUsersListJob.setDefaultOrgUserService(defaultOrgUserService);
		sendUsersListJob.setEmailService(emailService);
		sendUsersListJob.setModelService(modelService);
		sendUsersListJob.setCommonI18NService(commonI18NService);
		sendUsersListJob.setEmailMessageModelConverter(emailMessageModelConverter);
	}

	@Test
	public void testResultAsSuccessAndJobStatusAsFinishedWhenOrgListIsEmpty()
	{
		final ArrayList<OrganizationModel> orgList = new ArrayList<OrganizationModel>();
		when(defaultOrgUserService.getOrganizations()).thenReturn(orgList);
		final PerformResult result = sendUsersListJob.perform(cronJobModel);
		assertEquals(CronJobResult.SUCCESS, result.getResult());
		assertEquals(CronJobStatus.FINISHED, result.getStatus());
	}

	@Test
	public void testReturnResultAsSuccessAndJobStatusAsFinishedWhenOrgListIsNotEmptyAndCustomersListIsEmpty()
	{
		final ArrayList<OrganizationModel> orgList = new ArrayList<OrganizationModel>();
		orgList.add(organizationModel);
		final ArrayList<CustomerModel> custList = new ArrayList<CustomerModel>();
		when(defaultOrgUserService.getOrganizations()).thenReturn(orgList);
		when(organizationModel.getCustomers()).thenReturn(custList);
		final PerformResult result = sendUsersListJob.perform(cronJobModel);
		assertEquals(CronJobResult.SUCCESS, result.getResult());
		assertEquals(CronJobStatus.FINISHED, result.getStatus());

	}

	@Test
	public void testReturnResultAsSuccessAndJobStatusAsFinishedWhenOrgListIsNotEmptyAndCustomersListIsNotEmpty()
	{
		final ArrayList<OrganizationModel> orgList = new ArrayList<OrganizationModel>();
		orgList.add(organizationModel);
		final ArrayList<CustomerModel> custList = new ArrayList<CustomerModel>();
		custList.add(customerModel);
		when(defaultOrgUserService.getOrganizations()).thenReturn(orgList);
		when(organizationModel.getCustomers()).thenReturn(custList);
		final PerformResult result = sendUsersListJob.perform(cronJobModel);
		assertEquals(CronJobResult.SUCCESS, result.getResult());
		assertEquals(CronJobStatus.FINISHED, result.getStatus());

	}
}
