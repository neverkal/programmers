package level2.candidatekey;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    int answer = 0;
    ArrayList<String> candidateKeyList = new ArrayList<>();

    public int solution(String[][] relation) {
        int column = relation[0].length;

        boolean[] visited = new boolean[column];

        for (int i = 0; i < column; i++) {
            dfs(relation, visited, 0, i + 1);
        }

        return answer;
    }

    private void dfs(String[][] relation, boolean[] visited, int index, int count) {
        if (count == 0) {
            ArrayList<Integer> candidateList = new ArrayList<>();

            for (int i = 0; i < relation[0].length; i++) {
                if (visited[i] == true) {
                    candidateList.add(i);
                }
            }

            candidateCheck(candidateList, relation);
            return;
        }

        if (index == relation[0].length) {
            return;
        } else {
            visited[index] = true;
            dfs(relation, visited, index + 1, count - 1);

            visited[index] = false;
            dfs(relation, visited, index + 1, count);
        }
    }

    private void candidateCheck(ArrayList<Integer> candidateList, String[][] relation) {
        ArrayList<String> candidateCombination = new ArrayList<>();
        StringBuilder candidateKey = new StringBuilder();

        for (int cand : candidateList) {
            candidateKey.append(cand);
        }

        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();

            for(int candidate : candidateList) {
                sb.append(relation[i][candidate]);
            }

            candidateCombination.add(sb.toString());
        }


        // 중복 체크
        HashSet<String> set = new HashSet<>(candidateCombination);

        if (set.size() == candidateCombination.size()) {
            for (String candidateAddKey : candidateKeyList) {
                int count = 0;
                for (int i = 0; i < candidateKey.length(); i++) {
                    String sub = String.valueOf(candidateKey.charAt(i));
                    if (candidateAddKey.contains(sub)) count++;
                }
                if (count == candidateAddKey.length()) return;
            }
            candidateKeyList.add(String.valueOf(candidateKey));
            answer++;
        }
    }

    @Test
    public void answerTest() {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        Assert.assertEquals(2, solution(relation));
    }
}
