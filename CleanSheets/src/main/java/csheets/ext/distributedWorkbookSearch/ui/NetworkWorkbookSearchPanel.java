/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.distributedWorkbookSearch.ui;

import csheets.ext.distributedWorkbookSearch.NetworkWorkbookSearchExtension;
import csheets.ext.distributedWorkbookSearch.WorkBookDTO;
import csheets.ext.distributedWorkbookSearch.ui.NetworkWorkbookSearchPanel.InstanceResult;
import csheets.framework.ObjectSerialization;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class NetworkWorkbookSearchPanel extends JPanel implements Observer {

	/**
	 * UI Controller
	 */
	private final UIController uiController;

	/**
	 * The distributed workbook search controller
	 */
	private final NetworkWorkbookSearchController controller;

	/**
	 * Workbook name search pattern
	 */
	private String[] searchPattern;

	/**
	 * Task Manager
	 */
	private final TaskManager manager = new TaskManager();

	/**
	 * The search ending task
	 */
	private final Task stopTask;

	/**
	 * The search timeout
	 */
	private static final int SEARCH_TIMEOUT = 120;

	// @IMPROVEMENT: Needs to get the timer from the configuration.
	// Maybe get it through a configuration file?
	private static final int defaultSeconds = 10;

	/**
	 * List of found instances, used to keep track of already conctacted peers
	 */
	private final List<String> instances;

	/**
	 * Request message to deliver to other instances
	 */
	private static final String REQUEST_MESSAGE = "Allow Network Workbook Search?";

	/**
	 * Stores the state of the click in textBox
	 */
	private boolean firstClick = true;

	/**
	 * Preview table Model
	 */
	private DefaultTableModel tableModel;

	private static final String[] COLUMN_NAMES = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	private static final int ROW_COUNT = COLUMN_NAMES.length;

	/**
	 * Results ListModel
	 */
	private DefaultListModel listModel = new DefaultListModel<InstanceResult>();

	/**
	 * Creates new form WBSearchUI
	 *
	 * @param uiController The UIController
	 * @param controller the NetworkWorkbookSearchController
	 */
	public NetworkWorkbookSearchPanel(UIController uiController,
									  NetworkWorkbookSearchController controller) {
		setName(NetworkWorkbookSearchExtension.NAME);
		this.uiController = uiController;
		this.controller = controller;

		// Start the Search request listening service
		this.controller.startUdpService(this, defaultSeconds);
		this.controller.startTcpService(this);

		tableModel = new DefaultTableModel(COLUMN_NAMES, ROW_COUNT);

		initComponents();
		instances = new ArrayList<>();
		jList1.setModel(listModel);

		stopTask = new Task() {
			@Override
			public void fire() {
				stopSearch();
			}
		};

		this.jSearchPattern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (firstClick) {
					jSearchPattern.setText("");
					firstClick = false;
				}
			}
		});

		jToggleButton1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					switchToTableView();
				} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
					jPanel3.setVisible(false);
					jSpreadTitle.setText(" ");
				}
			}

		});
		this.jSpinner.setVisible(false);
		jPanel3.setVisible(false);
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
        jSearchPattern = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jStatusLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jSpinner = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPreviewTable = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jSpreadTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imgPanel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jSearchPattern.setText("Search here by name or content of workbook...");
        jSearchPattern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchPatternActionPerformed(evt);
            }
        });
        jSearchPattern.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSearchPatternKeyReleased(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchButton.setText("Search");
        searchButton.setEnabled(true);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        cancelButton.setEnabled(false);

        jStatusLabel.setText(" ");
        jStatusLabel.setMinimumSize(new Dimension(20,20));

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jList1);

        jSpinner.setText("");
        jSpinner.setIcon(new ImageIcon(
            NetworkWorkbookSearchExtension.class.getResource("res/img/small_spinner.gif")));

    jPreviewTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 204)));
    jPreviewTable.setModel(tableModel);
    jScrollPane1.setViewportView(jPreviewTable);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
            .addGap(0, 0, 0))
    );

    jToggleButton1.setText("Preview");
    jToggleButton1.setEnabled(false);

    jSpreadTitle.setText(" ");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jSpreadTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jToggleButton1)))
            .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSpreadTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2)
                .addComponent(jScrollPane3)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jSearchPattern)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSpinner))
                        .addComponent(jLabel1))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSearchPattern, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(3, 3, 3)
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    add(jPanel1, java.awt.BorderLayout.PAGE_START);

    imgPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    imgPanel.setIcon(new ImageIcon(
        NetworkWorkbookSearchExtension.class.getResource("res/img/spinner.gif")));
