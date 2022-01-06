package level2.colorbook;

class Solution {
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int sizeOfOneArea = 0;

    // 상,하,좌,우 탐색을 위한 배열.
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };

        solution(m, n, picture);
    }

    public static void dfs(int x,int y, int[][] picture, boolean[][] check){
        if(check[x][y]) return;
        check[x][y] = true;

        sizeOfOneArea++;

        for(int i =0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=picture.length || ny<0 || ny>=picture[0].length) continue;

            if(picture[x][y] == picture[nx][ny] && !check[nx][ny]){
                // 재귀 호출하여 영역 탐색
                dfs(nx,ny,picture,check);
            }
        }
    }

    public static int[] solution(int m, int n, int[][] picture) {
        numberOfArea =0;
        maxSizeOfOneArea=0;

        int[] answer = new int[2];

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        boolean[][] check = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !check[i][j]){
                    numberOfArea++;
                    dfs(i,j,picture,check);
                }

                if(sizeOfOneArea > maxSizeOfOneArea) maxSizeOfOneArea = sizeOfOneArea;
                sizeOfOneArea = 0;
            }
        }

        // 15. 각 값을 answer 배열에 담아주고 끝.
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }
}
