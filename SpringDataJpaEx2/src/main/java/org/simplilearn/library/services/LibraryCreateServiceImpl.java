package org.simplilearn.library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.simplilearn.library.entity.Library;
import org.simplilearn.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibraryCreateServiceImpl implements LibraryCreateService{
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	public String addSingleLibrary(Library library) {
		libraryRepository.save(library);
		libraryRepository.flush();
		return "Library Saved";
	}

	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "Libraries Saved";
	}

	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		
		return libraryRepository.saveAndFlush(library);
	}
	
}
