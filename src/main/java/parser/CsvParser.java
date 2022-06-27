package parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;


public class CsvParser {

    /**
     * Parse le fichier présent dans src/main/resources/open-food-facts.csv
     * et retourne une LISTE de String[].
     * 
     * Chaque élément dans la liste correspond à une ligne du csv (un élément de la
     * liste = un tableau de String contenant toutes les valeurs de la ligne).
     * 
     * @return une List<String[]> contenant chaque ligne du csv avec 1 ligne par élément
     * de la liste.
     * @throws IOException
     * @throws CsvException
     */
    public static List<String[]> parseFile() throws IOException, CsvException {

        Path myPath = Paths.get("src/main/resources/open-food-facts.csv");
        CSVParser parser = new CSVParserBuilder().withSeparator('|').build();

        // "try with resources" : https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        try (var br = Files.newBufferedReader(myPath,  StandardCharsets.UTF_8);
             var reader = new CSVReaderBuilder(br).withCSVParser(parser)
                     .build()) {

            List<String[]> rows = reader.readAll();
            
            /* 
            // Dé-commentez pour afficher les lignes dans la console
            for (String[] row : rows) {
                for (String e : row) {
                    System.out.format("%s ", e);
                }
                System.out.println();
            }
            */
            
            return rows;
        }
    }
}
