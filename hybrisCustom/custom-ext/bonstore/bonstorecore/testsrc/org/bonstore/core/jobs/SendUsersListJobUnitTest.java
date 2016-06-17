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
import de.hybris.platform.core.Registry;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.util.Config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

	private OrganizationModel organizationModel;
	private CustomerModel customerModel;
	private List<CustomerModel> customerModelList;
	private List<OrganizationModel> organizationModelList;
	private CronJobModel cronJobModel;
	private EmailMessageModel emailMessageModel;
	private List<EmailAddressModel> emailAddressModelList;
	private SendUsersListJob sendUsersListJob;
	private Locale loc;
	private EmailAddressModel emailAddressModel;


	@Before
	public void setup()
	{
		Registry.activateMasterTenant();

		loc = new Locale("en");
		customerModel = new CustomerModel();
		customerModelList = new ArrayList<CustomerModel>();
		organizationModel = new OrganizationModel();
		organizationModelList = new ArrayList<OrganizationModel>();
		emailAddressModelList = new ArrayList<EmailAddressModel>();

		customerModel.setCustomerID("CustID1");
		customerModel.setName("TestCustomer1");
		customerModel.setCreationtime(new Date());
		customerModel.setStatus(false);
		customerModel.setAttemptCount(0);
		customerModelList.add(customerModel);

		organizationModel.setId(1);
		organizationModel.setName("TestName", loc);
		organizationModel.setPhonenumber("180018001234");
		organizationModel.setEmail("testadmin@bonstore.com");
		organizationModel.setCustomers(customerModelList);
		organizationModelList.add(organizationModel);
		cronJobModel = new CronJobModel();

		emailAddressModel = new EmailAddressModel();
		emailAddressModel.setEmailAddress("testuser@gmail.com");
		emailAddressModel.setDisplayName("Bonstore Admin testOrg");

		emailMessageModel = new EmailMessageModel();
		emailMessageModel.setBody("List of users in your organization :-" + "\n" + "Donald Trump");
		emailMessageModel.setCreationtime(new Date());
		emailMessageModel.setSubject("Users List subject");
		emailMessageModel.setReplyToAddress(Config.getParameter("mail.replyto"));
		emailAddressModelList.add(emailAddressModel);
		emailMessageModel.setToAddresses(emailAddressModelList);
		emailMessageModel.setFromAddress(emailAddressModel);

		sendUsersListJob = new SendUsersListJob();
		sendUsersListJob.setDefaultOrgUserService(defaultOrgUserService);
		sendUsersListJob.setEmailService(emailService);
		sendUsersListJob.setModelService(modelService);


	}

	@Test
	public void testPerformEmailJob()

	{
		final List<OrganizationModel> organizationModels = organizationModelList;
		when(defaultOrgUserService.getOrganizations()).thenReturn(organizationModels);
		when(emailService.send(emailMessageModel)).thenReturn(true);
		when((EmailMessageModel) modelService.create(EmailMessageModel.class)).thenReturn(emailMessageModel);
		when((EmailAddressModel) modelService.create(EmailAddressModel.class)).thenReturn(emailAddressModel);
		final PerformResult result = sendUsersListJob.perform(cronJobModel);
		assertEquals("", CronJobResult.SUCCESS, result.getResult());
		assertEquals("", CronJobStatus.FINISHED, result.getStatus());

	}
}
