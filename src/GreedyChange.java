import java.util.*;


public class GreedyChange
 {
	public static void main(String[] args)
	{
            int[] d = prompt();
            int n = d[0];
            
	}

	public static int[] change_greedy(int n, int[] d)
	{

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
