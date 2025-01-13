package ByteMe;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MenuPage extends JPanel {
    private JTable menuTable;
    private Object[][] data;
    private String[] columnNames = {"Item ID", "Name", "Price", "Availability"};

    public MenuPage() {
        setLayout(new BorderLayout());
        data = fetchMenuData();
        menuTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(menuTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private Object[][] fetchMenuData() {
        Map<String, Admin.FoodItem> menu = Admin.menu;
        Object[][] data = new Object[menu.size()][4];
        int i = 0;
        for (Map.Entry<String, Admin.FoodItem> entry : menu.entrySet()) {
            Admin.FoodItem item = entry.getValue();
            data[i][0] = item.getId();
            data[i][1] = item.getName();
            data[i][2] = item.getPrice();
            data[i][3] = item.isAvailable() ? "Available" : "Not Available";
            i++;
        }
        return data;
    }

    public void refreshMenuData() {
        data = fetchMenuData();
        menuTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}