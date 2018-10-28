package com.sexycode.codepractice.beanutil.bean;

import java.util.List;


/**
 * Created by hongzeyang
 * Time 2018/8/20 下午7:19
 * Desc
 */
public class Zoo {

    public Zoo() {
    }


    public Zoo(String name, List<Dog> dogs) {
        this.name = name;
        this.dogs = dogs;
    }


    private String name;

    private List<Dog> dogs;

    private ZooConf zooConf;


    public ZooConf getZooConf() {
        return zooConf;
    }


    public void setZooConf(ZooConf zooConf) {
        this.zooConf = zooConf;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public List<Dog> getDogs() {
        return dogs;
    }


    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
