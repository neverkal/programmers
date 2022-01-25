package level2.report;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        // id별 신고 정보 초기화
        Map<String, Integer> userInfo = new LinkedHashMap<>();
        HashMap<String, HashSet<String>> reportInfo = new HashMap<>();

        for(String id : id_list) {
            userInfo.put(id, 0);
        }

        // 신고 당한 횟수 저장
        for (String reportDetail : report) {
            String[] reportSplit = reportDetail.split(" ");

            String reportUser = reportSplit[0];
            String reported = reportSplit[1];

            // 신고 정보 저장
            HashSet<String> reportedList;

            if (reportInfo.containsKey(reportUser)) {
                reportedList = reportInfo.get(reportUser);

                if (!reportedList.contains(reported)) {
                    // 신고 당한 횟수 저장(중복 불가)
                    userInfo.put(reported, userInfo.get(reported) + 1);
                }
            } else {
                reportedList = new HashSet<>();

                // 신고 당한 횟수 저장(중복 불가)
                userInfo.put(reported, userInfo.get(reported) + 1);
            }

            reportedList.add(reported);
            reportInfo.put(reportUser, reportedList);
        }

        // 메일 발송 정보 저장
        ArrayList<Integer> answerList = new ArrayList<>();

        for(String user : userInfo.keySet()) {
            int mailSendCount = 0;

            if (reportInfo.containsKey(user)) {
                HashSet<String> reportedList = reportInfo.get(user);

                for (String reported : reportedList) {
                    int reportedCount = userInfo.get(reported);

                    if (reportedCount >= k) {
                        mailSendCount++;
                    }
                }
            }

            answerList.add(mailSendCount);
        }

        answer = new int[answerList.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    @Test
    public void answerTest() {
        int[] answer = {0,0};
        String[] idList = {"con", "ryan"};
        String[] reports = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        Assert.assertArrayEquals(answer, solution(idList, reports, k));
    }
}
