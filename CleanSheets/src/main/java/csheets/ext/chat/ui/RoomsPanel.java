/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chat.ui;

import csheets.ext.chat.ChatController;
import csheets.ext.chat.domain.Room;
import csheets.notification.Notification;
import java.awt.GridLayout;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class RoomsPanel extends javax.swing.JPanel implements Observer {

	private ChatController controller;
	private JPanel jPanelColor;
	private JScrollPane jScrollPane;

	/**
	 * Creates new form ChatPanel
	 */
	public RoomsPanel(ChatController controller) {
		this.controller = controller;
		this.initComponents();
		this.jScrollPane = new JScrollPane(this.jPanelRooms);
		Notification.chatMessageInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Map) {

			Map<String, String> data = (Map) arg;
			/*
			for (Entry entry : data.entrySet()) {
				System.out.
					println("update - key: " + entry.getKey() + " - value: " + entry.
						getValue());
			}
			 */
			if (data.get("reference").equals("publicRoom")) {
				this.controller.
					addRoom(data.get("name"), data.get("creator"), false);
			}

			/*
			if (data.get("reference").equals("chatMessage")) {
				((Map) messageData).remove("reference");
				String message = (String) ((Map) messageData).get("message");
				String fromIP = ((String) ((Map) messageData).get("nickname")).
					split(":")[0];
				String chatMessage = "Received from " + fromIP + ": " + message;
				new TimedPopupMessageDialog(null, chatMessage);
				receivedMessage(fromIP, message);
				this.chatAppController.
					addMessage(message, fromIP, ChatMessage.MessageType.RECEIVED);
			}
			 */
			this.jPanelRooms.removeAll();
			this.jPanelRooms.setLayout(new GridLayout(5, 1));
			for (Room room : this.controller.rooms()) {
				//if (!addUser.equals(this.controller.name())) {
				RoomsPanelSingle panel = new RoomsPanelSingle(this.controller, room);
				this.jPanelRooms.add(panel);
				GridLayout layout = (GridLayout) this.jPanelRooms.
					getLayout();
				layout.setRows(layout.getRows() + 1);
				//}
			}
			this.jPanelRooms.revalidate();
			this.jPanelRooms.repaint();
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

        jPanelRooms = new javax.swing.JPanel();
        jButtonCreate = new javax.swing.JButton();
        jLabelRooms = new javax.swing.JLabel();

        jPanelRooms.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelRoomsLayout = new javax.swing.GroupLayout(jPanelRooms);
        jPanelRooms.setLayout(jPanelRoomsLayout);
        jPanelRoomsLayout.setHorizontalGroup(
            jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        jPanelRoomsLayout.setVerticalGroup(
            jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jButtonCreate.setText("Create Room");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jLabelRooms.setText("Rooms:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRooms)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCreate))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCreate)
                    .addComponent(jLabelRooms))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
		new RoomManage(this.controller);
    }//GEN-LAST:event_jButtonCreateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JLabel jLabelRooms;
    private javax.swing.JPanel jPanelRooms;
    // End of variables declaration//GEN-END:variables
}
