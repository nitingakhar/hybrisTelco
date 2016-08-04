/**
 *
 */
package org.bonstore.core.organization.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Arrays;
import java.util.List;

import org.bonstore.core.model.GiftWrapModel;
import org.bonstore.core.organization.dao.BonStoreCheckoutDao;
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
public class BonStoreCheckoutServiceImplTest
{

	@InjectMocks
	private BonStoreCheckoutServiceImpl bonStoreCheckoutService;
	@Mock
	private BonStoreCheckoutDao bonStoreCheckoutDao;
	@Mock
	private ModelService modelService;
	@Mock
	private GiftWrapModel giftWrapModel;
	@Mock
	private CartModel cartModel;

	private static final String GIFTWRAP_CODE = "card";
	private List<GiftWrapModel> giftWrapList;

	@Before
	public void setup()
	{
		giftWrapList = Arrays.asList(giftWrapModel);
	}

	@Test
	public void testGetGiftWrapList()
	{
		when(bonStoreCheckoutDao.getGiftWrapList()).thenReturn(giftWrapList);
		final List<GiftWrapModel> giftWraps = bonStoreCheckoutService.getGiftWrapList();
		assertEquals(giftWrapList, giftWraps);
	}

	@Test
	public void testGetGiftWrapByCodeWhenGiftWrapListIsNotEmpty()
	{
		when(bonStoreCheckoutDao.getGiftWrapByCode(GIFTWRAP_CODE)).thenReturn(giftWrapList);
		final GiftWrapModel giftWrap = bonStoreCheckoutService.getGiftWrapByCode(GIFTWRAP_CODE);
		assertEquals(giftWrap, giftWrapList.get(0));
	}

	@Test
	public void testGetGiftWrapByCodeAsNullWhenGiftWrapListIsEmpty()
	{
		when(bonStoreCheckoutDao.getGiftWrapByCode(GIFTWRAP_CODE)).thenReturn(null);
		final GiftWrapModel giftWrap = bonStoreCheckoutService.getGiftWrapByCode(GIFTWRAP_CODE);
		assertEquals(null, giftWrap);
	}

}
