package org.fernandogcabal.framework.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class CsvReaderUtil{

    //CSV Regex
    //Split on commas only if that comma is not inside double quotes.
    final String CSV_REGEX = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    //Read CSV
    //Input: file path as a String
    //Output: parsed CSV data
    //Handle file issues
    public List<List<String>> readCsv(String filepath) throws IOException{

        Path path = Path.of(filepath);
        //Reads the entire file
        //Each element =  one line of CSV
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        //Delegates parsing logic
        return parseLines(lines);

    }

    //ParseLines method - Private helper
    private List<List<String>> parseLines(List<String> lines){

        //Output container
        List<List<String>> finalLines = new ArrayList<>();

        //Remove header row
        //Assumption, first row always header
        if(!lines.isEmpty()){
            lines.remove(0);
        }

        //Loop over each data row
        for (String line: lines){
            //Skip empty lines
            if(line.isBlank()){
                continue;
            }else{
                //Split the CSV row
                String[] words = line.split(CSV_REGEX);

                //Clean each value
                for(int i = 0; i < words.length; i++){
                    //Removes leading/trailing spaces
                    //Removes double quotes
                    words[i] = words[i].trim().replace("\"","");
                }
                //Add parse row
                //Converts String[] -> List<String>
                finalLines.add(Arrays.stream(words).toList());
            }
        }
        return finalLines;
    }

}
