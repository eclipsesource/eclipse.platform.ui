/******************************************************************************* * Copyright (c) 2006 IBM Corporation and others. * All rights reserved. This program and the accompanying materials * are made available under the terms of the Eclipse Public License v1.0 * which accompanies this distribution, and is available at * http://www.eclipse.org/legal/epl-v10.html * * Contributors: *     IBM Corporation - initial API and implementation ******************************************************************************/package org.eclipse.ui.internal.menus;import java.util.List;import org.eclipse.core.commands.common.NotDefinedException;import org.eclipse.jface.action.ActionContributionItem;import org.eclipse.jface.action.IAction;import org.eclipse.jface.action.IContributionItem;import org.eclipse.jface.action.IContributionManager;import org.eclipse.jface.action.IContributionManagerOverrides;import org.eclipse.jface.action.IMenuListener;import org.eclipse.jface.action.IMenuManager;import org.eclipse.jface.action.MenuManager;import org.eclipse.swt.widgets.Composite;import org.eclipse.swt.widgets.CoolBar;import org.eclipse.swt.widgets.Menu;import org.eclipse.swt.widgets.ToolBar;import org.eclipse.ui.internal.WorkbenchWindow;/** * <p> * A wrapper around the new command-based menu services that speaks in terms of * the old menu manager class. * </p> * <p> * This class is not intended to be used outside of the * <code>org.eclipse.ui.workbench</code> plug-in. * </p> *  * @since 3.2 */public class LegacyMenuManager extends MenuManager {	/**	 * The layout node which this menu manager represents; never	 * <code>null</code>.	 */	private final ILayoutNode layoutNode;	/**	 * The window on which this menu manager exists; never <code>null</code>.	 */	private final WorkbenchWindow window;	/**	 * Constructs a new instance of <code>LegacyMenuManager</code>.	 * 	 * @param window	 *            The window on which this menu manager exists; must not be	 *            <code>null</code>.	 * @param layoutNode	 *            The layout node which this menu manager represents; must not	 *            be <code>null</code>.	 */	public LegacyMenuManager(final WorkbenchWindow window,			final ILayoutNode layoutNode) {		if (window == null) {			throw new NullPointerException("The window cannot be null"); //$NON-NLS-1$		}		if (layoutNode == null) {			throw new NullPointerException("The layout node cannot be null"); //$NON-NLS-1$		}		this.window = window;		this.layoutNode = layoutNode;	}	public final void add(final IAction action) {		// TODO	}	public final void add(final IContributionItem contributionItem) {		final String itemId = contributionItem.getId();		final IMenuService menuService = (IMenuService) window				.getService(IMenuService.class);		if (contributionItem instanceof IContributionManager) {			// The added item represents a menu.			final SMenu menu = menuService.getMenu(itemId);			if (menu.isDefined()) {				// The menu is already defined; simply add a location.				menu.addLocation(layoutNode.getLocation());			}			// TODO Define the menu.		} else if (contributionItem.isGroupMarker()				|| contributionItem.isSeparator()) {			// The added item represents a group.			final SGroup group = menuService.getGroup(itemId);			if (group.isDefined()) {				// The group is already defined; simply add a location.				group.addLocation(layoutNode.getLocation());			}			// TODO Define the group.		} else if (contributionItem instanceof ActionContributionItem) {			// The added item represents an item.			final SItem item = menuService.getItem(itemId);			if (item.isDefined()) {				// The item is already defined; simply add a location.				item.addLocation(layoutNode.getLocation());			}			// TODO Define the item.		} else {			/*			 * The added item represents some control we don't understand. This			 * will need to be represented as a widget.			 */			final SWidget widget = menuService.getWidget(itemId);			if (widget.isDefined()) {				// The widget is already defined; simply add a location.				widget.addLocation(layoutNode.getLocation());			}			// TODO Define the widget.		}		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IMenuManager#addMenuListener(org.eclipse.jface.action.IMenuListener)	 */	public void addMenuListener(IMenuListener listener) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#appendToGroup(java.lang.String,	 *      org.eclipse.jface.action.IAction)	 */	public void appendToGroup(String groupName, IAction action) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#appendToGroup(java.lang.String,	 *      org.eclipse.jface.action.IContributionItem)	 */	public void appendToGroup(String groupName, IContributionItem item) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#dispose()	 */	public void dispose() {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets.Composite)	 */	public void fill(Composite parent) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets.CoolBar,	 *      int)	 */	public void fill(CoolBar parent, int index) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets.Menu,	 *      int)	 */	public void fill(Menu parent, int index) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets.ToolBar,	 *      int)	 */	public void fill(ToolBar parent, int index) {		// TODO Auto-generated method stub	}	public final IContributionItem find(final String id) {		final IContributionItem[] items = getItems();		for (int i = 0; i < items.length; i++) {			final IContributionItem item = items[i];			final String itemId = item.getId();			if (itemId != null && itemId.equalsIgnoreCase(id)) {				return item;			}		}		return null;	}	public final IMenuManager findMenuUsingPath(final String path) {		final IContributionItem item = findUsingPath(path);		if (item instanceof IMenuManager)			return (IMenuManager) item;		return null;	}	public final IContributionItem findUsingPath(final String path) {		final int separator = path.indexOf(LeafLocationElement.PATH_SEPARATOR);		final String id;		final String rest;		if (separator == -1) {			id = path;			rest = null;		} else {			id = path.substring(0, separator);			rest = path.substring(separator + 1);		}		final IContributionItem item = find(id);		if (rest == null) {			return item;		} else if (item instanceof IMenuManager) {			final IMenuManager manager = (IMenuManager) item;			return manager.findUsingPath(rest);		}		return null;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#getId()	 */	public String getId() {		// TODO Auto-generated method stub		return null;	}	public final IContributionItem[] getItems() {		final List sortedChildren = layoutNode.getChildrenSorted();		final int length = sortedChildren.size();		final IContributionItem[] items = new IContributionItem[length];		for (int i = 0; i < length; i++) {			final ILayoutNode node = (ILayoutNode) sortedChildren.get(i);			final MenuElement element = node.getMenuElement();			if (element instanceof SMenu) {				items[i] = new LegacyMenuManager(window, node);			} else {				items[i] = new LegacyContributionItem(node);			}			// TODO Expand groups in-line.		}		return items;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#getOverrides()	 */	public IContributionManagerOverrides getOverrides() {		// TODO Auto-generated method stub		return null;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IMenuManager#getRemoveAllWhenShown()	 */	public boolean getRemoveAllWhenShown() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#insertAfter(java.lang.String,	 *      org.eclipse.jface.action.IAction)	 */	public void insertAfter(String id, IAction action) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#insertAfter(java.lang.String,	 *      org.eclipse.jface.action.IContributionItem)	 */	public void insertAfter(String id, IContributionItem item) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#insertBefore(java.lang.String,	 *      org.eclipse.jface.action.IAction)	 */	public void insertBefore(String id, IAction action) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#insertBefore(java.lang.String,	 *      org.eclipse.jface.action.IContributionItem)	 */	public void insertBefore(String id, IContributionItem item) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#isDirty()	 */	public boolean isDirty() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#isDynamic()	 */	public boolean isDynamic() {		// TODO Auto-generated method stub		return false;	}	public final boolean isEmpty() {		return layoutNode.isEmpty();	}	public final boolean isEnabled() {		return true;	}	public final boolean isGroupMarker() {		// TODO There is a difference in representation here: flat vs. container		return (layoutNode.getMenuElement() instanceof SGroup);	}	public final boolean isSeparator() {		// TODO There is a difference in representation here: flat vs. container		final MenuElement element = layoutNode.getMenuElement();		if (element instanceof SGroup) {			final SGroup group = (SGroup) element;			try {				return group.isSeparatorsVisible();			} catch (final NotDefinedException e) {				// Fall through to the "return false;" below			}		}		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#isVisible()	 */	public boolean isVisible() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#markDirty()	 */	public void markDirty() {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#prependToGroup(java.lang.String,	 *      org.eclipse.jface.action.IAction)	 */	public void prependToGroup(String groupName, IAction action) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#prependToGroup(java.lang.String,	 *      org.eclipse.jface.action.IContributionItem)	 */	public void prependToGroup(String groupName, IContributionItem item) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#remove(org.eclipse.jface.action.IContributionItem)	 */	public IContributionItem remove(IContributionItem item) {		// TODO Auto-generated method stub		return null;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#remove(java.lang.String)	 */	public IContributionItem remove(String id) {		// TODO Auto-generated method stub		return null;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#removeAll()	 */	public void removeAll() {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IMenuManager#removeMenuListener(org.eclipse.jface.action.IMenuListener)	 */	public void removeMenuListener(IMenuListener listener) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#saveWidgetState()	 */	public void saveWidgetState() {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#setParent(org.eclipse.jface.action.IContributionManager)	 */	public void setParent(IContributionManager parent) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IMenuManager#setRemoveAllWhenShown(boolean)	 */	public void setRemoveAllWhenShown(boolean removeAll) {		// TODO Auto-generated method stub	}	public final void setVisible(final boolean visible) {		final MenuElement element = layoutNode.getMenuElement();		element.setVisible(window, visible);	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#update()	 */	public void update() {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionManager#update(boolean)	 */	public void update(boolean force) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#update(java.lang.String)	 */	public void update(String id) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IMenuManager#updateAll(boolean)	 */	public void updateAll(boolean force) {		// TODO Auto-generated method stub	}}