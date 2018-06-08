package com.github.ricardocomar.testpyramid.microservice.book.usecase;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

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
public class BookFindUseCaseTest {
	@Mock
	private BookFindGateway findGateway;

	@InjectMocks
	private BookFindUseCase useCase;

	final Book book = Book.builder().id(1L).name("John's thoughts").writter("John Snow").price(120.0).build();
	final List<Book> listBook = Arrays.asList(
			Book.builder().id(1L).name("Teste 1").writter("John Snow").price(120.0).build(),
			Book.builder().id(2L).name("Teste 2").writter("John Snow").price(110.0).build(),
			Book.builder().id(3L).name("Teste 3").writter("John Snow").price(130.0).build());

	@Test
	public void testFindById() {
		Mockito.when(findGateway.find(1L)).thenReturn(book);
		
		Book newBook = useCase.find(1L);
		
		Assert.assertThat(newBook, Matchers.equalTo(book));
	}
	
	@Test
	public void testFindRange() {
		Mockito.when(findGateway.find(1, 3)).thenReturn(listBook);
		
		List<Book> list = useCase.find(1, 3);
		
		assertThat(list, is(listBook));
	}
}
