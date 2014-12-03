package server.Model;


import java.util.Stack;

public class Game {

    private Player FirstPlayer;
    private Player SecondPlayer;
    private Board CurrentBoard;
    private boolean CurrentPlayer;
    private Stack MoveHistory = new Stack();

    public Game(Player first, Player second, int rows, int cols)
    {
        FirstPlayer = first;
        SecondPlayer = second;
        this.CurrentBoard = new Board(rows, cols);
        CurrentPlayer = false;
    }

    public void ChangeCurrentPlayer()
    {
        CurrentPlayer = !CurrentPlayer;
    }

    public void Play(int Col)
    {
        //TODO: Not yet implemented!
    }

    public void CheckForVictory()
    {
        //TODO: Not yet implemented!
    }

    public void CancelLastMove()
    {
        //TODO: Not yet implemented!
    }

    private void SaveMove(int col)
    {
        //TODO: Not yet implemented!
    }

    public void NewGame()
    {
        //TODO: Not yet implemented!
    }

    private void ClearBoard()
    {
        //TODO: Not yet implemented!
    }


}
