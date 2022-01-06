package level2.openchat;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(record));
    }

    public static String[] solution(String[] record) {
        ArrayList<String> answerList = new ArrayList<>();
        HashMap<String, String> userInfo = new HashMap<>();

        // 초기 설정
        for(String userRecord :record) {
            String[] recordSplit = userRecord.split(" ");

            if (recordSplit[0].equals("Enter")) {
                userInfo.put(recordSplit[1], recordSplit[2]);
            } else if (recordSplit[0].equals("Change")) {
                userInfo.put(recordSplit[1], recordSplit[2]);
            }
        }

        // 출력
        for (String printRecord :record) {
            StringBuilder print = new StringBuilder();
            String[] printSplit = printRecord.split(" ");

            if (printSplit[0].equals("Enter")) {
                print.append(userInfo.get(printSplit[1]));
                print.append("님이 들어왔습니다.");
            } else if (printSplit[0].equals("Leave")) {
                print.append(userInfo.get(printSplit[1]));
                print.append("님이 나갔습니다.");
            } else {
                continue;
            }

            answerList.add(print.toString());
        }

        return answerList.toArray(new String[answerList.size()]);
    }
}

