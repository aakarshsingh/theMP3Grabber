import javax.swing.*;
import java.util.Enumeration;

public class SecondFrame extends javax.swing.JFrame
{
    private static String[] localResults;
    private static String[] localLinks;
    private static String localqueryTerm;
    private static int linkIndex;
    public SecondFrame(String[] results, String[] links, String queryTerm)
    {
        this.localResults=results;
        this.localLinks=links;
        this.localqueryTerm=queryTerm;
        initComponents();
        myMacFixer();
    }
    private void initComponents()
    {

        youTubePlaceHolderButtonGroup = new javax.swing.ButtonGroup();
        parentPanel = new javax.swing.JPanel();
        iconHolder = new javax.swing.JButton();
        youTubePlaceHolder1 = new javax.swing.JRadioButton();
        youTubePlaceHolder2 = new javax.swing.JRadioButton();
        youTubePlaceHolder3 = new javax.swing.JRadioButton();
        youTubePlaceHolder4 = new javax.swing.JRadioButton();
        youTubePlaceHolder5 = new javax.swing.JRadioButton();
        youTubePlaceHolder6 = new javax.swing.JRadioButton();
        downloadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Best Match");
        setLocation(new java.awt.Point(400, 50));
        setSize(new java.awt.Dimension(600, 600));

        parentPanel.setBackground(new java.awt.Color(211, 47, 47));
        parentPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        iconHolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("TMC.png"))); // NOI18N
        iconHolder.setBorderPainted(false);
        iconHolder.setContentAreaFilled(false);
        iconHolder.setFocusPainted(false);
        iconHolder.setFocusable(false);
        iconHolder.setRequestFocusEnabled(false);
        iconHolder.setRolloverEnabled(false);
        iconHolder.setVerifyInputWhenFocusTarget(false);

        youTubePlaceHolderButtonGroup.add(youTubePlaceHolder1);
        youTubePlaceHolder1.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        youTubePlaceHolder1.setForeground(new java.awt.Color(255, 255, 255));
        youTubePlaceHolder1.setText(localResults[0]);
        youTubePlaceHolder1.setContentAreaFilled(false);
        youTubePlaceHolder1.setFocusPainted(false);
        if(youTubePlaceHolder1.getText().equalsIgnoreCase("Oops"))
            youTubePlaceHolder1.setVisible(false);

        youTubePlaceHolderButtonGroup.add(youTubePlaceHolder2);
        youTubePlaceHolder2.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        youTubePlaceHolder2.setForeground(new java.awt.Color(255, 255, 255));
        youTubePlaceHolder2.setText(localResults[1]);
        youTubePlaceHolder2.setContentAreaFilled(false);
        youTubePlaceHolder2.setFocusPainted(false);
        if(youTubePlaceHolder2.getText().equalsIgnoreCase("Oops"))
            youTubePlaceHolder2.setVisible(false);

        youTubePlaceHolderButtonGroup.add(youTubePlaceHolder3);
        youTubePlaceHolder3.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        youTubePlaceHolder3.setForeground(new java.awt.Color(255, 255, 255));
        youTubePlaceHolder3.setText(localResults[2]);
        youTubePlaceHolder3.setContentAreaFilled(false);
        youTubePlaceHolder3.setFocusPainted(false);
        if(youTubePlaceHolder3.getText().equalsIgnoreCase("Oops"))
            youTubePlaceHolder3.setVisible(false);


        youTubePlaceHolderButtonGroup.add(youTubePlaceHolder4);
        youTubePlaceHolder4. setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        youTubePlaceHolder4. setForeground(new java.awt.Color(255, 255, 255));
        youTubePlaceHolder4. setText(localResults[3]);
        youTubePlaceHolder4.setContentAreaFilled(false);
        youTubePlaceHolder4. setFocusPainted(false);
        if(youTubePlaceHolder4.getText().equalsIgnoreCase("Oops"))
            youTubePlaceHolder4.setVisible(false);


        youTubePlaceHolderButtonGroup.add(youTubePlaceHolder5);
        youTubePlaceHolder5.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        youTubePlaceHolder5.setForeground(new java.awt.Color(255, 255, 255));
        youTubePlaceHolder5.setText(localResults[4]);
        youTubePlaceHolder5.setContentAreaFilled(false);
        youTubePlaceHolder5.setFocusPainted(false);
        if(youTubePlaceHolder5.getText().equalsIgnoreCase("Oops"))
            youTubePlaceHolder5.setVisible(false);


        youTubePlaceHolderButtonGroup.add(youTubePlaceHolder6);
        youTubePlaceHolder6.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        youTubePlaceHolder6.setForeground(new java.awt.Color(255, 255, 255));
        youTubePlaceHolder6.setText(localResults[5]);
        youTubePlaceHolder6.setToolTipText("");
        youTubePlaceHolder6.setContentAreaFilled(false);
        youTubePlaceHolder6.setFocusPainted(false);
        if(youTubePlaceHolder6.getText().equalsIgnoreCase("Oops"))
            youTubePlaceHolder6.setVisible(false);


        downloadButton.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        downloadButton.setForeground(new java.awt.Color(255, 255, 255));
        downloadButton.setText("DOWNLOAD");
        downloadButton.setContentAreaFilled(false);
        downloadButton.setFocusPainted(false);
        downloadButton.setFocusable(false);
        downloadButton.setRequestFocusEnabled(false);
        downloadButton.setRolloverEnabled(false);
        downloadButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                downloadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(parentPanel);
        parentPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(downloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(youTubePlaceHolder6)
                                                        .addComponent(youTubePlaceHolder5)
                                                        .addComponent(youTubePlaceHolder3)
                                                        .addComponent(youTubePlaceHolder4)
                                                        .addComponent(youTubePlaceHolder2)
                                                        .addComponent(youTubePlaceHolder1)
                                                        .addComponent(iconHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconHolder)
                                .addGap(40, 40, 40)
                                .addComponent(youTubePlaceHolder1)
                                .addGap(36, 36, 36)
                                .addComponent(youTubePlaceHolder2)
                                .addGap(36, 36, 36)
                                .addComponent(youTubePlaceHolder4)
                                .addGap(36, 36, 36)
                                .addComponent(youTubePlaceHolder3)
                                .addGap(36, 36, 36)
                                .addComponent(youTubePlaceHolder5)
                                .addGap(36, 36, 36)
                                .addComponent(youTubePlaceHolder6)
                                .addGap(27, 27, 27)
                                .addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(parentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        if(youTubePlaceHolderButtonGroup.getSelection()==null)
        {
            JOptionPane.showMessageDialog(this, "Please Select a YouTube Title to Download MP3");
        }
        else
        {
            String youTubeLink=getSelectedButtonID();
            localqueryTerm=localResults[linkIndex].replaceAll("[^A-Za-z0-9 )('-.]]", "");
            System.out.println(youTubeLink);
            String MusicFolder = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
            ThirdFrame thirdFrame = new ThirdFrame(MusicFolder, localqueryTerm, youTubeLink);
            thirdFrame.setVisible(true);
        }
    }

    private javax.swing.ButtonGroup youTubePlaceHolderButtonGroup;
    private javax.swing.JButton downloadButton;
    private javax.swing.JButton iconHolder;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JRadioButton youTubePlaceHolder1;
    private javax.swing.JRadioButton youTubePlaceHolder2;
    private javax.swing.JRadioButton youTubePlaceHolder3;
    private javax.swing.JRadioButton youTubePlaceHolder4;
    private javax.swing.JRadioButton youTubePlaceHolder5;
    private javax.swing.JRadioButton youTubePlaceHolder6;

    private void myMacFixer()
    {
        String OS = System.getProperty("os.name");
        if (OS.startsWith("M"))
        {
            downloadButton.setForeground(java.awt.Color.black);
        }
    }

    public String getSelectedButtonID()
    {
        linkIndex = 0;
        for (Enumeration<AbstractButton> buttons = youTubePlaceHolderButtonGroup.getElements(); buttons.hasMoreElements();)
        {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected())
            {
                System.out.println(button.getText());
                linkIndex=matchButtonText(button.getText());
            }
        }
        return localLinks[linkIndex];
    }

    private int matchButtonText(String text)
    {
        for(int i=0;i<6;i++)
        {
            if(localResults[i].equals(text))
                return i;
        }
        return -1;
    }
}
