package com.zwb.test.spring_chain_pattern;

/**
 * 链条总体节点方法
 */
public interface Pipeline {

    Pipeline fireTaskReceived();

    Pipeline fireTaskFiltered();

    Pipeline fireTaskExecuted();

    Pipeline fireAfterCompletion();

}
