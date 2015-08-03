/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.gui;

import imp.ImproVisor;
import imp.com.CommandManager;
import imp.com.RectifyPitchesCommand;
import imp.data.Fractal;
import imp.data.Leadsheet;
import imp.data.MelodyPart;
import imp.util.ErrorLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import polya.Polylist;

/**
 *
 * @author clessard
 */
public class FractalFrame extends javax.swing.JFrame {
    private final Notate notate;
    private final CommandManager cm;
    
    private String EXTENSION = ".fractal";
    private JFileChooser chooser;
    private String filename;
    
    private Fractal fractal;
    
    /**
     * Creates new form FractalFrame
     */
    public FractalFrame(Notate notate, CommandManager cm) {
        this.notate = notate;
        this.cm = cm;
        
        this.setTitle("Fractal Improvisation");
        
        initComponents();
        
        // set the file chooser and add the detection of overriding a file
        chooser = new JFileChooser(){
            @Override
            public void approveSelection(){
                File f = getSelectedFile();
                if(!f.getAbsolutePath().endsWith(EXTENSION))
                    f = new File(f.getAbsolutePath()+EXTENSION);
                if(f.exists() && getDialogType() == SAVE_DIALOG){
                    int result = JOptionPane.showConfirmDialog(this,
                                                               "The file exists, overwrite?",
                                                               "Existing file",
                                                               JOptionPane.YES_NO_CANCEL_OPTION);
                    switch(result){
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            return;
                        case JOptionPane.NO_OPTION:
                            return;
                        case JOptionPane.CLOSED_OPTION:
                            return;
                        case JOptionPane.CANCEL_OPTION:
                            cancelSelection();
                            return;
                    }
                }
                super.approveSelection();
            }        
        };
        
        chooser.setCurrentDirectory(ImproVisor.getFractalDirectory());
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fractal Files",
                                                                     "fractal");
        chooser.setFileFilter(filter);
        
        filename = "My.fractal";
       
        this.fractal = new Fractal(ImproVisor.getFractalFile());
        setTextBoxes();
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

