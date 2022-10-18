package kr.or.iei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.iei.vo.Member;
import kr.or.iei.vo.MemberMgr;

/**
 * Servlet implementation class Test2Servlet
 */
public class Test2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//spring 설정파일을 읽어오는 객체 생성
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("memberContext.xml");
		/*
		Member m1 = (Member)cntx.getBean("member1");
		System.out.println(m1.getName());
		System.out.println(m1.getAge());
		System.out.println(m1.getAddr());
		*/
		MemberMgr mm = (MemberMgr)cntx.getBean("mm1");
		Member m1 = mm.getM();
		System.out.println(m1.getName());
		System.out.println(m1.getAge());
		System.out.println(m1.getAddr());
		
		Member m2 = (Member)cntx.getBean("member2");
		System.out.println(m2.getAge());//30
		m2.setAge(1000);
		System.out.println(m2.getAge());//1000
		Member m22 = (Member)cntx.getBean("member2");
		System.out.println(m22.getAge());//scope설정 안하면 1000, scope="prototype"설정하면 30
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
