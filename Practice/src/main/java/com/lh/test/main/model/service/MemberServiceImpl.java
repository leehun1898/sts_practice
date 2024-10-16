package com.lh.test.main.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lh.test.main.model.dao.MemberDAO;
import com.lh.test.main.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{



	@Autowired
	private MemberDAO memberDAO;
	
	
	

	/** 카카오 로그인용 Service
	 * @param member
	 * @param imagePath
	 * @return loginMember
	 * @throws Exception
	 */
	@Override
	public Member kakaoLogin(Member member, String imagePath) throws Exception {
		// 1) ourtrip DB에 회원으로 등록되어있는지 확인
		int result = memberDAO.isMember(member);
				
		// 2) 안되있을 시 회원가입
		if(result == 0) {
			result = memberDAO.signUp(member);
			
			if(result > 0) {
				result = memberDAO.selectMemberNo(member);
				if(imagePath != null) {
					//result = memberDAO.insertProfileImage(new ProfileImage(imagePath, result));
				}
			}
		}
		
		// 3) 회원 객체 반환
		return memberDAO.socialLogin(member);
	}

	

	/** 회원가입용 Service
	 * @param member
	 * @return memberNo
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int signUp(Member member) throws Exception {
		//member.setMemberPwd(bCryptPasswordEncoder.encode(member.getMemberPwd()));
		
		int result = memberDAO.signUp(member);
		
		if(result > 0) {
			result = memberDAO.selectMemberNo(member);
		}
		
		return result;
	}

	
	

	/** 네이버 로그인용 Service
	 * @param member
	 * @param imagePath
	 * @return loginMember
	 * @throws Exception
	 */
	@Override
	public Member naverLogin(Member member, String imagePath) throws Exception{
		// 1) ourtrip DB에 회원으로 등록되어있는지 확인
		int result = memberDAO.isMember(member);
				
		// 2) 안되있을 시 회원가입
		if(result == 0) {
			result = memberDAO.signUp(member);
			
			if(result > 0) {
				result = memberDAO.selectMemberNo(member);
				if(imagePath != null) {
					//result = memberDAO.insertProfileImage(new ProfileImage(imagePath, result));
				}
			}
		}
		
		// 3) 회원 객체 반환
		return memberDAO.socialLogin(member);
	}



	@Override
	public Member login(Member member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int emailCertify(String email) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int updateNickName(Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int deleteProfileImage(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int updateProfileImage(int memberNo, MultipartFile profileImage, String savePath, String isDefault)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int changePwd(Member member, String changePwd) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int secession(Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int signUpedEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int findPwd(String memberEmail) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String getProfileImagePath(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
