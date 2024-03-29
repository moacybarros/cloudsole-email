/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thys.michels.email2sfdc.email;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageHandler;
import org.thys.michels.email2sfdc.util.ParseEmail;

/**
 * @author Oleg Zhurakousky
 *
 */
public class GmailInboundImapIdleAdapterTestApp {
	
	private static Logger logger = Logger.getLogger(GmailInboundImapIdleAdapterTestApp.class);
	public static void main (String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/gmail-imap-idle-config.xml");
		
		final ParseEmail parseEmailMessage = new ParseEmail();
		
		DirectChannel inputChannel = context.getBean("inputChannel", DirectChannel.class);
		inputChannel.subscribe(new MessageHandler() {
			public void handleMessage(Message<?> message) throws MessagingException {
				//logger.info("Message: " + message);
				parseEmailMessage.printMessage(parseEmailMessage.getEmailMessage(message));
				
			}
		});
	}
}
