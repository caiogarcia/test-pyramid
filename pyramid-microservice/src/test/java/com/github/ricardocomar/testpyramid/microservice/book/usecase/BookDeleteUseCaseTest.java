package com.github.ricardocomar.testpyramid.microservice.book.usecase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.ricardocomar.testpyramid.microservice.book.dataprovider.BookDeleteDataProvider;

@RunWith(MockitoJUnitRunner.class)
public class BookDeleteUseCaseTest {

	@Mock
	private BookDeleteGateway deleteGateway;

	@InjectMocks
	private BookDeleteUseCase useCase;

	final long id = 1L;
	
	@Test
	public void testSuccess() throws Exception {
	
		deleteGateway = Mockito.mock(BookDeleteDataProvider.class);
		
		useCase.delete(id);
		Assert.assertTrue(true);
	}
}
