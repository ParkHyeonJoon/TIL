package JavaExample.Ex06;

public class TvTest {
    public static void main(String[] args) {
        Tv t; // Tv인스턴스를 참조하기 위한 변수 t를 선언
        t = new Tv(); // Tv인스턴스를 생성한다.
        t.channel = 7;
        t.channelDown();
        System.out.println("현재 채널은 " + t.channel + "입니다.");
    }
}
class Tv {
    // Tv의 속성(멤버변수)
    String color;
    boolean power;
    int channel;

    void power() {
        power = !power;
    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}
