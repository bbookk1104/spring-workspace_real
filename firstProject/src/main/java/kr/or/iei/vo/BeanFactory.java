package kr.or.iei.vo;

public class BeanFactory {
	public TV getBean(String name) {
		if(name.equals("samsung")) {
			SamsungTV s = new SamsungTV();
			return s;
		}else if(name.equals("lg")) {
			LgTV l = new LgTV();
			return l;
		}
		return null;
	}
}
