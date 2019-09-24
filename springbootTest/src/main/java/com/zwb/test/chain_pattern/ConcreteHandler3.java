package com.zwb.test.chain_pattern;

public class ConcreteHandler3 extends Handler {
    @Override
    public void handleRequest(String request) {
        if(request.equals("three")){
            System.out.println("具体处理者3负责处理该请求！");
        }else{
            if(getNextHandler() != null){
                getNextHandler().handleRequest(request);
            }else{
                System.out.println("没有人处理该请求！");
            }
        }

    }
}
