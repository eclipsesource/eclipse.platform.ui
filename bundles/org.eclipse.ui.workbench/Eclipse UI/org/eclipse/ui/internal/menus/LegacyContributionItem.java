/******************************************************************************* * Copyright (c) 2006 IBM Corporation and others. * All rights reserved. This program and the accompanying materials * are made available under the terms of the Eclipse Public License v1.0 * which accompanies this distribution, and is available at * http://www.eclipse.org/legal/epl-v10.html * * Contributors: *     IBM Corporation - initial API and implementation ******************************************************************************/package org.eclipse.ui.internal.menus;import org.eclipse.jface.action.IContributionItem;import org.eclipse.jface.action.IContributionManager;import org.eclipse.swt.widgets.Composite;import org.eclipse.swt.widgets.CoolBar;import org.eclipse.swt.widgets.Menu;import org.eclipse.swt.widgets.ToolBar;/** * <p> * A wrapper around the new command-based menu services that speaks in terms of * the old contribution item interface. * </p> * <p> * This class is not intended to be used outside of the * <code>org.eclipse.ui.workbench</code> plug-in. * </p> *  * @since 3.2 *  */final class LegacyContributionItem implements IContributionItem {	/**	 * The layout node representing this contribution item; never	 * <code>null</code>.	 */	private final ILayoutNode node;	/**	 * Constructs a new instance of <code>LegacyContributionItem</code>.	 * 	 * @param node	 *            The node to wrapper; must not be <code>null</code>.	 */	LegacyContributionItem(final ILayoutNode node) {		if (node == null) {			throw new NullPointerException(					"A legacy contribution item requires a non-null layout node"); //$NON-NLS-1$		}		this.node = node;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#dispose()	 */	public void dispose() {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets.Composite)	 */	public void fill(Composite parent) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets.CoolBar,	 *      int)	 */	public void fill(CoolBar parent, int index) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets.Menu,	 *      int)	 */	public void fill(Menu parent, int index) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#fill(org.eclipse.swt.widgets.ToolBar,	 *      int)	 */	public void fill(ToolBar parent, int index) {		// TODO Auto-generated method stub	}	public final String getId() {		return node.getId();	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#isDirty()	 */	public boolean isDirty() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#isDynamic()	 */	public boolean isDynamic() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#isEnabled()	 */	public boolean isEnabled() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#isGroupMarker()	 */	public boolean isGroupMarker() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#isSeparator()	 */	public boolean isSeparator() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#isVisible()	 */	public boolean isVisible() {		// TODO Auto-generated method stub		return false;	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#saveWidgetState()	 */	public void saveWidgetState() {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#setParent(org.eclipse.jface.action.IContributionManager)	 */	public void setParent(IContributionManager parent) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#setVisible(boolean)	 */	public void setVisible(boolean visible) {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#update()	 */	public void update() {		// TODO Auto-generated method stub	}	/*	 * (non-Javadoc)	 * 	 * @see org.eclipse.jface.action.IContributionItem#update(java.lang.String)	 */	public void update(String id) {		// TODO Auto-generated method stub	}		public final String toString() {		final StringBuffer buffer = new StringBuffer();		buffer.append("LegacyContributionItem("); //$NON-NLS-1$		buffer.append(node);		buffer.append(')');		return buffer.toString();	}}