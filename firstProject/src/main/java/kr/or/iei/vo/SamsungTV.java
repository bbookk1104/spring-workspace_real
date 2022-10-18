package kr.or.iei.vo;

public class SamsungTV implements TV{
	@Override
	public void powerOn() {
		System.out.println("Samsung ------- 전원을 켠다.");
	}
	@Override
	public void powerOff() {
		System.out.println("Samsung ------- 전원을 끈다.");
	}
	@Override
	public void volumeUp() {
		System.out.println("Samsung ------- 음량을 높인다.");
	}
	@Override
	public void volumeDown() {
		System.out.println("Samsung ------- 음량을 낮춘다.");
	}
}
