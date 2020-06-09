import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] nums;
    private int[] candies;
    public int Max;

    public int maxProduct() {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);

    }

    public List<Boolean> kidsWithCandies(int extraCandies) {
        return kidsWithCandies(candies, extraCandies);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (constraint(candies, extraCandies))
            throw new IllegalArgumentException();
        List<Boolean> list = new LinkedList<>();
        int max = candies[0];
        int index = 0;
        Arrays.sort(candies);
        Max = candies[candies.length - 1];
        for (var cady : candies) {
            if ((cady + extraCandies) >= Max)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }

    public boolean constraint(int[] candies, int extraCandies) {
        return candies.length < 2 || candies.length > 100 || extraCandies < 1 || extraCandies > 50;

    }

    public int max(int[] candies, int max, int index) {
        if (candies[index] < 1 || candies[index] > 100)
            throw new IllegalArgumentException();
        max = Math.max(candies[index++], max);
        return (index == candies.length) ? max : max(candies, max, index);
    }

    public int reverse(int x) {
        double r = 0;
        while (x != 0) {
            r *= 10;
            r += x % 10;
            x = x / 10;
        }
        if (r >= Integer.MAX_VALUE || r <= Integer.MIN_VALUE)
            return 0;
        return (int) r;

    }

    public Solution() {
    }

    public Solution(int[] nums) {
        this.nums = nums;
        this.candies = nums;
    }
}