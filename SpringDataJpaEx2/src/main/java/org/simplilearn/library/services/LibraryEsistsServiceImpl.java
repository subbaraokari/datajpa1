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
public class LibraryEsistsServiceImpl implements LibraryExistService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public boolean checkLibraryExistById(int id) {
		
		return libraryRepository.existsById(id);
	}

	@Override
	public boolean checkLibraryExistsWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaseperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.exists(example);
	}

}
