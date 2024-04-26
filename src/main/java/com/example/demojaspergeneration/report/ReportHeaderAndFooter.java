package com.example.demojaspergeneration.report;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportHeaderAndFooter {
    private JRBeanCollectionDataSource collectionBeanParam;
    private String branchName;
    private String branchAddress;
    private String accountNumber;
    private String beginningBalance;
    private String endingBalance;
    private String ledgerBalance;
    private String totalCredit;
    private String totalDebit;

    public JRBeanCollectionDataSource getCollectionBeanParam() {
        return collectionBeanParam;
    }

    public void setCollectionBeanParam(JRBeanCollectionDataSource collectionBeanParam) {
        this.collectionBeanParam = collectionBeanParam;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBeginningBalance() {
        return beginningBalance;
    }

    public void setBeginningBalance(String beginningBalance) {
        this.beginningBalance = beginningBalance;
    }
    public String getEndingBalance() {
        return endingBalance;
    }

    public void setEndingBalance(String endingBalance) {
        this.endingBalance = endingBalance;
    }

    public String getLedgerBalance() {
        return ledgerBalance;
    }

    public void setLedgerBalance(String ledgerBalance) {
        this.ledgerBalance = ledgerBalance;
    }

    public String getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(String totalCredit) {
        this.totalCredit = totalCredit;
    }

    public String getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(String totalDebit) {
        this.totalDebit = totalDebit;
    }
}