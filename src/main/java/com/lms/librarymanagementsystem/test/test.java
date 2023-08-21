package com.lms.librarymanagementsystem.test;

public class test {
    public static void main(String[] args) throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        
    	System.out.println("The current working directory is " + currentDirectory);
	    System.out.println(currentDirectory.replace('/', '\\'));
    }
}

