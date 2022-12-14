package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LiteratureRepository extends ElasticsearchRepository<Literature, String>{

	// QUERIES ------------------------------- //
	List<Literature> getLiteratureByAuthorIs(String author);
	List<Literature> getLiteratureByTitleIn(List<String> keywords);
	List<Literature> getLiteratureByCantPagesGreaterThan(Integer pages);
	List<Literature> getLiteratureByFirstPostBeforeOrderByFirstPost(LocalDate date);
	List<Literature> getLiteratureByFirstPostAfterOrderByFirstPost(LocalDate date);
	List<Literature> getLiteratureByEditorialIs(String editorial);
	
}
