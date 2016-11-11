package com.zoudys;

import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.zoudys.config.AppConfig;
import com.zoudys.model.Article;
import com.zoudys.model.Comment;

public class App {
	
	public static void main(String[] args) throws UnknownHostException {

		AppConfig appConfig = new AppConfig();
		
		MongoOperations ops = appConfig.mongoOperations();
		
		Comment comment = new Comment();
		comment.setAuthor("Bob");
		comment.setDate(new Date());
		comment.setText("three Great comment");

		ops.upsert(Query.query(where("author").is("Chris")), 
						new Update()
						.push("comments", comment)
						.inc("comment_inc", 1), 
						Article.class);
	
		/*ops.upsert(Query.query(where("author").is("Chris")), 
				new Update().pop("comments", Update.Position.FIRST), 
				Article.class);*/
		
	}

}
