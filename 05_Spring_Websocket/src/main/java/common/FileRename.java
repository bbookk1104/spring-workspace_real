package common;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class FileRename {
	public String fileRename(String path, String filename) {
		String onlyFilename = filename.substring(0,filename.lastIndexOf("."));
		//파일명 추출 (0번인덱스부터 .앞까지 자름)
		String extention = filename.substring(filename.lastIndexOf("."));
		//.확장자 추출 (매개변수 1개: lastIndexOf(".")부터 끝까지 다 추출)
		
		//실제 업로드할 파일명
		String filepath = null;
		//파일명이 중복되는 경우 뒤에 붙일 숫자
		int count = 0;
		while(true) {
			if(count==0) {
				//파일이름체크 반복 첫번째인 경우
				filepath = onlyFilename+extention;//test.txt
			}else {
				filepath = onlyFilename+"_"+count+extention;//test_1.txt
			}
			File checkFile = new File(path+filepath);//이 File은 java.io객체
			if(!checkFile.exists()) {
				//중복파일명이 아닌 경우 무한반복문 나감
				break;
			}
			count++;
		}
		return filepath;
	}
}
