package Prob_1;

import java.io.*;
import java.util.*;

public class Prob_1 {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String[] velocities = new String[1001];
        int result = 0;

        for (int i = 0; i < velocities.length; i++) velocities[i] = "0 0";

        for (int i = 1; i <= Integer.parseInt(n); i++)
        {
            String input = br.readLine();
            String[] v_w = input.split(" ");
            if (velocities[Integer.parseInt(v_w[0])] != "0 0")
            {
                String[] exist_v_w = velocities[Integer.parseInt(v_w[0])].split(" ");
                if (Integer.parseInt(v_w[1]) >= Integer.parseInt(exist_v_w[1])) velocities[Integer.parseInt(v_w[0])] = i + " " + v_w[1];
            }
            else velocities[Integer.parseInt(v_w[0])] = i + " " + v_w[1];;
        }

        for (int i = 1; i <= 1000; i++) result += Integer.parseInt(velocities[i].split(" ")[0]);

        System.out.println(result);
    }
}
