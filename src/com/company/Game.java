package com.company;
import java.lang.*;
import java.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int gridWidth = 10;
    int gridHeight = 10;
    int maxShipLen = 4;

    public void PlayAOnePlayerGame()
    {
        int numOfShips = 5;
        BattleGrid field0 = new BattleGrid(gridWidth, gridHeight);
        BattleGrid field1 = new BattleGrid(gridWidth, gridHeight);

        for (int i = 0; i < numOfShips; ++i)
        {
            int x = field0.readInt("X: ");
            int y = field0.readInt("Y: ");
            int len = field0.readInt("Length of your ship: ");
            int dir = field0.readInt("for the direction of your ship, 1 is north and 2 is east: ");
            if (!field0.placeAShip(x, y, len, dir))
            {
                --i;
            }
        }

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
        System.out.println("-------------------------------------------");
    }


}
