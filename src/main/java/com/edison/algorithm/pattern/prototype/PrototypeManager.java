package com.edison.algorithm.pattern.prototype;

import java.util.Hashtable;

/**
 * @Description TODO
 * @Date 2020/3/12下午11:13
 * @Created by edsiongeng
 */
public class PrototypeManager {
    private Hashtable hashtable = new Hashtable();
    private static PrototypeManager pm = new PrototypeManager();

    private PrototypeManager() {
        hashtable.put("word", new Word());
        hashtable.put("ppt", new PPT());

    }

    public void add(String key, OfficialDocument document) {
        hashtable.put(key, document);
    }


    public OfficialDocument getOfficalDocument(String key) {
        return ((OfficialDocument) hashtable.get(key)).clone();
    }

    public static PrototypeManager getPropertyManager() {
        return pm;
    }


}
