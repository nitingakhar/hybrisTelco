/**
 *
 */
package org.bonstore.core.organization;

import de.hybris.platform.core.model.order.CartModel;

import java.util.List;
import java.util.Set;

import org.bonstore.core.model.GiftWrapModel;


/**
 * @author Nitin_Gakhar
 *
 */
public interface BonStoreCheckoutService
{
	List<GiftWrapModel> getGiftWrapList();

	GiftWrapModel getGiftWrapByCode(final String code);

	void setGiftWraps(Set<GiftWrapModel> giftWrapSet, CartModel cartModel);
}
