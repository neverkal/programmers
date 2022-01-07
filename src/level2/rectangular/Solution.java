package level2.rectangular;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Solution {
    public long solution(int w, int h) {
        /*
            1. 표시된 선의 반복이 끝나는 패턴 및 패턴 끝나는 지점의 좌표 파악
            2. 가로/세로의 최대 공약수 만큼 증가 확인
            3. 패턴 내의 사용하지 못하는 정사각형 확인(패턴의 총 정사각형 개수 - (가로 + 세로 - 1))
            4. 최종 공식 : 전체 크기 - 한 패턴 직사각형 당 사용하지 못하는 정사각형 크기 * 반복횟수
        */
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }

    @Test
    public void answer() {
        Assert.assertEquals(80, solution(8, 12));
        Assert.assertEquals(80, solution(12, 8));
        Assert.assertEquals(12, solution(4, 4));
    }
}
