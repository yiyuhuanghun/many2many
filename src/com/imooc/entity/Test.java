package com.imooc.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.imooc.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Project pro1 = new Project(1001,"��Ŀһ");
		Project pro2 = new Project(1002,"��Ŀ��");
		Employee emp1 = new Employee(1,"���");
		Employee emp2 = new Employee(2,"������");
//		��Ŀһ�������˲μ�
		pro1.getEmployees().add(emp1);
		pro1.getEmployees().add(emp2);
//		��Ŀ��ֻ��һ���˲μ�
		pro2.getEmployees().add(emp1);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(pro1);
		session.save(pro2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

}
