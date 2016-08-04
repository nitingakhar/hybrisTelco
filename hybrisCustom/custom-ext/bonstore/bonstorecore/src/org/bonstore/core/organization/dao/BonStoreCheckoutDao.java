/**
 *
 */
package org.bonstore.core.organization.dao;

import java.util.List;

import org.bonstore.core.model.GiftWrapModel;


/**
 * @author Nitin_Gakhar
 *
 */
public interface BonStoreCheckoutDao
{
	/**
	 * To the list of available gift wraps available in the system
	 *
	 * @return List of GiftWrapModel objects
	 */
	List<GiftWrapModel> getGiftWrapList();

	/**
	 * To get the gift wrap based on code
	 *
	 * @param code
	 * @return List of GiftWrapModel objects
	 */
	List<GiftWrapModel> getGiftWrapByCode(String code);
}
