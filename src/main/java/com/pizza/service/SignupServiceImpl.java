package com.pizza.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizza.dao.SignupDaoRepository;
import com.pizza.dao.SignupEntity;
import com.pizza.dto.SignupDTO;
import com.pizza.utils.Utils;

@Service
@Transactional
public class SignupServiceImpl implements SignupService {
	
	 @Autowired
	 private SignupDaoRepository signupDao;

	@Override
	public SignupDTO authUser(String username, String password) {
		Optional<SignupEntity>  optional= signupDao.findByUsernameAndPassword(username,password);
		SignupDTO signupDTO=null;
		if(optional.isPresent()) {
			 signupDTO=new SignupDTO();
			BeanUtils.copyProperties(optional.get(), signupDTO);	
		}
		return signupDTO;
	}

	@Override
	public void persist(SignupDTO signupDTO) {
		SignupEntity signupEntity=new SignupEntity();
		BeanUtils.copyProperties(signupDTO, signupEntity);
		signupDao.save(signupEntity);
	}
	
	

	@Override
	public byte[] findImageById(int sid) {
		return signupDao.findById(sid).get().getBphoto();
	}

	@Override
	public SignupDTO findById(int sid) {
		SignupEntity signupEntity=signupDao.findById(sid).get();
		SignupDTO signupDTO=new SignupDTO();
		BeanUtils.copyProperties(signupEntity, signupDTO);
		return signupDTO;
	}

	@Override
	public void deleteById(int sid) {
		signupDao.deleteById(sid);
	}

	@Override
	public List<SignupDTO> findAll() {
		List<SignupEntity> list=signupDao.findAll();
		List<SignupDTO> signupDTOs=new ArrayList<>();
		for(SignupEntity entity:list) {
			SignupDTO signupDTO=new SignupDTO();
			BeanUtils.copyProperties(entity, signupDTO);
			signupDTOs.add(signupDTO);
		}
		return signupDTOs;
	}
	
	
	@Override
	public List<SignupDTO> getSignups(int pageid, int total){
		//List<SignupEntity> list=signupDao.getSignups(pageid,total);
		List<SignupEntity> list=signupDao.findAll();
		List<SignupDTO> signupDTOs=new ArrayList<>();
		for(SignupEntity entity:list) {
			SignupDTO signupDTO=new SignupDTO();
			BeanUtils.copyProperties(entity, signupDTO);
			signupDTOs.add(signupDTO);
		}
		return signupDTOs;
	}

	@Override
	public void updateSignup(SignupDTO signupDTO) {
		SignupDTO dbsignupDTO=findById(signupDTO.getSid());
		Utils.copyNonNullProperties(signupDTO, dbsignupDTO);
		SignupEntity signupEntity=new SignupEntity();
		BeanUtils.copyProperties(dbsignupDTO, signupEntity);
		signupDao.save(signupEntity);
	}
	
	@Override
	public int findTotalSignup() {
		return (int)signupDao.count();
	}

}
