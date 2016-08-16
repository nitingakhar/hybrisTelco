/**
 *
 */
package org.bonstore.storefront.facade;

import java.util.List;

import org.bonstore.data.GiftWrapData;


/**
 * @author Nitin_Gakhar
 *
 */
public interface BonStoreFrontCheckoutFacade
{

	List<GiftWrapData> getGiftWrapList();

	void setGiftWraps(List<String> giftWraps);

}
