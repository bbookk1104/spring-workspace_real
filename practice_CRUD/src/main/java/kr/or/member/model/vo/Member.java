package kr.or.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor//생성자
@AllArgsConstructor//매개변수생성자
@Data//게터세터자동생성
public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String nickname;
	private String memberPhone;
	private String memberAddr;
	private int memberGrade;
	private String enrollDate;
}