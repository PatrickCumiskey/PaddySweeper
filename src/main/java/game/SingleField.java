package game;

import javax.swing.*;
import java.awt.*;


public class SingleField extends JButton
{
    private int number;
    private boolean isMine;
    private boolean isOpen;
    private boolean isFlagged;


    public SingleField()
    {
        this.number = 0;
        this.isMine = false;
        this.isOpen = false;
        this.isFlagged = false;
        setFont(new Font("Arial", Font.BOLD,20));
        setBackground(new Color(255, 255, 255));
    }


    public int getNumber()
    {
        return number;
    }


    public void setNumber(int number)
    {
        this.number = number;
    }

    public boolean isMine()
    {
        return isMine;
    }

    public void setMine(boolean mine)
    {
        this.isMine = mine;
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    public void setOpen(boolean open)
    {
        this.isOpen = open;
    }

    public boolean isFlagged()
    {
        return isFlagged;
    }

    public void setFlagged(boolean flagged)
    {
        this.isFlagged = flagged;
    }

    public void setColoredText(int coloredNumber)
    {
        switch(coloredNumber)
        {
            case 0:
                setForeground(null);
                break;
            case 1:
                setForeground(new Color(1, 0, 254));
                break;
            case 2:
                setForeground(new Color(0, 128, 0));
                break;
            case 3:
                setForeground(new Color(254, 0, 0));
                break;
            case 4:
                setForeground(new Color(1, 0, 128));
                break;
            case 5:
                setForeground(new Color(128, 0, 0));
                break;
            case 6:
                setForeground(new Color(0, 128, 129));
                break;
            case 7:
                setForeground(new Color(0, 0, 0));
                break;
            case 8:
                setForeground(new Color(128, 128, 128));
                break;

            default:
                setForeground(null); // Default color for all other numbers
        }

        setText(String.valueOf(coloredNumber));
    }

    @Override
    public String toString()
    {
        return "SingleField{" + "number=" + number + ", isMine=" + isMine + ", isOpen=" + isOpen + ", isFlagged=" + isFlagged + '}';
    }
}
