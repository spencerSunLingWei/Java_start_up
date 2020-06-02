package com.stage1.part5.task1;

public class Proxy implements SourceAble{

    private Source source;

    public Proxy(){
        source = new Source();
    }

    @Override
    public void method() {
        source.method();
        System.out.println("Proxy implements SourceAble");
    }
}
