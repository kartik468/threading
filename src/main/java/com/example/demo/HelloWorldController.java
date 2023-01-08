package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorldController {
	
   @Autowired
   FetchService fetchService;

	// get request
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello world1";
	}
	
	
	@GetMapping("/fetch")
	public String fetchData() {
		
//		FutureTask[] randomNumberTasks = new FutureTask[5];
//		
//		for (int i = 0; i < 5; i++)
//	    {
//	      Callable<String> callable = new FetchServerOneData();
//	  
//	      // Create the FutureTask with Callable
//	      randomNumberTasks[i] = new FutureTask<String>(callable);
//	  
//	      // As it implements Runnable, create Thread
//	      // with FutureTask
//	      Thread t = new Thread(randomNumberTasks[i]);
//	      t.start();
//	    }
//		
//		String result = "";
//	  
//	    for (int i = 0; i < 5; i++)
//	    {
//	      // As it implements Future, we can call get()
//	      try {
//			String getResult = (String) randomNumberTasks[i].get();
//			System.out.println(getResult);
//			result += " \n" + getResult;
//			
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	  
//	      // This method blocks till the result is obtained
//	      // The get method can throw checked exceptions
//	      // like when it is interrupted. This is the reason
//	      // for adding the throws clause to main
//	    }
//		
//		return "hello fetch1-> " + result;
		return "test";
	}

	@GetMapping("/posts")
	public String getPosts() {
		Post firstPost = new Post();
		Post secondPost = new Post();
		//firstPost = this.fetchService.getPostWithResponseHandling(1);
		
//		secondPost = this.fetchService.getPostWithResponseHandling(2);
		
		
		Future<Post> task1 = FetchService.executor.submit(new FetchServerOneData());
		Future<Post> task2 = FetchService.executor.submit(new FetchServerTwoData());
		try {
			firstPost = task1.get();
			secondPost = task2.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.wrapInPara(firstPost) + this.wrapInPara(secondPost);
	}
	
	public String wrapInPara(Post post) {
		return "<p>" + post.toString() + "</p>";
	}
}
