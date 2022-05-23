package Week3.FindPrimeNumber;

//문제 설명
//
//        1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
//
//        소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
//        (1은 소수가 아닙니다.)
//        제한 조건
//
//        n은 2이상 1000000이하의 자연수입니다.



// 소수 조건?
// 1이랑 자기 자신 빼고 나눠지면 안됨


class Solution {
    public int solution(int n) {
        //에라토스테네스의 체를 활용할 것임

        int[] numbers = new int[n + 1];

        int cnt = 0;

        
        // 배열에 2부터 n 까지의 수 담기
        for (int i = 2; i <= n; i++) {
            numbers[i] = i;
        }

        //2부터 시작해서 그의 배수들을 0으로 만든다.
        //후에 0이면 넘어가고 아니면 그의 배수들을 다시 0으로 만든다.
        for (int i = 2; i <= n; i++) {
            if (numbers[i] == 0) {
                continue;
            }

            for (int j = 2 * i; j <= n; j += i) {
                numbers[j] = 0;
            }
        }

        //배열에서 0이 아닌 것들의 개수를 세준다.
        for (int number : numbers) {
            if (number != 0) {
                cnt++;
            }
        }

        return cnt;
    }
}


public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.solution(11));
    }
}
