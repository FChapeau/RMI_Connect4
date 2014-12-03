package server.Model;

import java.util.Stack;

public class Board {

    private Integer Rows;
    private Integer Collumns;
    private Stack[] Tiles;


    public Board()
    {

    }

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
}
