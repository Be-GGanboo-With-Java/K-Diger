# OOP(Object Oriented Programming)

> 절차적 프로그래밍은 데이터에 대한 작업을 수행하는 절차나 메서드를 작성하는 것이고
> 
> 객체 지향 프로그래밍은 데이터와 메서드를 모두 포함하는 객체를 만드는 것이다.

---

## 객체지향 프로그래밍의 특징

- 빠르고 쉽게 실행 가능하다.
- 프로그램의 깔끔한 구조를 제공한다.
- 반복적인 코드를 막고, 수정과 디버그가 쉽다.
- 코드를 재사용 할 수 있게 된다.

---

## OOP 4대 원칙

- 캡슐화(Encapsulation)
- 추상화(Abstraction)
- 상속(Inheritance)
- 다형성(Polymorphism)

---

## 캡슐화(Encapsulation)
> 마치 알약이 내용물을 보호하듯이 코드를 보호해주는 역할을 수행한다.

### Java 에서 캡슐화를 만족시키려면 ? 

- 클래스의 변수를 **private**로 선언한다. #1
- **getter setter** 메서드를 활용한다. #2


        //EncapTest.java//

        public class EncapTest {

            // #1
            private String name;

            // #1
            private int age;

            // #2
            public int getAge() {
                return age;
            }

            // #2
            public String getName() {
                return name;
            }

            // #2
            public void setAge(int newAge) {
                age = newAge;
            }

            // #2
            public void setName(String newName) {
                name = newName;
            }
        }

        //Main.java//

        public class Main {
            public static void main(String args[]) {
                EncapTest encap = new EncapTest();

                // #2
                encap.setName("James");

                // #2
                encap.setAge(20);

                // #2
                encap.setIdNum("12343ms");

                // #2
                System.out.print("Name : " + encap.getName() + " Age : " + encap.getAge());
            }
        }

### 캡슐화의 효과

- 클래스 필드(속성)이 읽기전용 혹은 쓰기전용으로 사용 가능하다. (getter = ReadOnly, setter = writeOnly)
- 한 클래스에서 저장된 필드(속성)에 관하여 전부 제어할 수 있다. (조회 수정 등 자유자재로 가능함)

---

## 추상화(Abstraction)
> 이벤트보다 아이디어를 다루는 개념이다.
> 
> 예를 들어, 이메일을 보내자마자 일어나는 세부사항 내부 프로토콜 등을 전혀 신경쓰지 않도록 하게 하자는 것이다.
> 
> 즉 세부사항을 사용자에게 숨기는 과정, 오로지 기능만 노출되도록 한다.

### Java 에서 추상화를 만족시키려면?

- 추상 클래스를 활용한다.
- Abstract Class vs Interface

<br>

### Abstract Class
- 추상 메서드를 한 개 이상 포함하는 경우
- abstract 키워드로 정의된 경우
  - 추상으로 선언되면 인스턴스화 할수 없다.
  - 추상 클래스를 사용하려면, 다른 클래스에서 반드시 상속하여 사용하고, 명시한 메서드를 구현해야한다.
  - 추상 클래스를 상속하면, 모든 추상 메서드를 구현해야한다.


        public abstract class Employee {
            private String name;
            private String address;
            private int number;

            public Employee(String name, String address, int number) {
                System.out.println("Constructing an Employee");
                this.name = name;
                this.address = address;
                this.number = number;
            }

            public double computePay() {
                System.out.println("Inside Employee computePay");
                return 0.0;
            }

            public void mailCheck() {
                System.out.println("Mailing a check to " + this.name + " " + this.address);
            }

            public String toString() {
                return name + " " + address + " " + number;
            }

            public String getName() {
                return name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String newAddress) {
                address = newAddress;
            }

            public int getNumber() {
                return number;
            }
        }

---

## 상속(Inheritance)

> 한 개채(클래스가) 부모 (다른 클래스)의 속성과 동작을 획득하는 메커니즘이다.

<br>

### Java 에서 상속을 만족시키려면?

- extends 키워드로 상속 받음을 명시하기
- 다중 상속 (여러 클래스 상속 받기)


        class Animal {  
          void eat(){
            System.out.println("eating...");
          } 
        }

        class Dog extends Animal {
          void bark() {
            System.out.println("barking...");
          }  
        }

        class Cat extends Animal {
          void meow() {
            System.out.println("meowing...");
          }
        }

        class TestInheritance3 {
          public static void main(String args[]) {  
            Cat c=new Cat();  
            c.meow();  
            c.eat();
            //c.bark();//C.T.Error  
          }
        }

---

## 다형성(Polymorphism)

> 하나의 작업을 여러가지 방법으로 수행할 수 있는 성격

<br>

### Java 에서 다형성을 만족시키려면?
- 서로 다른 2개 이상의 객체가 하나의 부모에게 상속받아, 그 추상 메서드를 각기 용도에 맞게 달리하여 오버라이딩, 오버로딩하여 구현한다.


        import java.util.Scanner;

        interface OverWatch { // 인터페이스
          void name(); // 추상 메소드
          void lClick(); // 추상 메소드
          void rClick(); // 추상 메소드
          void shiftButton(); // 추상 메소드
          void eButton(); // 추상 메소드
          void qButton(); // 추상 메소드
        }

        class Mei implements OverWatch { // 인터페이스 구현 클래스
            public void name() { // 오버라이딩
              System.out.println("이름 : 메이");
          }
            public void lClick() { // 오버라이딩
              System.out.println("좌클릭 : 냉각총");
          }
            public void rClick() { // 오버라이딩
              System.out.println("우클릭 : 고드름 투사체");
          }
            public void shiftButton() { // 오버라이딩
              System.out.println("shift : 급속 빙결");
          }
            public void eButton() { // 오버라이딩
              System.out.println("e : 빙벽");
          }
            public void qButton() { // 오버라이딩
              System.out.println("q : 눈보라(궁극기)");
          }
        }

        class Reaper implements OverWatch { // 인터페이스 구현 클래스
          public void name() { // 오버라이딩
            System.out.println("이름 : 리퍼");
          }
          public void lClick() { // 오버라이딩
            System.out.println("좌클릭 : 헬파이어 샷건");
          }
          public void rClick() { // 오버라이딩
            System.out.println("우클릭 : 없음");
          }
          public void shiftButton() { // 오버라이딩
            System.out.println("shift : 망령화");
          }
          public void eButton() { // 오버라이딩
            System.out.println("e : 그림자 밟기");
          }
          public void qButton() { // 오버라이딩
            System.out.println("q : 죽음의 꽃(궁극기)");
          }
        }

        public class PolymorphismEx01 {
          public static void main(String[] args) { // main 메소드
            OverWatch ow; // 인터페이스 객체 선언

            System.out.println("플레이할 캐릭터 번호 선택(1. 메이, 2. 리퍼, 3. 맥크리)");

            Scanner sc = new Scanner(System.in); // 스캐너 객체

            int n = sc.nextInt();

            if(n==1) {
              ow = new Mei(); // 업캐스팅
            } else if(n==2) {
              ow = new Reaper(); // 업캐스팅
            } else {
              ow = new Mccree(); // 업캐스팅
            }

          //선택한 조건에 따라서 부모 객체로 자식 메소드 사용(하나의 타입으로 다양한 결과를 얻어냄 / 다형성)
          ow.name();
          ow.lClick();
          ow.rClick();
          ow.shiftButton();
          ow.eButton();
          ow.qButton();
          }
        }
