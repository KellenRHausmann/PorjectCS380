package com.example.helloworld;

import java.io.*;

/**
 * Static class used to serialize and deserialize User objects
 */

public class SerializationMethods {
    public static void serialize(Object obj, String name){
        try {
            FileOutputStream fos = new FileOutputStream(name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        }
        catch(IOException e){
            System.out.println("Something's gone terribly wrong. Could not save user data");
        }
    }
    public static Object load(String name){
        try {
            FileInputStream fis = new FileInputStream(name);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Something's gone terribly wrong. Could not load user data");
            return new User(); // return blank user to prevent crash
        }
    }
}
