/**
 *
 */
package org.bonstore.storefront.facade;

import de.hybris.platform.commercefacades.order.impl.DefaultCheckoutFacade;
import de.hybris.platform.core.model.order.CartModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bonstore.core.model.GiftWrapModel;
import org.bonstore.core.organization.BonStoreCheckoutService;
import org.bonstore.data.GiftWrapData;


/**
 * @author Nitin_Gakhar
 *
 */
public class BonStoreFrontCheckoutFacadeImpl extends DefaultCheckoutFacade implements BonStoreFrontCheckoutFacade
{

	private BonStoreCheckoutService bonStoreCheckoutService;


	@Override
	public void setGiftWraps(final List<String> selectedGiftWraps)
	{
		final CartModel cartModel = getCart();
		final Set<GiftWrapModel> giftWrapModels = new HashSet<>();
		for (final String giftWrapCode : selectedGiftWraps)
		{
			final GiftWrapModel giftWrapModel = getBonStoreCheckOutService().getGiftWrapByCode(giftWrapCode);
			giftWrapModels.add(giftWrapModel);
		}
		getBonStoreCheckOutService().setGiftWraps(giftWrapModels, cartModel);
	}


	@Override
	public List<GiftWrapData> getGiftWrapList()
	{
		return mapModelToDataList(getBonStoreCheckOutService().getGiftWrapList());
	}

	protected List<GiftWrapData> mapModelToDataList(final List<GiftWrapModel> giftWrapModelList)
	{
		final List<GiftWrapData> giftWrapDataList = new ArrayList<>(giftWrapModelList.size());

		for (final GiftWrapModel giftWrapModel : giftWrapModelList)
		{
			final GiftWrapData giftWrapData = new GiftWrapData();
			giftWrapData.setCode(giftWrapModel.getCode());
			giftWrapData.setName(giftWrapModel.getName());
			giftWrapDataList.add(giftWrapData);
		}

		return giftWrapDataList;
	}

	public BonStoreCheckoutService getBonStoreCheckOutService()
	{
		return bonStoreCheckoutService;
	}

	public void setBonStoreCheckoutService(final BonStoreCheckoutService bonStoreCheckoutService)
	{
		this.bonStoreCheckoutService = bonStoreCheckoutService;
	}

}
