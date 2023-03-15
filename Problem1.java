package code;

/**
 * Author: Runlin Liu
 * Class: INFO 6205
 */
public class Problem1 {

    /**
     * General ideas:
     * Sort the input sequences and find if there is a conflict between neighboring meetings(when array[i][1] > array[i+1][0])
     * @param intervals
     * @return can make all meetings
     */
    public static boolean solution(int[][] intervals){
        if(intervals.length <= 1) return true;

        sort(intervals);
        for(int[] i : intervals){
            System.out.println(i[0] + ", "+ i[1]);
        }
        for(int i = 1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }

        return true;
    }


    /**
     * Modified quick sort method to apply arrays.
     * Algo details see sort(int left, int right, int[][] m)
     */
    private static void sort(int[][] m){
        if(m.length < 2) return;
        else sort(0, m.length-1, m);
    }



    private static void sort(int left, int right, int[][] m){
        if(left >= right) return;

        int start = left, end = right;
        int pivot = m[start][0];

        while(left < right){
            if(m[right][0] < pivot) {
                left++;
                if(m[left][0] > pivot) swap(left, right, m);
            }
            else right--;
        }

        swap(start, right, m);
        sort(start, right - 1, m);
        sort(right + 1, end, m);
    }

    /**
     * Swap the memory space between position a and b
     *
     */
    private static void swap(int a, int b, int[][] m){
        int[] x = m[a];
        m[a] = m[b];
        m[b] = x;
    }

}
