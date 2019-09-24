package com.zwb.test.spring_chain_pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
 
  @Autowired
  private ApplicationContext context;
  
  public void mockedClient() {
    // request一般是通过外部调用获取
    Request request = new Request();
    Pipeline pipeline = newPipeline(request);
    try {
      pipeline.fireTaskReceived();
      pipeline.fireTaskFiltered();
      pipeline.fireTaskExecuted();
    } finally {
      pipeline.fireAfterCompletion();
    }
  }
  
  private Pipeline newPipeline(Request request) {
    return context.getBean(DefaultPipeline.class, request);
  }
}