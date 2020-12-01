package Lab_6;
import  java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Application extends JFrame
{

    Application()
    {
        super("I'm differs!");
        setBounds(0,0,500,500);


        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea txtArea = new JTextArea("Цвет и шрифт этого текста можно сменить");
        txtArea.setLineWrap(true);
        txtArea.setAutoscrolls(true);

        txtArea.setFont(new Font("Times New Roman", 1,30));
        txtArea.setToolTipText("Смените цвет и шрифт этого текста");

        JMenu colorMenu = new JMenu(("Цвет"));
        JMenuBar colorMenuBar= new JMenuBar();

        JMenu mFont = new JMenu(("Шрифт"));
        JMenuBar mbFont = new JMenuBar();

        JMenuItem menuItem;

        String[] colorOptions = new String[]{"Синий", "Красный", "Чёрный"};

        Color[] colorOptions2 = new Color[]{Color.BLUE, Color.RED, Color.BLACK};

        String[] fontOptions = new String[]{"Times New Roman", "MS Sans Serif", "Courier New"};

        for (int i = 0; i < colorOptions.length; i++)
        {
            menuItem = new JMenuItem(colorOptions[i]);
            int finalI = i;

            menuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    txtArea.setForeground(colorOptions2[finalI]);
                }
            });

            colorMenu.add(menuItem);
        }
        colorMenuBar.add(colorMenu);


        for (int i = 0; i < fontOptions.length; i++)
        {
            menuItem = new JMenuItem(fontOptions[i]);
            String finalOption = fontOptions[i];

            menuItem.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    txtArea.setFont(new Font(finalOption, 1, 22));
                }
            });

            mFont.add(menuItem);
        }
        mbFont.add(mFont);


        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 1, 0, 0));

        container.add(mbFont);
        container.add(colorMenuBar);
        container.add(new JScrollPane(txtArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
    }


    public static void main(String[] args) {
        Application app = new Application();
        app.setVisible(true);
    }

}
