package org.simplilearn.library.services;

import javax.transaction.Transactional;

import org.simplilearn.library.entity.Library;
import org.simplilearn.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryCountServiceImpl implements LibraryCountService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}

	@Override
	public long countLibraryWithZeroBooks() {
		Library library=new Library();
		library.setCommaseperatedBookNames("");
		ExampleMatcher exampleMatcher=ExampleMatcher.matching()
				.withMatcher("commaseperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, exampleMatcher);
		return libraryRepository.count(example);
	}
	
}
