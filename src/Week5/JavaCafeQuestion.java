package Week5;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class JavaCafeQuestion {
    public static void main(String[] args) {

        // Q1)

        // 정수배열에서 중복값을 제거 후  오름차순으로 정렬하여 출력하시오

         //[5, 2, 7, 1, 2] -> [1, 2, 5, 7]

        // input [9, 7, 1, 8, 2, 1, 23, 4, 11, 1, 8, 2, 6, 21, 18

        List<Integer> solve1 = new ArrayList(asList(9, 7, 1, 8, 2, 1, 23, 4, 11, 1, 8, 2, 6, 21, 18));

        //Hash 를 쓰면 자동으로 정렬이 된다.
        HashSet<Integer> solve1HashSet = new HashSet<>(solve1);

        solve1.clear();

        solve1.addAll(solve1HashSet);

        Collections.sort(solve1, Collections.reverseOrder());


        // JAVA 8 이후로 Stream으로 간단하게 가능

        solve1.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(solve1);



        // Q2)
        // 정수값이 저장된 리스트가 있다
        // 각 정수들이 몇개가 존재하는지를 찾고 출력
        // 7, 7, 1, 8, 2 ,1, 1, 11, 1, 4, 2, 9, 7, 10

        List<Integer> solve2 = new ArrayList(asList(7, 7, 1, 8, 2, 1, 1, 11, 1, 4, 2, 9, 7, 10));

        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

//        for (Integer item : solve2) {
//            System.out.println(item);
//
//            if (!count.containsKey(item)) {
//                count.put(item, 0);
//            }
//
//            count.put(item, count.get(count) + 1);
//        }

        System.out.println(count);
        System.out.println(
                solve2.stream()
                .collect((Collectors.groupingBy(a -> a, Collectors.counting()))));


    }
}
