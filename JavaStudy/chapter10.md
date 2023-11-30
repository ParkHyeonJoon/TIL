# 1. 날짜와 시간

## Calendar와 Date

- Calendar는 추상클래스이다.
  - Calendar cal = new Calendar(); -> 에러!! 추상클래스는 인스턴스 생성 불가.
  - Calendar cal = Calendar.getInstance(); -> getInstance()메서드로 반환.

  - Calendar today = Calendar.getInstance(); // 기본적으로 현재 날짜와 현재 시간.
  - today.get(Calendar.YEAR), today.get(Calendar.Month)....
  - int get(int field)를 이용해서 원하는 필드의 값을 얻어온다.
  - get메서드의 매개변수인 field는 Calendar에 정의된 static상수이다.
  - void set(field들)로 값을 설정할 수 있다.

*get(Calendar.MONTH)로 얻어오는 값의 범위가 0~11이므로 0이면 1월, 11이면 12월이다.*
 
두 날짜간의 차이를 알고 싶으면 'boolean after(Object when)'와 'boolean before(Object when)' 사용.

## 형식화 클래스

- DecimalFormat
  - 숫자 데이터를 형식화 하여 사용할 수 있다.
  - 1. 출력형식의 패턴을 작성해 DecimalFormat인스턴스를 생성한다.
  - 2. 출력하고자 하는 문자열로 format메서드를 호출하면 원하는 패턴에 맞게 변환된다.
```agsl
double number = 1234567.89;
DecimalFormate df = new DecimalFormat("#.#E0"); // 원하는 출력형식
String result = df.format(number);
```

- parse(String source)
  - public Number parse(String source) throws ParseException
  - parse메서드는 DecimalFormat의 조상인 NumberFormat에 정의된 메서드.
  - Number클래스는 래퍼클래스의 조상이다. 
    - intValue(), doubleValue(), floatValue()등의 메서드가 Number클래스에 정의되어있다.
  - parse메서드를 이용하면 기호와 문자가 포함된 문자열을 숫자로 쉽게 변환할 수 있다.


- SimpleDateFormat
  - 날짜 데이터를 원하는 형태로 다양하게 출력할 수 있다.
  - 1. 출력형식의 패턴을 작성해 SimpleDateFormat인스턴스를 생성한다.
  - 2. 출력하고자 하는 Date인스턴스를 가지고 format(Date d)를 호출하면 출력형식에 맞게 변환된다.
  - Date인스턴스만 format메서드에 사용 가능. Calendar <-> Date 방법을 알고 있어야 함.
```agsl
// SimpleDateFormat 사용법 예시
Date today = new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

// 오늘 날짜를 yyyy-MM-dd 형태로 변환하여 반환한다.
String result = df.format(today);
```
```agsl
1. Calendar를 Date로 변환
Calendar cal = Calendar.getInstance();

Date d = new Date(cal.getTimeInMillis()); // Date(long date)

2. Date를 Calendar로 변환
Date d = new Date();

Calendar cal = Calendar.getInstance();
cal.setTime(d);
```
SimpleDateFormate의 parse(String source)는 문자열source을 날짜Date인스턴스로


## ChoieFormat

