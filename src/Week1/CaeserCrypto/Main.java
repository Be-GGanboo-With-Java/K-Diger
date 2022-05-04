package Week1.CaeserCrypto;

// 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
// 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
// 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
//
//    공백은 아무리 밀어도 공백입니다.
//    s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//    s의 길이는 8000이하입니다.
//    n은 1 이상, 25이하인 자연수입니다.


public class Main {
    public static void main(String[] args) {

        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            //문자열 문자 단위로 슬라이싱
            char character = s.charAt(i);

            //공백이 아니면 실행
            if (character != ' ') {

                //대문자 범위 = 65 ~ 90
                //소문자 범위 = 97 ~ 122

                // 대문자 일때
                if (character >= 65 && character <= 90) {

                    // n 만큼 밀었을 때 Z 보다 커지면
                    if (character + n > 90) {
                        result.append(Character.toString(65 + character + n - 1 - 90));
                    }
                    else {
                        result.append(Character.toString(character + n));
                    }

                }

                //


                // 소문자 일때
                if (character >= 97 && character <= 122) {

                    // n 만큼 밀었을 때 z 보다 커지면
                    if (character + n > 122) {
                        result.append(Character.toString(97 + character + n - 1 - 122));
                    }

                    else {
                        result.append(Character.toString(character + n));
                    }
                }
            }
            //공백은 그대로 문자열에 추가
            else {
                result.append(character);
            }
        }

        return String.valueOf(result);
    }
}
