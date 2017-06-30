/**
 * This Java Class is part of the Impro-Visor Application.
 *
 * Copyright (C) 2005-2015 Robert Keller and Harvey Mudd College.
 *
 * Impro-Visor is free software; you can redistribute it and/or modifyc it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * Impro-Visor is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of merchantability or fitness
 * for a particular purpose. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Impro-Visor; if not, write to the Free Software Foundation, Inc., 51 Franklin
 * St, Fifth Floor, Boston, MA 02110-1301 USA
 */

/*
 * IntervalLearningFrame.java
 *@author Mikayla Konst 2015
 * Created on July 27, 2015, 4:57:53 PM
 */

package imp.gui;
import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntervalLearningFrame
        extends javax.swing.JDialog
        implements imp.Constants {

    
    private final Notate notate;
    
    private final IntervalLearningPanel intervalLearningTab;
    /**
     * Creates new LickgenFrame
     * @param notate The notate this interval learning frame was spawned from
     */
    public IntervalLearningFrame(Notate notate){
        this.notate = notate;
        initComponents();
        intervalLearningTab = new IntervalLearningPanel(notate);
        intervalLearningPanelHolder.add(intervalLearningTab, new GridLayout(1, 1, 1, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        transformPane = new javax.swing.JTabbedPane();
        intervalLearningPanelHolder = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        transformMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();
        addFromFile = new javax.swing.JMenuItem();
        saveFile = new javax.swing.JMenuItem();
        generatorWindowMenu1 = new javax.swing.JMenu();
        closeWindowMI2 = new javax.swing.JMenuItem();
        cascadeMI2 = new javax.swing.JMenuItem();
        windowMenuSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Interval Learning Controls");
        setMinimumSize(new java.awt.Dimension(1000, 850));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                closeWindow(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        transformPane.setBackground(new java.awt.Color(218, 215, 215));
        transformPane.setMinimumSize(new java.awt.Dimension(1200, 700));
        transformPane.setPreferredSize(new java.awt.Dimension(1200, 700));

        intervalLearningPanelHolder.setLayout(new java.awt.GridLayout(1, 0));
        transformPane.addTab("Interval Learning", intervalLearningPanelHolder);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Help For Interval Learning:\n\nAbout Interval Learning\n\tWhat is Interval Learning?\n\t\tInterval Learning is the process of learning the probabilities with which certain intervals\n\t\tare followed by other intervals in a solo or a collection of solos. These transition probabilities\n\t\tcan be used to form an abstract structure called a Markov Chain. A Markov chain is a graph composed of nodes and edges.\n\t\tIt is traversed by moving from node to node via weighted edges. Edges with higher weights are more likely to be traversed.\n\t\tIn our graph, the nodes represent intervals and the edges carry weights corresponding to transition probabilities.\n\n\tWhy is it Useful?\n\t\tInterval learning is useful for both practical and pedagogical reasons.\n\t\tFrom a practical standpoint, interval learning is useful because it can be used to create original improvisation.\n\t\tFrom a pedagogical standpoint, interval learning is useful because it can reveal certain musical insights.\n\t\tFor example, the trend that large leaps are often followed by stepwise motion in the opposite direction can be\n\t\taccurately captured by interval learning.\n\nReading the Source -> Destination Table\n\tTo read a probability off the Source -> Destination Table, follow these steps:\n\t\t1.\n\t\t\tStart on the left-hand side of the table. Choose a source interval that you are interested in.\n\t\t\tIntervals are described by their direction and their size in semitones. \n\t\t\t(For example, -2 corresponds to moving down by a whole step.)\n\t\t2.\n\t\t\tNow look at the top edge of the table. Choose a destination interval that you are interested in.\n\t\t\tMove to the right across the row containing your source interval until you land in the column\n\t\t\tcontaining your destination interval. The probability in that cell represents the probabiliity\n\t\t\tthat your source interval will be followed by your destination interval.\n\nLoading & Saving Files\n\tTo load or save files, open the File Menu in the upper left corner.\n\tYou will be presented with the following options:\n\t\tNew\n\t\t\tCreate a new file. (NOTE: Any unsaved changes will be lost.)\n\t\tOpen\n\t\t\tOpen a file saved in your counts directory. (NOTE: Any unsaved changes will be lost.)\n\t\tAdd From...\n\t\t\tAdd probabiliites from a file in your .counts directory to the running total.\n\t\tSave\n\t\t\tSave the current file to your counts directory. You will be prompted for a filename.\n\nLearn Interval Probabilities\n\tAdd to total?\n\t\tYes\n\t\t\tWhen this option is selected, every time you learn from a solo,\n\t\t\tthe interval probabilities learned will be added to the running total.\n\t\tNo\n\t\t\tWhen this option is selected, every time you learn from a solo,\n\t\t\tthe interval probabilities learned will replace the old interval probabilities.\n\tLearn from:\n\t\tThis Chorus\n\t\t\tWhen this option is selected, interval probabilities will be learned from\n\t\t\tonly the chorus that you're currently looking at.\n\t\tAll Choruses\n\t\t\tWhen this option is selected, interval probabilities will be learned from\n\t\t\tall the choruses in the leadsheet.\n\tLearn!\n\t\tClick this button to learn interval probabilities.\n\tStart Over\n\t\tClick this button to clear all interval probabilities.\n\nView Options\n\tToggle View:\n\t\tProbabilities / Counts\n\t\t\tProbabilities\n\t\t\t\tWhen this option is selected, the probabilities of moving from\n\t\t\t\tany source interval to any destination interval will be displayed.\n\t\t\tCounts\n\t\t\t\tWhen this option is selected, the number of times that\n\t\t\t\tany source interval moved to any destination interval\n\t\t\t\tin the solo(s) that were learned from will be displayed.\n\t\tFirst Order / Second Order\n\t\t\tFirst Order\n\t\t\t\tWhen this option is selected, the probabilities or counts\n\t\t\t\tcorresponding to the source interval moving to the destination interval will be displayed.\n\t\t\tSecond Order\n\t\t\t\tWhen this option is selected, the 1st Source Interval Slider will become activated.\n\t\t\t\tThe probabilities or counts corresponding to the 1st source interval moving to the source\n\t\t\t\tinterval and then to the destination interval will be displayed.\n\t1st Source Interval:\n\t\tThis slider will become activated if you toggle the First Order / Second Order button to Second Order.\n\t\tDragging this slider left or right will change the display to correspond to the probabilities associated with\n\t\tmoving from the 1st source interval to the source interval on the left to the destination interval on the top.\n\nSolo Options\n\tChoose Range\n\t\tClicking this button will open a window containing a piano that will allow you to select a range for your solo.\n\tMerge Same Notes\n\t\tChecking this box will merge consecutive notes that have the same pitch.\n\tRectify\n\t\tChecking this box will rectify your solo.\n\tChord, Color, Approach\n\t\tYou can check any combination of these boxes to indicate which types of notes you'd like to rectify your solo to.\n\t\tThe default setting is to rectify to chord and approach tones.\n\t\t\nGenerate Solo\n\tRhythm\n\t\tEighths\n\t\t\tThis will generate a solo composed only of eighth notes.\n\t\tChorus 1\n\t\t\tThis will generate a solo that has the same rhythm as Chorus 1.\n\t\tGrammar\n\t\t\tThis will generate a solo with a rhythm created by the grammar that is currently selected in the main window.\n\tOrder\n\t\tFirst\n\t\t\tSelect this option to generate a solo using a first-order Markov chain.\n\t\t\tThis option works best when you have not learned very many probabilities.\n\t\tSecond\n\t\t\tSelect this option to generate a solo using a second-order Markov chain.\n\t\t\tThis option works best when you have learned a lot of probabilities.\n\tGenerate Solo\n\t\tClick this button to generate and play a solo based on interval probabilities!");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        transformPane.addTab("Help", jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(transformPane, gridBagConstraints);

        transformMenuBar.setMinimumSize(new java.awt.Dimension(115, 23));

        fileMenu.setMnemonic('G');
        fileMenu.setText("File");
        fileMenu.setToolTipText("Edit or change the current counts file.");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        newFile.setText("New");
        newFile.setToolTipText("Create a new counts file.");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        fileMenu.add(newFile);

        openFile.setText("Open");
        openFile.setToolTipText("Load a counts file.");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        fileMenu.add(openFile);

        addFromFile.setText("Add From...");
        addFromFile.setToolTipText("Add from a counts file.");
        addFromFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFromFileActionPerformed(evt);
            }
        });
        fileMenu.add(addFromFile);

        saveFile.setText("Save");
        saveFile.setToolTipText("Save the current counts file.");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        fileMenu.add(saveFile);

        transformMenuBar.add(fileMenu);

        generatorWindowMenu1.setLabel("Window");
        generatorWindowMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                generatorWindowMenu1MenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });

        closeWindowMI2.setMnemonic('C');
        closeWindowMI2.setText("Close Window");
        closeWindowMI2.setToolTipText("Closes the current window (exits program if there are no other windows)");
        closeWindowMI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeWindowMI2ActionPerformed(evt);
            }
        });
        generatorWindowMenu1.add(closeWindowMI2);

        cascadeMI2.setMnemonic('A');
        cascadeMI2.setText("Cascade Windows");
        cascadeMI2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cascadeMI2ActionPerformed(evt);
            }
        });
        generatorWindowMenu1.add(cascadeMI2);
        generatorWindowMenu1.add(windowMenuSeparator2);

        transformMenuBar.add(generatorWindowMenu1);

        setJMenuBar(transformMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

                        private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed
                            // TODO add your handling code here:
                        }//GEN-LAST:event_fileMenuActionPerformed

                        private void closeWindowMI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeWindowMI2ActionPerformed
                            closeWindow();
                        }//GEN-LAST:event_closeWindowMI2ActionPerformed
    public void closeWindow() {
        this.setVisible(false);

        WindowRegistry.unregisterWindow(this);
    }
                        private void cascadeMI2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cascadeMI2ActionPerformed
                            WindowRegistry.cascadeWindows(this);
                        }//GEN-LAST:event_cascadeMI2ActionPerformed

                        private void generatorWindowMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_generatorWindowMenu1MenuSelected

                            generatorWindowMenu1.removeAll();

                            generatorWindowMenu1.add(closeWindowMI2);

                            generatorWindowMenu1.add(cascadeMI2);

                            generatorWindowMenu1.add(windowMenuSeparator2);

                            for (WindowMenuItem w : WindowRegistry.getWindows()) {

                                generatorWindowMenu1.add(w.getMI(this));      // these are static, and calling getMI updates the name on them too in case the window title changed
                            }

                            generatorWindowMenu1.repaint();

                        }//GEN-LAST:event_generatorWindowMenu1MenuSelected

                        private void closeWindow(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeWindow
                            closeWindow();
                        }//GEN-LAST:event_closeWindow

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        intervalLearningTab.newFile();
    }//GEN-LAST:event_newFileActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        try {
            intervalLearningTab.open();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IntervalLearningPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void addFromFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFromFileActionPerformed
        try {
            intervalLearningTab.addFromFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IntervalLearningPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addFromFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        try {
            intervalLearningTab.saveCounts();
        } catch (IOException ex) {
            Logger.getLogger(IntervalLearningPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveFileActionPerformed

    public void intervalImprovise(){
        intervalLearningTab.generateSolo();
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addFromFile;
    private javax.swing.JMenuItem cascadeMI2;
    private javax.swing.JMenuItem closeWindowMI2;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu generatorWindowMenu1;
    private javax.swing.JPanel intervalLearningPanelHolder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JMenuBar transformMenuBar;
    private javax.swing.JTabbedPane transformPane;
    private javax.swing.JSeparator windowMenuSeparator2;
    // End of variables declaration//GEN-END:variables

}
