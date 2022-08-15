package org.simplilearn.library.services;

import java.util.List;
import java.util.Optional;

import org.simplilearn.library.entity.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface LibraryReadService {
	List<Library> getAllLibrary();
	List<Library> getAllLibrariesWithZeroBooks();
	Page<Library> getLibrariesPaged();
	Page<Library> getLibrariesCustomPaged(int pageNumber,int noOfRecords);
	List<Library> getLibrariesWithLatestAddedOrder();
	List<Library> getLibrariesCustomSortedById(Direction direct);
	List<Library> getLibrariesCustomSortedByName(Direction direct);
	Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames);
	Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(String commaSeperatedBookNames,int pageNumber,int noOfRecords);
	List<Library> getLibrariesSortedByNameWithTheseBooks(String commaSeperatedBookNames);
	List<Library> getLibrariesByIds(List<Integer> ids);
	Optional<Library> getLibraryById(int id);
	Optional<Library> getLibraryWithTheseBookNames(String commaSeperatedBookNames);
	Page<Library> getLibrariesPagedAndSortedByName();
	
}
