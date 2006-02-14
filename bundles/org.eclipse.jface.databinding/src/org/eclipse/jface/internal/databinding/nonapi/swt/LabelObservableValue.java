/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jface.internal.databinding.nonapi.swt;

import org.eclipse.jface.internal.databinding.api.observable.value.AbstractObservableValue;
import org.eclipse.jface.internal.databinding.api.observable.value.ValueDiff;
import org.eclipse.swt.widgets.Label;

/**
 * @since 3.2
 * 
 */
public class LabelObservableValue extends AbstractObservableValue {

	private final Label label;

	/**
	 * @param label
	 */
	public LabelObservableValue(Label label) {
		this.label = label;
	}

	public void setValue(final Object value) {
		String oldValue = label.getText();
		label.setText(value == null ? "" : value.toString()); //$NON-NLS-1$
		fireValueChange(new ValueDiff(oldValue, label.getText()));
	}

	public Object doGetValue() {
		return label.getText();
	}

	public Object getValueType() {
		return String.class;
	}
	
}
