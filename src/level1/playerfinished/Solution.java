package level1.playerfinished;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> playerInfo = new HashMap<>();

        for (String participantPlayer : participant) playerInfo.put(participantPlayer, playerInfo.getOrDefault(participantPlayer, 0) + 1);
        for (String completionPlayer : completion) playerInfo.put(completionPlayer, playerInfo.get(completionPlayer) -1);

        for (Map.Entry<String, Integer> entry : playerInfo.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}
