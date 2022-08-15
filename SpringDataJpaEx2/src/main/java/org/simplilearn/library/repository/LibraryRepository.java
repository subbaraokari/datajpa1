package org.simplilearn.library.repository;

import org.simplilearn.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer>{

}
