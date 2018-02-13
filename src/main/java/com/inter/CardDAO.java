package com.inter;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.BankCard.Card;

public interface CardDAO {
	public Card Get(@Param("number")int number,@Param("password")String password);
	/*
	 * �����DAO�����ǰJDBCʱ��һ����������Ϊ�ӿڣ�ֻ��Ҫ���巽���Ϳ���,ͬʱ��Ҫע�������@Param()�����Ǹ�������ע��
	 */
	public int modifyPassword(@Param("number")int number,@Param("newPassword")String newPassword);//�������Ҫ�����
	public int modifyMoney(@Param("number")int number,@Param("money")double money);
	public int open(Card card);
	
	public ArrayList<Card> List(@Param("number")int number,@Param("currentNumber")int currentNumber,@Param("move")int move);
	public ArrayList<Card> list(@Param("username")String usernamer,@Param("currentNumber")int currentNumber,@Param("move")int move);
	public int totalNumber(int number);
	public int total(String username);
	public Card GetCad(int number);
	public Card GetCard(@Param("number")int number,@Param("password")String password);
	public int  delete(int number);
}
