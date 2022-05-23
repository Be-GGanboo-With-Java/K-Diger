# Null VS isEmpty

---

## NULL

    public class NullTest {
        public static void main(String[] args) {
            String str = null;
            System.out.println(str.length());
        }
    }

> 위와 같이 Null 을 넣는다는 구문을 입력하면, JVM 이 메모리를 할당하지 않는다.
> 
> 따라서 위 str 이라는 문자열 변수는 메모리가 할당 되지 않은 변수이므로 없는 변수와 마찬가지이다.


## isEmpty

    public class EmptyTest {
        public static void main(String[] args) {
            String str = "";
            System.out.println(str.length());
        }
    }

> 위와 같이 "" 으로 빈 문자열을 넣는다는 구문을 입력하면, JVM 은 해당 변수에 비어있는 값을 가지는 변수를 넣기 위해 메모리를 할당한다.
> 
> 또한 해당 변수의 길이를 출력하면 오류가 아닌, 0이라는 길이가 없다는 결과를 나타낸다.


## Conclusion

> 메모리 자체를 할당하지 않는 Null
> 
> 비록 프로그래머에게 와닿는, 무엇인가를 나타내는 값은 아니지만 메모리를 할당받는 Empty