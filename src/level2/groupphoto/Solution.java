package level2.groupphoto;

class Solution {
    public static int answer = 0;
    public static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        System.out.println(solution(n, data));
    }

    public static int solution(int n, String[] data) {
        boolean[] isVisited = new boolean[8];
        dfs("", isVisited, data);

        return answer;
    }

    private static void dfs(String names, boolean[] isVisited, String[] conditionInfo) {
        // 깊이 우선 탐색
        if (names.length() == 7) {
            if (checkCondition(names, conditionInfo)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) { // 조합
            if (!isVisited[i]) {
                isVisited[i] = true;
                String name = names + friends[i];
                dfs(name, isVisited, conditionInfo);
                isVisited[i] = false;
            }
        }
    }

    // 조건 확인
    private static boolean checkCondition(String names, String[] conditionInfo) {
        for (String condition : conditionInfo) {
            int position1 = names.indexOf(condition.charAt(0)); // 포지션1
            int position2 = names.indexOf(condition.charAt(2)); // 포지션2

            char op = condition.charAt(3); // 수식
            int index = condition.charAt(4) -'0'; // 간격

            if (op == '=') {
                // 동일
                if (!(Math.abs(position1 - position2) == index+1)) return false;
            } else if (op == '>') {
                // 초과
                if (!(Math.abs(position1 - position2) > index+1)) return false;
            } else if (op == '<') {
                // 미만
                if (!(Math.abs(position1 - position2) < index+1)) return false;
            }
        }
        return true;
    }
}
