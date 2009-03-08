package org.eclipse.ui.about;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * An installation dialog page.
 * 
 * <em>This API is experimental and will change before 3.5 ships</em>
 * 
 * @since 3.5
 */
public abstract class InstallationPage extends DialogPage {

	private IInstallationPageContainer container;

	/**
	 * Sets or clears the message for this page.
	 * <p>
	 * This message has no effect when the receiver is used in an
	 * IInstallationPageContainer.
	 * </p>
	 * 
	 * @param newMessage
	 *            the message, or <code>null</code> to clear the message
	 */
	public void setMessage(String newMessage) {
		super.setMessage(newMessage);
	}

	/**
	 * Sets the message for this page with an indication of what type of message
	 * it is.
	 * <p>
	 * The valid message types are one of <code>NONE</code>,
	 * <code>INFORMATION</code>,<code>WARNING</code>, or <code>ERROR</code>.
	 * </p>
	 * <p>
	 * This message has no effect when the receiver is used in an
	 * IInstallationPageContainer.
	 * </p>
	 * 
	 * @param newMessage
	 *            the message, or <code>null</code> to clear the message
	 * @param newType
	 *            the message type
	 * @since 2.0
	 */
	public void setMessage(String newMessage, int newType) {
		super.setMessage(newMessage, newType);
	}

	public void setPageContainer(IInstallationPageContainer container) {
		this.container = container;
	}

	/**
	 * Create the buttons that belong to this page using the specified parent.
	 * 
	 * @param parent
	 *            the parent to use for the buttons.
	 * 
	 * @see #createButton(Composite, int, String)
	 * @see #buttonPressed(int)
	 */
	public void createPageButtons(Composite parent) {
		// By default, there are no page-specific buttons
	}

	/**
	 * Creates a new button with the given id.
	 * <p>
	 * This method creates a standard push button, registers it for selection
	 * events, and registers it as a button belonging to this page. Subclasses
	 * should not make any assumptions about the visibility, layout, or
	 * presentation of this button inside the dialog.
	 * </p>
	 * 
	 * @param parent
	 *            the parent composite
	 * @param id
	 *            the id of the button (see <code>IDialogConstants.*_ID</code>
	 *            constants for standard dialog button ids)
	 * @param label
	 *            the label from the button
	 * @return the new button
	 * 
	 * @see #createPageButtons(Composite)
	 * @see #buttonPressed(int)
	 */
	protected Button createButton(Composite parent, int id, String label) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(label);
		button.setData(new Integer(id));
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				buttonPressed(((Integer) event.widget.getData()).intValue());
			}
		});
		container.registerPageButton(this, button);
		return button;
	}

	/**
	 * Notifies that this page's button with the given id has been pressed.
	 * Subclasses should extend this method to handle the buttons created in
	 * {@link #createButton(Composite, int, String)}
	 * 
	 * @param buttonId
	 *            the id of the button that was pressed (see
	 *            <code>IDialogConstants.*_ID</code> constants)
	 */
	protected void buttonPressed(int buttonId) {
	}

	protected IInstallationPageContainer getPageContainer() {
		return container;
	}

}