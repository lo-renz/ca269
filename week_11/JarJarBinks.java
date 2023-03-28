import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

// CSV
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

class StarWarsCharacters implements java.io.Serializable {
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
    String homeWorld = "";
    String species = "";

    // no-arg constructor
    StarWarsCharacters() {}

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
        return this.homeWorld;
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
        this.homeWorld = homeWorld;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}

public class JarJarBinks {
    public static void main(String args[]) {
        /*try {
            BufferedReader in = new BufferedReader(new FileReader("test.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

            String line = in.readLine();
            out.write(line);
            out.close();
            StringTokenizer tokenize = new StringTokenizer(line);
            int x = Integer.parseInt(tokenize.nextToken());
        } catch(Exception e) {
        }*/

        Scanner input = new Scanner(new File("characters.csv"));
        input.useDelimiter(",");
        while(input.hasNextLine()) {
            String[] characters = input.nextLine().split(","); // row data

            for(String info: characters) {
                System.out.print(info + " ");
            }
            System.out.println();
        }
        input.close();
        try {
        } catch(Exception e) {
        }
    }
}