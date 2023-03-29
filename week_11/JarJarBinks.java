/**
 * JarJarBinks.java = Week 11 Assignment
 * @author guilalr2
 */

import java.util.List;
import java.util.ArrayList;

// CSV
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import java.io.Reader;

// Gson
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

class StarWarsCharacter implements java.io.Serializable {
    private List list;

    // properties
    String name = "";
    String height = "";
    String mass = "";
    String hairColor = "";
    String skinColor = "";
    String eyeColor = "";
    String birthYear = "";
    String gender = "";
    String homeworld = "";
    String species = "";

    // no-arg constructor
    public StarWarsCharacter() {}

    public List getList() {
        return this.list;
    }

    public String getName() {
        return this.name;
    }

    public String getHeight() {
        return this.height;
    }

    public String getMass() {
        return this.mass;
    }

    public String getHairColor() {
        return this.hairColor;
    }

    public String getSkinColor() {
        return this.skinColor;
    }

    public String getEyeColor() {
        return this.eyeColor;
    }

    public String getBirthYear() {
        return this.birthYear;
    }

    public String getGender() {
        return this.gender;
    }

    public String getHomeWorld() {
        return this.homeworld;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeworld = homeWorld;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String toString() {
        String output = "";
        output += getName();
        return output;
    }
}

public class JarJarBinks {
    public static void main(String args[]) {
        try {
            List<StarWarsCharacter> characterList = new ArrayList<>();
            Reader in = new FileReader("characters.csv");
            CSVFormat CSVparser = CSVFormat.Builder.create().setHeader().build();
            Iterable<CSVRecord> records = CSVparser.parse(in);

            for(CSVRecord record: records) {
                StarWarsCharacter character = new StarWarsCharacter();
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

                //System.out.println(character);
                characterList.add(character);
            }

            FileWriter out = new FileWriter("characters.json");
            Gson gson = new Gson();
            gson.toJson(characterList, out);
            out.close();
        } catch(Exception e) {
        }
    }
}
