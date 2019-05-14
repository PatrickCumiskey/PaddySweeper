package gui;

import game.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game
{
    private Home home;
    private JFrame frameGame;
    private JPanel panelBar;
    private JPanel panelInfo;
    private JPanel panelGame;
    private JPanel panelMenu;
    private JLabel labelOpenFields;
    private JLabel labelClosedFields;
    private JLabel labelNumberOfMines;
    private JLabel labelNumberOfLives;
    private JTextField textFieldOpenFields;
    private JTextField textFieldClosedFields;
    private JTextField textFieldNumberOfMines;
    private JTextField textFieldNumberOfLives;
    private JMenuBar menuBar;
    private JButton buttonBack;
    private JButton buttonRestart;

    public Game(Home home)
    {
        this.home = home;
        this.frameGame = new JFrame("PaddySweeper");
        this.panelBar = new JPanel();
        this.panelInfo = new JPanel();
        this.panelGame = new JPanel();
        this.panelMenu = new JPanel();
        this.labelOpenFields = new JLabel("Open", SwingConstants.CENTER);
        this.labelClosedFields = new JLabel("Closed", SwingConstants.CENTER);
        this.labelNumberOfMines = new JLabel("Mines", SwingConstants.CENTER);
        this.labelNumberOfLives = new JLabel("Lives", SwingConstants.CENTER);
        this.textFieldOpenFields = new JTextField();
        this.textFieldClosedFields = new JTextField();
        this.textFieldNumberOfMines = new JTextField();
        this.textFieldNumberOfLives = new JTextField();
        this.menuBar = new JMenuBar();
        this.buttonBack = new JButton();
        this.buttonRestart = new JButton();

        paint();
    }

    public void paint()
    {
        frameGame.setResizable(false);
        frameGame.setSize(1920, 1080);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setLayout(new BorderLayout(10, 10));
        frameGame.setIconImage(Faces.getBomb());
        frameGame.getContentPane().setBackground(new Color(255, 255, 255));

        Field field = new Field(home, Game.this);
        field.placeMines();

        panelBar.setLayout(new BorderLayout(10,10));
        panelBar.setBackground(new Color(255, 255, 255));

        panelGame.setBackground(new Color(255, 255, 255));

        buttonBack.setBackground(new Color(214, 42, 34));
        buttonBack.setIcon(new ImageIcon(Faces.getLeftArrow()));
        buttonBack.addActionListener(new KeyListenerBack());

        menuBar.setBackground(new Color(255, 255, 255));
        menuBar.add(buttonBack);

        panelMenu.setLayout(new BorderLayout(0, 0));
        panelMenu.setBackground(new Color(255, 255, 255));
        panelMenu.add(menuBar, BorderLayout.CENTER);

        labelOpenFields.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldOpenFields.setEditable(false);
        textFieldOpenFields.setText(String.valueOf(field.getOpenFields()));
        textFieldOpenFields.setHorizontalAlignment(JTextField.CENTER);
        textFieldOpenFields.setForeground(Color.RED);
        textFieldOpenFields.setBackground(Color.BLACK);
        textFieldOpenFields.setFont(new Font("Arial", Font.BOLD,30));

        labelClosedFields.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldClosedFields.setEditable(false);
        textFieldClosedFields.setText(String.valueOf(field.getFieldsTotal() - field.getOpenFields()));
        textFieldClosedFields.setHorizontalAlignment(JTextField.CENTER);
        textFieldClosedFields.setForeground(Color.RED);
        textFieldClosedFields.setBackground(Color.BLACK);
        textFieldClosedFields.setFont(new Font("Arial", Font.BOLD,30));

        buttonRestart.setBackground(new Color(214, 65, 34));
        buttonRestart.addActionListener(new KeyListenerRestart());
        buttonRestart.addMouseListener(new MouseListenerRestart());
        setButtonSmilingFaceWithSmilingEyes();

        labelNumberOfMines.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldNumberOfMines.setEditable(false);
        textFieldNumberOfMines.setText(String.valueOf(field.getMinesTotal()));
        textFieldNumberOfMines.setHorizontalAlignment(JTextField.CENTER);
        textFieldNumberOfMines.setForeground(Color.RED);
        textFieldNumberOfMines.setBackground(Color.BLACK);
        textFieldNumberOfMines.setFont(new Font("Arial", Font.BOLD,30));

        labelNumberOfLives.setFont(new Font("Arial", Font.PLAIN,20));

        textFieldNumberOfLives.setEditable(false);
        textFieldNumberOfLives.setText(String.valueOf(field.getPlayer().getLives()));
        textFieldNumberOfLives.setHorizontalAlignment(JTextField.CENTER);
        textFieldNumberOfLives.setForeground(Color.RED);
        textFieldNumberOfLives.setBackground(Color.BLACK);
        textFieldNumberOfLives.setFont(new Font("Arial", Font.BOLD,30));

        panelInfo.setLayout(new GridLayout(1, 9, 0, 0));
        panelInfo.setBackground(new Color(255, 255, 255));
        panelInfo.add(labelOpenFields);
        panelInfo.add(textFieldOpenFields);
        panelInfo.add(labelClosedFields);
        panelInfo.add(textFieldClosedFields);
        panelInfo.add(buttonRestart);
        panelInfo.add(labelNumberOfMines);
        panelInfo.add(textFieldNumberOfMines);
        panelInfo.add(labelNumberOfLives);
        panelInfo.add(textFieldNumberOfLives);

        panelBar.add(panelMenu, BorderLayout.NORTH);
        panelBar.add(panelInfo, BorderLayout.CENTER);

        frameGame.add(panelBar, BorderLayout.NORTH);
        frameGame.add(panelGame, BorderLayout.CENTER);
        frameGame.setLocationRelativeTo(null);
        frameGame.setVisible(true);
    }

    public JFrame getFrameGame()
    {
        return frameGame;
    }

    public JPanel getPanelGame()
    {
        return panelGame;
    }

    public JTextField getTextFieldOpenFields()
    {
        return textFieldOpenFields;
    }

    public JTextField getTextFieldClosedFields()
    {
        return textFieldClosedFields;
    }

    public JTextField getTextFieldNumberOfMines()
    {
        return textFieldNumberOfMines;
    }

    public JTextField getTextFieldNumberOfLives()
    {
        return textFieldNumberOfLives;
    }

    public void setButtonSmilingFaceWithSmilingEyes()
    {
        buttonRestart.setIcon(new ImageIcon(Faces.getSmilingFaceWithSmilingEyes()));
    }

    public void setButtonSmilingFaceWithSunglasses()
    {
        buttonRestart.setIcon(new ImageIcon(Faces.getSmilingFaceWithSunglasses()));
    }

    public void setButtonDizzyFace()
    {
        buttonRestart.setIcon(new ImageIcon(Faces.getDizzyFace()));
    }

    public void setButtonFearfulFace()
    {
        buttonRestart.setIcon(new ImageIcon(Faces.getFearfulFace()));
    }

    public void restartGame()
    {
        frameGame.dispose();
        home.setGame(new Game(home));
    }

    class KeyListenerRestart implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            restartGame();
        }
    }

    class MouseListenerRestart implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
        }

        public void mousePressed(MouseEvent e)
        {
            buttonRestart.setIcon(new ImageIcon(Faces.getSmirkingFace()));
        }

        public void mouseReleased(MouseEvent e)
        {
            setButtonSmilingFaceWithSmilingEyes();
        }

        public void mouseEntered(MouseEvent e)
        {
            buttonRestart.setIcon(new ImageIcon(Faces.getSmirkingFace()));
        }

        public void mouseExited(MouseEvent e)
        {
            setButtonSmilingFaceWithSmilingEyes();
        }
    }

    class KeyListenerBack implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            home.getButtonBack().setEnabled(true);
            home.getMainWindow().setVisible(true);
            frameGame.setVisible(false);
        }
    }
}
