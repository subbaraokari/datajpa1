package org.simplilearn.library.services;

import java.util.List;

import org.simplilearn.library.entity.Library;

public interface LibraryCreateService {
	String addSingleLibrary(Library library);
	String addAllLibraries(List<Library> libraries);
	Library addLibraryWithSaveAndFlush(Library library);
}
