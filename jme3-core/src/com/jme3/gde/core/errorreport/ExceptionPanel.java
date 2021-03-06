/*
 * Copyright (c) 2003-2012 jMonkeyEngine
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * * Neither the name of 'jMonkeyEngine' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jme3.gde.core.errorreport;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URI;
import javax.swing.JPanel;
import org.openide.DialogDescriptor;
import org.openide.util.Exceptions;

/**
 * An ExceptionPanel is used to visualize an Exception, prompting the user
 * to report it to us.
 * 
 * @author normenhansen
 */
public final class ExceptionPanel extends JPanel {
    
    protected boolean wantIssue = true;
    /**
     * Creates new form ExceptionPanel.
     * 
     * @param descriptor The DialogDescriptor containing this Panel.
     */
    public ExceptionPanel(DialogDescriptor descriptor) {
        initComponents();
    }

    public ExceptionPanel(String text, boolean wantIssue) {
        this.wantIssue = wantIssue;
        initComponents();
        setText(text);
    }

    public void setText(String text) {
        jTextArea1.setText(text);
    }

    private void copyToClip(String text) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(text);
        clipboard.setContents(strSel, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanelExReport = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanelRenderInfo = new javax.swing.JPanel();

        jTextPane1.setEditable(false);
        jTextPane1.setText(org.openide.util.NbBundle.getMessage(ExceptionPanel.class, "ExceptionPanel.jTextPane1.text")); // NOI18N
        jTextPane1.setFocusable(false);
        jScrollPane2.setViewportView(jTextPane1);

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ExceptionPanel.class, "ExceptionPanel.jScrollPane2.TabConstraints.tabTitle"), jScrollPane2); // NOI18N

        jPanelExReport.setName("panelExceptionReport"); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTextArea1);

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(ExceptionPanel.class, "ExceptionPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(ExceptionPanel.class, "ExceptionPanel.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelExReportLayout = new javax.swing.GroupLayout(jPanelExReport);
        jPanelExReport.setLayout(jPanelExReportLayout);
        jPanelExReportLayout.setHorizontalGroup(
            jPanelExReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(jPanelExReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelExReportLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelExReportLayout.setVerticalGroup(
            jPanelExReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExReportLayout.createSequentialGroup()
                .addContainerGap(550, Short.MAX_VALUE)
                .addGroup(jPanelExReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
            .addGroup(jPanelExReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelExReportLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ExceptionPanel.class, "ExceptionPanel.jPanelExReport.TabConstraints.tabTitle"), jPanelExReport); // NOI18N

        jPanelRenderInfo.setName("panelExceptionReport"); // NOI18N
        jPanelRenderInfo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelRenderInfoComponentShown(evt);
            }
        });

        javax.swing.GroupLayout jPanelRenderInfoLayout = new javax.swing.GroupLayout(jPanelRenderInfo);
        jPanelRenderInfo.setLayout(jPanelRenderInfoLayout);
        jPanelRenderInfoLayout.setHorizontalGroup(
            jPanelRenderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanelRenderInfoLayout.setVerticalGroup(
            jPanelRenderInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(ExceptionPanel.class, "ExceptionPanel.jPanelRenderInfo.TabConstraints.tabTitle"), jPanelRenderInfo); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ExceptionPanel.class, "ExceptionPanel.jTabbedPane1.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        copyToClip(jTextArea1.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanelRenderInfoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelRenderInfoComponentShown
        JPanel pnl = (JPanel)evt.getComponent();
        
        if (pnl.getComponents().length == 0) { // No endless loop
            pnl.setLayout(new GridLayout(1, 1));
            pnl.add(new RendererInfo());
        }
    }//GEN-LAST:event_jPanelRenderInfoComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Desktop desk = Desktop.getDesktop();
            String uri = wantIssue ? ExceptionUtils.ISSUE_TRACKER_URL : ExceptionUtils.FORUMS_URL;            
            
            if (desk.isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(uri));
            } else {
                // Linux does not seem to be supported very well with Desktop.
                String os = System.getProperty("os.name");
                if (os.startsWith("Windows")) {
                    Runtime.getRuntime().exec(new String[] { "explorer", uri});
                } else if (os.startsWith("Mac OS")) {
                    Runtime.getRuntime().exec(new String[] { "open", uri});
                } else if (os.startsWith("Linux"))  {
                    Runtime.getRuntime().exec(new String[] { "xdg-open", uri});
                }
            }
        } catch (Exception e) {
            Exceptions.printStackTrace(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanelExReport;
    private javax.swing.JPanel jPanelRenderInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
