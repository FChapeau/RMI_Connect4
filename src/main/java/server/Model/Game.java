package main.java.server.Model;


import sun.awt.SunHints;

import java.util.Stack;

public class Game {

    private Player FirstPlayer;
    private Player SecondPlayer;
    private Board CurrentBoard;
    private Integer ValueToWin;
    private Integer CurrentPlayer;
    private Stack<Integer> MoveHistory;

    public Game()
    {

    }

    public Game(Player first, Player second, Integer rows, Integer cols, Integer value)
    {
        FirstPlayer = first;
        SecondPlayer = second;
        ValueToWin = value;
        Initialize(rows, cols);
    }

    public void Initialize(Integer rows, Integer cols)
    {
        this.CurrentBoard = new Board(rows, cols);
        CurrentPlayer = 1;
        MoveHistory = new Stack<Integer>();
    }

    public void ChangeCurrentPlayer()
    {
        if(CurrentPlayer == 1)
        {
            CurrentPlayer = 2;
        }
        else
        {
            CurrentPlayer = 1;
        }
    }

    public void Play(Integer col)
    {
        if(CurrentBoard.Play(col, CurrentPlayer)) {
            ChangeCurrentPlayer();
            SaveMove(col);
        }
    }

    public boolean CheckForVictory()
    {
        Position pos = new Position();
        pos.setPosX(MoveHistory.peek());
        //pos.setPosY(LA_POSITION_EN_Y);
        if(CurrentBoard.CheckHighestNumberOfTokenInLine(pos) == ValueToWin)
        {
            return true;
        }
        return false;
    }

    public void CancelLastMove()
    {
        CurrentBoard.Pop(MoveHistory.pop());
        ChangeCurrentPlayer();
    }

    private void SaveMove(Integer col)
    {
        MoveHistory.push(col);
    }

    public void NewGame()
    {
        Initialize(CurrentBoard.getRows(), CurrentBoard.getCollumns());
    }

    private void ClearBoard()
    {
        CurrentBoard.ClearBoard();
    }

    public Integer[][] GetCurrentBoard()
    {
        //TODO NOT YET IMPLEMENTED
        //Find a useful way to carry over a Board...oh well
        return new Integer[2][3];
    }


}
