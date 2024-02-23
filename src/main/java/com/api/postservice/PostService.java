package com.api.postservice;

import java.util.List;
import java.util.Map;

public interface PostService {
	
	List<Map<String,Object>> getPosts();
	
	Map<String,Object> getPost(int id);
	
	Map<String,Object> insertPost(Map<String,Object> payload);

}
