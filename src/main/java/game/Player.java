package game;

public class Player
{
    private String name;
    private int lives;

    public Player(String name)
    {
        this.name = name;
        this.lives = 0;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void calculateLives(int mines)
    {
        this.lives = Math.round(mines / 2); // TODO Make better calculation
    }

    public int getLives()
    {
        return lives;
    }

    public void setLives(int lives)
    {
        this.lives = lives;
    }

    @Override
    public String toString()
    {
        return "Player{" + "name='" + name + '\'' + ", lives=" + lives + '}';
    }
}
