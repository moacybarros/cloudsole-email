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

/**
 * @author Oleg Zhurakousky
 *
 */
public class GmailInboundPop3AdapterTestApp {

	private static Logger logger = Logger.getLogger(GmailInboundPop3AdapterTestApp.class);

	public static void main (String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/META-INF/spring/integration/gmail-pop3-config.xml");
		DirectChannel inputChannel = ac.getBean("receiveChannel", DirectChannel.class);
		inputChannel.subscribe(new MessageHandler() {
			public void handleMessage(Message<?> message) throws MessagingException {
				logger.info("Message: " + message.getPayload() + " " + message.getHeaders());
			}
		});
	}
}
