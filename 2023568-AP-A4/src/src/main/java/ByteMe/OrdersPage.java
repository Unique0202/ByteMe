package ByteMe;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class OrdersPage extends JPanel {
    private JTable ordersTable;
    private Object[][] data;
    private String[] columnNames = {"Order Number", "Items Ordered", "Status"};

    public OrdersPage() {
        setLayout(new BorderLayout());
        data = fetchOrdersData();
        ordersTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(ordersTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private Object[][] fetchOrdersData() {
        Map<String, Order> orders = Admin.orders;
        Object[][] data = new Object[orders.size()][3];
        int i = 0;
        for (Map.Entry<String, Order> entry : orders.entrySet()) {
            Order order = entry.getValue();
            data[i][0] = entry.getKey();
            data[i][1] = order.getItem();
            data[i][2] = order.getStatus();
            i++;
        }
        return data;
    }

    public void refreshOrdersData() {
        data = fetchOrdersData();
        ordersTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}