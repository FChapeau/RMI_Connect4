package server.Model;

import java.util.Stack;

public class Board {

    private Integer Rows;
    private Integer Collumns;
    private Stack<Integer>[] Tiles;


    public Board(Integer rows, Integer cols)
    {
        Rows = rows;
        Collumns = cols;
        Tiles = new Stack[Collumns];
    }

    public boolean Play(Integer col, Integer player)
    {
        if(CollumnIsNotFull(col))
        {
            Tiles[col].push(player);
            return true;
        }
        return false;
    }

    private boolean CollumnIsFull(Integer col) {
        if(Tiles[col].size() == Rows)
        {
            return true;
        }
        return false;
    }

    private boolean CollumnIsNotFull(Integer col)
    {
        return !CollumnIsFull(col);
    }

    private boolean CollumnIsEmpty(Integer col)
    {
        return Tiles[col].empty();
    }

    private boolean CollumnIsNotEmpty(Integer col)
    {return !CollumnIsEmpty(col);}

    public boolean Pop(Integer col)
    {
        if(CollumnIsNotEmpty(col))
        {
            Tiles[col].pop();

            return true;
        }
        return false;
    }

    public void ClearBoard()
    {
        Tiles = new Stack[Collumns];
    }

    public Integer getRows()
    {
        return Rows;
    }

    public Integer getCollumns()
    {
        return Collumns;
    }

    public Integer CheckHighestNumberOfTokenInLine(Position pos) {
        Integer i = 0;
        i = CheckVertical(pos);
        if(CheckHorizontal(pos) > i){i = CheckHorizontal(pos);}
        if(CheckMainDiagonal(pos) > i){i = CheckMainDiagonal(pos);}
        if(CheckOffDiagonal(pos) > i){i = CheckOffDiagonal(pos);}
        return i;
    }

    private Integer CheckVertical(Position pos)
    {
        //Sum the number of tokens below and above target position
        return 2;
    }

    private Integer CheckHorizontal (Position pos)
    {
        //Sum the number of tokens on both sides of target position
        return 2;
    }

    private Integer CheckMainDiagonal(Position pos)
    {
        //Sum the number of tokens on the main diagonal of target position
        return 2;
    }

    private Integer CheckOffDiagonal(Position pos)
    {
        //Sum the number of tokens on the off diagonal of target position
        return 2;
    }

    private Integer CheckTargetPosition(Position pos)
    {
        return Tiles[pos.getPosX()].get(pos.getPosY());
    }
}
