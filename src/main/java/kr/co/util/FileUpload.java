package kr.co.util;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload
{
	private MultipartFile BOARD_FILE2;

	public MultipartFile getBOARD_FILE2()
	{
		return BOARD_FILE2;
	}

	public void setBOARD_FILE2(MultipartFile bOARD_FILE2)
	{
		BOARD_FILE2 = bOARD_FILE2;
	}

	@Override
	public String toString()
	{
		return "클래스명=[FileUpload] 필드명[BOARD_FILE2=" + BOARD_FILE2 + "]";
	}
	
	

}
