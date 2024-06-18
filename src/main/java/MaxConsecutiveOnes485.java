import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxConsecutiveOnes485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = max(count, max);
                count = 0;
            }
            else count++;
        }

        return max(count, max);
    }

    public static int max(int a, int b) {
        return a >= b ? a : b;
    }

    public static int findMaxConsecutiveOnesUsingStreamAPI(int[] nums) {
        return Arrays.stream(Arrays.stream(nums)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(""))
                        .split("0"))
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,0,1,0};

        int result = findMaxConsecutiveOnes(nums);

        System.out.println(result);
    }
}
