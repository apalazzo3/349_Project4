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
		int counts = new int[d.length];
		
		for(int i = 0; i < d.length; i++)
		{
			counts[i] = Math.floor(n/d[i]);
			n = n%d[i];
		}
		
		return counts;
	}
	
	public static void main(String[] args)
	{
		
	}
}