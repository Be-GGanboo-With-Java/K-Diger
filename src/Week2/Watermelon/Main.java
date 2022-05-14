package Week2.Watermelon;

//길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
// 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
//        제한 조건
//
//        n은 길이 10,000이하인 자연수입니다.

import java.util.Arrays;

class Solution1 {
    public String solution(int n) {

        String[] arr = new String[n];

        String result = "";


        String soo = "수";
        String bak = "박";


        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                arr[i] = soo;
            } else {
                arr[i] = bak;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            result += arr[j];
        }
        return result;
    }
}

class Solution2 {
    public String solution(int n) {

        String result = "";

        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                result += "수";
            } else {
                result += "박";
            }
        }

        return result;
    }
}


public class Main {

    public static void main(String[] args) {
        Solution2 sol2 = new Solution2();

        sol2.solution(5);
    }
}
