package org.simplilearn.library.services;

import java.awt.print.Book;
import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.library.entity.Library;
import org.simplilearn.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryDeleteServiceImpl implements LibraryDeleteService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public String deleteOneLibrary(Library library) {
		libraryRepository.delete(library);
		return "library deleted";
	}

	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "Deleteing All Libraries";
	}

	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "Deleting ccompleted";
	}

	@Override
	public String deleteAllInBatch() {
		libraryRepository.deleteAllInBatch();
		return "Deleted all records in Batch";
	}

	@Override
	public String deleteLibraryById(int id) {
		libraryRepository.deleteById(id);
		return "Library deleted";
	}

	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteAllInBatch(libraries);
		return "Libraries deleted";
	}

//	@Override
//	public String deleteLibrariesWithZeroBooks() {
//		Library library=new Library();
//		library.setCommaseperatedBookNames("");
//		ExampleMatcher matcher=ExampleMatcher.matching()
//				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
//				.withIgnorePaths("id","name");
//		Example<Library> example=Example.of(library, matcher);
//		return libraryRepository.dele;
//	}

}
