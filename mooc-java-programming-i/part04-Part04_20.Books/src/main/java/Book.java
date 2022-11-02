/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
public class Book {
    private String title;
    private int pages;
    private String publicationYear;
    
    public Book(String title, int pages, String publicationYear){
        this.title = title;
        this.pages = pages;
        this.publicationYear = publicationYear;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public int getPages(){
        return this.pages;
    }
    
    public String getPublicationYear(){
        return this.publicationYear;
    }
    
    public String toString(){
        return (this.getTitle() + ", " + this.getPages() + " pages, " + this.getPublicationYear());
    }
}
