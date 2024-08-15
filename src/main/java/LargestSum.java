
import java.util.List;

public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list. A number can't be added
     * to itself, unless there are duplicates.
     *
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums){
        if (nums == null || nums.size() < 2) {
            // Not enough elements to form a pair
            return 0;
        }

        Integer max1 = null; // largest number
        Integer max2 = null; // second largest number
        boolean foundMax1Twice = false; // flag to check if max1 is present at least twice

        for (int num : nums) {
            if (max1 == null || num > max1) {
                max2 = max1; // update second largest
                max1 = num; // update largest
                foundMax1Twice = false; // reset flag as max1 might have changed
            } else if (num == max1) {
                foundMax1Twice = true; // found another instance of max1
            } else if (max2 == null || num > max2) {
                max2 = num; // update second largest if num is between max1 and max2
            }
        }

        // If max1 is found at least twice, return its doubled value
        if (foundMax1Twice) {
            return max1 + max1;
        }

        // Otherwise, return the sum of max1 and max2
        return (max1 != null && max2 != null) ? max1 + max2 : 0;
    }
}