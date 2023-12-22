# 예외처리(exception handling) #

- 컴파일 에러 : 컴파일 시에 발생하는 에러
- 런타임 에러 : 실행 시에 발생하는 에러
- 논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것

**에러** : 수습 될 수 없는 심각한 오류

**예외** : 수습 될 수 있는 미약한 오류

**Exception** 클래스 : 사용자의 실수와 같은 외적인 요인에 의해 발생.

**RuntimeException** : 프로그래머의 실수로 발생.

## try-catch문 ##


_________________
> - printStackTrace() : 예외발생 당시에 호출스택(Call Stack)에 있었던 **메서드의 정보**와 **예외 메세지**를 화면에 출력.
> - getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.


```agsl
컴파일 완료 안됨. Why? 'Exception클래스들' 이 발생할 가능성이 있는 문장들에
대해 예외처리를 해주지 않으면 컴파일 안된다!!

public class ex8_10 {
    public static void main(String args[]) {
        throw new Exception(); // Exception 고의로 발생시킴.
    }
}

컴파일러가 예외처리를 확인하는 Exception 클래스들은 'checked예외'
```

```agsl
예외처리를 하지 않았음에도 성공적으로 컴파일 된다. But 실행하면 
RuntimeException 발생해서 비정상적으로 종료!!

public class ex8_10 {
    public static void main(String args[]) {
        throw new RuntimeException(); // RuntimeException 고의로 발생시킴.
    }
}

컴파일러가 예외처리를 확인하지 않는 RuntimeException 클래스들은 'unchecked예외'
```

## 메서드에 예외 선언 ##
```agsl
void method() throws Exception1, Exception2, .... ExceptionN {
    // 메서드 내용
}
```
메서드 선언부에 키워드 throws를 사용해서 예외를 적어주기

예외를 메서드의 throws에 명시하는 것은 자신(예외가 발생할 가능성이 있는 메서드)을
호출한 메서드에게 예외를 전달하여 예외처리를 떠맡기는 것.

```agsl
class ExceptionEx12 {
    public static void main(String[] args) throws Exception {
        mehtod1(); // 같은 클래스 내의 static 멤버이므로 객체생성 없이 직접 호출
    }
    
    static void method1() throws Exception {
        method2();
    }
    
    static void method2() throws Exception {
        throw new Exception(); 
    }
}
```
1. 예외가 발생했을 때, 모두 3개의 메서드(main, method1, method2)가 호출 스택에 있었으며,
2. 예외가 발생한 곳은 제일 윗 줄에 있는 method2() 라는 것과
3. main()이 method1()을, 그리고 method1은 method2를 호출 했다는 것

예외가 처리 되는것이 아니라 예외를 ***단순히 전달만 하는 것***

어느 한 곳에서는 try-catch문으로 예외처리 해줘야 한다.

## finally 블럭 ##
- 예외의 발생여부에 상관없이 실행되어야할 코드를 포함시킬 목적으로 사용.

```agsl
class Test {
    public static void main(String args[]) {
        Test.method();
        System.out.println("method()의 수행을 마치고 main으로 돌아옴.");
    }
    
    static void method() {
        try {
            System.out.println("method()이 호출되었습니다.");
            return; // 현재 실행 중인 메소드를 종료.
        } catch(Exception e) { 
            e.printStackTrace();
        } finally {
            System.out.println("method()의 finally 블럭이 실행.");
        }
    }
}
실행결과 : method()호출 -> finally블럭 실행 -> main으로 돌아옴
try 블럭에서 return문이 실행되는 경우에도 finally 블럭의 문장들이 먼저 실행됨.
```
  







