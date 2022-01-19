package level2.newsclusting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    public int solution(String str1, String str2) {
        // 문자열을 두 집합으로 만들기
        ArrayList<String> firstStringList = splitString(str1.toLowerCase());
        ArrayList<String> secondStringList = splitString(str2.toLowerCase());

        // 합집합 / 교집합 직접 구하기
        ArrayList<String> intersectionList = new ArrayList<>();
        ArrayList<String> unionList = new ArrayList<>();

        for (String word : firstStringList) {
            if (secondStringList.remove(word)) {
                intersectionList.add(word);
            }
            unionList.add(word);
        }

        unionList.addAll(secondStringList);

        double interSectionSize = intersectionList.size();
        double unionSize = unionList.size();

        if (unionSize == 0) {
            return 65536;
        } else {
            return (int) (interSectionSize / unionSize * 65536);
        }
    }

    public static ArrayList<String> splitString(String str) {
        ArrayList<String> splitStringList = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' && str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z') {
                splitStringList.add(str.substring(i, i + 2));
            }
        }

        return splitStringList;
    }

    @Test
    public void answerTest() {
        Assert.assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));
    }
}
