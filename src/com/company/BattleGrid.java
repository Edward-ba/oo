package com.company;
import java.util.*;
import java.lang.*;

public class BattleGrid {
    Scanner scanner = new Scanner(System.in);
    private String tryMessage = "Try Again";
    int sizeOfFleet = 0;
    int maxShipLen = 4;
    int minShipLen = 1;
    private int width = 0;
    private int height = 0;
    char[][] field;

    int readInt(String message) {
        int ret;
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);

        try {
            ret = scanner.nextInt();
            return ret;
        } catch (InputMismatchException e) {
            return -1;
        }
    }
    public BattleGrid(int w, int h)
    {
        width = w;
        height = h;
        field = new char[height][width];
        clearBoard();
    }

    public void clearBoard()
    {
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                field[y][x] = ' ';
            }
        }
    }

    public void printBoard()
    {
        System.out.println("PrintBoard");
        System.out.print("  ");
        for (int i = 0; i < width; ++i)
        {
            System.out.print(i);
        }
        System.out.println();
        for (int x = 0; x < height; ++x)
        {
            System.out.print(x + "|");
            for (int y = 0; y < width; ++y)
            {
                System.out.print(field[y][x]);
            }
            System.out.print("|" + x);
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i < width; ++i)
        {
            System.out.print(i);
        }
        System.out.println();
    }

    boolean placeAShip(int x, int y, int len, int dir)
    {
        if (len > maxShipLen || len < minShipLen || dir > 2 || dir < 1 || x >= width - len || x < 0 || y >= height - len || y < 0)
        {
            System.out.println(tryMessage);
            return false;
        }
        for (int i = 0; i < len; ++i)
        {
            if (field[y][x] != '@')
            {
                System.out.println(tryMessage);
                return false;
            }
            field[y][x] = '@';
            if (dir == 1)
                ++x;
            else if (dir == 2)
                ++y;
        }
        sizeOfFleet += len;
        return true;
    }

    boolean checkForWinner()
    {
        int playerShipsDead = 0;
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                if (field[y][x] == '!')
                {
                    ++playerShipsDead;
                }
            }
        }
        if (playerShipsDead == sizeOfFleet)
        {
            return true;
        }
        return false;
    }
}
