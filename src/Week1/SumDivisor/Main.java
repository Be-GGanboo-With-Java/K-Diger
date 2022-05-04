package Week1.SumDivisor;


// 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
// n은 0 이상 3000이하인 정수입니다.

//약수의 조건 == 나눴을때 나머지가 0


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
        System.out.println(AdvancedSolution(n));

    }

    //약수의 합을 계산할 메서드
    public static int solution(int n) {
        int answer = 0;

        // 0은 약수가 될 수 없으므로 1부터 시작, 자기 자신은 무조건 약수에 포함하므로 반복문 인덱스 + 1
        for (int i = 1; i < n+1; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }

    //약수의 합을 계산할 메서드 . Advanced
    public static int AdvancedSolution(int n) {
        int answer = 0;

        // n의 제곱근 까지만 반복하여도, 약수는 루트 n 을 기점으로 짝을 이루기 때문에 상관없다.
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {

                answer += i;
            }
        }
        return answer + n;
    }
}
