package com.company;

public class BattleGrid {
    private int width = 0;
    private int height = 0;
    char[][] field;

    public BattleGrid(int w, int h)
    {
        width = w;
        height = h;
        field = new char[width][height];
        clearBoards();
    }

    public void clearBoards()
    {
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                field[x][y] = '~';
            }
        }
    }

    public void printBoard()
    {
        System.out.println("PrintBoard");
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                System.out.print(field[x][y]);
            }
            System.out.println();
        }
    }
}
