package com.sexycode.codepractice.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * @author: hzy
 * @since:
 */
public class SingletonRegistry {
    public static SingletonRegistry REGISTRY = new SingletonRegistry();
    private static HashMap map = new HashMap();
    private static Logger logger = LoggerFactory.getLogger(SingletonRegistry.class);

    private SingletonRegistry() {
    }

    public static synchronized Object getInstance(String classname) {
        Object singleton = map.get(classname);
        if (singleton != null) {
            return singleton;
        }
        try {
            singleton = Class.forName(classname).newInstance();
            logger.info("created singleton: " + singleton);
        } catch (ClassNotFoundException cnf) {
            logger.warn("Couldn't find class " + classname);
        } catch (InstantiationException ie) {
            logger.warn("Couldn't instantiate an object of type " +
                    classname);
        } catch (IllegalAccessException ia) {
            logger.warn("Couldn't access class " + classname);
        }
        map.put(classname, singleton);
        return singleton;
    }
}