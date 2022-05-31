package Week3.FindPrimeNumber;

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

        System.out.println(s.solution(10));
    }
}
