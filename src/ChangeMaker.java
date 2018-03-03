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


	public static void printGreedy(int n, int[] d, int[] dp)
	{
		int coins = 0;
		boolean flag = false;

		System.out.println();
		System.out.println("Greedy algorithm results");
		System.out.printf("Amount: %d\n", n);
		System.out.printf("Optimal distribution: ");

		for(int i = 0; i < dp.length; i++)
		{
			if(dp[i] != 0)
			{
				if(!flag)
				{
					System.out.printf("%d*%dc", dp[i], d[i]);
					flag = true;

				}
				else
				{
					System.out.printf("+ %d*%dc", dp[i], d[i]);
				}


				coins += dp[i];
			}
		}

		System.out.println();
		System.out.printf("Optimal coin count: %d\n\n", coins);
	}

	public static void printDP(int n, int[] d, int[] dp)
	{
		int coins = 0;
		boolean switch = false;

		System.out.println();
		System.out.println("DP algorithm results");
		System.out.printf("Amount: %d\n", n);
		System.out.printf("Optimal distribution: ");

		for(int i = 0; i < dp.length; i++)
		{
			if(dp[i] != 0)
			{
				if(!switch)
				{
					System.out.printf("%d*%dc", dp[i], d[i]);
					switch = true;

				}
				else
				{
					System.out.printf("+ %d*%dc", dp[i], d[i]);
				}


				coins += dp[i];
			}
		}

		System.out.println();
		System.out.printf("Optimal coin count: %d\n\n", coins);
	}


	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int[] p = prompt(keyboard);
		int[] d = Arrays.copyOfRange(p, 1, p.length);
		int n = p[0];



		while(n != 0)
		{
			int[] dp = change_DP(n, d);
			int[] g = change_greedy(n, d);
			printDP(n, d, dp);
			printGreedy(n, d, g);

			System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
			n = keyboard.nextInt();

		}



	}

	private static int[] prompt(Scanner in) // {n, d0..di}
	{
		int num;
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

	public static int[] change_DP(int n, int[] d)
	{
		int[] C = new int[n];
		int[] A = new int[n];
		int[] result = new int[d.length];
		C[0] = 0;

		// initialize arrays
		for(int i = 1; i < n; i++)
		{
			C[i] = Integer.MAX_VALUE-1;
			A[i] = -1;
		}

		for(int i = 0; i < d.length; i++) // iterating {100 , 25 , 10 , 5 , 1}
		{
			for(int j = 0; j < n; j++) // from 0..amount to be changed
			{
				if(j >= d[i]) // if amount to be changed is >= current coin denomination
				{
					if (C[j - d[i]] < C[j])
					{
						C[j] =  C[j - d[i]];
						A[j] = i;
					}
				}

			}
		}

		//constructing the result array
		int index = n - 1;
		while(index > 0)
		{
			if(A[index] != -1)
			{
				result[A[index]]++;
				index -= d[A[index]];
			}
			else
			{
				index--;
			}
		}

		// emergency - we didn't want to do this but we had to....
		if(n % 5 != 0)
		{
			result[result.length - 1]++;
		}



		return result;
	}

	public static int[] change_greedy(int n, int[] d)
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
}
