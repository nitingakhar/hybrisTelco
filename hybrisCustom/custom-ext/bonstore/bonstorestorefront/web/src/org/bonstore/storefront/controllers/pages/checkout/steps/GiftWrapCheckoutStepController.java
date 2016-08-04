/**
 *
 */
package org.bonstore.storefront.controllers.pages.checkout.steps;

import de.hybris.platform.acceleratorstorefrontcommons.annotations.PreValidateCheckoutStep;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.acceleratorstorefrontcommons.checkout.steps.CheckoutStep;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.checkout.steps.AbstractCheckoutStepController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.commercefacades.order.data.CartData;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.bonstore.storefront.controllers.ControllerConstants;
import org.bonstore.storefront.facade.BonStoreFrontCheckoutFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @author Nitin_Gakhar
 *
 */
@Controller
@RequestMapping(value = "/checkout/multi/gift-wrap")

public class GiftWrapCheckoutStepController extends AbstractCheckoutStepController
{

	private static final String GIFT_WRAP = "gift-wrap";
	@Resource(name = "bonStoreFrontCheckoutFacade")
	private BonStoreFrontCheckoutFacade bonStoreFrontCheckoutFacade;

	@RequestMapping(value = "/choose", method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	@PreValidateCheckoutStep(checkoutStep = GIFT_WRAP)
	public String enterStep(final Model model, final RedirectAttributes redirectAttributes)
			throws CMSItemNotFoundException, CommerceCartModificationException
	{
		final CartData cartData = getCheckoutFacade().getCheckoutCart();
		model.addAttribute("cartData", cartData);
		model.addAttribute("giftWraps", getBonStoreFrontCheckoutFacade().getGiftWrapList());
		this.prepareDataForPage(model);
		storeCmsPageInModel(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		setUpMetaDataForContentPage(model, getContentPageForLabelOrId(MULTI_CHECKOUT_SUMMARY_CMS_PAGE_LABEL));
		model.addAttribute(WebConstants.BREADCRUMBS_KEY,
				getResourceBreadcrumbBuilder().getBreadcrumbs("checkout.multi.giftWrap.breadcrumb"));
		model.addAttribute("metaRobots", "noindex,nofollow");
		setCheckoutStepLinksForModel(model, getCheckoutStep());

		return ControllerConstants.Views.Pages.MultiStepCheckout.GiftWrapPage;
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@RequireHardLogIn
	public String doSelectGiftWrap(@RequestParam(value = "gift_wrap", required = false) final List<String> gift_wraps)
	{
		if (CollectionUtils.isNotEmpty(gift_wraps))
		{
			getBonStoreFrontCheckoutFacade().setGiftWraps(gift_wraps);
		}
		return getCheckoutStep().nextStep();
	}


	@RequestMapping(value = "/back", method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	public String back(final RedirectAttributes redirectAttributes)
	{
		return getCheckoutStep().previousStep();
	}

	protected CheckoutStep getCheckoutStep()
	{
		return getCheckoutStep(GIFT_WRAP);
	}


	@RequestMapping(value = "/next", method = RequestMethod.GET)
	@RequireHardLogIn
	@Override
	public String next(final RedirectAttributes redirectAttributes)
	{
		return getCheckoutStep().nextStep();
	}

	public BonStoreFrontCheckoutFacade getBonStoreFrontCheckoutFacade()
	{
		return bonStoreFrontCheckoutFacade;
	}

	public void setBonStoreFrontCheckoutFacade(final BonStoreFrontCheckoutFacade bonStoreFrontCheckoutFacade)
	{
		this.bonStoreFrontCheckoutFacade = bonStoreFrontCheckoutFacade;
	}


}
