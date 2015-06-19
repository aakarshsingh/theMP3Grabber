import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.math.BigInteger;

import static java.awt.Color.black;

public class FirstFrame extends javax.swing.JFrame
{
    public FirstFrame()
    {
        initComponents();
        myMacFixer();
    }

    private void initComponents()
    {
        parentPanelFirstFrame = new javax.swing.JPanel();
        iconHolder = new javax.swing.JButton();
        titleTextField = new javax.swing.JTextField();
        showResultsButton = new javax.swing.JButton();
        artistTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enter Details");
        setBackground(new java.awt.Color(156, 39, 176));
        setLocation(new java.awt.Point(400, 50));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        parentPanelFirstFrame.setBackground(new java.awt.Color(123, 31, 162));
        parentPanelFirstFrame.setPreferredSize(new java.awt.Dimension(600, 600));

        iconHolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("TMC.png"))); // NOI18N
        iconHolder.setBorderPainted(false);
        iconHolder.setContentAreaFilled(false);
        iconHolder.setFocusPainted(false);
        iconHolder.setFocusable(false);
        iconHolder.setRequestFocusEnabled(false);
        iconHolder.setRolloverEnabled(false);
        iconHolder.setVerifyInputWhenFocusTarget(false);

        titleTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titleTextField.setForeground(new java.awt.Color(255, 255, 255));
        titleTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Title", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        titleTextField.setOpaque(false);
        titleTextField.setSelectionColor(new java.awt.Color(225, 190, 231));

        showResultsButton.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        showResultsButton.setForeground(new java.awt.Color(255, 255, 255));
        showResultsButton.setText("SHOW RESULTS");
        showResultsButton.setContentAreaFilled(false);
        showResultsButton.setFocusPainted(false);
        showResultsButton.setFocusable(false);
        showResultsButton.setRequestFocusEnabled(false);
        showResultsButton.setRolloverEnabled(false);
        showResultsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                showResultsButtonActionPerformed(evt);
            }
        });

        artistTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        artistTextField.setForeground(new java.awt.Color(255, 255, 255));
        artistTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Artist", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        artistTextField.setOpaque(false);
        artistTextField.setSelectionColor(new java.awt.Color(225, 190, 231));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(parentPanelFirstFrame);
        parentPanelFirstFrame.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(showResultsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(titleTextField)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(iconHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 276, Short.MAX_VALUE))
                                        .addComponent(artistTextField))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconHolder)
                                .addGap(90, 90, 90)
                                .addComponent(artistTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(showResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(parentPanelFirstFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(parentPanelFirstFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void showResultsButtonActionPerformed(ActionEvent evt)
    {
        String artist=artistTextField.getText();
        String title=titleTextField.getText();
        YouTubeSearch youTubeSearch = new YouTubeSearch();
        String results[] = new String[6];
        String links[]=new String[6];
        try
        {
            results=youTubeSearch.setter(artist, title);
            links=youTubeSearch.getYouTubeLinks();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String queryTerm=artist.concat(" - ").concat(title.replaceAll("[^A-Za-z0-9 .[()]'-]", ""));
        SecondFrame secondFrame=new SecondFrame(results, links, queryTerm);
        this.dispose();
        secondFrame.setVisible(true);
    }

    private javax.swing.JButton showResultsButton;
    private javax.swing.JButton iconHolder;
    private javax.swing.JPanel parentPanelFirstFrame;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JTextField artistTextField;

    private void myMacFixer()
    {
        String OS = System.getProperty("os.name");
        if (OS.startsWith("M"))
        {
            showResultsButton.setForeground(black);
        }
    }
}
