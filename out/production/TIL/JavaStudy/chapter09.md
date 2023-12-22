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



