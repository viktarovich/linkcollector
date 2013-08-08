package com.github.eugeneviktorovich.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main application.
 *
 * @author Eugene Viktorovich
 */
public class Main {

    /*public static void main(String[] args) throws SkypeException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Collector collector = (Collector) context.getBean("collector");

        collector.run();
    }*/

    private static String[] data = {"element 111111111111", "element 2", "element 3",
            "element 4", "element 5", "element 6"};

    private static String[] data2 = {"Chrome", "Firefox", "Internet Explorer", "Safari",
            "Opera", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "IL-2", "CMR", "NFS Undercover",
            "Star Wars", "Call of Duty", "IL-2", "CMR"
    };

    private static JScrollPane createLeftScrollPane() {
        JPanel leftPanel = new JPanel();

        leftPanel.setLayout(
                new BoxLayout(leftPanel, BoxLayout.Y_AXIS)
        );

        leftPanel.setBorder(
                BorderFactory.createTitledBorder("Active chats")
        );

        JList list = new JList(data);
        list.setLayoutOrientation(JList.VERTICAL);

        leftPanel.add(new JScrollPane(list));

        return new JScrollPane(leftPanel);
    }

    private static JScrollPane createWorkspaceScrollPane() {
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        centerPanel.setBorder(BorderFactory.createTitledBorder("Workspace"));

        JList list2 = new JList(data2);
        list2.setLayoutOrientation(JList.VERTICAL);

        JLabel label = new JLabel();

        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(list2), label);

        centerPanel.add(split);

        return new JScrollPane(centerPanel);
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JScrollPane leftPanel = createLeftScrollPane();

        JScrollPane workspacePanel = createWorkspaceScrollPane();

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, workspacePanel);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        frame.getContentPane().add(new JButton("Refresh"), BorderLayout.PAGE_START);
        frame.getContentPane().add(split, BorderLayout.CENTER);


        frame.setPreferredSize(new Dimension(700, 500));

        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
}
