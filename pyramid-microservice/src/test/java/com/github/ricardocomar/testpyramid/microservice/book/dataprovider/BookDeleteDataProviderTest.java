package com.github.ricardocomar.testpyramid.microservice.book.dataprovider;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.ricardocomar.testpyramid.microservice.PyramidMicroserviceApplication;
import com.github.ricardocomar.testpyramid.microservice.book.usecase.BookDeleteGateway;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataProviderConfiguration.class})
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = PyramidMicroserviceApplication.class)
@ActiveProfiles("dataprovider")
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:simpleBooks.sql")
public class BookDeleteDataProviderTest {

	@Autowired
	private BookDeleteGateway deleteGateway;
	
	final long bookId = 1000;
	
	@Test
	public void testSuccess() throws Exception{
		deleteGateway.delete(bookId);
	}
}
