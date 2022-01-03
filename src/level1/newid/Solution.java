package level1.newid;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String new_id) {
        String answer = new_id.toLowerCase(); // 소문자로

        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");

        if(answer.equals(""))
            answer += "a";

        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("^[.]|[.]$", "");
        }
        if(answer.length() <= 2) // 2자 이하라면 3자까지 마지막 문자추가
            while(answer.length() < 3)
                answer += answer.charAt(answer.length() - 1);

        return answer;
    }
}
