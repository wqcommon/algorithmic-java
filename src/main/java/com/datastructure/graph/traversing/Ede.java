package com.datastructure.graph.traversing;

public class Ede<T> {

    private Ver<T> ver;

    private Ver<T> adjVer;

    public Ede(Ver<T> ver,Ver<T> adjVer){
        this.ver = ver;
        this.adjVer = adjVer;
    }

    public Ver<T> getVer() {
        return ver;
    }

    public Ver<T> getAdjVer() {
        return adjVer;
    }
}
