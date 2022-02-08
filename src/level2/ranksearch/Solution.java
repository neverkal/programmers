package level2.ranksearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {

    private static HashMap<String, ArrayList<Integer>> infoMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 경우의 수 만들기
        for (String infoData : info) {
            String[] infoArray = infoData.split(" ");
            dfs("", 0, infoArray);
        }

        // 각 점수 정보 검색을 위한 정렬
        List<String> list = new ArrayList<>(infoMap.keySet());

        for (int i = 0; i < list.size(); i++) {
            List<Integer> pointList = infoMap.get(list.get(i));
            Collections.sort(pointList);
        }

        // 검색
        for (int i = 0; i < query.length; i++) {
            StringBuilder queryParse = new StringBuilder();

            String[] queryArray = query[i].split(" and ");
            String[] pointInfo = queryArray[3].split(" ");

            for (int j = 0; j < 3; j++) {
                queryParse.append(queryArray[j]);
            }

            queryParse.append(pointInfo[0]);
            answer[i] = search(queryParse.toString(), Integer.parseInt(pointInfo[1]));
        }

        return answer;
    }

    private static int search(String queryInfo, int point) {
        if (infoMap.containsKey(queryInfo)) {
            ArrayList<Integer> pointList = infoMap.get(queryInfo);

            int start = 0;
            int end = pointList.size() - 1;

            while(start <= end) {
                int mid = (start + end) / 2;

                if (pointList.get(mid) < point) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return pointList.size() - start;
        } else {
            return 0;
        }
    }

    private static void dfs(String perInfo, int index, String[] info) {
        if (index == 4) {
            if (infoMap.containsKey(perInfo)) {
                infoMap.get(perInfo).add(Integer.parseInt(info[4]));
            } else {
                ArrayList<Integer> pointList = new ArrayList<>();
                pointList.add(Integer.parseInt(info[4]));

                infoMap.put(perInfo, pointList);
            }

            return;
        }

        dfs(perInfo + info[index], index + 1, info);
        dfs(perInfo + "-", index + 1, info);
    }

    @Test
    public void answerTest() {
        int[] answer = {1, 1, 1, 1, 2, 4};
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250", "- and backend and senior and - 150",
                "- and - and - and chicken 100", "- and - and - and - 150"};

        Assert.assertArrayEquals(answer, solution(info, query));
    }
}
