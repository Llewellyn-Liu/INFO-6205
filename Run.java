package code;

/**
 * Author: Runlin Liu
 * Class: INFO 6205
 */
public class Run {
    public static void main(String[] args) {

        //Problem 1 solution
        System.out.println("Problem 1:");
        int[][] a = {{1,2},{3,4},{2,5}};
        System.out.println("Can make all meetings?: " + Problem1.solution(a));


        //Problem 2 solution
        System.out.println("\nProblem 2:");
        int[] input = new int[]{0,0,1,0,1,1,0,1};
        Problem2.solution1(input);
    }
}
