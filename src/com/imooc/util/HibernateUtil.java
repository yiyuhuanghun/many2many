package com.imooc.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * ������
 * */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	static
	{
//		����Configuration���󣬶�ȡhibernate.cfg.xml�ļ�����ɳ�ʼ��
//		ע�Ͳ��ֲ��������ǲ�������ʹ�á�
//		Configuration config =new Configuration().confugure();
		sessionFactory = new Configuration().configure().buildSessionFactory();
//		��׼  ���� ������            															Ӧ��    ����					����
//		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
//		StandardServiceRegistry ssr = ssrb.build();
//		sessionFactory = config.buildSessionFactory(ssr);
	}
//	��ȡSessionFactory
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
//	��ȡSession
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
//  �ر�Session
	public static void closeSession(Session session) {
		if(session!=null)
		{
			session.close();
		}
		
	}

}
