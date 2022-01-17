package level2.menurenewal;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    static List<String> combination;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        combination = new ArrayList<>();

        //모든 경우의 수 구하기 (dfs)
        for(int i = 0; i < orders.length; i++) {
            String[] one = orders[i].split("");
            Arrays.sort(one);

            for(int j = 0; j < one.length-1; j++) {
                for(int k = 0; k < course.length; k++) {
                    dfs(one, j, 1, course[k], one[j]);
                }
            }
        }

        Map<String , Integer> combinationMap = new HashMap<>();

        for(String menu : combination) {
            combinationMap.put(menu, combinationMap.getOrDefault(menu, 0)+1);
        }


        List<String> list = new ArrayList<>(combinationMap.keySet());
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return combinationMap.get(o2) - combinationMap.get(o1);
            }
        });


        List<String> answerList = new ArrayList<>();

        for(int i=0; i< course.length; i++) {
            int max =0;

            // course 갯수별로 가장 인기있는 품목 선정
            for(String courseMenu : list) {
                if(combinationMap.get(courseMenu)>1 && courseMenu.length() == course[i]) {
                    if(combinationMap.get(courseMenu) >= max) {
                        answerList.add(courseMenu);
                        max = combinationMap.get(courseMenu);
                    }
                }
            }
        }

        // 문자순 정렬
        Collections.sort(answerList);

        answer = new String[answerList.size()];
        answerList.toArray(answer);

        return answer;
    }


    static void dfs(String[] one, int idx, int len, int courseLen, String str) {
        if(len == courseLen) {
            combination.add(str);
        }

        for(int i= idx+1; i<one.length; i++) {
            dfs(one, i, len+1, courseLen, str+one[i]);
        }
    }

    @Test
    public void answerTest() {
        String[] orders = {"ABCD", "ABCD", "ABCD"};
        int[] course = {2, 3, 4};
        String[] answer = {"AB", "ABC", "ABCD", "ABD", "AC", "ACD", "AD", "BC", "BCD", "BD", "CD"};

        Assert.assertArrayEquals(answer, solution(orders, course));
    }
}
