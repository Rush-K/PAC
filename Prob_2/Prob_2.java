package Prob_2;

import java.io.*;
import java.util.*;

/*
 ** 주차시스템
 ** 핵심 알고리즘 : BFS
 */
class Position
{
    public int x;
    public int y;

    public Position(int _x, int _y)
    {
        this.x = _x;
        this.y = _y;
    }
}
public class Prob_2 {
    public static int[][] statusBoard;
    public static boolean[][] visitedBoard;
    public static int N;
    public static int M;
    public static int result;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        statusBoard = new int[N][M];
        visitedBoard = new boolean[N][M];

        for (int i = 0; i < N; i++)
        {
            input = br.readLine();
            String[] elements = input.split(" ");

            for (int j = 0; j < M; j++)
            {
                if (Integer.parseInt(elements[j]) == 0) statusBoard[i][j] = 1;
                else if (Integer.parseInt(elements[j]) == 1)
                { statusBoard[i][j] = 0; visitedBoard[i][j] = true; }
                else if (Integer.parseInt(elements[j]) == 2) statusBoard[i][j] = -2;
            }
        }

        int finalResult = 0;
        Queue<Position> bfsList = new LinkedList<Position>();

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                result = 0;
                if (!visitedBoard[i][j])
                {
                    bfsList.add(new Position(i, j));
                    while (!bfsList.isEmpty())
                    {
                        Position pos = bfsList.poll();
                        if (visitedBoard[pos.x][pos.y]) continue;
                        else visitedBoard[pos.x][pos.y] = true;

                        result += statusBoard[pos.x][pos.y];
                        if (pos.x - 1 >= 0) bfsList.add(new Position(pos.x - 1, pos.y));
                        if (pos.x + 1 < N) bfsList.add(new Position(pos.x + 1, pos.y));
                        if (pos.y - 1 >= 0) bfsList.add(new Position(pos.x, pos.y - 1));
                        if (pos.y + 1 < M) bfsList.add(new Position(pos.x, pos.y + 1));
                    }
                }
                finalResult = Math.max(finalResult, result);
            }
        }

        System.out.println(finalResult);
    }
}
