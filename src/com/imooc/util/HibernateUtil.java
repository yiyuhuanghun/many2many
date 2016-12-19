package com.imooc.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * 工具类
 * */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;
	static
	{
//		创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
//		注释部分不报错，但是不能正常使用。
//		Configuration config =new Configuration().confugure();
		sessionFactory = new Configuration().configure().buildSessionFactory();
//		标准  服务 构造器            															应用    设置					内容
//		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
//		StandardServiceRegistry ssr = ssrb.build();
//		sessionFactory = config.buildSessionFactory(ssr);
	}
//	获取SessionFactory
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
//	获取Session
	public static Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}
//  关闭Session
	public static void closeSession(Session session) {
		if(session!=null)
		{
			session.close();
		}
		
	}

}
