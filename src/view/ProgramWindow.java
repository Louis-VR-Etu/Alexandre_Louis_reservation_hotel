package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramWindow extends JFrame {
    private JMenuBar menuBar;
    private JMenu membersManagementMenu, researchMenu;
    //private TabbedPaneMembers tabbedPaneMembersPanel;
    //private TabbedPaneResearch tabbedPaneResearchPanel;
    private JMenuItem addMember, listMember;
    private Container container;

    public ProgramWindow(){
        super("JavaProject");
        container = this.getContentPane();
        setBounds(550,150,500,500);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        membersManagementMenu = new JMenu("Members Management");
        menuBar.add(membersManagementMenu);
        addMember = new JMenuItem("Add Member");
        addMember.addActionListener(new FormListener());
        listMember = new JMenuItem("List Members");
        listMember.addActionListener(new ListListener());
        membersManagementMenu.add(addMember);
        membersManagementMenu.add(listMember);

        researchMenu = new JMenu("Researches");
        menuBar.add(researchMenu);

        this.setVisible(true);
    }
    /*
    private class FormListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            container.removeAll();
            container.add(new FormPanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }

    private class ListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            container.removeAll();
            container.add(new AllMembersPanel(), BorderLayout.CENTER);
            container.repaint();
            ProgramWindow.this.setVisible(true);
        }
    }
    */
}
