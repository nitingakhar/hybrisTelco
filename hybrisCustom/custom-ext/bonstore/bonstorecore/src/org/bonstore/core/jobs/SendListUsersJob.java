/**
 *
 */
package org.bonstore.core.jobs;

import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import org.apache.log4j.Logger;


/**
 * @author Nitin_Gakhar
 *
 */
public class SendListUsersJob extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(SendListUsersJob.class);

	private EmailService emailService;
	//private MailService mailService;

	@Override
	public PerformResult perform(final CronJobModel cronJob)
	{
		LOG.info("Sending ranking mails");
		/*
		 * final List<RankingData> rankings = playerService.getRankings();
		 *
		 * if (rankings.isEmpty()) { LOG.info("No competitions have changed, skipping send of ranking mails"); return new
		 * PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED); }
		 *
		 * for (final PlayerModel player : playerService.getAllPlayers()) { final List<RankingData> playerRankings =
		 * playerService.filterRankingsForPlayer(rankings, player); if (!playerRankings.isEmpty() &&
		 * player.isSendNewsletter()) { mailService.sendRankingMail(player, playerRankings); } }
		 */



		emailService.send(message);
		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

	public void setEmailService(final EmailService emailService)
	{
		this.emailService = emailService;
	}

}
