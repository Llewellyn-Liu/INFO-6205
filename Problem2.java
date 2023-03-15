package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Runlin Liu
 * Class: INFO 6205
 */
public class Problem2 {

    /**
     * General ideas:
     * For each window size 1 to input.length, slide the window to check if count(1) is greater than count(0)
     * @param input
     */
    public static void solution1(int[] input) {
        if (input.length == 0) return;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= input.length; i++) {
            System.out.println("Window size: " + i);
            map.put(1,0);
            map.put(0,0);

            for (int init = 0; init < i; init++) {
                map.compute(input[init], (k, v) -> ++v);
            }
            if (map.get(1) > map.get(0)) {
                System.out.println("Valid: " + Arrays.toString(Arrays.copyOfRange(input, 0, i)));
            }


            for (int j = 1; j <= input.length - i; j++) {
                int toDelete = j - 1, toAdd = j + i - 1;
                if(toAdd>=input.length) break;

                if (map.get(input[toDelete]) > 0) {
                    map.compute(input[toDelete], (k, v) -> --v);
                }

                map.compute(input[toAdd], (k, v) -> ++v);

                if ( map.get(1) > map.get(0)) {
                    System.out.println("Valid: " + Arrays.toString(Arrays.copyOfRange(input, j, j + i)));
                }
            }


            map.clear();
        }
    }
}
