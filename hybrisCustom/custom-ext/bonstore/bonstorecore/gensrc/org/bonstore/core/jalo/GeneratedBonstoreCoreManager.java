/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jun 9, 2016 3:48:21 PM                      ---
 * ----------------------------------------------------------------
 */
package org.bonstore.core.jalo;

import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bonstore.core.constants.BonstoreCoreConstants;
import org.bonstore.core.jalo.ApparelProduct;
import org.bonstore.core.jalo.ApparelSizeVariantProduct;
import org.bonstore.core.jalo.ApparelStyleVariantProduct;
import org.bonstore.core.jalo.ElectronicsColorVariantProduct;
import org.bonstore.core.jalo.Organization;

/**
 * Generated class for type <code>BonstoreCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedBonstoreCoreManager extends Extension
{
	/** Relation ordering override parameter constants for CustomerOrganizationRelation from ((bonstorecore))*/
	protected static String CUSTOMERORGANIZATIONRELATION_SRC_ORDERED = "relation.CustomerOrganizationRelation.source.ordered";
	protected static String CUSTOMERORGANIZATIONRELATION_TGT_ORDERED = "relation.CustomerOrganizationRelation.target.ordered";
	/** Relation disable markmodifed parameter constants for CustomerOrganizationRelation from ((bonstorecore))*/
	protected static String CUSTOMERORGANIZATIONRELATION_MARKMODIFIED = "relation.CustomerOrganizationRelation.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("status", AttributeMode.INITIAL);
		tmp.put("attemptCount", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.attemptCount</code> attribute.
	 * @return the attemptCount - It indicates how many times user entered incorrect password successively
	 */
	public Integer getAttemptCount(final SessionContext ctx, final Customer item)
	{
		return (Integer)item.getProperty( ctx, BonstoreCoreConstants.Attributes.Customer.ATTEMPTCOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.attemptCount</code> attribute.
	 * @return the attemptCount - It indicates how many times user entered incorrect password successively
	 */
	public Integer getAttemptCount(final Customer item)
	{
		return getAttemptCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.attemptCount</code> attribute. 
	 * @return the attemptCount - It indicates how many times user entered incorrect password successively
	 */
	public int getAttemptCountAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Integer value = getAttemptCount( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.attemptCount</code> attribute. 
	 * @return the attemptCount - It indicates how many times user entered incorrect password successively
	 */
	public int getAttemptCountAsPrimitive(final Customer item)
	{
		return getAttemptCountAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.attemptCount</code> attribute. 
	 * @param value the attemptCount - It indicates how many times user entered incorrect password successively
	 */
	public void setAttemptCount(final SessionContext ctx, final Customer item, final Integer value)
	{
		item.setProperty(ctx, BonstoreCoreConstants.Attributes.Customer.ATTEMPTCOUNT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.attemptCount</code> attribute. 
	 * @param value the attemptCount - It indicates how many times user entered incorrect password successively
	 */
	public void setAttemptCount(final Customer item, final Integer value)
	{
		setAttemptCount( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.attemptCount</code> attribute. 
	 * @param value the attemptCount - It indicates how many times user entered incorrect password successively
	 */
	public void setAttemptCount(final SessionContext ctx, final Customer item, final int value)
	{
		setAttemptCount( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.attemptCount</code> attribute. 
	 * @param value the attemptCount - It indicates how many times user entered incorrect password successively
	 */
	public void setAttemptCount(final Customer item, final int value)
	{
		setAttemptCount( getSession().getSessionContext(), item, value );
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BonstoreCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BonstoreCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BonstoreCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BonstoreCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public Organization createOrganization(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( BonstoreCoreConstants.TC.ORGANIZATION );
			return (Organization)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Organization : "+e.getMessage(), 0 );
		}
	}
	
	public Organization createOrganization(final Map attributeValues)
	{
		return createOrganization( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return BonstoreCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.organizations</code> attribute.
	 * @return the organizations
	 */
	public Collection<Organization> getOrganizations(final SessionContext ctx, final Customer item)
	{
		final List<Organization> items = item.getLinkedItems( 
			ctx,
			true,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			"Organization",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.organizations</code> attribute.
	 * @return the organizations
	 */
	public Collection<Organization> getOrganizations(final Customer item)
	{
		return getOrganizations( getSession().getSessionContext(), item );
	}
	
	public long getOrganizationsCount(final SessionContext ctx, final Customer item)
	{
		return item.getLinkedItemsCount(
			ctx,
			true,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			"Organization",
			null
		);
	}
	
	public long getOrganizationsCount(final Customer item)
	{
		return getOrganizationsCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.organizations</code> attribute. 
	 * @param value the organizations
	 */
	public void setOrganizations(final SessionContext ctx, final Customer item, final Collection<Organization> value)
	{
		item.setLinkedItems( 
			ctx,
			true,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(CUSTOMERORGANIZATIONRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.organizations</code> attribute. 
	 * @param value the organizations
	 */
	public void setOrganizations(final Customer item, final Collection<Organization> value)
	{
		setOrganizations( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to organizations. 
	 * @param value the item to add to organizations
	 */
	public void addToOrganizations(final SessionContext ctx, final Customer item, final Organization value)
	{
		item.addLinkedItems( 
			ctx,
			true,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(CUSTOMERORGANIZATIONRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to organizations. 
	 * @param value the item to add to organizations
	 */
	public void addToOrganizations(final Customer item, final Organization value)
	{
		addToOrganizations( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from organizations. 
	 * @param value the item to remove from organizations
	 */
	public void removeFromOrganizations(final SessionContext ctx, final Customer item, final Organization value)
	{
		item.removeLinkedItems( 
			ctx,
			true,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(CUSTOMERORGANIZATIONRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from organizations. 
	 * @param value the item to remove from organizations
	 */
	public void removeFromOrganizations(final Customer item, final Organization value)
	{
		removeFromOrganizations( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.status</code> attribute.
	 * @return the status - It indicates if account is locked or not
	 */
	public Boolean isStatus(final SessionContext ctx, final Customer item)
	{
		return (Boolean)item.getProperty( ctx, BonstoreCoreConstants.Attributes.Customer.STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.status</code> attribute.
	 * @return the status - It indicates if account is locked or not
	 */
	public Boolean isStatus(final Customer item)
	{
		return isStatus( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.status</code> attribute. 
	 * @return the status - It indicates if account is locked or not
	 */
	public boolean isStatusAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Boolean value = isStatus( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.status</code> attribute. 
	 * @return the status - It indicates if account is locked or not
	 */
	public boolean isStatusAsPrimitive(final Customer item)
	{
		return isStatusAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.status</code> attribute. 
	 * @param value the status - It indicates if account is locked or not
	 */
	public void setStatus(final SessionContext ctx, final Customer item, final Boolean value)
	{
		item.setProperty(ctx, BonstoreCoreConstants.Attributes.Customer.STATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.status</code> attribute. 
	 * @param value the status - It indicates if account is locked or not
	 */
	public void setStatus(final Customer item, final Boolean value)
	{
		setStatus( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.status</code> attribute. 
	 * @param value the status - It indicates if account is locked or not
	 */
	public void setStatus(final SessionContext ctx, final Customer item, final boolean value)
	{
		setStatus( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.status</code> attribute. 
	 * @param value the status - It indicates if account is locked or not
	 */
	public void setStatus(final Customer item, final boolean value)
	{
		setStatus( getSession().getSessionContext(), item, value );
	}
	
}
