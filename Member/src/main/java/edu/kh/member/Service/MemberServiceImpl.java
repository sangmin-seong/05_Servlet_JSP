package edu.kh.member.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.member.dao.MemberDao;
import edu.kh.member.dao.MemberDaoImpl;
import edu.kh.member.dto.Member;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao dao = null;
	
	
	public MemberServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		 dao = new MemberDaoImpl();
	}
	
	@Override
	public Map<String, Object> memberListFullView() {
		List<Member> memberList = dao.memberListFullView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberList", memberList);
		
		return map;
	}
	//--------------------------------------
	
	@Override
	public String memberDetailView(int index) {
		Member member = dao.memberDetailView(index);
		
		if(member == null) return null;
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("------------------------------------");
		sb.append(String.format("회원번호 : %d\n", member.getIndex()));
		sb.append(String.format("회원이름 : %s\n", member.getName()));
		sb.append(String.format("전화번호 : %s\n", member.getPhone()));
		sb.append(String.format("등  급 : %d\n", 
				member.getAmount() == 0? Member.COMMON : member.getAmount() == 1 ? Member.GOLD : Member.DIAMOND));
		sb.append("------------------------------------");
		sb.append("\n누적 금액\n");
		sb.append( String.format("%d\n", member.getAmount()) );
		
		return sb.toString();
	}
	
	//---------------------------------------------------------------------
	@Override
	public int memberAdd(String name, String phone) throws FileNotFoundException, IOException {
		
		Member meber = new Member(name, phone);
		
		return dao.memberAdd(meber);
	}
	//----------------------------------------------------------------------
	@Override
	public boolean memberUpdate(int index, String name, String phone, int amount)
			throws FileNotFoundException, IOException {
		
		return dao.memberUpdate(index, name, phone, amount);
	}
	
	//-----------------------------------------------------------------------
	@Override
	public String memberDelete(int index) throws FileNotFoundException, IOException {

		Member deletedTarget = dao.memberDelete(index);
		
		if(deletedTarget != null) return deletedTarget.getName();
		
		return null;
	}
}
