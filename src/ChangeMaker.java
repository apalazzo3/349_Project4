/*
* CS 349
* Project 4
*
* @authors: Griffin Johnson & Michael Lozada
* @id: mlozada & gpjohnso
* @date: February 20, 2018
*/

import java.util.*;
import java.io.*;

public class ChangeMaker
{
	public static int[] change_DP(int n, int[] d)
	{
		int remains;
		int[] counts = new int[d.length];
		
		for(int i = 0; i < d.length; i++)
		{
			if(n != 0)
			{
				counts[i] = (int)Math.floor(n/d[i]);
				n = n%d[i];
			}
			else
			{
				counts[i] = 0;
			}
		}
		
		return counts;
	}
	
	public static void printDP(int n, int[] d, int[] dp)
	{
		int coins = 0;
		
		System.out.println();
		System.out.println("DP algorithms results");
		System.out.printf("Amount: %d\n", n);
		System.out.printf("Optimal distribution: ");
		
		for(int i = 0; i < dp.length; i++)
		{
			if(dp[i] != 0)
			{
				System.out.printf("%d*%dc ", dp[i], d[i]);
				coins += dp[i];
			}
		}
		
		System.out.println();
		System.out.printf("Optimal coin count: %d\n", coins);
	}
	
	/* public static int[] change_greedy(int n, int[] d)
	{

	} */
	
	public static void main(String[] args)
	{
            int[] p = prompt();
            int[] d = Arrays.copyOfRange(p, 1, p.length);
            int n = p[0];
            int[] dp = change_DP(n, d);
			printDP(n, d, dp);
            
	}

      private static int[] prompt() // {n, d0..di}
      {
            int num;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of coin-denominations and the set of coin values:");
		num = in.nextInt();
		int[] d = new int[num + 1];

		for(int i = 1; i < num + 1; i++)
		{
			d[i] = in.nextInt();
		}
		System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
		int n = in.nextInt();
            d[0] = n;
            return d;
      }
}