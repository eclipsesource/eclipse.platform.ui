/*******************************************************************************
 * Copyright (c) 2008 Angelo Zerr and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 *******************************************************************************/
package org.eclipse.e4.ui.css.swt.selectors;

import org.eclipse.e4.ui.css.core.dom.selectors.IDynamicPseudoClassesHandler;
import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Control;

/**
 * SWT class to manage dynamic pseudo classes handler ...:focus with SWT
 * Control.
 */
public class DynamicPseudoClassesSWTFocusHandler extends
		AbstractDynamicPseudoClassesControlHandler {

	public static final IDynamicPseudoClassesHandler INSTANCE = new DynamicPseudoClassesSWTFocusHandler();

	private static String FOCUS_LISTENER = "org.eclipse.e4.ui.core.css.swt.selectors.FOCUS_LISTENER";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.e4.ui.core.css.swt.selectors.AbstractDynamicPseudoClassesControlHandler#intialize(org.eclipse.swt.widgets.Control,
	 *      org.eclipse.e4.ui.core.css.engine.CSSEngine)
	 */
	protected void intialize(final Control control, final CSSEngine engine) {
		// Create SWT Focus Listener
		FocusListener focusListener = new FocusListener() {
			public void focusGained(FocusEvent e) {
				// control got focus, apply styles
				// into the SWT control
				try {
					engine.applyStyles(control, false, true);
				} catch (Exception ex) {
					engine.handleExceptions(ex);
				}
			}

			public void focusLost(FocusEvent e) {
				try {
					// Set focusLost flag to true
					control.setData("focusLost", Boolean.TRUE);
					// control lost focus, apply styles
					// into the SWT control
					engine.applyStyles(control, false, true);
				} catch (Exception ex) {
					engine.handleExceptions(ex);
				} finally {
					// Set focusLost flag to false
					control.setData("focusLost", null);
				}
			}
		};
		// Register the focus listener into Control Data
		// in order to remove it when dispose method is called.
		control.setData(FOCUS_LISTENER, focusListener);
		// Add the focus listener to the control
		control.addFocusListener(focusListener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.e4.ui.core.css.swt.selectors.AbstractDynamicPseudoClassesControlHandler#dispose(org.eclipse.swt.widgets.Control,
	 *      org.eclipse.e4.ui.core.css.engine.CSSEngine)
	 */
	protected void dispose(Control control, CSSEngine engine) {
		// Get the focus listener registered into control data
		FocusListener focusListener = (FocusListener) control
				.getData(FOCUS_LISTENER);
		if (focusListener != null)
			// remove the focus listener to the control
			control.removeFocusListener(focusListener);
		control.setData(FOCUS_LISTENER, null);
	}
}