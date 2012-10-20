/*******************************************************************************
 * Copyright (c) 2012 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ralf Sternberg - initial API and implementation
 *******************************************************************************/
package org.eclipse.e4.ui.workbench.rap;

import java.util.Map;
import org.eclipse.e4.ui.internal.workbench.swt.E4Application;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.rap.rwt.lifecycle.IEntryPoint;
import org.eclipse.rap.rwt.lifecycle.IEntryPointFactory;
import org.eclipse.swt.widgets.Display;


public class E4EntryPointFactory implements IEntryPointFactory {

	private final Map<String, String> properties;

	public E4EntryPointFactory(Map<String, String> properties) {
		this.properties = properties;
	}

	public IEntryPoint create() {
		return new IEntryPoint() {
			public int createUI() {
				Display display = new Display();
				try {
					IApplication application = new E4Application();
					application.start(new E4ApplicationContext(properties));
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				} finally {
					display.dispose();
				}
				return 0;
			}
		};
	}

}
