package com.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.BankCard.Card;
import com.fenye.Fenye;
import com.inter.CardDAO;



@Component	//�����ע����Ϊ�˷���Control�еı�������
@Transactional
public class CardService {
	
	@Autowired
	private CardDAO cardDao;
	
	public Fenye List(int number,int currentPage) {
		int totalNumber=cardDao.totalNumber(number);
		Fenye fenye=new Fenye(totalNumber, currentPage);
		 ArrayList<Card>list=cardDao.List(number, fenye.getcurrentNumber(), fenye.move);
		 fenye.setObject(list);//����ȡ�ļ�¼����
		 System.out.println(">>>>>>>>"+fenye);
		 return fenye;
	}
	
	public Fenye list(String username,int currentPage) {
		int totalNumber=cardDao.total(username);
		System.out.println(totalNumber);
		Fenye fenye=new Fenye(totalNumber, currentPage);
		 ArrayList<Card>list=cardDao.list(username, fenye.getcurrentNumber(), fenye.move);
		 fenye.setObject(list);//����ȡ�ļ�¼����
		 return fenye;
	}

}
