package AdvJavaPractice.serialization;

import java.io.*;

public class SerializationPractice {

    /*

    Task:
        Book tipinde nesneler uretip bu nesneleri book.txt dosyasina kaydedin ve daha sonra
        bu dosyadan nesneleri okuyun.

     */

    public static void main(String[] args) {

        //writeObject();
        readObject();

    }

    public static void writeObject(){

        Book book1 = new Book("Sefiller","Victor Hugo",1945);
        Book book2 = new Book("Suc ve Ceza","Tolstoy",1955);
        Book book3 = new Book("Savas ve Baris","Dostoyevski",1940);

        //Nesneleri yazdiracagimiz dosyayi yazdirmak icin
        try {
            FileOutputStream fos = new FileOutputStream("book.txt");

            //Nesneleri yazdirmak icin
            ObjectOutputStream write = new ObjectOutputStream(fos);
            write.writeObject(book1);
            write.writeObject(book2);
            write.writeObject(book3);

            write.close();
            fos.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readObject(){

        //Nesneleri okuyacagimiz dosyayi okur.
        try {
            FileInputStream fis = new FileInputStream("book.txt");
            //Nesneleri okumak icin
            ObjectInputStream read = new ObjectInputStream(fis);
            Book book1 = (Book) read.readObject();
            Book book2 = (Book) read.readObject();
            Book book3 = (Book) read.readObject();

            System.out.println(book1);
            System.out.println(book2);
            System.out.println(book3);

            read.close();
            fis.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
