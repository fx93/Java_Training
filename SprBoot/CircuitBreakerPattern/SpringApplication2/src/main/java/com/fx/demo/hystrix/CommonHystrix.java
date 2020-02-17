package com.alfar.demo.hystrix;

import com.alfar.demo.model.Allocation;
import com.google.common.base.Supplier;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommonHystrix<T> extends HystrixCommand<T>{
	
	Supplier<T> execute;
	Supplier<T> fallback;
	
	public CommonHystrix(String group, Supplier<T> execute) {
		
		super(HystrixCommandGroupKey.Factory.asKey(group));
		
		this.execute = execute;
		
	}
	
     public CommonHystrix(Setter config, Supplier<T> execute) {
		
		super(config);
		
		this.execute = execute;
		
	}
	

     
     public CommonHystrix(String group, Supplier<T> execute,Supplier<T> fallback) {
 		
 		super(HystrixCommandGroupKey.Factory.asKey(group));
 		
 		this.execute = execute;
 		
 		this.fallback = fallback;
 		
 	}
 	
      public CommonHystrix(Setter config, Supplier<T> execute,Supplier<T> fallback) {
 		
 		super(config);
 		
 		this.execute = execute;
 		
 		this.fallback = fallback;
 	}

	

	@Override
	protected T run() throws Exception {
		
		return execute.get();
	}
	
	@Override
	protected T getFallback() {
		
		if(fallback != null) {
			
			return fallback.get();
			
		}
			
			return super.getFallback();
		
	}
	
}
