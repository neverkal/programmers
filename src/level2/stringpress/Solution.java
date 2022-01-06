package level2.stringpress;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String checkString = s.substring(0, i);
            String last = "";
            String convert = "";

            int count = 1;
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                if (checkString.equals(s.substring(j, j + i))) {
                    count++;
                } else {
                    convert += checkString;
                    if (count != 1) {
                        convert = count + convert;
                    }
                    checkString = s.substring(j, j + i);
                    count = 1;
                }
            }
            convert += checkString + last;
            if (count != 1) {
                convert = count + convert;
            }

            answer = Math.min(answer, convert.length());
        }

        return answer;
    }
}
