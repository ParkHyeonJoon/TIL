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

- **변경 불가능한 클래스**
  - 한번 생성된 String인스턴스가 갖고 있는 문자열은 읽어 올 수만 있다.
  - 문자열이 바뀌면 새로운 문자열이 담긴 String인스턴스가 생성 되는 것.
  
- 빈 문자열이 가능하다. String s = "";(O) String s = null;(X)

### join()과 StringJoiner

join()은 여러 문자열 사이에 구분자를 넣어서 결합한다.
split()의 반대 작업.

```agsl
String animals = "dog,cat,bear";
String[] arr = animals.split(","); // 문자열을 ','를 구분자로 나눠서 배열에 저장
String str =  String.join("-", arr); // 배열의 문자열을 '-'로 구분해서 결합
System.out.print(str) // dog-cat-bear
```

java.util.StringJoiner 클래스 사용법
```agsl
StringJoiner sj = new StringJoiner(",", "[", "]");
String[] strArr = { "aaa", "bbb", "ccc" };

for(String s : strArr) {
    sj.add(s.toUpperCase());
}
System.out.println(sj.toString()); // [AAA, BBB, CCC]
```

### String.format()

format()은 형식화된 문자열을 만들어내는 메서드. printf()와 방법이 아예 같다.

```agsl
String str = String.format("%d 더하기 %d는 %d입니다.", 3, 5, 3+5);
System.out.println(str) // 3 더하기 5는 8입니다.
```

### 기본형 <---> 문자형

**기본형-->문자형**
1. String.valueOf()를 사용한다.
2. 숫자에 빈 문자열""을 더해준다.

**String-->기본형**

 Integer.parseInt(String s)

 Long.parseLong(String s)

## 1.3 StringBuffer클래스와 StringBuilder클래스

**StringBuffer**는 String과 달리 내용 변경이 가능하다. 
1. StringBuffer sb = new StringBuffer("abc");
2. sb.append("123"); // sb내용 뒤에 "123"을 추가한다.
3. String sb2 = sb.append("ZZ"); // sb내용 뒤에 "ZZ"를 추가한다.

append()는 반환타입이 StringBuffer로 자신의 주소를 반환한다.

StringBuffer클래스에는 equals()는 오버라이딩X, toString()은 오버라이딩O

| 메서드 / 설명                                   | 예제 / 결과                                                                       |
|--------------------------------------------|-------------------------------------------------------------------------------|
| StringBuffer()                             | StringBuffer sb = new StringBuffer();<br/>sb = ""                             |
| StringBuffer(int length)                   | StringBuffer sb = new StringBuffer(10);<br/>sb = ""                           |
| StringBuffer(STring str)                   | StringBuffer sb = new StringBuffer("Hi");<br/>sb = "Hi"                       |
| int capacity()<br/>StringBuffer인스턴스의 크기    | StringBuffer sb = new StringBuffer(100);<br/> int buffersize = sb.capacity(); |

**StringBuilder**는 멀티쓰레드에 안전하도록 동기화 되어있다. 

멀티쓰레드로 작성된 프로그램이 아닌 경우, StringBuffer의 동기화는 성능만 떨어뜨리게 된다.

StringBuffer에서 쓰레드의 동기화만 뺀 StringBuilder.

## 1.5 래퍼(wrapper) 클래스

자바에서 8개의 기본형을 객체로 다루지 않는다.

기본형 변수를 객체로 다뤄야 할 경우 사용하는 것이 **래퍼(wrapper)클래스**이다.

### Number 클래스

기본형 중에 숫자와 관련된 래퍼 클래스들의 조상 클래스이다.

그 외에도 BigInteger(long 보다 큰 범위) 와 BigDecimal(double 보다 큰 범위)가 있다. 

### 문자열 --> 숫자로

**타입.parse타입(String s)** 형식의 메서드와 **타입.valueOf()** 형식의 메소드.

전자는 반환값이 기본형이고, 후자는 반환값이 래퍼 클래스 타입이다.

- static int parseInt(String s, int radix) // 문자열 s를 radix진법으로 인식
  - int i = Integer.parseInt("100", 2); // 100(2) -> 4
  - int i = Integer.parseInt("100", 8); // 100(8) -> 64
  - int i = Integer.parseInt("FF", 16); // FF(16) -> 255

### 오토박싱 & 언박싱
JDK1.5 전까지는 기본형과 참조형 간의 연산이 불가능했다.

지금은 컴파일러가 자동으로 변환하는 코드를 넣어줘 가능해졌다.
<table>
  <tr>
    <th>컴파일 전의 코드</th>
    <th>컴파일 후의 코드</th>
  </tr>
  <tr>
    <td>
    int i = 5;<br/>
    Integer iObj = new Integer(7);<br/>
    int sum = i + iObj; // 에러
    </td>
    <td>
    int i = 5;<br/>
    Integer iObj = new Integer(7);<br/>
    int sum = i + iObj.intValue();
    </td>
  </tr>
