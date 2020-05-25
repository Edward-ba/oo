package com.company;
import java.lang.*;
import java.util.*;

public class Game {

    public class ShipCoordinates
    {
        int x;
        int y;
        int len;
        char dir;

        public String toString()
        {
            StringBuffer sb = new StringBuffer();
            sb.append("X(");
            sb.append(x);
            sb.append(") Y(");
            sb.append(y);
            sb.append(") Len(");
            sb.append(len);
            sb.append(") Dir(");
            sb.append(dir);
            sb.append(")");
            return sb.toString();
        }
    };

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int gridWidth = 10;
    int gridHeight = 10;
    int maxShipLen = 4;
    int numOfShips = 5;
    BattleGrid field0 = new BattleGrid(gridWidth, gridHeight);
    BattleGrid field1 = new BattleGrid(gridWidth, gridHeight);

    ShipCoordinates getShipCoordinates()
    {
        System.out.println("Enter your ship coordinates as X,Y,Len,Dir. Eg \"3, 5, 2, N\"");
        Scanner scanner = new Scanner(System.in);
        String tokens[] = scanner.nextLine().split(",");
        if (tokens.length != 4)
            System.out.println("Please try again, incorrect number of inputs: Enter as  X,Y,Len,Dir. Eg \"3, 5, 2, N\"");

        for(var t : tokens)
            System.out.println(t.trim());

        ShipCoordinates sc = new ShipCoordinates();

        sc.x = Integer.parseInt(tokens[0].trim());
        sc.y = Integer.parseInt(tokens[1].trim());
        sc.len = Integer.parseInt(tokens[2].trim());
        sc.dir = tokens[3].trim().charAt(0);

        return sc;
    }



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

        field0.printBoard(true);

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

        field1.printBoard(false);

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

            field1.printBoard(false);

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

            field0.printBoard(true);

            if (field0.checkIfLost())
            {
                System.out.println("you lost oh well better luck next time");
                return;
            }
        }
    }

}
