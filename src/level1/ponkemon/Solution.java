package level1.ponkemon;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        // 중복 포함 제거
        for(int i=1; i<nums.length; i++) {
            if(!list.contains(nums[i])) list.add(nums[i]);
        }

        // 가질 수 있는 폰켓몬 계산
        return (list.size() < nums.length/2) ? list.size() : nums.length/2;
    }

}
