package game;

import gui.Faces;
import gui.Game;
import gui.Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Field
{
    private Home home;
    private Game game;
    private Player player;
    private int row;
    private int col;
    private SingleField singleFields[][];
    private int minesTotal;
    private int minesCurrent;
    private int minesAround;
    private boolean isWon;
    private int fieldsTotal;
    private JLabel labelMessageDialog;

    public Field(Home home, Game game)
    {
        this.home = home;
        this.game = game;
        this.player = new Player(home.getName());
        this.row = home.getRow();
        this.col = home.getCol();
        this.singleFields = new SingleField[this.row][this.col];
        this.minesTotal = 0;
        this.minesCurrent = 0;
        this.minesAround = 0;
        this.isWon = false;
        this.fieldsTotal = 0;
        this.labelMessageDialog = new JLabel();
        this.labelMessageDialog.setFont(new Font("Arial", Font.PLAIN, 20));

        createField();
    }

    public void createField()
    {

        game.getPanelGame().setLayout(new GridLayout(row, col, 0, 0));

        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                singleFields[r][c] = new SingleField();
                game.getPanelGame().add(singleFields[r][c]);
                singleFields[r][c].addActionListener(new KeyListenerSingleField());
                singleFields[r][c].addMouseListener(new MouseListenerSingleField());
            }
        }

        calculateMines();
        player.calculateLives(getMinesTotal());
    }

    private void calculateMines()
    {
        setMinesTotal(Math.round((row + col) / 2)); // TODO Make better calculation
        setMinesCurrent(minesTotal); // Sets also current mines same as total mines
    }

    private void setMinesTotal(int minesTotal)
    {
        this.minesTotal = minesTotal;
    }

    public int getMinesTotal()
    {
        return minesTotal;
    }

    public int getMinesCurrent()
    {
        return minesCurrent;
    }

    public void setMinesCurrent(int minesCurrent)
    {
        this.minesCurrent = minesCurrent;
    }

    public void placeMines()
    {
        for(int i = 0; i < getMinesTotal(); i++)
        {
            Random rand = new Random();
            int r = rand.nextInt(row);
            int c = rand.nextInt(col);

            while(singleFields[r][c].isMine())
            {
                r = rand.nextInt(row);
                c = rand.nextInt(col);
            }

            singleFields[r][c].setMine(true);
        }
    }

    public void minesAround()
    {
        for(int row = 0; row < this.row; row++)
        {
            for(int col = 0; col < this.col; col++)
            {
                if(!(singleFields[row][col].isMine()))
                {
                    minesAround = 0;

                    for(int r = row - 1; r <= row + 1; r++)
                    {
                        for(int c = col - 1; c <= col + 1; c++)
                        {
                            if(0 <= r && r < this.row && 0 <= c && c < this.col)
                            {
                                if(singleFields[r][c].isMine())
                                {
                                    ++minesAround;
                                }
                            }
                        }
                    }

                    singleFields[row][col].setNumber(minesAround);
                }
            }
        }
    }

    public Player getPlayer()
    {
        return player;
    }

    private void winningCondition()
    {

        if(getFieldsTotal() - getMinesTotal() == getOpenFieldsWithoutMines())
        {
            setWon(true);
        }
        else
        {
            setWon(false);
        }
    }

    public boolean isWon()
    {
        winningCondition();
        return isWon;
    }

    public void setWon(boolean won)
    {
        this.isWon = won;
    }

    public int getOpenFields()
    {
        int openFields = 0;

        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                if(singleFields[r][c].isOpen())
                {
                    openFields++;
                }
            }
        }

        return openFields;
    }

    public int getOpenFieldsWithoutMines()
    {
        int openFieldsWithoutMines = 0;

        for(int r=0; r<row; r++)
        {
            for(int c=0; c<col; c++)
            {
                if(singleFields[r][c].isOpen())
                {
                    if(!singleFields[r][c].isMine())
                    {
                        openFieldsWithoutMines++;
                    }
                }
            }
        }

        return openFieldsWithoutMines;
    }

    public int getFieldsTotal()
    {
        calculateFieldsTotal();
        return fieldsTotal;
    }

    public void setFieldsTotal(int fieldsTotal)
    {
        this.fieldsTotal = fieldsTotal;
    }

    public void calculateFieldsTotal()
    {
        setFieldsTotal(row*col);
    }

    class KeyListenerSingleField implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            minesAround();

            SingleField singleField = (SingleField) e.getSource();

            if(singleField.isOpen() == false && singleField.isFlagged() == false)
            {
                singleField.setOpen(true);
                game.getTextFieldOpenFields().setText(String.valueOf(getOpenFields()));
                game.getTextFieldClosedFields().setText(String.valueOf(getFieldsTotal() - getOpenFields()));

                if(singleField.isMine())
                {
                    singleField.setBackground(new Color(255, 0, 0));
                    singleField.setIcon(new ImageIcon(Faces.getBomb()));
                    player.setLives(player.getLives() - 1);


                    if(player.getLives() >= 0)
                    {
                        game.getTextFieldNumberOfLives().setText(String.valueOf(player.getLives()));
                    }
                    else
                    {
                        game.getTextFieldNumberOfLives().setText("");
                    }

                    setMinesCurrent(getMinesCurrent() - 1);
                    game.getTextFieldNumberOfMines().setText(String.valueOf(getMinesCurrent()));

                    if(player.getLives() < 0)
                    {
                        game.setButtonDizzyFace();
                        labelMessageDialog.setText("Game Over!");
                        JOptionPane.showMessageDialog(game.getFrameGame(), labelMessageDialog, "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
                            Faces.getCollision()));
                        game.restartGame();
                    }
                }
                else
                {
                    singleField.setBackground(new Color(215, 215, 215));
                    singleField.setColoredText(singleField.getNumber());

                    if(isWon())
                    {
                        game.setButtonSmilingFaceWithSunglasses();
                        labelMessageDialog.setText("You Win!");
                        JOptionPane.showMessageDialog(game.getFrameGame(), labelMessageDialog, "Info", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
                            Faces.getPartyPopper()));
                        game.restartGame();
                    }
                }
            }
        }
    }

    class MouseListenerSingleField implements java.awt.event.MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            SingleField singleField = (SingleField) e.getSource();

            if(SwingUtilities.isRightMouseButton(e))
            {
                if(!singleField.isOpen())
                {
                    if(!singleField.isFlagged())
                    {
                        singleField.setFlagged(true);
                        singleField.setIcon(new ImageIcon(Faces.getTriangularFlag()));
                    }
                    else
                    {
                        singleField.setFlagged(false);
                        singleField.setIcon(null);
                    }
                }
            }
        }

        public void mousePressed(MouseEvent e)
        {
            SingleField singleField = (SingleField) e.getSource();

            if(singleField.isFlagged() == false && singleField.isOpen() == false && SwingUtilities.isRightMouseButton(e) == false)
            {
                game.setButtonFearfulFace();
            }
        }

        public void mouseReleased(MouseEvent e)
        {
            game.setButtonSmilingFaceWithSmilingEyes();
        }

        public void mouseEntered(MouseEvent e)
        {
        }

        public void mouseExited(MouseEvent e)
        {
        }
    }
}
