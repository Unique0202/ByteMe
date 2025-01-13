package ByteMe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private MenuPage menuPage;

    public GUI() {
        setTitle("ByteMe Canteen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        menuPage = new MenuPage();
        OrdersPage ordersPage = new OrdersPage();

        Admin.setMenuPage(menuPage); // Set the MenuPage reference in Admin

        mainPanel.add(menuPage, "Menu");
        mainPanel.add(ordersPage, "Orders");

        add(mainPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton menuButton = new JButton("Menu");
        JButton ordersButton = new JButton("Orders");

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Menu");
                menuPage.refreshMenuData(); // Refresh menu data when switching to menu page
            }
        });

        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Orders");
            }
        });

        buttonPanel.add(menuButton);
        buttonPanel.add(ordersButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Populate the menu before initializing the GUI
        ByteMe.basicMenu();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }
}