        probabilitiesPanel = new javax.swing.JPanel();
        divProbPanel = new javax.swing.JPanel();
        wholeDivLabel = new javax.swing.JLabel();
        halfDivLabel = new javax.swing.JLabel();
        quarterDivLabel = new javax.swing.JLabel();
        eighthDivLabel = new javax.swing.JLabel();
        sixteenthDivLabel = new javax.swing.JLabel();
        defaultDivLabel = new javax.swing.JLabel();
        wholeDivText = new javax.swing.JTextField();
        halfDivText = new javax.swing.JTextField();
        quarterDivText = new javax.swing.JTextField();
        eighthDivText = new javax.swing.JTextField();
        sixteenthDivText = new javax.swing.JTextField();
        defaultDivText = new javax.swing.JTextField();
        restProbPanel = new javax.swing.JPanel();
        wholeRestLabel = new javax.swing.JLabel();
        halfRestLabel = new javax.swing.JLabel();
        quarterRestLabel = new javax.swing.JLabel();
        eighthRestLabel = new javax.swing.JLabel();
        sixteenthRestLabel = new javax.swing.JLabel();
        defaultRestLabel = new javax.swing.JLabel();
        wholeRestText = new javax.swing.JTextField();
        halfRestText = new javax.swing.JTextField();
        quarterRestText = new javax.swing.JTextField();
        eighthRestText = new javax.swing.JTextField();
        sixteenthRestText = new javax.swing.JTextField();
        defaultRestText = new javax.swing.JTextField();
        numDivPanel = new javax.swing.JPanel();
        doubleLabel = new javax.swing.JLabel();
        tripleLabel = new javax.swing.JLabel();
        fiveLabel = new javax.swing.JLabel();
        doubleText = new javax.swing.JTextField();
        tripleText = new javax.swing.JTextField();
        fiveText = new javax.swing.JTextField();
        dividingPanel = new javax.swing.JPanel();
        numDivisionsSpinner = new javax.swing.JSpinner();
        multDivideButton = new javax.swing.JButton();
        singleDivideButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openFileMI = new javax.swing.JMenuItem();
        saveFileMI = new javax.swing.JMenuItem();

        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(800, 400));
        setSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        probabilitiesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Probabilities"));
        probabilitiesPanel.setPreferredSize(new java.awt.Dimension(700, 266));
        probabilitiesPanel.setLayout(new java.awt.GridBagLayout());

        divProbPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Division"));
        divProbPanel.setLayout(new java.awt.GridBagLayout());

        wholeDivLabel.setText("Whole Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        divProbPanel.add(wholeDivLabel, gridBagConstraints);

        halfDivLabel.setText("Half Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        divProbPanel.add(halfDivLabel, gridBagConstraints);

        quarterDivLabel.setText("Quarter Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        divProbPanel.add(quarterDivLabel, gridBagConstraints);

        eighthDivLabel.setText("Eighth Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        divProbPanel.add(eighthDivLabel, gridBagConstraints);

        sixteenthDivLabel.setText("Sixteenth Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        divProbPanel.add(sixteenthDivLabel, gridBagConstraints);

        defaultDivLabel.setText("Default");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        divProbPanel.add(defaultDivLabel, gridBagConstraints);

        wholeDivText.setMinimumSize(new java.awt.Dimension(50, 28));
        wholeDivText.setPreferredSize(new java.awt.Dimension(50, 28));
        divProbPanel.add(wholeDivText, new java.awt.GridBagConstraints());

        halfDivText.setMinimumSize(new java.awt.Dimension(50, 28));
        halfDivText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        divProbPanel.add(halfDivText, gridBagConstraints);

        quarterDivText.setMinimumSize(new java.awt.Dimension(50, 28));
        quarterDivText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        divProbPanel.add(quarterDivText, gridBagConstraints);

        eighthDivText.setMinimumSize(new java.awt.Dimension(50, 28));
        eighthDivText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        divProbPanel.add(eighthDivText, gridBagConstraints);

        sixteenthDivText.setMinimumSize(new java.awt.Dimension(50, 28));
        sixteenthDivText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        divProbPanel.add(sixteenthDivText, gridBagConstraints);

        defaultDivText.setMinimumSize(new java.awt.Dimension(50, 28));
        defaultDivText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        divProbPanel.add(defaultDivText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 50);
        probabilitiesPanel.add(divProbPanel, gridBagConstraints);

        restProbPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Rest"));
        restProbPanel.setLayout(new java.awt.GridBagLayout());

        wholeRestLabel.setText("Whole Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        restProbPanel.add(wholeRestLabel, gridBagConstraints);

        halfRestLabel.setText("Half Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        restProbPanel.add(halfRestLabel, gridBagConstraints);

        quarterRestLabel.setText("Quarter Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        restProbPanel.add(quarterRestLabel, gridBagConstraints);

        eighthRestLabel.setText("Eighth Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        restProbPanel.add(eighthRestLabel, gridBagConstraints);

        sixteenthRestLabel.setText("Sixteenth Note");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        restProbPanel.add(sixteenthRestLabel, gridBagConstraints);

        defaultRestLabel.setText("Default");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        restProbPanel.add(defaultRestLabel, gridBagConstraints);

        wholeRestText.setMinimumSize(new java.awt.Dimension(50, 28));
        wholeRestText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        restProbPanel.add(wholeRestText, gridBagConstraints);

        halfRestText.setMinimumSize(new java.awt.Dimension(50, 28));
        halfRestText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        restProbPanel.add(halfRestText, gridBagConstraints);

        quarterRestText.setMinimumSize(new java.awt.Dimension(50, 28));
        quarterRestText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        restProbPanel.add(quarterRestText, gridBagConstraints);

        eighthRestText.setMinimumSize(new java.awt.Dimension(50, 28));
        eighthRestText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        restProbPanel.add(eighthRestText, gridBagConstraints);

        sixteenthRestText.setMinimumSize(new java.awt.Dimension(50, 28));
        sixteenthRestText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        restProbPanel.add(sixteenthRestText, gridBagConstraints);

        defaultRestText.setMinimumSize(new java.awt.Dimension(50, 28));
        defaultRestText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        restProbPanel.add(defaultRestText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 50);
        probabilitiesPanel.add(restProbPanel, gridBagConstraints);

        numDivPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ways to Divide"));
        numDivPanel.setLayout(new java.awt.GridBagLayout());

        doubleLabel.setText("Two");
        numDivPanel.add(doubleLabel, new java.awt.GridBagConstraints());

        tripleLabel.setText("Triplet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        numDivPanel.add(tripleLabel, gridBagConstraints);

        fiveLabel.setText("Quintuplet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        numDivPanel.add(fiveLabel, gridBagConstraints);

        doubleText.setEditable(false);
        doubleText.setMinimumSize(new java.awt.Dimension(50, 28));
        doubleText.setPreferredSize(new java.awt.Dimension(50, 28));
        numDivPanel.add(doubleText, new java.awt.GridBagConstraints());

        tripleText.setMinimumSize(new java.awt.Dimension(50, 28));
        tripleText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        numDivPanel.add(tripleText, gridBagConstraints);

        fiveText.setMinimumSize(new java.awt.Dimension(50, 28));
        fiveText.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        numDivPanel.add(fiveText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 50, 50);
        probabilitiesPanel.add(numDivPanel, gridBagConstraints);

        getContentPane().add(probabilitiesPanel, new java.awt.GridBagConstraints());

        dividingPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        dividingPanel.add(numDivisionsSpinner, gridBagConstraints);

        multDivideButton.setText("Divide Multiple Times");
        multDivideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multDivideButtonActionPerformed(evt);
            }
        });
        dividingPanel.add(multDivideButton, new java.awt.GridBagConstraints());

        singleDivideButton.setText("Divide One Time");
        singleDivideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleDivideButtonActionPerformed(evt);
            }
        });
        dividingPanel.add(singleDivideButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(dividingPanel, gridBagConstraints);

        fileMenu.setText("File");

        openFileMI.setText("Open Fractal File");
        openFileMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMIActionPerformed(evt);
            }
        });
        fileMenu.add(openFileMI);

        saveFileMI.setText("Save Fractal File");
        saveFileMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMIActionPerformed(evt);
            }
        });
        fileMenu.add(saveFileMI);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void multDivideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multDivideButtonActionPerformed
        setProbabilities();
        
        int numTimes = (Integer)numDivisionsSpinner.getValue();
        MelodyPart fractalSolo = fractal.fractalImprovise(notate.getCurrentMelodyPart(), numTimes);
        notate.cm.execute(new RectifyPitchesCommand(fractalSolo,
                                                    0,
                                                    fractalSolo.getSize() - 1,
                                                    notate.getChordProg(),
                                                    false,
                                                    false,
                                                    true,
                                                    true,
                                                    true));
        notate.addChorus(fractalSolo);
        notate.playCurrentSelection(true, 
                                    0, 
                                    true, 
                                    "Playing fractal line");
    }//GEN-LAST:event_multDivideButtonActionPerformed

    private void singleDivideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleDivideButtonActionPerformed
        setProbabilities();
        
        MelodyPart fractalSolo = fractal.fractalImprovise(notate.getCurrentMelodyPart(), 1);
        notate.cm.execute(new RectifyPitchesCommand(fractalSolo,
                                                    0,
                                                    fractalSolo.getSize() - 1,
                                                    notate.getChordProg(),
                                                    false,
                                                    false,
                                                    true,
                                                    true,
                                                    true));
        notate.addChorus(fractalSolo);
        notate.playCurrentSelection(true, 
                                    0, 
                                    true, 
                                    "Playing fractal line");
    }//GEN-LAST:event_singleDivideButtonActionPerformed

    private void openFileMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMIActionPerformed
        open();
        setTextBoxes();
    }//GEN-LAST:event_openFileMIActionPerformed

    private void saveFileMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMIActionPerformed
        setProbabilities();
        saveCurrentFractal();
    }//GEN-LAST:event_saveFileMIActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel defaultDivLabel;
    private javax.swing.JTextField defaultDivText;
    private javax.swing.JLabel defaultRestLabel;
    private javax.swing.JTextField defaultRestText;
    private javax.swing.JPanel divProbPanel;
    private javax.swing.JPanel dividingPanel;
    private javax.swing.JLabel doubleLabel;
    private javax.swing.JTextField doubleText;
    private javax.swing.JLabel eighthDivLabel;
    private javax.swing.JTextField eighthDivText;
    private javax.swing.JLabel eighthRestLabel;
    private javax.swing.JTextField eighthRestText;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel fiveLabel;
    private javax.swing.JTextField fiveText;
    private javax.swing.JLabel halfDivLabel;
    private javax.swing.JTextField halfDivText;
    private javax.swing.JLabel halfRestLabel;
    private javax.swing.JTextField halfRestText;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton multDivideButton;
    private javax.swing.JPanel numDivPanel;
    private javax.swing.JSpinner numDivisionsSpinner;
    private javax.swing.JMenuItem openFileMI;
    private javax.swing.JPanel probabilitiesPanel;
    private javax.swing.JLabel quarterDivLabel;
    private javax.swing.JTextField quarterDivText;
    private javax.swing.JLabel quarterRestLabel;
    private javax.swing.JTextField quarterRestText;
    private javax.swing.JPanel restProbPanel;
    private javax.swing.JMenuItem saveFileMI;
    private javax.swing.JButton singleDivideButton;
    private javax.swing.JLabel sixteenthDivLabel;
    private javax.swing.JTextField sixteenthDivText;
    private javax.swing.JLabel sixteenthRestLabel;
    private javax.swing.JTextField sixteenthRestText;
    private javax.swing.JLabel tripleLabel;
    private javax.swing.JTextField tripleText;
    private javax.swing.JLabel wholeDivLabel;
    private javax.swing.JTextField wholeDivText;
    private javax.swing.JLabel wholeRestLabel;
    private javax.swing.JTextField wholeRestText;
    // End of variables declaration//GEN-END:variables

    public void open(){
        if( chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION )
        {
            String newFilename = chooser.getSelectedFile().getName();
            String fractalStr = "";
            try {
                fractalStr = new Scanner(chooser.getSelectedFile()).useDelimiter("\\Z").next();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TransformPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(fractalStr.length() > 0)
            {
                fractal = new Fractal(fractalStr);
                setTextBoxes();
            }
        }
    }
    
    public boolean saveCurrentFractal()
    {
        chooser.setSelectedFile(new File(filename));
        
        if( chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION )
          {
            if( chooser.getSelectedFile().getName().endsWith(
                EXTENSION) )
              {
                filename = chooser.getSelectedFile().getName();

                saveFractalFile(chooser.getSelectedFile().getAbsolutePath());
              }
            else
              {
                filename = chooser.getSelectedFile().getName() + EXTENSION;

                saveFractalFile(chooser.getSelectedFile().getAbsolutePath() + EXTENSION);
              }
            return true;
          }
        else
        {
            return false;
        }
    }
    
        private int saveFractalFile(String filepath) {
        try
        {
            String content = fractal.probsToString();
            FileWriter out = new FileWriter(new File(filepath));
            out.write(content);
            out.close();
            return 0;
        }
        catch( IOException e )
        {
            ErrorLog.log(ErrorLog.WARNING, "Error saving to " + filename);
            return -1;
        }
    }
    
    private String loadProbabilities(File file)
    {
        String probString = fileToString(file);
        fractal.setProbabilities(probString);
        return probString;
    }
    
    private static String fileToString(File file){
        String probStr = "";
        try {
            probStr = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GuideToneLineDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return probStr;
    }
    
    private void setTextBoxes()
    {
        double tripletProb = fractal.getTripletProb();
        tripleText.setText(String.valueOf(tripletProb));
        
        double fiveProb = fractal.getQuintupletProb();
        fiveText.setText(String.valueOf(fiveProb));
        
        double twoProb = 1.0 - (tripletProb + fiveProb);
        doubleText.setText(String.valueOf(twoProb));
        
        wholeDivText.setText(String.valueOf(fractal.getWholeDivProb()));
        halfDivText.setText(String.valueOf(fractal.getHalfDivProb()));
        quarterDivText.setText(String.valueOf(fractal.getQuarterDivProb()));
        eighthDivText.setText(String.valueOf(fractal.getEighthDivProb()));
        sixteenthDivText.setText(String.valueOf(fractal.getSixteenthDivProb()));
        defaultDivText.setText(String.valueOf(fractal.getDefaultDivProb()));
        
        wholeRestText.setText(String.valueOf(fractal.getWholeRestProb()));
        halfRestText.setText(String.valueOf(fractal.getHalfRestProb()));
        quarterRestText.setText(String.valueOf(fractal.getQuarterRestProb()));
        eighthRestText.setText(String.valueOf(fractal.getEighthRestProb()));
        sixteenthRestText.setText(String.valueOf(fractal.getSixteenthRestProb()));
        defaultRestText.setText(String.valueOf(fractal.getDefaultRestProb()));
    }
    
    private void setProbabilities()
    {
        double triplet = Double.parseDouble(tripleText.getText());
        double quintuplet = Double.parseDouble(fiveText.getText());
        
        doubleText.setText(String.valueOf(1.0 - (triplet + quintuplet)));
                
        fractal.setTripletProb(triplet);
        fractal.setQuintupletProb(quintuplet);
        
        fractal.setWholeDivProb(Double.parseDouble(wholeDivText.getText()));
        fractal.setHalfDivProb(Double.parseDouble(halfDivText.getText()));
        fractal.setQuarterDivProb(Double.parseDouble(quarterDivText.getText()));
        fractal.setEighthDivProb(Double.parseDouble(eighthDivText.getText()));
        fractal.setSixteenthDivProb(Double.parseDouble(sixteenthDivText.getText()));
        fractal.setDefaultDivProb(Double.parseDouble(defaultDivText.getText()));
        
        fractal.setWholeRestProb(Double.parseDouble(wholeRestText.getText()));
        fractal.setHalfRestProb(Double.parseDouble(halfRestText.getText()));
        fractal.setQuarterRestProb(Double.parseDouble(quarterRestText.getText()));
        fractal.setEighthRestProb(Double.parseDouble(eighthRestText.getText()));
        fractal.setSixteenthRestProb(Double.parseDouble(sixteenthRestText.getText()));
        fractal.setDefaultRestProb(Double.parseDouble(defaultRestText.getText()));
    }
}