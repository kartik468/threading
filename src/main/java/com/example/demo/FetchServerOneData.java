package com.example.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.util.Random;
import java.util.concurrent.Callable;


import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchServerOneData implements Callable<Post> {

	@Override
	public Post call() throws Exception {

		return this.getPostWithResponseHandling(11);
//        // Create random number generator
//        Random generator = new Random();
//  
//        Integer randomNumber = generator.nextInt(500);
//  
//        // To simulate a heavy computation,
//        // we delay the thread for some random time
//        Thread.sleep(10000);
//        System.out.println(java.time.LocalDate.now());    
//  
//        return randomNumber + "";

	}

	public Post getPostWithResponseHandling(int id) {

		String TARGET_URL = "https://jsonplaceholder.typicode.com/posts/" + id;
//		ResponseEntity<Post> response = this.restTemplate.getForEntity(url, Post.class, 1);
//		if (response.getStatusCode() == HttpStatus.OK) {
//			Post body = response.getBody();
//			System.out.println(body);
//			return body;
//		} else {
//			return null;
//		}

		System.out.println(TARGET_URL);
		Post post = new Post();
		try {
			URI targetURI = new URI(TARGET_URL);
			HttpRequest httpRequest = HttpRequest.newBuilder().uri(targetURI).GET().build();

			HttpClient httpClient = HttpClient.newHttpClient();
			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			// Reading response
			System.out.println("1");
			ObjectMapper objectMapper = new ObjectMapper();
			post = objectMapper.readValue(response.body(), Post.class);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return post;

	}

}
