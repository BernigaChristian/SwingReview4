import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 01/05/2022, domenica
 **/
public class Main {
    public static void main(String[] args) {
        JMenu menu = new JMenu("MENU");
        ArrayList<JMenuItem> items = new ArrayList<>();
        items.add(new JMenuItem("1"));
        items.add(new JMenuItem("2"));
        items.add(new JMenuItem("3"));
        /*JMenuItem item1 = new JMenuItem("ITEM1");
        JMenuItem item2 = new JMenuItem("ITEM2");
        JMenuItem item3 = new JMenuItem("ITEM3");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);*/
        menu.add(items.get(0));
        menu.add(items.get(1));
        menu.add(items.get(2));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        ArrayList<JPanel> panels = new ArrayList<>();
        panels.add(new JPanel());
        panels.add(new JPanel());
        panels.add(new JPanel());
        panels.get(0).setBackground(Color.red);
        panels.get(1).setBackground(Color.black);
        panels.get(2).setBackground(Color.cyan);
        /**JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setBackground(Color.red);
        p2.setBackground(Color.black);
        p3.setBackground(Color.cyan);*/
        JPanel body = new JPanel(new GridLayout(3,1));
        body.add(panels.get(0));
        body.add(panels.get(1));
        body.add(panels.get(2));

        JTabbedPane p1 = new JTabbedPane();
        p1.addTab("TAB1",panels.get(0));
        p1.addTab("TAB2",panels.get(1));
        p1.addTab("TAB3",panels.get(2));

        JFrame mainFrame = new JFrame("test");
        mainFrame.setSize(300,200);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panels.get(0).setVisible(false);
        panels.get(1).setVisible(false);
        panels.get(2).setVisible(false);

        ActionListener cambiaPannelli = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceItem = Integer.parseInt(((JMenuItem)e.getSource()).getText());
                panels.get(0).setVisible(false);
                panels.get(1).setVisible(false);
                panels.get(2).setVisible(false);
                panels.get(indiceItem - 1).setVisible(true);
            }
        };

        items.get(0).addActionListener(cambiaPannelli);
        items.get(1).addActionListener(cambiaPannelli);
        items.get(2).addActionListener(cambiaPannelli);

        mainFrame.getContentPane().add(BorderLayout.NORTH,menuBar);
        mainFrame.getContentPane().add(BorderLayout.CENTER,p1);
        mainFrame.setVisible(true);
    }
}
