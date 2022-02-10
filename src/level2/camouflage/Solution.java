package level2.camouflage;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Solution {

    public int solution(String[][] clothes) {
        int answer;

        HashMap<String, Integer> clothesMap = new HashMap<>();

        // map에 종류 만큼 추가
        for (String[] c : clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
        }

        /*
            * 1. 종류가 A,B 두 가지일 경우 각 종류에 대하여 조합을 구하는 수는 A*B
            * 2. 한 종류만 선택할 수 있는 경우가 있기 때문에 (A+1)*(B+1) 의 경우의 수가 나옴
            * 3. 마지막으로 아무것도 선택 안하는 경우의 수가 존재할 수 있어서 마지막에 -1
        */
        if (clothesMap.size() > 1) {
            answer = 1;

            for (String key : clothesMap.keySet()) {
                answer *= clothesMap.get(key) + 1;
            }
            answer--;

            return answer;
        } else {
            return clothes.length;
        }
    }

    @Test
    public void answerTest() {
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        Assert.assertEquals(5, solution(clothes));
    }
}
