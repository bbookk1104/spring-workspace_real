package kr.or.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
}