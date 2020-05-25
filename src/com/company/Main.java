package com.company;
import javax.swing.text.Style;
import java.lang.*;
import java.util.*;

public class Main
{
    // Main entry point


    public static void main(String[] args)
    {
        Game game = new Game();
        Game.ShipCoordinates sc = game.getShipCoordinates();
        System.out.println(sc.toString());

//        game.playAOnePlayerGame();
/*
        Battlefield battlefield = new Battlefield();
        battlefield.clear_boards();
        for (int i = 0; i < 5; ++i)
        {
            try
            {
                int x = battlefield.readInt("x:");
                int y = battlefield.readInt("y:");
                int len = battlefield.readInt("length of your ship:");
                int dir = battlefield.readInt("direction of your ship, 1 = vertical, 2 = horizontal:");

                boolean did_it_work = battlefield.placeAShip(x, y, len, dir);
                if (did_it_work == false)
                {
                    --i;
                }
            } catch (InputMismatchException e)
            {
                --i;
            }
        }
        for (int i = 0; i < 5; ++i)
        {
            boolean did_the_computer_work = battlefield.compPlaceAShip();
            if (did_the_computer_work == false)
            {
                --i;
            }
            else
            {
                System.out.println("computer ship #" + (i + 1) + " placed");
            }
        }
        battlefield.printBoard();

        while (true)
        {
            battlefield.playerShoot();
            if (battlefield.checkForWinner())
            {
                break;
            }
            battlefield.computerShoot();
            if (battlefield.checkForWinner())
            {
                break;
            }
        }
        return;
 */
    }
}
