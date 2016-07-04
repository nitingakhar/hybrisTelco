/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 1, 2016 11:40:53 AM                     ---
 * ----------------------------------------------------------------
 */
package org.bonstore.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bonstore.core.constants.BonstoreCoreConstants;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Organization}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedOrganization extends GenericItem
{
	/** Qualifier of the <code>Organization.id</code> attribute **/
	public static final String ID = "id";
	/** Qualifier of the <code>Organization.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>Organization.phonenumber</code> attribute **/
	public static final String PHONENUMBER = "phonenumber";
	/** Qualifier of the <code>Organization.email</code> attribute **/
	public static final String EMAIL = "email";
	/** Qualifier of the <code>Organization.customers</code> attribute **/
	public static final String CUSTOMERS = "customers";
	/** Relation ordering override parameter constants for CustomerOrganizationRelation from ((bonstorecore))*/
	protected static String CUSTOMERORGANIZATIONRELATION_SRC_ORDERED = "relation.CustomerOrganizationRelation.source.ordered";
	protected static String CUSTOMERORGANIZATIONRELATION_TGT_ORDERED = "relation.CustomerOrganizationRelation.target.ordered";
	/** Relation disable markmodifed parameter constants for CustomerOrganizationRelation from ((bonstorecore))*/
	protected static String CUSTOMERORGANIZATIONRELATION_MARKMODIFIED = "relation.CustomerOrganizationRelation.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ID, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(PHONENUMBER, AttributeMode.INITIAL);
		tmp.put(EMAIL, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.customers</code> attribute.
	 * @return the customers
	 */
	public List<Customer> getCustomers(final SessionContext ctx)
	{
		final List<Customer> items = getLinkedItems( 
			ctx,
			false,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			"Customer",
			null,
			Utilities.getRelationOrderingOverride(CUSTOMERORGANIZATIONRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CUSTOMERORGANIZATIONRELATION_TGT_ORDERED, true)
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.customers</code> attribute.
	 * @return the customers
	 */
	public List<Customer> getCustomers()
	{
		return getCustomers( getSession().getSessionContext() );
	}
	
	public long getCustomersCount(final SessionContext ctx)
	{
		return getLinkedItemsCount(
			ctx,
			false,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			"Customer",
			null
		);
	}
	
	public long getCustomersCount()
	{
		return getCustomersCount( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.customers</code> attribute. 
	 * @param value the customers
	 */
	public void setCustomers(final SessionContext ctx, final List<Customer> value)
	{
		setLinkedItems( 
			ctx,
			false,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			null,
			value,
			Utilities.getRelationOrderingOverride(CUSTOMERORGANIZATIONRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CUSTOMERORGANIZATIONRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CUSTOMERORGANIZATIONRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.customers</code> attribute. 
	 * @param value the customers
	 */
	public void setCustomers(final List<Customer> value)
	{
		setCustomers( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to customers. 
	 * @param value the item to add to customers
	 */
	public void addToCustomers(final SessionContext ctx, final Customer value)
	{
		addLinkedItems( 
			ctx,
			false,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(CUSTOMERORGANIZATIONRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CUSTOMERORGANIZATIONRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CUSTOMERORGANIZATIONRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to customers. 
	 * @param value the item to add to customers
	 */
	public void addToCustomers(final Customer value)
	{
		addToCustomers( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from customers. 
	 * @param value the item to remove from customers
	 */
	public void removeFromCustomers(final SessionContext ctx, final Customer value)
	{
		removeLinkedItems( 
			ctx,
			false,
			BonstoreCoreConstants.Relations.CUSTOMERORGANIZATIONRELATION,
			null,
			Collections.singletonList(value),
			Utilities.getRelationOrderingOverride(CUSTOMERORGANIZATIONRELATION_SRC_ORDERED, true),
			Utilities.getRelationOrderingOverride(CUSTOMERORGANIZATIONRELATION_TGT_ORDERED, true),
			Utilities.getMarkModifiedOverride(CUSTOMERORGANIZATIONRELATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from customers. 
	 * @param value the item to remove from customers
	 */
	public void removeFromCustomers(final Customer value)
	{
		removeFromCustomers( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.email</code> attribute.
	 * @return the email - email
	 */
	public String getEmail(final SessionContext ctx)
	{
		return (String)getProperty( ctx, EMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.email</code> attribute.
	 * @return the email - email
	 */
	public String getEmail()
	{
		return getEmail( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.email</code> attribute. 
	 * @param value the email - email
	 */
	public void setEmail(final SessionContext ctx, final String value)
	{
		setProperty(ctx, EMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.email</code> attribute. 
	 * @param value the email - email
	 */
	public void setEmail(final String value)
	{
		setEmail( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.id</code> attribute.
	 * @return the id - ID
	 */
	public Integer getId(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.id</code> attribute.
	 * @return the id - ID
	 */
	public Integer getId()
	{
		return getId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.id</code> attribute. 
	 * @return the id - ID
	 */
	public int getIdAsPrimitive(final SessionContext ctx)
	{
		Integer value = getId( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.id</code> attribute. 
	 * @return the id - ID
	 */
	public int getIdAsPrimitive()
	{
		return getIdAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.id</code> attribute. 
	 * @param value the id - ID
	 */
	public void setId(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, ID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.id</code> attribute. 
	 * @param value the id - ID
	 */
	public void setId(final Integer value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.id</code> attribute. 
	 * @param value the id - ID
	 */
	public void setId(final SessionContext ctx, final int value)
	{
		setId( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.id</code> attribute. 
	 * @param value the id - ID
	 */
	public void setId(final int value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.name</code> attribute.
	 * @return the name - name
	 */
	public String getName(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedOrganization.getName requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.name</code> attribute.
	 * @return the name - name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.name</code> attribute. 
	 * @return the localized name - name
	 */
	public Map<Language,String> getAllName(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,NAME,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.name</code> attribute. 
	 * @return the localized name - name
	 */
	public Map<Language,String> getAllName()
	{
		return getAllName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.name</code> attribute. 
	 * @param value the name - name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedOrganization.setName requires a session language", 0 );
		}
		setLocalizedProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.name</code> attribute. 
	 * @param value the name - name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.name</code> attribute. 
	 * @param value the name - name
	 */
	public void setAllName(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.name</code> attribute. 
	 * @param value the name - name
	 */
	public void setAllName(final Map<Language,String> value)
	{
		setAllName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.phonenumber</code> attribute.
	 * @return the phonenumber - phonenumber
	 */
	public String getPhonenumber(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PHONENUMBER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Organization.phonenumber</code> attribute.
	 * @return the phonenumber - phonenumber
	 */
	public String getPhonenumber()
	{
		return getPhonenumber( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.phonenumber</code> attribute. 
	 * @param value the phonenumber - phonenumber
	 */
	public void setPhonenumber(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PHONENUMBER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Organization.phonenumber</code> attribute. 
	 * @param value the phonenumber - phonenumber
	 */
	public void setPhonenumber(final String value)
	{
		setPhonenumber( getSession().getSessionContext(), value );
	}
	
}
