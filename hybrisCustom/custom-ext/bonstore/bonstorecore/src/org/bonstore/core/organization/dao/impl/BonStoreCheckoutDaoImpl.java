/**
 *
 */
package org.bonstore.core.organization.dao.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import org.bonstore.core.model.GiftWrapModel;
import org.bonstore.core.organization.dao.BonStoreCheckoutDao;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Nitin_Gakhar
 *
 */
public class BonStoreCheckoutDaoImpl implements BonStoreCheckoutDao
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Override
	public List<GiftWrapModel> getGiftWrapList()
	{
		final String queryString = //
				"SELECT {g:" + GiftWrapModel.PK + "} " + "FROM {" + GiftWrapModel._TYPECODE + " AS g}";
		final SearchResult<GiftWrapModel> searchResult = flexibleSearchService.search(queryString);
		return searchResult.getResult();
	}

	@Override
	public List<GiftWrapModel> getGiftWrapByCode(final String code)
	{
		final String queryString = "SELECT {g:" + GiftWrapModel.PK + "}" + "FROM {" + GiftWrapModel._TYPECODE + " AS g}"
				+ "WHERE {g:" + GiftWrapModel.CODE + "}=?code";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("code", code);
		final SearchResult<GiftWrapModel> searchResult = flexibleSearchService.search(query);
		return searchResult.getResult();
	}

}
