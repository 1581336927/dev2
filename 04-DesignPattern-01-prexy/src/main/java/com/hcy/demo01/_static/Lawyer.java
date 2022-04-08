package com.hcy.demo01._static;

//当事人请的律师,俗称代理的对象
public class Lawyer implements Lawsuit {

    private final Lawsuit lawsuit;

    public Lawyer(Lawsuit lawsuit) {
        this.lawsuit = lawsuit;
    }

    @Override
    public void submit() {
        this.gatherEvidence();
    }

    //搜集证据，代理对象对被代理的一个增强
    private void gatherEvidence() {
        lawsuit.defend();
        System.out.println("搜集证据");
    }

    @Override
    public void defend() {

        this.compareNotes();
    }

    private void compareNotes() {
        lawsuit.submit();
        System.out.println("交换意见");
    }
}
