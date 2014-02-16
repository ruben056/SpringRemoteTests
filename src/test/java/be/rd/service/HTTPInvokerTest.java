package be.rd.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import be.rd.entitybean.Contact;

public class HTTPInvokerTest {

	@Test
	public void testContactService(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:/spring/http-invoker-config.xml");
		ctx.refresh();
		IContactService contactService = ctx.getBean("remoteContactService", IContactService.class);
		
		String[] names = new String[]{"Clarence", "Scott", "John"};
		List<Contact> contacts = contactService.findAll();
		int idx = 0; 
		for(Contact cur: contacts){
			System.out.println(cur);
			Assert.assertEquals(cur.getFirstName(), names[idx]);	
			idx++;
		}
	}

}
