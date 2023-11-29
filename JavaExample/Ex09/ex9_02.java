package JavaExample.Ex09;

class Person {
    long id;

    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            return id == ((Person)obj).id; // obj가 Object타입이므로 id 값을 참조하기 위해서는 Person타입으로 형변환.
        } else {
            return false; // 타입이 Person이 아니면 값을 비교할 필요 없음.
        }
    }

    Person(long id) {
        this.id = id;
    }
}
public class ex9_02 {
    public static void main(String[] args) {
        Person p1 = new Person(8011L);
        Person p2 = new Person(8011L);

        if(p1.equals(p2)) {
            System.out.println("p1과 p2가 같다");
        } else {
            System.out.println("p1과 p2가 다르다");
        }
    }

}
