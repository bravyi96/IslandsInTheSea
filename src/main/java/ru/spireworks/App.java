package ru.spireworks;

public class App {
    public static void main( String[] args ) {
        Map a = new Map(FileUtils.readFileToList());
        System.out.println(a);
        Map b = new Map(FileUtils.readFileToList());
        System.out.println(b);
        Map c = new Map(FileUtils.readFileToList());
        System.out.println(c);
        Map d = new Map(FileUtils.readFileToList());
        System.out.println(d);
    }
}
