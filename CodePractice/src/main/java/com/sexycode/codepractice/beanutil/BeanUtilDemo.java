package com.sexycode.codepractice.beanutil;

import com.sexycode.codepractice.beanutil.bean.Dog;
import com.sexycode.codepractice.beanutil.bean.DogV2;
import com.sexycode.codepractice.beanutil.bean.Zoo;
import com.sexycode.codepractice.beanutil.bean.ZooV2;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hongzeyang
 * Time 2018/8/20 下午7:15
 * Desc
 */
public class BeanUtilDemo {

    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException {
        Dog dog = new Dog("bei");
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        Zoo zoo = new Zoo("zoo", dogs);

        ZooV2 zooV2 = new ZooV2();

        BeanUtils.copyProperties(zooV2, zoo);

        System.out.println(zooV2.getName());

        List<DogV2> dogV2s = zooV2.getDogs();

        System.out.println(dogV2s.size());

        DogV2 dogV2 = dogV2s.get(0);

        System.out.println(dogV2.getName());
    }

}
