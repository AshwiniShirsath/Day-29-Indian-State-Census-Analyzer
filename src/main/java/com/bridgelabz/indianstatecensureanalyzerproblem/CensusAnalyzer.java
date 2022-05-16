package com.bridgelabz.indianstatecensureanalyzerproblem;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();;
            int namOfEateries = 0;
            while (censusCSVIterator.hasNext()) {
                namOfEateries++;
                IndiaCensusCSV censusData = censusCSVIterator.next();
            }
            return namOfEateries;
        } catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        catch(RuntimeException e) {
            throw new CensusAnalyzerException("CSV File Must Have Comma As Delimiter Or Has Incorrect Header", CensusAnalyzerException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER);
        }
    }
    public int loadIndianStateCode(String csvFilePath) throws CensusAnalyzerException {
        try {
            if(csvFilePath.contains(".txt")) {
                throw new CensusAnalyzerException("File must be in CSV Format", CensusAnalyzerException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
            }
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaStateCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaStateCSV>(reader);
            csvToBeanBuilder.withType(IndiaStateCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaStateCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaStateCSV> stateCodesCSVIterator = csvToBean.iterator();
            int numberOfEntries = 0;
            while(stateCodesCSVIterator.hasNext()) {
                numberOfEntries++;
                IndiaStateCSV censusData = stateCodesCSVIterator.next();
            }
            return numberOfEntries;
        }
        catch (IOException e) {
            throw new CensusAnalyzerException(e.getMessage(), CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        catch(RuntimeException e) {
            throw new CensusAnalyzerException("CSV File Must Have Comma As Delimiter Or Has Incorrect Header", CensusAnalyzerException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER);
        }
    }
}