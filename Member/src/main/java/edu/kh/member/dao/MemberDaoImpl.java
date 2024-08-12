package edu.kh.member.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.member.dto.Member;

public class MemberDaoImpl implements MemberDao{
private final String FILE_PATH = "MemberList.dat"; // tools에 이클립스 폴더
	
	private List<Member> memberList = null;
	
	private ObjectOutputStream	oos = null;
	private ObjectInputStream	 ois = null;
	
	
	// 기본 생성자
	public MemberDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		// TodoList.dat 파일이 없으면 새로운 List 생성, 있으면 읽어오기
		File file = new File(FILE_PATH);
		
		if(!file.exists()) {
			memberList = new ArrayList<Member>();
			
			memberList.add(new Member(1, "신짱구", "010-1234-1234", 0));
			memberList.add(new Member(2, "신짱아", "010-5678-5678", 0));
			memberList.add(new Member(3, "김철수", "010-2580-2580", 0));
			
			
			
		} else {
			try {
				// 객체 생성 시 외부 파일에 작성된 List<Todo> 객체를 입력 받아 todoList에 대입
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				memberList = (ArrayList<Member>)ois.readObject();
			}finally {
				if(ois != null) ois.close();
			}
		}
		
	}
	//=--------------------------------------------------------------------------
	
	// MemberList 파일로 저장
	@Override
	public void saveFile() throws FileNotFoundException, IOException {
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(memberList);
		}finally {
			oos.close();
		}
	}
	
	//-------------------------------------------------------------
	// 회원목록 전체 조회 
	@Override
	public List<Member> memberListFullView() {
		return memberList;
	}
	//-------------------------------------------------------------
	// 회원 정보 조회
	@Override
	public Member memberDetailView(int index) {
		if(index < 0 || index >= memberList.size()) return null;
		return memberList.get(index);
	}
	//--------------------------------------------------------------
	// 회원 추가
		
	@Override
	public int memberAdd(Member member) throws FileNotFoundException, IOException {
		
		if(memberList.add(member)) {
			saveFile();
			return memberList.size()-1;
		}
		
		return -1;
	}
	//----------------------------------------------------------------
	// 회원 정보 수정
	@Override
	public boolean memberUpdate(int index, String name, String phone, int amount) throws FileNotFoundException, IOException {
		
		Member newMember = new Member();
		
		newMember.setName(name);
		newMember.setPhone(phone);
		newMember.setAmount(amount);
		
		if(memberList.set(index, newMember) != null) {
			saveFile();
			
			return true;
		}
		return false;
	}
	//---------------------------------------------------------------
	// 회원 정보 삭제
	@Override
	public Member memberDelete(int index) throws FileNotFoundException, IOException {
		if(index < 0 || index >= memberList.size()) return null;
		
		Member deletedTarget = memberList.remove(index);
		
		saveFile();
		
		return deletedTarget;
	}
}
