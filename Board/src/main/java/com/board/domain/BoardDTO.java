package com.board.domain;

import java.util.List;

//import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
 * CommonDTO를 상속 -> 공통멤버변수는 CommonDTO에 추가되어 삭제됨
 * */
public class BoardDTO extends CommonDTO {

	/** 번호 (PK) */
	private Long idx;

	/** 제목 */
	private String title;

	/** 내용 */
	private String content;

	/** 작성자 */
	private String writer;

	/** 조회 수 */
	private int viewCnt;

	/** 공지 여부 */
	private String noticeYn;

	/** 비밀 여부 */
	private String secretYn;
	
	/** 파일 변경 여부 */
	private String changeYn;

	/** 파일 인덱스 리스트 */
	private List<Long> fileIdxs;
	
	

}