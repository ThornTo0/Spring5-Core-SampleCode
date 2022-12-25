package com.greedy.section01.fieldinjection.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 스프링에서 관리하는 bean으로 등록하기 위한 어노테이션으로 Service계층에서는 @Service어노테이션을 사용 */
@Service
public class BookService {

	/* BookDAO타입의 빈으로 생성된 객체를 이 프로퍼티에 자동으로 연결해준다. 
	 * 간단하게 주입할 수 있지만 필드 주입은 최대한 사용을 지양한다.
	 * */
	
	@Autowired
	private BookDAO bookDAO;
	
	public BookService() {}
	
	public BookService(BookDAO bookDAO) {
		
		this.bookDAO = bookDAO;
	}
	
	/**
	 * <pre>
	 *   도서 정보 전체 조회용 메소드
	 * </pre>
	 * @return
	 */
	public List<BookDTO> selectAllBooks(){
		
		return bookDAO.selectBookList();
	}
	
	/**
	 * <pre>
	 *   도서번호로 도서 검색용 메소드
	 * </pre>
	 * @param sequence
	 * @return
	 */
	public BookDTO searchBookSequence(int sequence) {
		
		return bookDAO.selectOneBook(sequence);
	}
}
