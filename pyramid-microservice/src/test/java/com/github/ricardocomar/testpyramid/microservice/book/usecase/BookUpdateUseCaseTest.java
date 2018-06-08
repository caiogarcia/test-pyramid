package com.github.ricardocomar.testpyramid.microservice.book.usecase;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.ricardocomar.testpyramid.microservice.book.model.Book;

@RunWith(MockitoJUnitRunner.class)
public class BookUpdateUseCaseTest {
	@Mock
	private BookUpdateGateway updateGateway;

	@InjectMocks
	private BookUpdateUseCase useCase;

	final Book book = Book.builder().id(123L).name("John's thoughts").writter("John Snow").price(120.0).build();

	final Book updated = Book.builder().id(123L).name("John's thoughts").writter("John Snow 2").price(120.0).build();

	@Test
	public void testSuccess() throws Exception {
	
		Mockito.when(updateGateway.update(Mockito.eq(book))).thenReturn(updated);
		
		Book newBook = useCase.update(book);
		
		Assert.assertThat(newBook, Matchers.equalTo(updated));
	}
}
