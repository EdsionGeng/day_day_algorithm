package com.edison.algorithm.pattern.facade;

/**
 * @Description TODO
 * @Date 2020/3/21上午9:00
 * @Created by edsiongeng
 */
public class EncryptFacade {

    private FileReader reader;
    private CipherMachine cipherMachine;
    private FileWriter writer;

    public EncryptFacade() {
        reader = new FileReader();
        cipherMachine = new CipherMachine();
        writer = new FileWriter();
    }

    public void fileEncrypt(String fileNameSrc, String fileNameDesc) {
        String plainStr=reader.Read(fileNameSrc);
        String encryptStr=cipherMachine.encrypt(plainStr);
        writer.write(encryptStr,fileNameDesc);


    }
}
