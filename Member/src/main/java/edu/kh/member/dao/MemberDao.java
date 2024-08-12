package edu.kh.member.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.member.dto.Member;

public interface MemberDao {
	
	/**
	 * MemberList를 파일로 저장하는 메서드
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveFile() throws FileNotFoundException, IOException;

	/**
	 * 할 일 목록 반환
	 * 
	 * @return todoList
	 */
	List<Member> memberListFullView();

	/**
	 * 전달 받은 index 번째 member를 반환
	 * 
	 * @param index
	 * @return index 번째 todo, 없으면 null
	 */
	Member memberDetailView(int index);

	/**
	 * 회원 추가
	 * 
	 * @param member
	 * @return 추가된 index 번호 반환
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	int memberAdd(Member member) throws FileNotFoundException, IOException;

	
	/**
	 * 회원정보 수정
	 * 
	 * @param index
	 * @param title
	 * @param detail
	 * @return 성공 true, 실패 시 false
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	boolean memberUpdate(int index, String name, String phone, int amount) throws FileNotFoundException, IOException;

	/**
	 * 회원 삭제
	 * 
	 * @param index
	 * @return 성공 시 삭제된 회원 반환 인덱스 범위 초과로 실패 시 null 반환
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	Member memberDelete(int index) throws FileNotFoundException, IOException;
}


