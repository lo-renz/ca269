
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

// CSV
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import java.io.Reader;

// Gson
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * JarJarBinks.java = Week 11 Assignment
 * @author guilalr2
 */

/**
 * Class StarWarsCharacter is a Bean class for a Star Wars character.
 * Implements the Serializable interface.
 */

class StarWarsCharacter implements java.io.Serializable {

    // properties
    /**
     * Variable for the character name
     */
    String name = "";

    /**
     * Variable for the character height
     */
    String height = "";

    /**
     * Variable for the character mass
     */
    String mass = "";

    /**
     * Variable for the character hair color
     */
    String hairColor = "";

    /**
     * Variable for the character skin color
     */
    String skinColor = "";

    /**
     * Variable for the character eye color
     */
    String eyeColor = "";

    /**
     * Variable for the character birth year
     */
    String birthYear = "";

    /**
     * Variable for the character gender
     */
    String gender = "";

    /**
     * Variable for the character home world
     */
    String homeworld = "";

    /**
     * Variable for the character species
     */
    String species = "";

    /**
     * Default constructor for the StarWarsCharacter class.
     * No-arg constructor,
     * Which allows for easy instantiation.
     */
    public StarWarsCharacter() {}

    /**
     * Getter method for the name
     * @return Returns the name of the character
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for the height
     * @return Returns the height of the character
     */
    public String getHeight() {
        return this.height;
    }

    /**
     * Getter method for the mass
     * @return Returns the mass of the character
     */
    public String getMass() {
        return this.mass;
    }

    /**
     * Getter method for the hair color
     * @return Returns the hair color of the character
     */
    public String getHairColor() {
        return this.hairColor;
    }

    /**
     * Getter method for the skin color
     * @return Returns the skin color of the character
     */
    public String getSkinColor() {
        return this.skinColor;
    }

    /**
     * Getter method for the eye color
     * @return Returns the eye color of the character
     */
    public String getEyeColor() {
        return this.eyeColor;
    }

    /**
     * Getter method for the birth year
     * @return Returns the birth year of the character
     */
    public String getBirthYear() {
        return this.birthYear;
    }

    /**
     * Getter method for the gender
     * @return Returns the gender of the character
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Getter method for the home world
     * @return Returns the home world of the character
     */
    public String getHomeWorld() {
        return this.homeworld;
    }

    /**
     * Getter method for the species
     * @return Returns the species of the character
     */
    public String getSpecies() {
        return this.species;
    }

    /**
     * Setter method for the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for the height
     * @param height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Setter method for the mass
     * @param mass
     */
    public void setMass(String mass) {
        this.mass = mass;
    }

    /**
     * Setter method for the hair color
     * @param hairColor
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Setter method for the skin color
     * @param skinColor
     */
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    /**
     * Setter method for the eye color
     * @param eyeColor
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Setter method for the birth year
     * @param birthYear
     */
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * Setter method for the gender
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Setter method for the home world
     * @param homeWorld
     */
    public void setHomeWorld(String homeWorld) {
        this.homeworld = homeWorld;
    }

    /**
     * Setter method for the species
     * @param species
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * toString method
     * @return Returns the name of the character
     */
    public String toString() {
        String output = "";
        output += getName();
        return output;
    }
}

/**
 * class JarJarBinks, contains the main method
 */
public class JarJarBinks {

    /**
     * Main method which
     * 1. Reads the csv file and creates appropriate Java Beans class to represent the data
     * 2. Serialize and exports the data to a file called 'characters.json' using the GSON library.
     */
    public static void main(String args[]) {
        try {
            List<StarWarsCharacter> characterList = new ArrayList<>();

            // reading the csv file
            Reader in = new FileReader("characters.csv");
            CSVFormat CSVparser = CSVFormat.Builder.create().setHeader().build();
            Iterable<CSVRecord> records = CSVparser.parse(in);

            for(CSVRecord record: records) {

                // creating a new instance
                StarWarsCharacter character = new StarWarsCharacter();

                // setting the characters information
                character.name = record.get("name");
                character.height = record.get("height");
                character.mass = record.get("mass");
                character.hairColor = record.get("hair_color");
                character.skinColor = record.get("skin_color");
                character.eyeColor = record.get("eye_color");
                character.birthYear = record.get("birth_year");
                character.gender = record.get("gender");
                character.homeworld = record.get("homeworld");
                character.species = record.get("species");

                // adding the character to the ArrayList
                characterList.add(character);
            }

            // serializing and exporting the data into a file called 'characters.json'
            FileWriter out = new FileWriter("characters.json");
            Gson gson = new Gson();
            gson.toJson(characterList, out);
            out.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
