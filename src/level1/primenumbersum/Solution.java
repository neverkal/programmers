package level1.primenumbersum;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int x = j + 1; x < nums.length; x++) {
                    int sum = nums[i] + nums[j] + nums[x];
                    boolean isPrimeCheck = isPrime(sum);

                    if (isPrimeCheck) answer++;
                }
            }

        }

        return answer;
    }

    public static boolean isPrime(int num) {
        boolean isPrimeFlag = true;

        for(int i = 2; i < num; i++) {
            if( num % i == 0) {
                isPrimeFlag = false;
                break;
            } else {
                isPrimeFlag = true;
            }
        }
        return isPrimeFlag;
    }
}
