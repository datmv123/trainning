/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;
import reflectiondemo.Cat;

/**
 *
 * @author Drol
 */
public final class Demo {

    public static void main(String[] args) {
        //get all public method of class Cat, include inherit method
        Method[] a = Cat.class.getDeclaredMethods();//getMethods();
        for (Method t : a) {
            System.out.println(t.getName());
        }
        System.out.println("");
        //print name of class
        System.out.println(Demo.class.getName());
        System.out.println("");
        //print package
        System.out.println(Demo.class.getPackage());
        //print modifier
        System.out.println("");
        System.out.println(Modifier.toString(Demo.class.getModifiers()));
        System.out.println("");

        //create object follow by reflect
        try {
            Constructor c = Cat.class.getConstructor(String.class);
            Cat newCat = (Cat) c.newInstance("mimi");
        } catch (NoSuchMethodException ex) {
        } catch (SecurityException ex) {
        } catch (InstantiationException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //get all variable
        Field[] fields = Cat.class.getDeclaredFields();
        for (Field t : fields) {
            System.out.println(t.getName());
        }
    }
}
