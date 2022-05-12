# Iterator(for-loop) VS forEach(stream)

### For-loop(반복문)을 이용한 배열 접근 후 최댓값 도출

    int[] a = ints;
    
    int e = ints.length;
    
    int m = Integer.MIN_VALUE;
    
    for(int i=0; i < e; i++)
    if(a[i] > m) m = a[i];



### Stream을 이용한 배열 접근 후 최댓값 도출

    int m = Arrays.stream(ints)
    .reduce(Integer.MIN_VALUE, Math::max);

<br>

> 두 코드를 동작시킨 환경에서의 성능차이는 다음과 같다.

int-array, for-loop : 0.36 ms

int-array, seq. stream: 5.35 ms

---
단편적인 예시이긴 하지만 일반 배열이아닌 ArrayList 에서도 반복문이 더 우세한 결과를 가지고 있었다.


https://pamyferret.tistory.com/49

또한 위 블로그에 따르면

For-loop이 더 빠른 이유를 설명한다.


## for문은 단순 인덱스 기반이다.
#### for문은 단순 인덱스 기반으로 도는 반복문으로 메모리 접근이기 때문에 Stream에 비해 빠르고 오버헤드도 없다.
#### stream의 경우는 JVM이 이것저것 처리해줘야하는 것들이 많아 실행 시 느릴 수 밖에 없다.


## for문은 컴파일러가 최적화를 시킨다.
#### stream은 java 8부터 지원한 것이고 for문은 그보다 훨씬 오래전부터 계속 사용해왔다.
#### 그만큼 사용되는 컴파일러는 오래 사용된 for문에 대한 처리가 되어 있어 for문의 경우 미리 최적화를 시킬 수 있지만,
#### stream의 경우 for-loop 에 비해 상용 시기가 짧은 만큼 정보가 없어 for문과 같은 정교한 최적화를 수행할 수 없다.