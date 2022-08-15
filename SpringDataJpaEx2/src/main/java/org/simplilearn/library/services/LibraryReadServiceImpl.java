package org.simplilearn.library.services;

import java.util.List;
import java.util.Optional;

import org.simplilearn.library.entity.Library;
import org.simplilearn.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class LibraryReadServiceImpl implements LibraryReadService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public List<Library> getAllLibrary() {
		return libraryRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithZeroBooks() {
		Library library=new Library();
		library.setCommaseperatedBookNames("");
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.findAll(example);
	}

	@Override
	public Page<Library> getLibrariesPaged() {
		Pageable pageable=PageRequest.of(0, 3);
		return libraryRepository.findAll(pageable);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int noOfRecords) {
		Pageable pageable=PageRequest.of(pageNumber, noOfRecords);
		return libraryRepository.findAll(pageable);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return libraryRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direct) {
		
		return libraryRepository.findAll(Sort.by(direct, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direct) {
		return libraryRepository.findAll(Sort.by(direct, "name"));
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaseperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		Pageable pageable=PageRequest.of(0, 3, Sort.by("name"));
		return libraryRepository.findAll(example, pageable);
	}

	@Override
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeperatedBookNames, int pageNumber, int noOfRecords) {
		Library library=new Library();
		library.setCommaseperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		Pageable pageable=PageRequest.of(0, 3, Sort.by("name"));
		return libraryRepository.findAll(example, pageable);
	}

	@Override
	public List<Library> getLibrariesSortedByNameWithTheseBooks(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaseperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		
		return libraryRepository.findAll(example, Sort.by("name"));
	}

	@Override
	public List<Library> getLibrariesByIds(List<Integer> ids) {
		
		return libraryRepository.findAllById(ids);
	}

	@Override
	public Optional<Library> getLibraryById(int id) {
		return libraryRepository.findById(id);
	}

	@Override
	public Optional<Library> getLibraryWithTheseBookNames(String commaSeperatedBookNames) {
		Library library=new Library();
		library.setCommaseperatedBookNames(commaSeperatedBookNames);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withMatcher("commaSeperatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id","name");
		Example<Library> example=Example.of(library, matcher);
		return libraryRepository.findOne(example);
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable pageable=PageRequest.of(0, 3,Sort.by("name"));
		return libraryRepository.findAll(pageable);
	}

}
