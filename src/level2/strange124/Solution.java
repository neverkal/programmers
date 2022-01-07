package level2.strange124;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public String solution(int n) {
        String answer = "";

        while (n > 0) {
            int rest = n % 3;

            if (rest == 0) {
                answer = "4" + answer;
                n = Math.round(n / 3) - 1;
            } else if (rest == 1) {
                answer = "1" + answer;
                n = Math.round(n / 3);
            } else if (rest == 2) {
                answer = "2" + answer;
                n = Math.round(n / 3);
            }
        }

        return answer;
    }

    @Test
    public void answer() {
        Assert.assertEquals("1", solution(1));
        Assert.assertEquals("2", solution(2));
        Assert.assertEquals("4", solution(3));
        Assert.assertEquals("11", solution(4));
        Assert.assertEquals("12", solution(5));
        Assert.assertEquals("14", solution(6));
        Assert.assertEquals("21", solution(7));
        Assert.assertEquals("22", solution(8));
        Assert.assertEquals("24", solution(9));
        Assert.assertEquals("41", solution(10));
    }

}
