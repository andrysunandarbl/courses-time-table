/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Admin_Main.java
 *
 * Created on Dec 3, 2011, 12:49:03 AM
 */
package coursetimetable;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author mahmoud
 */
public class AddProDays extends javax.swing.JFrame {
    connect c = new connect();                      //donnect driver class
    procedures prc = new procedures();              //procedures object
    public ResultSet r;                       //data container
    ExtraFunctions extra = new ExtraFunctions();    //object to access the extra functions
    String query;                                   //to get the query in it
    int proID;
    int check;
    int count;                                       //counter
    Professor frame;
    DefaultListModel list1=new DefaultListModel();
    DefaultListModel list2=new DefaultListModel();
    DefaultListModel days=new DefaultListModel();
    

    /** Creates new form Admin_Main */
    public AddProDays(int profID, Professor f) {
      
        this.setLocation(200, 100);
        this.setResizable(false);
        this.setTitle("Add Professor Days Frame");
        proID=profID;
        frame=f;
        
        initComponents();
        try{
            
            query = prc.get_Current_Year();
            r=c.connection(query);
            while(r.next()){
                jLabel2.setText(r.getString(1));
            }
            query = prc.get_Prof_Days(String.valueOf(profID));
            r = c.connection(query);
            while(r.next()){
                days.addElement(r.getString(1));
            }
            jList2.setModel(days);
            
            query=prc.GetWeekDays();
            r=c.connection(query);
            while(r.next()){
                jComboBox1.addItem(r.getString(1));
            }
            query = prc.get_Prof_Days(String.valueOf(profID));
            r=c.connection(query);
            while(r.next()){
                jComboBox1.removeItem(r.getString(1));
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR"+ex.toString());
        }
        jButton45.setVisible(false);
    }
  
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton47 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                Closing(evt);
            }
        });

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(coursetimetable.CourseTimeTableApp.class).getContext().getResourceMap(AddProDays.class);
        jButton47.setText(resourceMap.getString("jButton47.text")); // NOI18N
        jButton47.setToolTipText(resourceMap.getString("jButton47.toolTipText")); // NOI18N
        jButton47.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton47.setName("jButton47"); // NOI18N
        jButton47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton47MouseClicked(evt);
            }
        });
        jPanel2.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 90, 50));

        jButton46.setText(resourceMap.getString("jButton46.text")); // NOI18N
        jButton46.setToolTipText(resourceMap.getString("jButton46.toolTipText")); // NOI18N
        jButton46.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton46.setName("jButton46"); // NOI18N
        jButton46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton46MouseClicked(evt);
            }
        });
        jPanel2.add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 60, 50));

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        jButton45.setText(resourceMap.getString("jButton45.text")); // NOI18N
        jButton45.setToolTipText(resourceMap.getString("jButton45.toolTipText")); // NOI18N
        jButton45.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton45.setName("jButton45"); // NOI18N
        jButton45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton45MouseClicked(evt);
            }
        });
        jPanel2.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 160, 70));

        jLabel4.setText("Add Days"); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 120, 40));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jList1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setName("jList1"); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 220, 90));

        jLabel5.setText("Professor's Available Days"); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel5.setName("jLabel5"); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, 40));

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jList2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.setName("jList2"); // NOI18N
        jScrollPane2.setViewportView(jList2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 220, 90));

        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jComboBox1.setName("jComboBox1"); // NOI18N
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 120, 40));

        jLabel8.setIcon(resourceMap.getIcon("jLabel8.icon")); // NOI18N
        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel8.setName("jLabel8"); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 700, 480));

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setLayout(null);

        jLabel1.setFont(resourceMap.getFont("YearLabel.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("YearLabel.text")); // NOI18N
        jLabel1.setName("YearLabel"); // NOI18N
        jPanel7.add(jLabel1);
        jLabel1.setBounds(10, 20, 140, 40);

        jLabel2.setFont(resourceMap.getFont("Yaer20_label.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("Yaer20_label.text")); // NOI18N
        jLabel2.setName("Yaer20_label"); // NOI18N
        jPanel7.add(jLabel2);
        jLabel2.setBounds(150, 20, 90, 40);

        jLabel9.setIcon(resourceMap.getIcon("jLabel9.icon")); // NOI18N
        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        jPanel7.add(jLabel9);
        jLabel9.setBounds(0, 0, 260, 70);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 260, 70));

        jLabel3.setIcon(resourceMap.getIcon("jLabel3.icon")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 840, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void Closing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Closing
        // TODO add your handling code here:
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_Closing
            //Go Back
    private void jButton46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton46MouseClicked
        // TODO add your handling code here:
        this.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_jButton46MouseClicked
                    //deletes the selected day
    private void jButton47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton47MouseClicked
        // TODO add your handling code here:
        try{
         String s=jList2.getSelectedValue().toString();
         query = prc.GetDayID(s);
         r=c.connection(query);
         String id=null;
         while(r.next()){
             id=r.getString(1);
         }
         query = prc.drop_Prof_Day(String.valueOf(proID), id);
         check=c.UpdateConnection(query);
         if(check == 1)
                JOptionPane.showMessageDialog(null, "Deleted Succefully", "Success Operation", JOptionPane.INFORMATION_MESSAGE);
             else
                JOptionPane.showMessageDialog(null, "Can't be Deleted", "Unsuccess Operation", JOptionPane.INFORMATION_MESSAGE);
         query=prc.get_Prof_Days(String.valueOf(proID));
         r=c.connection(query);
         while(r.next()){
             list2.addElement(r.getString(1));
         }
         jList2.setModel(list2);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR"+ex.toString());
        }
        
    }//GEN-LAST:event_jButton47MouseClicked
            //move the selected day to the list
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
             String s=jComboBox1.getSelectedItem().toString();
       list1.addElement(s);
       jList1.setModel(list1);
       jComboBox1.removeItem(s);
       jButton45.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked
                //saves changes and update professor days
    private void jButton45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton45MouseClicked
        // TODO add your handling code here:
        try{
            if(jList1.isSelectionEmpty()){
                if(jList2.isSelectionEmpty()){
                list1=(DefaultListModel) jList1.getModel();
                Object[] AvailableDays=list1.toArray();
                int [] daysID=new int[AvailableDays.length];
                for(int i=0; i<AvailableDays.length; i++){
                    query=prc.GetDayID(AvailableDays[i].toString());
                    r=c.connection(query);
                    while(r.next()){
                        daysID[i]=Integer.parseInt(r.getString(1));
                    }
                }
                for(int i=0; i<daysID.length; i++){
                    query=prc.ADD_Prof_Day(String.valueOf(proID), String.valueOf(daysID[i]));
                    check = c.UpdateConnection(query);
                }
                if(check == 1 )
                    JOptionPane.showMessageDialog(null, "Updated Succefully", "Success Operation", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Can't be Updated", "Unsuccess Operation", JOptionPane.INFORMATION_MESSAGE);
            }
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR"+ex.toString());
        }
    }//GEN-LAST:event_jButton45MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AddProDays(0, null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
