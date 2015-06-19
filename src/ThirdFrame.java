import java.awt.FileDialog;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import com.jaunt.Element;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

import javax.swing.*;

public class ThirdFrame extends javax.swing.JFrame
{
    private static String musicFolder, songName, youTubeLink;

    public ThirdFrame(String x, String y, String z)
    {
        this.musicFolder = x;
        this.songName = y;
        this.youTubeLink = z;
        initComponents();
        myUpdates();
        myMacFixer();
    }

    private void initComponents()
    {

        parentPanel = new javax.swing.JPanel();
        iconHolder = new javax.swing.JButton();
        againButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        browseButton = new javax.swing.JButton();
        pathLabel = new javax.swing.JLabel();
        downloadButton = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();
        fileSizeLabel = new javax.swing.JLabel();
        downloadProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Complete Download");
        setLocation(new java.awt.Point(400, 50));
        setSize(new java.awt.Dimension(600, 600));

        parentPanel.setBackground(new java.awt.Color(69, 90, 100));
        parentPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        iconHolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("TMC.png"))); // NOI18N
        iconHolder.setBorderPainted(false);
        iconHolder.setContentAreaFilled(false);
        iconHolder.setFocusPainted(false);
        iconHolder.setFocusable(false);
        iconHolder.setRequestFocusEnabled(false);
        iconHolder.setRolloverEnabled(false);
        iconHolder.setVerifyInputWhenFocusTarget(false);

        againButton.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        againButton.setForeground(new java.awt.Color(255, 255, 255));
        againButton.setText("AGAIN");
        againButton.setContentAreaFilled(false);
        againButton.setFocusPainted(false);
        againButton.setFocusable(false);
        againButton.setRequestFocusEnabled(false);
        againButton.setRolloverEnabled(false);
        againButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                againButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("EXIT");
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setFocusable(false);
        exitButton.setRequestFocusEnabled(false);
        exitButton.setRolloverEnabled(false);
        exitButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitButtonActionPerformed(evt);
            }
        });

        browseButton.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        browseButton.setForeground(new java.awt.Color(255, 255, 255));
        browseButton.setText("BROWSE");
        browseButton.setContentAreaFilled(false);
        browseButton.setFocusPainted(false);
        browseButton.setFocusable(false);
        browseButton.setRequestFocusEnabled(false);
        browseButton.setRolloverEnabled(false);
        browseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                browseButtonActionPerformed(evt);
            }
        });

        pathLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        pathLabel.setForeground(new java.awt.Color(255, 255, 255));
        pathLabel.setText(musicFolder);

        downloadButton.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
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
                try
                {
                    downloadButtonActionPerformed(evt);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });

        fileNameLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        fileNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        fileNameLabel.setText("");

        fileSizeLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        fileSizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        fileSizeLabel.setText("");

        downloadProgressBar.setStringPainted(true);

        javax.swing.GroupLayout parentPanelLayout = new javax.swing.GroupLayout(parentPanel);
        parentPanel.setLayout(parentPanelLayout);
        parentPanelLayout.setHorizontalGroup(
                parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(parentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(parentPanelLayout.createSequentialGroup()
                                                .addComponent(downloadProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parentPanelLayout.createSequentialGroup()
                                                .addComponent(againButton, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27))
                                        .addGroup(parentPanelLayout.createSequentialGroup()
                                                .addComponent(pathLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(browseButton)
                                                .addContainerGap())
                                        .addGroup(parentPanelLayout.createSequentialGroup()
                                                .addComponent(iconHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parentPanelLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(fileNameLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(fileSizeLabel)
                                                .addContainerGap())))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, parentPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(downloadButton)
                                .addGap(233, 233, 233))
        );
        parentPanelLayout.setVerticalGroup(
                parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(parentPanelLayout.createSequentialGroup()
                                .addComponent(iconHolder)
                                .addGap(53, 53, 53)
                                .addGroup(parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pathLabel)
                                        .addComponent(browseButton))
                                .addGap(59, 59, 59)
                                .addComponent(downloadButton)
                                .addGap(61, 61, 61)
                                .addGroup(parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fileNameLabel)
                                        .addComponent(fileSizeLabel))
                                .addGap(61, 61, 61)
                                .addComponent(downloadProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addGroup(parentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(againButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(parentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(parentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void againButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        FirstFrame firstFrame = new FirstFrame();
        this.dispose();
        firstFrame.setVisible(true);
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.dispose();
    }

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt)
    {

        FileDialog fd = new FileDialog(this, "Save File", FileDialog.SAVE);
        fd.setDirectory(musicFolder);
        fd.setFile(songName.concat(".mp3"));
        fd.setVisible(true);
        String savePath = fd.getDirectory().concat(fd.getFile());
        pathLabel.setText(savePath);
    }

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, IOException
    {
        String savePath = pathLabel.getText();
        RetrieverClass retrieverClass = new RetrieverClass(youTubeLink, savePath);
        String downloadURL = retrieverClass.getDownloadURL();
        nowDownloadIt(downloadURL, savePath);
    }

    private javax.swing.JButton iconHolder;
    private javax.swing.JButton againButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton downloadButton;
    private javax.swing.JProgressBar downloadProgressBar;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JLabel fileSizeLabel;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JLabel pathLabel;

    private void myUpdates()
    {
        String OS = System.getProperty("os.name");
        if (OS.startsWith("W"))
            pathLabel.setText(musicFolder.concat("\\").concat(songName).concat(".mp3"));
        else
            pathLabel.setText(musicFolder.concat("/").concat(songName).concat(".mp3"));
    }

    private void myMacFixer()
    {
        String OS = System.getProperty("os.name");
        if (OS.startsWith("M"))
        {
            againButton.setForeground(java.awt.Color.black);
            exitButton.setForeground(java.awt.Color.black);
            browseButton.setForeground(java.awt.Color.black);
            downloadButton.setForeground(java.awt.Color.black);
        }
    }

    private void nowDownloadIt(String downloadURL, String file)
    {
        byte[] readBuffer = new byte[2048];
        int length;
        try
        {
            float totalDataRead = 0;
            URLConnection URLConnection = new URL(downloadURL).openConnection();
            int fileSize = URLConnection.getContentLength();
            if (fileSize == -1)
            {
                JOptionPane.showMessageDialog(this, "Broken Link, Try another Download");
                this.dispose();
            }
            InputStream inputStream = URLConnection.getInputStream();
            OutputStream outputStream = new FileOutputStream(new File(file));
            while ((length = inputStream.read(readBuffer)) > 0)
            {
                totalDataRead = totalDataRead + length;
                outputStream.write(readBuffer, 0, length);
                final float percent = (totalDataRead * 100) / fileSize;

                Thread t = new Thread()
                {
                    public void run()
                    {
                        if((int)(percent)==99)
                            downloadProgressBar.setValue(100);
                        else
                            downloadProgressBar.setValue((int) percent);
                        downloadProgressBar.paintImmediately(downloadProgressBar.getVisibleRect());
                        try
                        {
                            Thread.sleep(100);
                        }
                        catch (InterruptedException e)
                        {
                        }

                    }
                };
                t.start();
            }
            outputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

class RetrieverClass
{
    private static String youTubeSlug;
    private final String directoryPath;
    private final File downloadFile;
    private String downloadURL;

    RetrieverClass(String x, String y) throws InterruptedException
    {
        this.youTubeSlug = x;
        this.directoryPath = y;
        this.downloadFile = new File(directoryPath);
        retrieveDownloadURL();
    }

    private void retrieveDownloadURL()
    {
        UserAgent userAgent = new UserAgent();
        try
        {
            String videoURL = "http://www.youtube.com/watch?v=" + youTubeSlug;
            String url = "http://youtubeinmp3.com/download/?video=http://youtubeinmp3.com/download/?video=" + videoURL;
            userAgent.visit(url);
            downloadURL = "";
            com.jaunt.Elements anchor = userAgent.doc.findEach("<a>");
            int i = 0;
            for (Element e : anchor)
            {
                i++;
                if (i == 2)
                {
                    downloadURL = e.getAt("href");
                    break;
                }
            }
        }
        catch (ResponseException e)
        {
            e.printStackTrace();
        }
        catch (NotFound notFound)
        {
            notFound.printStackTrace();
        }
    }

    public String getDownloadURL()
    {
        return downloadURL;
    }
}

