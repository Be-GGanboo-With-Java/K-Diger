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
        public int getAge() { return age; }
    
        // #2
        public String getName() { return name; }

        // #2
        public void setAge(int newAge) { age = newAge; }

        // #2
        public void setName(String newName) { name = newName; }

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

### Abstract Class VS Interface

- 추상 클래스는 추상 메서드뿐만 아니라 생성자, 필드, 일반 메소드도 포함할 수 있다.

<br>

- 인터페이스는 오로지 추상 메서드와 상수만을 포함할 수 있다.

<br>

- 자바는 클래스를 통한 다중 상속은 지원하지 않지만 클래스와 인터페이스를 통한 다중 상속은 지원하기 때문에 인터페이스를 사용한다.

---

## 상속(Inheritance)

> 한 클래스가 다른 클래스의 속성과 동작을 획득하는 메커니즘이다.

<br>

### Java 에서 상속을 만족시키려면?

- extends 키워드로 상속 받음을 명시하기
- 다중 상속 (여러 클래스 상속 받기)


    // 부모 클래스
    class Animal {  
      
      void eat() { System.out.println("eating..."); }

    }

    //자식 클래스 (상속 받음)
    class Dog extends Animal {
      
    void bark() { System.out.println("barking..."); }  
    
    }

    //자식 클래스 (상속 받음)
    class Cat extends Animal {
      
    void meow() { System.out.println("meowing..."); }
    
    }

    //메인 클래스
    class TestInheritance3 {
      public static void main(String args[]) {  
        
        Cat c=new Cat();
        c.meow();  
        c.eat();

        //Type Error
        //c.bark(); 
      }
    }

---

## 다형성(Polymorphism)

> 상위 클래스에서 동일한 메서드로 하위 클래스를 서로 다르게 동작 시킬 수 있는 원리

부모 클래스가 자식 클래스의 동작 방식을 알 수 없어도 오버라이딩을 통해 자식 클래스에 접근 가능하다.

<br>

### Java 에서 다형성을 만족시키려면?
1) 부모-자식 클래스 구현
2) 메서드 오버라이딩
3) 업캐스팅하여 객체 선언
4) 부모 클래스 객체로 자식 메서드 호출


** 업캐스팅이란? 자식 클래스가 부모 클래스 타입으로 변환 되는 것 <br>
** 다운캐스팅이란? 부모 클래스가 자식 클래스 타입으로 변환 되는 것

    import java.util.Scanner;
    
    interface Player { // 인터페이스
      void name(); // 추상 메소드
      void shoot(); // 추상 메소드
      void hiddenShoot(); // 추상 메소드
    }
    

    // 인터페이스 구현 클래스
    class Zlatan implements Player {
      
        // 오버라이딩
        public void name() { 
          System.out.println("이름 : 즐라탄 이브라히모비치");
      }

        // 오버라이딩
        public void shoot() {
          System.out.println("맞고 죽어라 슛");
      }

        // 오버라이딩
        public void hiddenShoot() { // 오버라이딩
          System.out.println("아크로바틱 슛");
      }

    }

    // 인터페이스 구현 클래스
    class Drogba implements Player { 

      // 오버라이딩
      public void name() {
        System.out.println("이름 : 디디에 드로그바");
      }

      // 오버라이딩
      public void shoot() {
        System.out.println("대포알 슛");
      }

      // 오버라이딩
      public void hiddenShoot() {
        System.out.println("수비수 3명 데리고 슛하기");
      }
    }
    
    public class PolymorphismExample {
      public static void main(String[] args) {

        // 인터페이스 객체 선언
        Player player; 

        System.out.println("플레이할 캐릭터 번호 선택(1. 즐라탄, 2. 드록바)");

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 업캐스팅
        if(n==1) { player = new Zlatan(); }
        // 업캐스팅 
        else if(n==2) { player = new Drogba(); }
      
        //선택한 조건에 따라서 부모 객체로 자식 메소드 사용(하나의 타입으로 다양한 결과를 얻어냄 / 다형성)
        player.name();
        player.shoot();
        player.hiddenShoot();

      }
    }
