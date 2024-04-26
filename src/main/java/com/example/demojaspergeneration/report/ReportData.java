package com.example.demojaspergeneration.report;

public class ReportData {

    private String entryDate;
    private String valueDate;
    private String transactionAmount;
    private String transactionDescription;
    private String statementBalance;

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getStatementBalance() {
        return statementBalance;
    }

    public void setStatementBalance(String statementBalance) {
        this.statementBalance = statementBalance;
    }
}
