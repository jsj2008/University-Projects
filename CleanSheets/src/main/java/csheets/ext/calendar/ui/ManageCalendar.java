package csheets.ext.calendar.ui;

import csheets.domain.ContactCalendar;
import csheets.domain.Contact;
import csheets.ext.calendar.CalendarController;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author João Martins 1131190
 */
public class ManageCalendar extends javax.swing.JPanel implements Observer {

	private CalendarController controller;
	private ContactCalendar calendar;
	private List<Contact> listContacts = new ArrayList();

	/**
	 * Creates new form NewJPanel
	 *
	 * @param controller The events controller.
	 * @param calendar calendar
	 */
	public ManageCalendar(CalendarController controller,
						  ContactCalendar calendar) {
		this.controller = controller;
		this.calendar = calendar;
		initComponents();
		initContact();
		this.update(null, this.calendar);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (this.calendar != null) {
			this.jComboBoxContacts.setSelectedItem(this.calendar.getContact());
			this.jTextFieldName.setText(this.calendar.getName());
			this.jTextFieldDescription.setText(this.calendar.getText());
			this.jPanelColour.setBackground(this.calendar.getColor());
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        managePanel = new javax.swing.JPanel();
        jLabelContact = new javax.swing.JLabel();
        jComboBoxContacts = new javax.swing.JComboBox<>();
        nameLabel = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        colourLabel = new javax.swing.JLabel();
        jPanelColour = new javax.swing.JPanel();
        descriptionLabel = new javax.swing.JLabel();
        jTextFieldDescription = new javax.swing.JTextField();

        managePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calendar Manager", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabelContact.setText("Contact:");

        jComboBoxContacts.setFocusable(false);
        jComboBoxContacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxContactsActionPerformed(evt);
            }
        });

        nameLabel.setText("Name:");

        colourLabel.setText("Colour:");

        jPanelColour.setBackground(new java.awt.Color(51, 153, 0));
        jPanelColour.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelColour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelColourMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelColourLayout = new javax.swing.GroupLayout(jPanelColour);
        jPanelColour.setLayout(jPanelColourLayout);
        jPanelColourLayout.setHorizontalGroup(
            jPanelColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanelColourLayout.setVerticalGroup(
            jPanelColourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        descriptionLabel.setText("Description:");

        javax.swing.GroupLayout managePanelLayout = new javax.swing.GroupLayout(managePanel);
        managePanel.setLayout(managePanelLayout);
        managePanelLayout.setHorizontalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel)
                    .addComponent(nameLabel)
                    .addComponent(jLabelContact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBoxContacts, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(managePanelLayout.createSequentialGroup()
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colourLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldDescription))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        managePanelLayout.setVerticalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managePanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContact)
                    .addComponent(jComboBoxContacts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(managePanelLayout.createSequentialGroup()
                        .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel)
                            .addComponent(colourLabel))
                        .addGap(18, 18, 18)
                        .addGroup(managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionLabel)
                            .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxContacts.getAccessibleContext().setAccessibleParent(jLabelContact);
        jTextFieldName.getAccessibleContext().setAccessibleParent(nameLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(managePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(managePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelColourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelColourMouseClicked
		JColorChooser colorChooser = new JColorChooser();
		colorChooser.setColor(this.jPanelColour.getBackground());
		JPanel panel = new JPanel();
		panel.add(colorChooser);
		int result = JOptionPane.
			showConfirmDialog(null, panel, "Please choose the color for the calendar:", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			this.jPanelColour.setBackground(colorChooser.getColor());
		}
    }//GEN-LAST:event_jPanelColourMouseClicked

    private void jComboBoxContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxContactsActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxContactsActionPerformed

	private void initContact() {
		for (Contact contact : this.controller.allContacts()) {
			this.listContacts.add(contact);
			this.jComboBoxContacts.addItem(contact.toString());
		}
	}

	public void createCalendar() {
		if (this.calendar == null) {
			try {
				this.controller.
					createCalendar((Contact) this.listContacts.
						get(this.jComboBoxContacts.getSelectedIndex()), this.jTextFieldName.
								   getText(), this.jTextFieldDescription.
								   getText(), this.jPanelColour.getBackground());
			} catch (DataIntegrityViolationException ex) {
				JOptionPane.
					showMessageDialog(null, "Calendar already exists!", "Calendar edition", JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException ex) {
				JOptionPane.
					showMessageDialog(null, "Illegal arguments!", "Calendar edition", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			this.calendar.
				defineCalendar(this.calendar.getContact(), this.jTextFieldName.
							   getText(), this.jTextFieldDescription.getText(), this.jPanelColour.
							   getBackground());
			this.controller.editCalendar(this.calendar);
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel colourLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JComboBox<String> jComboBoxContacts;
    private javax.swing.JLabel jLabelContact;
    private javax.swing.JPanel jPanelColour;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JPanel managePanel;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
