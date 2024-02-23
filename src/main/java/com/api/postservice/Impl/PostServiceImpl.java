package com.api.postservice.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.postservice.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	
	String baseUrl="https://jsonplaceholder.typicode.com";
	StringBuilder stringBulider=new StringBuilder(baseUrl);
	
	String POST="/posts";
	
	String PostById="/posts/";
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Map<String, Object>> getPosts() {
		HttpEntity <Void> httpEntity= new HttpEntity<>(getHttpHeaders());
		String url = stringBulider.append(POST).toString();
		 var response = restTemplate.exchange(url,HttpMethod.GET,httpEntity,List.class);
		 return response.getBody();
	}
	
	@Override
	public Map<String, Object> getPost(int id) {
		HttpEntity httpEntity=new HttpEntity(getHttpHeaders());
		String url = stringBulider.append(POST).toString();
		var response = restTemplate.exchange(url, HttpMethod.GET,httpEntity,Map.class);
		return response.getBody();
	}
	
	@Override
	public Map<String,Object> insertPost(Map<String,Object> payload) {
		System.out.println("....2");
		HttpEntity httpEntity=new HttpEntity(getHttpHeaders());
		System.out.println("....3");
		String url = stringBulider.append(POST).toString();
		System.out.println("....4"+url);
		var response = restTemplate.exchange(url, HttpMethod.POST,httpEntity,Map.class);
		System.out.println("....5");
		return response.getBody();
	}
	
	                                               
	           
	   private HttpHeaders getHttpHeaders() {
		HttpHeaders headers=new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}


