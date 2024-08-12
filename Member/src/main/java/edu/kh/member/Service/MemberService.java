package edu.kh.member.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface MemberService {
	
	/**  회원 목록 반환 서비스
	 * @return todoList + 완료 개수
	 */ 
	public abstract Map<String, Object> memberListFullView();

	
	
	
	/** 전달 받은 index 번째 member를 반환
	 * @param index
	 * @return index 번째 member 상세 정보, 없으면 null 반환
	 */
	public abstract String memberDetailView(int index);



	/** 회원 추가
	 * @param title
	 * @param content
	 * @return 추가된 index 번호 반환, 실패 시 -1
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract int memberAdd( String name, String phone)
										throws FileNotFoundException, IOException ;



	/** 회원정보 수정
	 * @param amount
	 * @param name
	 * @param phone
	 * @return 수정 성공 true, 실패 시 false
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract boolean memberUpdate(int index, String name, String phone, int amount)  throws FileNotFoundException, IOException ;



	/** 회원 삭제
	 * @param index
	 * @return 삭제 성공 시 삭제된 할 일의 제목 반환
	 * 				 실패 시 null 반환
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract String memberDelete(int index)  throws FileNotFoundException, IOException ;

}