</table>

이 외에도 객체배열을 가지고 있는 Vector클래스나 ArraryList클래스에 기본형 값을 저장해야 할 때,
형변환이 필요할 때도 컴파일러가 자동으로 코드 추가 해준다.

기본형 값 --> 래퍼 클래스 객체 : **오토박싱**

래퍼 클래스 객체 --> 기본형 값 : **언박싱**

ArrayList에서의 오토박싱 & 언박싱
```agsl
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(10); // 오토박싱. 10 -> new Integer(10)

int value = list.get(0); // 언박싱. new Integer(10) -> 10
```

# 2. 유용한 클래스

## java.util.Objects클래스

- static boolean isNull(Object obj)
- static boolean nonNull(Object obj)
- static <T> T requireNonNull(T obj)
  - 해당 객체가 null이면 NullPointException을 발생시킨다.
  - (T obj, String message) -> 두번째 매개변수로 지정하는 문자열은 예외의 메시지.

- static int compare(Object a, Object b, Comparator c)
  - 비교대상이 같으면 0, 크면 양수, 작으면 음수 반환.
- static boolean equals(Object a, Object b)
- static boolean deepEquals(Object a, Object b)
  - 객체를 재귀적으로 비교. 다차원 배열의 비교가 가능하다.
- equals(), toString(), hashCode() 모두 Object에도 있지만 Objects클래스에 있는 메서드들은 내부적으로 Null 검사를 해준다.


## java.util.Random클래스

- 난수를 얻는 방법
  - double randNum = Math.random();
  - double randNum = **new Random().nextDouble()**;

- Random()은 종자값을 System.currentTimeMillis()로 하여 난수가 계속 바뀐다.
- Random(long seed)는 매개변수 seed를 종자값으로 하는 Random인스턴스를 생성한다.
- next타입형() -> ex) nextInt(), nextDouble(), nextFloat()
- next타입형(int n) -> 0~n 범위에 있는 int값 반환한다.

## 정규식 - java.util.regex패키지

- **정규식** : 텍스트 데이터 중에서 **원하는 조건(패턴)과 일치하는 문자열**을 찾아내기 위해
사용하는 것으로 미리 정의된 기호와 문자를 이용해서 작성한다.

- Patter : 정규식을 정의하는데 사용한다.
- Matcher : 정규식(패턴)을 데이터와 비교하는 역할을 한다.

1. 정규식을 매개변수로 Patter클래스의 static메서드인 **Pattern compile(String regex)을
호출하여 Pattern인스턴스를 얻는다.
>Patter p = Pattern.compile("c[a-z]*");
2. 정규식으로 비교할 대상을 배개변수로 Pattern클래스의 Matcher matcher(CharSequence input)를
호출해서 Matcher인스턴스를 얻는다.
>Matcher m = p.matcher(data[i]);
3. Matcher인스턴스에 boolean matches()를 호출해서 정규식에 부합하는지 확인한다.
>if(m.matches())

- group(int i)
  - 정규식 '(0\\d{1,2})-(\\d{3,4})-(\\d{4})'은 괄호를 이용해서 세 부분으로 나눴다.
  - 0으로 시작하는 최소 2자리 최대 3자리 숫자(0포함), 최소 3자리 최대 4자리 숫자, 4자리 숫자
  - group() or group(0)은 매칭된 문자열 전체, group(1)은 첫번째 그룹, group(2)는 두번째 그룹, group(3)은 세번째 그룹.

- find()
  - 주어진 소스 내에서 패턴과 일치하는 부분을 찾으면 true, 못 찾으면 false
  - 다시 find()를 호출하면 전에 발견한 패턴과 일치하는 부분의 다음부터 다시 매칭 시작한다.
  - start()와 end()로 일치하는 부분을 찾아 낼 수 있다.
  - appendReplacement(StringBuffer sb, String replacement)로 치환할 수 있다.

## java.util.StringTokenizer 클래스

<table>
  <tr>
    <th>생성자/메서드</th>
    <td>설명</td>
  </tr>
  <tr>
    <th>StringTokenizer(String str, String delim)</th>
    <td>문자열(str)을 지정된 구분자(delim)로 나누는 StringTokenizer를 생성한다.</td>
  </tr>
  <tr>
    <th>boolean hasMoreTokens()</th>
    <td>토큰이 남아있는지 알려준다.</td>
  </tr>
  <tr>
    <th>String nextToken()</th>
    <td>다음 토큰을 반환한다.</td>
  </tr>
</table>