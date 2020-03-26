package com.edison.algorithm.pattern.facade;

/**
 * @Description TODO
 * @Date 2020/3/21上午9:04
 * @Created by edsiongeng
 */
public class Client {
    public static void main(String[] args) {
        EncryptFacade ef=new EncryptFacade();
        ef.fileEncrypt("src.txt","desc.txt");
    }
}
