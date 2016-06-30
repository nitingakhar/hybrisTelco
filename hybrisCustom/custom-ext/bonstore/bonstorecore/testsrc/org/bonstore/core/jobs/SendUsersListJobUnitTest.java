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
import org.mockito.InjectMocks;
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
	@InjectMocks
	private SendUsersListJob sendUsersListJob;
	private Locale loc;
	private ArrayList<OrganizationModel> orgList;
	private ArrayList<CustomerModel> custList;

	@Before
	public void setup()
	{
		loc = new Locale("en");
		orgList = new ArrayList<OrganizationModel>();
		custList = new ArrayList<CustomerModel>();
		when(cronJobModel.getSessionLanguage()).thenReturn(languageModel);
		when(commonI18NService.getLocaleForLanguage(languageModel)).thenReturn(loc);

	}

	@Test
	public void testResultAsSuccessAndJobStatusAsFinishedWhenOrgListIsEmpty()
	{
		when(defaultOrgUserService.getOrganizations()).thenReturn(orgList);
		final PerformResult result = sendUsersListJob.perform(cronJobModel);
		assertEquals(CronJobResult.SUCCESS, result.getResult());
		assertEquals(CronJobStatus.FINISHED, result.getStatus());
	}

	@Test
	public void testReturnResultAsSuccessAndJobStatusAsFinishedWhenOrgListIsNotEmptyAndCustomersListIsEmpty()
	{
		orgList.add(organizationModel);
		when(defaultOrgUserService.getOrganizations()).thenReturn(orgList);
		when(organizationModel.getCustomers()).thenReturn(custList);
		when(emailMessageModelConverter.convert(organizationModel)).thenReturn(emailMessageModel);
		final PerformResult result = sendUsersListJob.perform(cronJobModel);
		assertEquals(CronJobResult.SUCCESS, result.getResult());
		assertEquals(CronJobStatus.FINISHED, result.getStatus());

	}

	@Test
	public void testReturnResultAsSuccessAndJobStatusAsFinishedWhenOrgListIsNotEmptyAndCustomersListIsNotEmpty()
	{
		orgList.add(organizationModel);
		custList.add(customerModel);
		when(defaultOrgUserService.getOrganizations()).thenReturn(orgList);
		when(organizationModel.getCustomers()).thenReturn(custList);
		when(emailMessageModelConverter.convert(organizationModel)).thenReturn(emailMessageModel);
		final PerformResult result = sendUsersListJob.perform(cronJobModel);
		assertEquals(CronJobResult.SUCCESS, result.getResult());
		assertEquals(CronJobStatus.FINISHED, result.getStatus());

	}
}
