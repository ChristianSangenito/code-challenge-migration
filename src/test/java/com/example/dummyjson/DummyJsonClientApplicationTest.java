package com.example.dummyjson;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = DummyJsonClientApplication.class)
public class DummyJsonClientApplicationTest {

	@Autowired
	private ApplicationContext context;

	@Test
	void contextLoads() {
		assertThat(context, notNullValue());
	}

	@Test
	public void main() {
		DummyJsonClientApplication.main(new String[] {});
	}
}