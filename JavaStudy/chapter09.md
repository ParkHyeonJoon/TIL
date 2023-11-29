# 1. java.lang 패키지 

java.lang 패키지의 클래스들은 가장 기본 클래스들을 포함. import 없이 사용가능

## 1.1 Object 클래스

| Object클래스의 메서드 | 설명   |
| -------------------|--------|
| **protected** Object clone()| 객체 자신의 복사본을 반환한다.|
| public boolean equals(Object obj)| 객체 자신과 객체 obj가 같은 객체인지 알려준다.(같으면 true)|
| public Class getClass() | 객체 자신의 클래스 정보를 담고 있는 Class인스턴스를 반환한다.|
| public int hashCode() | 객체 자신의 해시코드를 반환한다.|
 | public String toString() | 객체 자신의 정보를 문자열로 반환한다.|

### equals(Object obj)

```agsl
public boolean equals(Object obj) {
    return (this==obj);
}
```
매개변수로 객체의 참조변수를 받아서 비교하여 결과를 boolean 값으로 알려줌.

Object클래스로부터 상속받은 equals 메서드는 주소값으로 비교.
```agsl
Value v1 = new Value(10);
Vaule v2 = new Value(10);
v1.equals(v2); // false
v2 = v1;
v1.equals(v2); // true
```
'v2 = v1'을 수행한 후에는 참조변수v2는 v1이 참조하고 있는 인스턴스의 주소값이 저장됨.

>String클래스, Date,File,wrapper클래스(Integer,Double 등)의 equals메서드는 주소값이 아닌 내용을 비교하도록 오버라이딩 되어있다.
```agsl
public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        return (anObject instanceof String aString)
                && (!COMPACT_STRINGS || this.coder == aString.coder)
                && StringLatin1.equals(value, aString.value);
    }
```

### haseCode()

해싱기법에 사용되는 **해시함수** 를 구현한 것.

찾고자하는 값을 입력하면, 그 값이 저장된 **위치** 를 알려주는 해시코드를 반환.

- Object클래스에 정의된 hashCode메서드는 객체의 주소값으로 해시코드를 만들어 반환.
    - 서로 다른 두 객체는 같은 해시코드 가질 수 없음.(32bit JVM에서)
    - 64bit JVM에서는 8byte 주소값으로 해시코드(4byte) 만들기 때문에 중복될 수 있음.

- String클래스는 문자열 내용이 같으면 동일한 해시코드 반환하도록 오버라이딩 되어있음.


### toString()


인스턴스에 대한 정보(인스턴스 변수에 저장된 값)을 문자열로 제공할 목적으로 정의.
```agsl
public String toString() {
    return getClass().getName()+"@"+Integer.toHexString(hashCode());
}
```
Object클래스에 정의된 대로 사용하면 클래스이름@16진수의 해시코드 반환.

String클래스나 Date클래스에서 toString() 호출하면 String인스턴스가 갖고있는 문자열과
Date인스턴스가 갖고 있는 날짜와 시간을 문자로 반환하도록 오버라이딩 되어있음.
--------------------------

```agsl
class Card {
    String kind;
    int number;

    Card() {
        this("Space", 1); // Card(String kind, int number)를 호출
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public String toString() {
        return "kind : " + kind + ", number : " + number; // Card인스턴스의 kind와 number를 문자열로 출력
    }
}
```
toString()을 직접 오버라이딩 하여 해당 Card인스턴스의 kind와 number를 문자열로 출력 받음.

조상에 정의된 메서드를 자손에서 오버라이딩 할 때 조상에 정의된 접근범위보다 같거나 더 넓어야함.
그래서 toString()의 접근 제어자를 public으로 할 수 밖에 없다.

### clone()

자신을 복제하여 새로운 인스턴스를 생성하는 일.

Object클래스에 정의된 clone()은 인스턴스변수의 값만 복사, 그래서 참조타입의 인스턴스변수가 있는 클래스는
완전한 인스턴스 복제가 **X**

예를 들어 배열의 경우, 복제된 인스턴도스도 같은 배열의 주소를 같기 때문에 복제된 인스턴스의 작업이 원래의
인스턴스에 영향을 미치게 됨. 이런 경우는 clone()을 오버라이딩 해야됨.

**공변 반환타입**
clone()의 반환타입은 Object인데, 이것을 상속 받는 클래스타입으로 변경 시키는 것.
```agsl
원래 코드
public Object clone() {
    Object obj = null;
    try {
        obj = super.clone(); // 조상인 Object의 clone()을 호출.
    } catch(CloneNotSupportedException e) {}
    return obj;
}

공변 반환타입 사용
public Point clone() { // 실제 반환되는 자손 객체의 타입으로 변경.
    Object obj = null;
    try {
        obj = super.clone();
    } catch(CloneNotSupportedException e) {}
    return (Point)obj; // Point 타입으로 형변환.
}
```
---------------------------
```agsl
배열도 객체이므로 Objcet클래스를 상속 받음. 
배열에서는 clone()을 public으로 오버라이딩 해놔서 직접 호출 가능.

int[] arr = {1, 2, 3, 4, 5};
int[] arrClone = arr.clone();
```
배열 뿐 아니라 Vector, ArrayList, LinkedList, HashSet, TreeSet,... 같은 클래스들이
이와 같이 복제 가능.

*clone()으로 복제 가능한 클래스인지 확인하려면 Java Api에서 Cloneable 구현하였는지 확인.*

#### 얕은 복사와 깊은 복사

얕은 복사 : 원본과 복제본이 같은 객체를 공유.
```agsl
public Circle shallowCopy() { // 얕은 복사
        Object obj = null;
        
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e) {}
        return (Circle)obj;
    }
```
깊은 복사 : 원본과 복사본이 서로 다른 객체를 참조.
```agsl
public Circle deepCopy() { // 깊은 복사
        Object obj = null;
        
        try {
            obj = super.clone();
        } catch(CloneNotSupportedException e) {}
        Circle c = (Circle) obj;
        c.p = new Point(this.p.x, this.p.y);
        
        return c;
    }
```
```agsl
Circle c = (Circle) obj;
c.p = new Point(this.p.x, this.p.y);
```
이 두 줄을 추가하여 복제된 객체가 새로운 Point인스턴스를 참조하도록 함.

**기본형 배열 같은 경우는 크게 상관없음. 객체형 배열에서는 차이가 있음.**

### getClass()

자신이 속한 클래스의 Class객체를 반환하는 메서드.

클래스 객체 : 클래스 파일을 읽어서 사용하기 편한 형태로 저장해놓은 것.

- 클래스 객체를 얻는 방법
    - Class cObj = new Card().getClass(); // 생성된 객체로 부터 얻는 방법
    - Class cObj = Card.class; // 클래스 리터럴로부터 얻는 방법
    - Class cObj = Class.forName("Card"); // 클래스 이름으로부터 얻는 방법


## 1.2 String 클래스



