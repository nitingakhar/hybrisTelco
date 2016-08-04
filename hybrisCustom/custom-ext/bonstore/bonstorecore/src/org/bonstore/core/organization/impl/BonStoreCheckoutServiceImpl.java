/**
 *
 */
package org.bonstore.core.organization.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.List;
import java.util.Set;

import org.bonstore.core.model.GiftWrapModel;
import org.bonstore.core.organization.BonStoreCheckoutService;
import org.bonstore.core.organization.dao.BonStoreCheckoutDao;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Nitin_Gakhar
 *
 */
public class BonStoreCheckoutServiceImpl implements BonStoreCheckoutService
{

	private BonStoreCheckoutDao bonStoreCheckoutDao;
	@Autowired
	private ModelService modelService;

	@Override
	public List<GiftWrapModel> getGiftWrapList()
	{
		return bonStoreCheckoutDao.getGiftWrapList();
	}

	@Override
	public GiftWrapModel getGiftWrapByCode(final String code)
	{
		final List<GiftWrapModel> giftWrapModelList = bonStoreCheckoutDao.getGiftWrapByCode(code);
		return (giftWrapModelList != null && !giftWrapModelList.isEmpty()) ? giftWrapModelList.get(0) : null;
	}

	public BonStoreCheckoutDao getBonStoreCheckoutDao()
	{
		return bonStoreCheckoutDao;
	}

	public void setBonStoreCheckoutDao(final BonStoreCheckoutDao bonStoreCheckoutDao)
	{
		this.bonStoreCheckoutDao = bonStoreCheckoutDao;
	}


	@Override
	public void setGiftWraps(final Set<GiftWrapModel> giftWrapSet, final CartModel cartModel)
	{
		validateParameterNotNull(cartModel, "Cart model cannot be null");
		cartModel.setGiftwraps(giftWrapSet);
		modelService.save(cartModel);
	}

}
