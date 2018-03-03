/*
* CS 349
* Project 4
*
* @authors: Griffin Johnson & Michael Lozada
* @id: mlozada & gpjohnso
* @date: February 20, 2018
*/
import java.util.*;

public class Tester
{
    public staic void main(String[] args)
    {
        int[] set1 = {100, 50, 25, 10, 5, 1};
        int[] set2 = {100, 50, 20, 15, 10, 5, 3, 2, 1 };
        int[] set3 = {64, 32, 16, 8, 4, 2, 1};
        int[] set4 = {100, 50, 25, 10, 1};
        int[] set5 = {66, 35, 27, 18, 10, 1};

        System.out.println("Testing change_DP and change_greedy algortihms");

        // set 1 *************************
        int matches = 0;
        for(int i = 1; i < 201; i++)
        {
            matches += compareCoins(ChangeMaker.change_DP(i, set1), ChangeMaker.change_greedy(i, set1));
        }
        System.out.println("Testing set1: " + matches + " matches in 200 tests");
        // *************************

        // set 2 *************************
        matches = 0;
        for(int i = 1; i < 201; i++)
        {
            matches += compareCoins(ChangeMaker.change_DP(i, set2), ChangeMaker.change_greedy(i, set2));
        }
        System.out.println("Testing set2: " + matches + " matches in 200 tests");
        // *************************

        // set 3 *************************
        matches = 0;
        for(int i = 1; i < 201; i++)
        {
            matches += compareCoins(ChangeMaker.change_DP(i, set3), ChangeMaker.change_greedy(i, set3));
        }
        System.out.println("Testing set3: " + matches + " matches in 200 tests");
        // *************************

        // set 4 *************************
        matches = 0;
        for(int i = 1; i < 201; i++)
        {
            matches += compareCoins(ChangeMaker.change_DP(i, set4), ChangeMaker.change_greedy(i, set4));
        }
        System.out.println("Testing set4: " + matches + " matches in 200 tests");
        // *************************

        // set 5 *************************
        matches = 0;
        for(int i = 1; i < 201; i++)
        {
            matches += compareCoins(ChangeMaker.change_DP(i, set5), ChangeMaker.change_greedy(i, set5));
        }
        System.out.println("Testing set5: " + matches + " matches in 200 tests");
        // *************************

    }

    // returns the number of matching elements
    private static int compareCoins(int[] dynamic, int[] greedy)
    {
        int counter = 0;
        for(int i = 0; i < dynamic.length; i++)
        {
            if(dynamic[i] == greedy[i]) ++counter;
        }
        return counter;
    }
}
