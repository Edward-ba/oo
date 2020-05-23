package com.company;
import java.util.*;
import java.lang.*;

public class Battlefield
{
    // Test arjuna change


    int sizeOfPlayerFleet = 0;
    int sizeOfCompFleet = 0;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int computerLastShotThatHitX = -1;
    int computerLastShotThatHitY = -1;
    int maxShipLen = 4;
    int minShipLen = 1;
    int width = 10;
    int height = 10;
    char[][] field0 = new char[width][height];
    char[][] field1 = new char[width][height];

    private String tryMessage = "Try Again";

    int readInt(String message) {
        int ret;
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        try {
            ret = scanner.nextInt();
            return ret;
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    boolean placeAShip(int x, int y, int len, int dir)
    {
        if (len > maxShipLen || len < minShipLen || dir > 2 || dir < 1 || x >= width || x < 0 || y >= height || y < 0)
        {
            System.out.println(tryMessage);
            return false;
        }
        for (int i = 0; i < len; ++i)
        {
            if (field0[x][y] != '@' && field1[x][y] != '@')
            {
                System.out.println(tryMessage);
                return false;
            }
            field0[x][y] = '@';
            if (dir == 1)
                ++y;
            else if (dir == 2)
                ++x;
        }
        sizeOfPlayerFleet += len;
        return true;
    }

    void clear_boards()
    {
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                field0[x][y] = ' ';
                field1[x][y] = ' ';
            }
        }
    }

    void printBoard()
    {
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                System.out.print(field0[x][y]);
            }
            System.out.println();
        }
    }

    boolean compPlaceAShip()
    {
        int dir = random.nextInt(4);
        ++dir;
        int len = random.nextInt(maxShipLen);
        ++len;
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        for (int i = 0; i < len; ++i)
        {
            if (field0[x][y] != '@' && field1[x][y] != '@')
            {
                System.out.println(tryMessage);
                return false;
            }
            field1[x][y] = '@';

            if (dir == 1)
                ++y;
            else if (dir == 2)
                ++x;
            else if (dir == 3)
                --y;
            else if (dir == 4)
                --x;
        }
        sizeOfCompFleet += len;
        return true;
    }

    void playerShoot()
    {
        for (int i = 0; i < 1; ++i)
        {
            int x = readInt("X: ");
            int y = readInt("Y: ");
            if (x > width - 1 || x < 0 || y > height - 1 || y < 0 || field0[x][y] == '-' || field1[x][y] == 'X' || field0[x][y] == '!')
            {
                System.out.println(tryMessage);
                --i;
            }
            else if (field0[x][y] == ' ')
            {
                System.out.println("sorry you didn't hit anything except water this will be marked with a -");
                field0[x][y] = '-';
            }
            else if (field0[x][y] == '@')
            {
                System.out.println("whoops you hit your own ship this will be marked as a !");
                field0[x][y] = '!';
            }
            else if (field1[x][y] == '@')
            {
                System.out.println("good job you hit one of the computers ships. this will be marked with a X");
                field0[x][y] = 'X';
                System.out.println("and you get to go again");
                --i;
            }
        }
    }

    void computerShoot()
    {
        for (int i = 0; i < 1; ++i)
        {
            int randomX = random.nextInt(width);
            int randomY = random.nextInt(height);
            if (field0[randomX][randomY] == ' ')
            {
                System.out.println("The computer didn't hit anything but water this will be marked with a -");
                field0[randomX][randomY] = '-';
            }
            else if (field0[randomX][randomY] == '@')
            {
                System.out.println("The computer hit one of its own ships. This will be marked with a X");
                field0[randomX][randomY] = '!';
            }
            else if (field1[randomX][randomY] == '@')
            {
                System.out.println("The computer hit one of your ships. This will be marked as a !");
                field0[randomX][randomY] = 'X';
                System.out.println("and the computer gets to go again");
                --i;
            }
            else
            {
                --i;
            }
        }
    }

    boolean checkForWinner()
    {
        int playerShipsDead = 0;
        int compShipsDead = 0;
        for (int x = 0; x < width; ++x)
        {
            for (int y = 0; y < height; ++y)
            {
                if (field0[x][y] == '!')
                {
                    ++playerShipsDead;
                }
                else if (field0[x][y] == 'X')
                {
                    ++compShipsDead;
                }
            }
        }
        if (playerShipsDead == sizeOfPlayerFleet)
        {
            System.out.println("you win! good job!!");
            return true;
        }
        else if (compShipsDead == sizeOfCompFleet)
        {
            System.out.println("The Computer won!");
            return true;
        }
        return false;
    }
}

