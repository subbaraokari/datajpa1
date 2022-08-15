package org.simplilearn.library.services;

public interface LibraryExistService {
	boolean checkLibraryExistById(int id);
	boolean checkLibraryExistsWithTheseBooks(String commaSeperatedBookNames);

}
