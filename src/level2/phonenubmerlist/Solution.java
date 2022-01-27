package level2.phonenubmerlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Solution {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        boolean answerCheck = false;

        HashMap<String, Integer> phoneMap = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            phoneMap.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            if (answerCheck) break;

            for (int j = 0; j < phone_book[i].length(); j++) {
                if (phoneMap.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    answerCheck = true;
                    break;
                }
            }
        }

        return answer;
    }

    @Test
    public void answerTest() {
        String[] phoneBook = {"12","123","1235","567","88"};
        Assert.assertEquals(false, solution(phoneBook));
    }
}
