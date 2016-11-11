package com.zoudys.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.zoudys.model.Article;

public interface ArticleRepository extends CrudRepository<Article, ObjectId>{

	public Article findByAuthor(String author);
}
