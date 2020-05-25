package com.company;
import java.lang.*;
import java.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int gridWidth = 10;
    int gridHeight = 10;
    int maxShipLen = 4;
    int numOfShips = 5;
    BattleGrid field0 = new BattleGrid(gridWidth, gridHeight);
    BattleGrid field1 = new BattleGrid(gridWidth, gridHeight);

    int readInt(String message) {
        int ret;
        System.out.print(message);
        try {
            ret = scanner.nextInt();
            return ret;
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public void playAOnePlayerGame()
    {
        for (int i = 0; i < numOfShips; ++i)
        {
            int x = readInt("X: ");
            int y = readInt("Y: ");
            int len = readInt("Length of your ship: ");
            int dir = readInt("for the direction of your ship, 1 is north and 2 is east: ");
            if (!field0.placeAShip(x, y, len, dir))
            {
                --i;
            }
        }

        field0.printBoard();

        for (int i = 0; i < numOfShips; ++i)
        {
            int x = random.nextInt(gridWidth);
            int y = random.nextInt(gridHeight);
            int len = random.nextInt(maxShipLen) + 1;
            int dir = random.nextInt(2) + 1;
            if (!field1.placeAShip(x, y, len, dir))
            {
                --i;
            }
            else
            {
                System.out.println("Computer ship #" + (i + 1) + " placed");
            }
        }

        field1.enemyPrint();

        System.out.println("-------------------------------------------");
        while (true)
        {
            for (int i = 0; i < 1; ++i)
            {
                int x = readInt("X: ");
                int y = readInt("Y: ");
                if (x >= gridWidth || x < 0 || y >= gridHeight || y < 0)
                {
                    System.out.println("Try Again");
                    --i;
                }
                else if (field1.field[y][x] == '-' || field1.field[y][x] == 'X')
                {
                    System.out.println("Try Again");
                    --i;
                }
                else if (field1.field[y][x] == ' ')
                {
                    System.out.print("you didn't hit anything.");
                    System.out.println(" This will be marked with a '-'.");
                    field1.field[y][x] = '-';
                }
                else if (field1.field[y][x] == '@')
                {
                    System.out.print("good job you hit one of the computers ships.");
                    System.out.println(" This will be marked with a 'X'.");
                    field1.field[y][x] = 'X';
                    System.out.print(" Also you get to go again.");
                    --i;
                }
            }

            field1.enemyPrint();

            if (field1.checkIfLost())
            {
                System.out.println("good job, you won!!!!");
                return;
            }
            for (int i = 0; i < 1; ++i)
            {
                int x = random.nextInt(gridWidth);
                int y = random.nextInt(gridWidth);
                if (field0.field[y][x] == '-' || field0.field[y][x] == '!')
                {
                    --i;
                }
                else if (field0.field[y][x] == ' ')
                {
                    System.out.print("The computer missed.");
                    System.out.println(" This will be marked on your board with a '-'.");
                    field0.field[y][x] = '-';
                }
                else if (field0.field[y][x] == '@')
                {
                    System.out.print("The computer hit one of your ships.");
                    System.out.print(" This will be marked with a '!'.");
                    field0.field[y][x] = '!';
                    System.out.println(" Also The computer gets to go again.");
                    --i;
                }
            }

            field0.printBoard();

            if (field0.checkIfLost())
            {
                System.out.println("you lost oh well better luck next time");
                return;
            }
        }
    }

}
