/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.email.ui;

import csheets.notification.Notification;

/**
 *
 * @author João Martins
 */
public class EmailInstancePanel extends javax.swing.JPanel {

	private String destination;

	private String subject;

	/**
	 * Body of the email.
	 */
	private String body;

	/**
	 * Creates new form EmailInstancePanel
	 *
	 * @param destination email destination
	 * @param subject subject of email
	 * @param body body of email
	 */
	public EmailInstancePanel(String destination, String subject, String body) {
		initComponents();
		this.destinationText.setText(destination);
		this.destinationText.setEditable(false);
		this.destination = destination;
		this.subjectText.setText(subject);
		this.subjectText.setEditable(false);
		this.subject = subject;
		this.body = body;
		Notification.emailInformer().notifyChange(this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        destinationLabel = new javax.swing.JLabel();
        subjectLabel = new javax.swing.JLabel();
        destinationText = new javax.swing.JTextField();
        subjectText = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        destinationLabel.setText("Destination:");

        subjectLabel.setText("Subject:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(destinationLabel)
                    .addComponent(subjectLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(subjectText, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(destinationText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationLabel)
                    .addComponent(destinationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(subjectText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
		if (evt.getClickCount() == 2) {
			new PreviewSentEmailFrame(this.destination, this.subject, this.body).
				setVisible(true);
		}
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JTextField destinationText;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JTextField subjectText;
    // End of variables declaration//GEN-END:variables
}