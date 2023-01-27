/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cheong
 */
public class CD implements Packable{
    private String artist;
    private String name;
    private int publicationYear;

    public CD(String artist, String name, int publicationYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = publicationYear;
    }
    
    public double weight(){
        return 0.1;
    }

    @Override
    public String toString() {
        return (this.artist + ": " + this.name + " (" + this.publicationYear + ")");
    }
    
    
}
