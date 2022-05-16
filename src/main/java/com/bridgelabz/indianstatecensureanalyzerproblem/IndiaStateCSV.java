package com.bridgelabz.indianstatecensureanalyzerproblem;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCSV {
    public int SrNo;
    public String state;
    public int TIN;
    public String stateCode;

    /**
     * @return all values by printing all.
     */
    @Override
    public String toString() {
        return "IndiaStateCSV{" +
                "SrNo=" + SrNo +
                ", state='" + state + '\'' +
                ", TIN=" + TIN +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}

