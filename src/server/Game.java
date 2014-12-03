package server;


public class Game {

    private Player FirstPlayer;
    private Player SecondPlayer;
    private Board CurrentBoard;

    public Game()
    {

    }

    public Game(Player first, Player second, int rows, int cols)
    {
        FirstPlayer = first;
        SecondPlayer = second;
        this.CurrentBoard = new Board(rows, cols);
    }


}
