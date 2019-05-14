package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home
{
    private Game game;
    private JFrame MainWindow;
    private JPanel panelInput;
    private JPanel panelButton;
//    private JLabel labelName;
    private JLabel labelRow;
    private JLabel labelCol;
    private JTextField textFieldName;
    private JComboBox comboBoxRow;
    private JComboBox comboBoxCol;
    private JMenuBar menuBar;
    private JButton buttonStart;
    private JButton buttonBack;

    public Home()
    {
        this.MainWindow = new JFrame("PaddySweeper");
        this.panelInput = new JPanel();
        this.panelButton = new JPanel();
//        this.labelName = new JLabel("Name", SwingConstants.CENTER);
        this.labelRow = new JLabel("Rows", SwingConstants.CENTER);
        this.labelCol = new JLabel("Columns", SwingConstants.CENTER);
        this.textFieldName = new JTextField();
        this.comboBoxRow = new JComboBox();
        this.comboBoxCol = new JComboBox();
        this.menuBar = new JMenuBar();
        this.buttonStart = new JButton("Start");
        this.buttonBack = new JButton();
    }

    public void paint()
    {
        MainWindow.setResizable(false);
        MainWindow.setSize(800, 600);
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setLayout(new BorderLayout(10, 10));
        MainWindow.setIconImage(Faces.getBomb());
        MainWindow.getContentPane().setBackground(new Color(255, 255, 255));

        buttonBack.setBackground(new Color(214, 25, 28));
        buttonBack.setIcon(new ImageIcon(Faces.getRightArrow()));
        buttonBack.setEnabled(false);
        buttonBack.addActionListener(new KeyListenerBack());

        menuBar.setBackground(new Color(255, 255, 255));
        menuBar.add(buttonBack);

//        labelName.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldName.setFont(new Font("Arial", Font.PLAIN,20));

        labelRow.setFont(new Font("Arial", Font.PLAIN,20));

        comboBoxRow.setBackground(new Color(255, 255, 255));
        comboBoxRow.setFont(new Font("Arial", Font.PLAIN,20));
        comboBoxRow.addItem(5);
        comboBoxRow.addItem(6);
        comboBoxRow.addItem(7);
        comboBoxRow.addItem(8);
        comboBoxRow.addItem(9);
        comboBoxRow.addItem(10);

        labelCol.setFont(new Font("Arial", Font.PLAIN,20));

        comboBoxCol.setBackground(new Color(255, 255, 255));
        comboBoxCol.setFont(new Font("Arial", Font.PLAIN,20));
        comboBoxCol.addItem(5);
        comboBoxCol.addItem(6);
        comboBoxCol.addItem(7);
        comboBoxCol.addItem(8);
        comboBoxCol.addItem(9);
        comboBoxCol.addItem(10);

        panelInput.setLayout(new GridLayout(2, 2, 10, 10));
        panelInput.setBackground(new Color(255, 255, 255));
//        panelInput.add(labelName);
//        panelInput.add(textFieldName);
        panelInput.add(labelRow);
        panelInput.add(comboBoxRow);
        panelInput.add(labelCol);
        panelInput.add(comboBoxCol);

        buttonStart.setBackground(new Color(214, 56, 31));
        buttonStart.setFont(new Font("Arial", Font.PLAIN,20));
        buttonStart.addActionListener(new KeyListenerStart());

        panelButton.setLayout(new BorderLayout(0, 0));
        panelButton.setBackground(new Color(255, 255, 255));
        panelButton.setPreferredSize(new Dimension(0, 200));
        panelButton.add(buttonStart, BorderLayout.CENTER);

        MainWindow.add(menuBar, BorderLayout.NORTH);
        MainWindow.add(panelInput, BorderLayout.CENTER);
        MainWindow.add(panelButton, BorderLayout.SOUTH);
        MainWindow.setLocationRelativeTo(null);
        MainWindow.setVisible(true);
    }

    public int getRow()
    {
        return (Integer) comboBoxRow.getSelectedItem();
    }

    public int getCol()
    {
        return (Integer) comboBoxCol.getSelectedItem();
    }

    public String getName()
    {
        return textFieldName.getText();
    }

    public JFrame getMainWindow()
    {
        return MainWindow;
    }

    public JButton getButtonBack()
    {
        return buttonBack;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }


    class KeyListenerStart implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            game = new Game(Home.this);
            MainWindow.setVisible(false);
        }
    }

    class KeyListenerBack implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(game != null)
            {
                game.getFrameGame().setVisible(true);
                MainWindow.setVisible(false);
            }
        }
    }
}
