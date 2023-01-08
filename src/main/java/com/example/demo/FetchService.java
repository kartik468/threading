package com.example.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FetchService {

	static ExecutorService executor = Executors.newFixedThreadPool(10);

//	private RestTemplate restTemplate;


	public void fetch() throws InterruptedException, ExecutionException {
//		Set<Callable<String>> callables = new HashSet<Callable<String>>();  
//		  
//        callables.add(new Callable<String>() {  
//            public String call() throws Exception {  
//                return "Task 1";  
//            }  
//        });  
//        callables.add(new Callable<String>() {  
//            public String call() throws Exception {  
//                return "Task 2";  
//            }  
//        });  
//        callables.add(new Callable<String>() {  
//            public String call() throws Exception {  
//                return "Task 3";  
//            }  
//        });  
//  
//        java.util.List<Future<String>> futures = executor.invokeAll(callables);  
//  
//        for(Future<String> future : futures){  
//            System.out.println("future.get = " + future.get());  
//        }  
	}

	public Post getPostWithResponseHandling(int id)  {
		
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
	        HttpRequest httpRequest = HttpRequest.newBuilder()
	                .uri(targetURI)
	                .GET()
	                .build();
	        
	        HttpClient httpClient = HttpClient.newHttpClient();
	        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
	        
	     // Reading response
	        ObjectMapper objectMapper = new ObjectMapper();
	        post = objectMapper.readValue(response.body(), Post.class);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
        return post;
        
	}


}
