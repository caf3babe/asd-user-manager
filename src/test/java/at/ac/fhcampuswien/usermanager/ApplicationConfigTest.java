/*
 * Copyright 2012 the original author or authors.
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
package at.ac.fhcampuswien.usermanager;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * Test case bootstrapping both JavaConfig and XML configuration to validate configuration.
 * 
 * @author Oliver Gierke
 */
public class ApplicationConfigTest {

	@Test
	public void bootstrapAppFromJavaConfig() {

		ApplicationContext context = new AnnotationConfigApplicationContext(InitGUI.class);
		assertThat(context, is(notNullValue()));
		assertThat(context.getBean(UserRepository.class), is(notNullValue()));
	}
}
