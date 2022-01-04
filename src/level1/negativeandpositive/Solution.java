package level1.negativeandpositive;

public class Solution {
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] sings = {true,false,true};

        System.out.println(solution(absolutes, sings));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
