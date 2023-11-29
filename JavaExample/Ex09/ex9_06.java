package JavaExample.Ex09;

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
public class ex9_06 {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card("Heart", 10);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
