import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import parser.CsvParser;

public class App {
    
    public static void main(String[] args) {
        try {
            List<String[]> lignes = CsvParser.parseFile();
            
            // La première ligne contient le nom des "colonnes" :
            // categorie marque nom nutritionGradeFr ingredients energie100g
            // graisse100g sucres100g fibres100g proteines100g sel100g vitA100g
            // vitD100g vitE100g vitK100g vitC100g vitB1100g vitB2100g vitPP100g
            // vitB6100g vitB9100g vitB12100g calcium100g magnesium100g iron100g
            // fer100g betaCarotene100g presenceHuilePalme allergenes additifs
            lignes.remove(0);
            
            for (String[] ligne : lignes) {
                // Construire un ensemble d'entités qui correspondent à cette ligne.
                  
                for (String e : ligne) {
                    System.out.format("%s ", e);
                }
                System.out.println();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

}
