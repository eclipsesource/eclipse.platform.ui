/**
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      IBM Corporation - initial API and implementation
 */
package org.eclipse.e4.ui.model.application.impl;

import java.util.Collection;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.ui.model.application.MApplicationPackage;
import org.eclipse.e4.ui.model.application.MCommand;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.MHandledItem;
import org.eclipse.e4.ui.model.application.MItem;
import org.eclipse.e4.ui.model.application.MElementContainer;
import org.eclipse.e4.ui.model.application.MMenu;
import org.eclipse.e4.ui.model.application.MMenuItem;
import org.eclipse.e4.ui.model.application.MParameter;
import org.eclipse.e4.ui.model.application.MUIItem;
import org.eclipse.e4.ui.model.application.MUIElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Menu Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getIconURI <em>Icon URI</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#isSelected <em>Selected</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#isSeparator <em>Separator</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getWbCommand <em>Wb Command</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.e4.ui.model.application.impl.MenuItemImpl#getPersistedState <em>Persisted State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MenuItemImpl extends MenuImpl implements MMenuItem {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconURI() <em>Icon URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIconURI()
	 * @generated
	 * @ordered
	 */
	protected String iconURI = ICON_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOLTIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected String tooltip = TOOLTIP_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SELECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected boolean selected = SELECTED_EDEFAULT;

	/**
	 * The default value of the '{@link #isSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSeparator()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEPARATOR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSeparator() <em>Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSeparator()
	 * @generated
	 * @ordered
	 */
	protected boolean separator = SEPARATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCommand() <em>Command</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommand()
	 * @generated
	 * @ordered
	 */
	protected MCommand command;

	/**
	 * The default value of the '{@link #getWbCommand() <em>Wb Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWbCommand()
	 * @generated
	 * @ordered
	 */
	protected static final ParameterizedCommand WB_COMMAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWbCommand() <em>Wb Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWbCommand()
	 * @generated
	 * @ordered
	 */
	protected ParameterizedCommand wbCommand = WB_COMMAND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<MParameter> parameters;

	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected Object object = OBJECT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPersistedState() <em>Persisted State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistedState()
	 * @generated
	 * @ordered
	 */
	protected static final String PERSISTED_STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPersistedState() <em>Persisted State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistedState()
	 * @generated
	 * @ordered
	 */
	protected String persistedState = PERSISTED_STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MenuItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MApplicationPackage.Literals.MENU_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIconURI() {
		return iconURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIconURI(String newIconURI) {
		String oldIconURI = iconURI;
		iconURI = newIconURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__ICON_URI, oldIconURI, iconURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTooltip(String newTooltip) {
		String oldTooltip = tooltip;
		tooltip = newTooltip;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__TOOLTIP, oldTooltip, tooltip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelected(boolean newSelected) {
		boolean oldSelected = selected;
		selected = newSelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__SELECTED, oldSelected, selected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSeparator() {
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeparator(boolean newSeparator) {
		boolean oldSeparator = separator;
		separator = newSeparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__SEPARATOR, oldSeparator, separator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MCommand getCommand() {
		if (command != null && ((EObject)command).eIsProxy()) {
			InternalEObject oldCommand = (InternalEObject)command;
			command = (MCommand)eResolveProxy(oldCommand);
			if (command != oldCommand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MApplicationPackage.MENU_ITEM__COMMAND, oldCommand, command));
			}
		}
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MCommand basicGetCommand() {
		return command;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommand(MCommand newCommand) {
		MCommand oldCommand = command;
		command = newCommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__COMMAND, oldCommand, command));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedCommand getWbCommand() {
		return wbCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWbCommand(ParameterizedCommand newWbCommand) {
		ParameterizedCommand oldWbCommand = wbCommand;
		wbCommand = newWbCommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__WB_COMMAND, oldWbCommand, wbCommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectResolvingEList<MParameter>(MParameter.class, this, MApplicationPackage.MENU_ITEM__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getURI() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURI(String newURI) {
		String oldURI = uri;
		uri = newURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__URI, oldURI, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(Object newObject) {
		Object oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPersistedState() {
		return persistedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistedState(String newPersistedState) {
		String oldPersistedState = persistedState;
		persistedState = newPersistedState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MApplicationPackage.MENU_ITEM__PERSISTED_STATE, oldPersistedState, persistedState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MApplicationPackage.MENU_ITEM__NAME:
				return getName();
			case MApplicationPackage.MENU_ITEM__ICON_URI:
				return getIconURI();
			case MApplicationPackage.MENU_ITEM__TOOLTIP:
				return getTooltip();
			case MApplicationPackage.MENU_ITEM__ENABLED:
				return isEnabled();
			case MApplicationPackage.MENU_ITEM__SELECTED:
				return isSelected();
			case MApplicationPackage.MENU_ITEM__SEPARATOR:
				return isSeparator();
			case MApplicationPackage.MENU_ITEM__COMMAND:
				if (resolve) return getCommand();
				return basicGetCommand();
			case MApplicationPackage.MENU_ITEM__WB_COMMAND:
				return getWbCommand();
			case MApplicationPackage.MENU_ITEM__PARAMETERS:
				return getParameters();
			case MApplicationPackage.MENU_ITEM__URI:
				return getURI();
			case MApplicationPackage.MENU_ITEM__OBJECT:
				return getObject();
			case MApplicationPackage.MENU_ITEM__PERSISTED_STATE:
				return getPersistedState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MApplicationPackage.MENU_ITEM__NAME:
				setName((String)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__ICON_URI:
				setIconURI((String)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__TOOLTIP:
				setTooltip((String)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__SELECTED:
				setSelected((Boolean)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__SEPARATOR:
				setSeparator((Boolean)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__COMMAND:
				setCommand((MCommand)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__WB_COMMAND:
				setWbCommand((ParameterizedCommand)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends MParameter>)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__URI:
				setURI((String)newValue);
				return;
			case MApplicationPackage.MENU_ITEM__OBJECT:
				setObject(newValue);
				return;
			case MApplicationPackage.MENU_ITEM__PERSISTED_STATE:
				setPersistedState((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MApplicationPackage.MENU_ITEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__ICON_URI:
				setIconURI(ICON_URI_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__TOOLTIP:
				setTooltip(TOOLTIP_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__SELECTED:
				setSelected(SELECTED_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__SEPARATOR:
				setSeparator(SEPARATOR_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__COMMAND:
				setCommand((MCommand)null);
				return;
			case MApplicationPackage.MENU_ITEM__WB_COMMAND:
				setWbCommand(WB_COMMAND_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__PARAMETERS:
				getParameters().clear();
				return;
			case MApplicationPackage.MENU_ITEM__URI:
				setURI(URI_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__OBJECT:
				setObject(OBJECT_EDEFAULT);
				return;
			case MApplicationPackage.MENU_ITEM__PERSISTED_STATE:
				setPersistedState(PERSISTED_STATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MApplicationPackage.MENU_ITEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MApplicationPackage.MENU_ITEM__ICON_URI:
				return ICON_URI_EDEFAULT == null ? iconURI != null : !ICON_URI_EDEFAULT.equals(iconURI);
			case MApplicationPackage.MENU_ITEM__TOOLTIP:
				return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
			case MApplicationPackage.MENU_ITEM__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case MApplicationPackage.MENU_ITEM__SELECTED:
				return selected != SELECTED_EDEFAULT;
			case MApplicationPackage.MENU_ITEM__SEPARATOR:
				return separator != SEPARATOR_EDEFAULT;
			case MApplicationPackage.MENU_ITEM__COMMAND:
				return command != null;
			case MApplicationPackage.MENU_ITEM__WB_COMMAND:
				return WB_COMMAND_EDEFAULT == null ? wbCommand != null : !WB_COMMAND_EDEFAULT.equals(wbCommand);
			case MApplicationPackage.MENU_ITEM__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case MApplicationPackage.MENU_ITEM__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case MApplicationPackage.MENU_ITEM__OBJECT:
				return OBJECT_EDEFAULT == null ? object != null : !OBJECT_EDEFAULT.equals(object);
			case MApplicationPackage.MENU_ITEM__PERSISTED_STATE:
				return PERSISTED_STATE_EDEFAULT == null ? persistedState != null : !PERSISTED_STATE_EDEFAULT.equals(persistedState);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MUIItem.class) {
			switch (derivedFeatureID) {
				case MApplicationPackage.MENU_ITEM__NAME: return MApplicationPackage.UI_ITEM__NAME;
				case MApplicationPackage.MENU_ITEM__ICON_URI: return MApplicationPackage.UI_ITEM__ICON_URI;
				case MApplicationPackage.MENU_ITEM__TOOLTIP: return MApplicationPackage.UI_ITEM__TOOLTIP;
				default: return -1;
			}
		}
		if (baseClass == MItem.class) {
			switch (derivedFeatureID) {
				case MApplicationPackage.MENU_ITEM__ENABLED: return MApplicationPackage.ITEM__ENABLED;
				case MApplicationPackage.MENU_ITEM__SELECTED: return MApplicationPackage.ITEM__SELECTED;
				case MApplicationPackage.MENU_ITEM__SEPARATOR: return MApplicationPackage.ITEM__SEPARATOR;
				default: return -1;
			}
		}
		if (baseClass == MHandledItem.class) {
			switch (derivedFeatureID) {
				case MApplicationPackage.MENU_ITEM__COMMAND: return MApplicationPackage.HANDLED_ITEM__COMMAND;
				case MApplicationPackage.MENU_ITEM__WB_COMMAND: return MApplicationPackage.HANDLED_ITEM__WB_COMMAND;
				case MApplicationPackage.MENU_ITEM__PARAMETERS: return MApplicationPackage.HANDLED_ITEM__PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == MContribution.class) {
			switch (derivedFeatureID) {
				case MApplicationPackage.MENU_ITEM__URI: return MApplicationPackage.CONTRIBUTION__URI;
				case MApplicationPackage.MENU_ITEM__OBJECT: return MApplicationPackage.CONTRIBUTION__OBJECT;
				case MApplicationPackage.MENU_ITEM__PERSISTED_STATE: return MApplicationPackage.CONTRIBUTION__PERSISTED_STATE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MUIItem.class) {
			switch (baseFeatureID) {
				case MApplicationPackage.UI_ITEM__NAME: return MApplicationPackage.MENU_ITEM__NAME;
				case MApplicationPackage.UI_ITEM__ICON_URI: return MApplicationPackage.MENU_ITEM__ICON_URI;
				case MApplicationPackage.UI_ITEM__TOOLTIP: return MApplicationPackage.MENU_ITEM__TOOLTIP;
				default: return -1;
			}
		}
		if (baseClass == MItem.class) {
			switch (baseFeatureID) {
				case MApplicationPackage.ITEM__ENABLED: return MApplicationPackage.MENU_ITEM__ENABLED;
				case MApplicationPackage.ITEM__SELECTED: return MApplicationPackage.MENU_ITEM__SELECTED;
				case MApplicationPackage.ITEM__SEPARATOR: return MApplicationPackage.MENU_ITEM__SEPARATOR;
				default: return -1;
			}
		}
		if (baseClass == MHandledItem.class) {
			switch (baseFeatureID) {
				case MApplicationPackage.HANDLED_ITEM__COMMAND: return MApplicationPackage.MENU_ITEM__COMMAND;
				case MApplicationPackage.HANDLED_ITEM__WB_COMMAND: return MApplicationPackage.MENU_ITEM__WB_COMMAND;
				case MApplicationPackage.HANDLED_ITEM__PARAMETERS: return MApplicationPackage.MENU_ITEM__PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == MContribution.class) {
			switch (baseFeatureID) {
				case MApplicationPackage.CONTRIBUTION__URI: return MApplicationPackage.MENU_ITEM__URI;
				case MApplicationPackage.CONTRIBUTION__OBJECT: return MApplicationPackage.MENU_ITEM__OBJECT;
				case MApplicationPackage.CONTRIBUTION__PERSISTED_STATE: return MApplicationPackage.MENU_ITEM__PERSISTED_STATE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", iconURI: "); //$NON-NLS-1$
		result.append(iconURI);
		result.append(", tooltip: "); //$NON-NLS-1$
		result.append(tooltip);
		result.append(", enabled: "); //$NON-NLS-1$
		result.append(enabled);
		result.append(", selected: "); //$NON-NLS-1$
		result.append(selected);
		result.append(", separator: "); //$NON-NLS-1$
		result.append(separator);
		result.append(", wbCommand: "); //$NON-NLS-1$
		result.append(wbCommand);
		result.append(", URI: "); //$NON-NLS-1$
		result.append(uri);
		result.append(", object: "); //$NON-NLS-1$
		result.append(object);
		result.append(", persistedState: "); //$NON-NLS-1$
		result.append(persistedState);
		result.append(')');
		return result.toString();
	}

} //MenuItemImpl