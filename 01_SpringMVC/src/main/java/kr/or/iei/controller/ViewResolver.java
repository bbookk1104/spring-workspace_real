package kr.or.iei.controller;

public class ViewResolver {
	public String getView(String result) {
		return "/views/"+result+".jsp";
	}
}
