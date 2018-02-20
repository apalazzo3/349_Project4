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
			counts[i] = (int)Math.floor(n/d[i]);
			n = n%d[i];
		}
		
		return counts;
	}
	
	public static int[] change_greedy(int n, int[] d)
	{

	}
	
	public static void main(String[] args)
	{
            int[] d = prompt();
            int n = d[0];
            
	}

      private int[] prompt() // {n, d0..di}
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