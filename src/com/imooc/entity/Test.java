package com.imooc.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.imooc.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Project pro1 = new Project(1001,"项目一");
		Project pro2 = new Project(1002,"项目二");
		Employee emp1 = new Employee(1,"李炜");
		Employee emp2 = new Employee(2,"何善贤");
//		项目一有两个人参加
		pro1.getEmployees().add(emp1);
		pro1.getEmployees().add(emp2);
//		项目二只有一个人参加
		pro2.getEmployees().add(emp1);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(pro1);
		session.save(pro2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

}
