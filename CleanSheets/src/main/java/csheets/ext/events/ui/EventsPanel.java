package csheets.ext.events.ui;

import csheets.domain.Event;
import csheets.ext.events.EventsController;
import csheets.ext.events.EventsExtension;
import csheets.notification.Notification;
import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Martins
 */
public class EventsPanel extends javax.swing.JPanel implements Observer {

	private EventsController controller;

	/**
	 * Creates new form EventsPanel
	 *
	 * @param uiController The user interface controller.
	 */
	public EventsPanel(UIController uiController) {
		this.setName(EventsExtension.NAME);
		this.initComponents();
		this.controller = new EventsController(uiController, this);
		this.update(null, null);
		Notification.eventInformer().addObserver(this);
		Notification.calendarInformer().addObserver(this);
		Notification.contactInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		clearEventList();
		for (Event event : this.controller.allEvents()) {
			EventsPanelSingle panel = new EventsPanelSingle(this.controller, event);
			this.addEventPanel(panel);
		}
		this.jPanelEvents.revalidate();
		this.jPanelEvents.repaint();

	}

	private void addEventPanel(EventsPanelSingle panel) {
		this.jPanelEvents.add(panel);
		addGridRow();
	}

	/*
    * Deletes all information from event list.
	 */
	private void clearEventList() {
		this.jPanelEvents.removeAll();
		defaultGridRow();
	}

	/*
    * Layout specific: set's the default number of rows (5)
	 */
	private void defaultGridRow() {
		((GridLayout) this.jPanelEvents.getLayout()).setRows(5);
	}

	/*
    * Layout specific: add's a row to the panel's layout (to prevent adding a new colummn).
	 */
	private void addGridRow() {
		GridLayout layout = (GridLayout) this.jPanelEvents.getLayout();
		layout.setRows(layout.getRows() + 1);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAddEvent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelEvents = new javax.swing.JPanel();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jButtonAddEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/add_event.png"))); // NOI18N
        jButtonAddEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEventActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddEvent, java.awt.BorderLayout.EAST);

        jPanelEvents.setLayout(new java.awt.GridLayout(5, 1));
        jScrollPane1.setViewportView(jPanelEvents);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEventActionPerformed
		ManageEvents event = new ManageEvents(this.controller, null);
		int eventOption = JOptionPane.
			showConfirmDialog(null, event, "Create Event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (eventOption == JOptionPane.OK_OPTION) {
			event.createEvent();
		}
    }//GEN-LAST:event_jButtonAddEventActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddEvent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEvents;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
