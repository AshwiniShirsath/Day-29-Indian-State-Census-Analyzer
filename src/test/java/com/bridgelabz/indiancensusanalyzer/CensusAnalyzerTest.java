package com.bridgelabz.indiancensusanalyzer;

import com.bridgelabz.indianstatecensureanalyzerproblem.CensusAnalyser;
import com.bridgelabz.indianstatecensureanalyzerproblem.CensusAnalyzerException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CensusAnalyzerTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/IndiaStateCensusDataInWrongFormat.txt";
    private static final String CSV_WITH_WRONG_DELIMITER = "./src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
    private static final String CSV_WITH_INCORRECT_HEADER = "./src/test/resources/IndiaStateCensusDataIncorrectHeader.csv";


    private static final String INDIA_STATE_CODE_CSV = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CODE_CSV_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String STATE_CODE_INCORRECT_FILE_FORMAT = "./src/test/resources/IndiaStateCode.txt";
    private static final String STATE_CODES_WITH_WRONG_DELIMITER = "./src/test/resources/IndiaStateCodeWrongDelimiter.csv";
    private static final String STATE_CODES_WITH_INCORRECT_HEADER = "./src/test/resources/IndiaStateCodeIncorrectHeader.csv";


    @Test
    public void givenIndianCensusCSVFile_ReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyzerException e) { }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyzerException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyzerException.class);
            censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
        }
        catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianCensusCSVFile_WhenCustomDelimiter_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyzerException.class);
            censusAnalyser.loadIndiaCensusData(CSV_WITH_WRONG_DELIMITER);
        }
        catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianCensusCSVFile_WhenIncorrectHeader_ShouldThrowException() {

        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyzerException.class);
            censusAnalyser.loadIndiaCensusData(CSV_WITH_INCORRECT_HEADER);
        }
        catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
            e.printStackTrace();
        }
    }



    @Test
    public void givenIndianCensusCSVFile_WhenCorrectPath_ShouldReturnCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(33, numOfRecords);
        }
        catch (CensusAnalyzerException e) {
        }
    }




    @Test
    public void givenIndiaStateCodeCSVFile_WhenCorrectPath_ShouldReturnsCorrectRecords()
    {
        try
        {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndianStateCode(INDIA_STATE_CODE_CSV);
            Assert.assertEquals(37,numOfRecords);
        }
        catch (CensusAnalyzerException e) { }
    }
    @Test
    public void givenIndianStateCodeCSVFile_WhenWithWrongFilePath_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyzerException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(WRONG_STATE_CODE_CSV_PATH);
        }
        catch (CensusAnalyzerException e)
        {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenCorrectPathButWrongFileFormat_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyzerException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(STATE_CODE_INCORRECT_FILE_FORMAT);
        }
        catch (CensusAnalyzerException e)
        {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianStateCSVFile_WhenCustomDelimiter_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule =  ExpectedException.none();
        exceptionRule.expect(CensusAnalyzerException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(STATE_CODES_WITH_WRONG_DELIMITER);
        }
        catch (CensusAnalyzerException e)
        {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndiaStateCodeCSVFile_WhenIncorrectHeader_ShouldThrowException()
    {
        CensusAnalyser censusAnalyser = new CensusAnalyser();
        ExpectedException exceptionRule = ExpectedException.none();
        exceptionRule.expect(CensusAnalyzerException.class);
        try
        {
            censusAnalyser.loadIndianStateCode(STATE_CODES_WITH_INCORRECT_HEADER);
        }
        catch (CensusAnalyzerException e)
        {
            Assert.assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_WRONG_DELIMITER_OR_WRONG_HEADER, e.type);
            e.printStackTrace();
        }
    }
}