imgPanel.setVisible(false);
add(imgPanel, java.awt.BorderLayout.CENTER);
}// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
		// TODO add your handling code here:
		jToggleButton1.setEnabled(true);
    }//GEN-LAST:event_jList1ValueChanged

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		stopSearch();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

		startSearch();

    }//GEN-LAST:event_searchButtonActionPerformed

    private void jSearchPatternKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchPatternKeyReleased
		// TODO add your handling code here:
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!jSearchPattern.getText().isEmpty()) {
				startSearch();
			}
		}
    }//GEN-LAST:event_jSearchPatternKeyReleased

    private void jSearchPatternActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchPatternActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jSearchPatternActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel imgPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable jPreviewTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jSearchPattern;
    private javax.swing.JLabel jSpinner;
    private javax.swing.JLabel jSpreadTitle;
    private javax.swing.JLabel jStatusLabel;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

	private void startSearch() {
		String wordToSearch = this.jSearchPattern.getText();
		this.searchPattern = wordToSearch.split(";");
		for (int i = 0; i < searchPattern.length; i++) {
			if (!this.searchPattern[i].isEmpty()) {
				this.jStatusLabel.setForeground(Color.BLACK);
				this.jStatusLabel.setText("Search in progress...");
				this.listModel.clear();
				switchToSpinnerView();
				this.cancelButton.setEnabled(true);
				this.searchButton.setEnabled(false);

				this.controller.restartUdpService(this, defaultSeconds);
				this.controller.discoverInstances(defaultSeconds);
				this.controller.restartTcpService(this);

				manager.after(SEARCH_TIMEOUT).once(stopTask);
			}
		}
	}

	private void stopSearch() {
		System.out.println("Stopping services...");
		this.controller.stopServices();
		this.instances.clear();
		this.cancelButton.setEnabled(false);
		this.searchButton.setEnabled(true);
		this.stopTask.kill();
		if (listModel.isEmpty()) {
			jStatusLabel.setForeground(Color.RED);
			jStatusLabel.setText("Search timeout");
			switchToCleanView();
		} else {
			jStatusLabel.setText(this.listModel.size() + " Result(s) found");
			jSpinner.setVisible(false);
			imgPanel.setVisible(false);
		}
	}

	private void updatePreviewTable() {
		Object selected = jList1.getSelectedValue();
		if (!(selected instanceof InstanceResult)) {
			System.out.println("Unknown Object...");
			return;
		}
		InstanceResult selectedResult = (InstanceResult) jList1.
			getSelectedValue();
		generatePreviewTableModel(selectedResult.workbook.cells.get(0));
		this.jSpreadTitle.
			setText("<html><font color=\"rgb(128,128,128)\">SpreadSheet:</font>  " + selectedResult.workbook.spreadsheets.
				get(0) + "</html>");
	}

	private void generatePreviewTableModel(String[][] cells) {
		tableModel.setDataVector(cells, COLUMN_NAMES);
	}

	private void switchToCleanView() {
		jPanel3.setVisible(false);
		imgPanel.setVisible(false);
		jSpinner.setVisible(false);
	}

	private void switchToSpinnerView() {
		jPanel3.setVisible(false);
		imgPanel.setVisible(true);
		jSpinner.setVisible(true);
	}

	private void switchToTableView() {
		updatePreviewTable();
		imgPanel.setVisible(false);
		jPanel3.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (arg instanceof String) { // Permission response received

			for (int i = 0; i < this.searchPattern.length; i++) {
				String target = (String) arg;
				System.out.
					println("Resquesting search from " + target + " for '" + this.searchPattern[i] + "'");
				this.controller.initiateSearch(target, this.searchPattern[i]);
				System.out.println(searchPattern[i]);
			}

		} else if (arg instanceof Map) { // New search Result

			System.out.println("Result received...");
			HashMap<String, Object> result = (HashMap<String, Object>) arg;
			String instance = (String) result.get("instance");
			WorkBookDTO workbook = (WorkBookDTO) result.get("dto");
			InstanceResult instanceResult = new InstanceResult(instance, workbook);
			if (!this.listModel.contains(instanceResult)) {
				this.listModel.addElement(instanceResult);
			}

		} else if (arg instanceof List) { // New instance discovered

			System.out.println("Got new address........");
			// List<String> adresses changed!
			List<String> addresses = (List<String>) arg;
			for (String address : addresses) {
				if (!this.instances.contains(address)) {
					System.out.println("This is a new address: " + address);
					this.instances.add(address);
					this.controller.requestPermission(address, REQUEST_MESSAGE);
				} else {
					System.out.println(address + " was already contacted!");
				}
			}

		} else if (arg instanceof String[]) { // Search request received

			String[] search = (String[]) arg;
			String pattern = search[1];
			String from = search[2];
			System.out.
				println("Received search request from " + from + " to look for " + pattern);
			List<WorkBookDTO> results = this.controller.
				newLocalSearch(uiController, search[1]);
			if (results == null || results.isEmpty()) {
				System.out.println("No results on local search");
				return;
			}
			for (WorkBookDTO result : results) {
				String serializedResult;
				try {
					serializedResult = ObjectSerialization.
						toString(result);
				} catch (Exception ex) {
					Logger.getLogger(NetworkWorkbookSearchPanel.class.
						getName()).
						log(Level.SEVERE, null, ex);
					return;
				}
				try {
					this.controller.
						sendSearchResult(search[2], serializedResult);
				} catch (NullPointerException ex) {
					// This is probably due to a timed out request
				}
			}

		}
	}

	/**
	 * Inner class used to create objects for ListModel
	 */
	class InstanceResult {

		public final String instance;

		public final WorkBookDTO workbook;

		public InstanceResult(String instance, WorkBookDTO workbook) {
			this.instance = instance;
			this.workbook = workbook;
		}

		@Override
		public String toString() {
			return instance + ":   '" + workbook.name + "'";
		}
	}

}
