package com.example.demojaspergeneration.controller;

import com.example.demojaspergeneration.report.ReportData;
import com.example.demojaspergeneration.report.ReportHeaderAndFooter;
import com.example.demojaspergeneration.service.GenerateJasperReport;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.fill.JRExpressionEvalException;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestingController {

    private String TARGET_TEMPLATE = "D:\\Users\\80011109\\Downloads\\demo-jasper-generation\\src\\main\\resources\\templates\\Deposit MY Statement.jrxml";
    private String TARGET_FILE = "D:\\Users\\80011109\\Downloads\\demo-jasper-generation\\src\\main\\resources\\testing-deposit-my.pdf";

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() throws FileNotFoundException, JRException {
        ReportData reportData = new ReportData();
        reportData.setEntryDate("12 May 2000");
        reportData.setValueDate("08 Feb 2023");
        reportData.setTransactionDescription("INTER-BANK PAYMENT INTO A/C");
        reportData.setTransactionAmount("8,999.00");
        reportData.setStatementBalance("89,999.00");

        ReportData reportData2 = new ReportData();
        reportData2.setEntryDate("12 May 2000");
        reportData2.setValueDate("08 Feb 2023");
        reportData2.setTransactionDescription("INWARD CLEARING CHQ DEBIT  775643");
        reportData2.setTransactionAmount("8,999.00");
        reportData2.setStatementBalance("89,999.00");

        ReportData reportData3 = new ReportData();
        reportData3.setEntryDate("12 May 2000");
        reportData3.setValueDate("08 Feb 2023");
        reportData3.setTransactionDescription("CHEQUE PROCESSING FEE");
        reportData3.setTransactionAmount("8,999.00");
        reportData3.setStatementBalance("89,999.00");

        ReportData reportData4 = new ReportData();
        reportData4.setEntryDate("12 May 2000");
        reportData4.setValueDate("08 Feb 2023");
        reportData4.setTransactionDescription("INWARD CLEARING CHQ DEBIT  775643");
        reportData4.setTransactionAmount("8,999.00");
        reportData4.setStatementBalance("89,999.00");

        ReportData reportData5 = new ReportData();
        reportData5.setEntryDate("12 May 2000");
        reportData5.setValueDate("08 Feb 2023");
        reportData5.setTransactionDescription("CHEQUE PROCESSING FEE");
        reportData5.setTransactionAmount("8,999.00");
        reportData5.setStatementBalance("89,999.00");

        List<ReportData> reportDataList = new ArrayList<>();
        reportDataList.add(reportData);
        reportDataList.add(reportData2);
        reportDataList.add(reportData3);
        reportDataList.add(reportData4);
        reportDataList.add(reportData5);
        reportDataList.add(reportData);
        reportDataList.add(reportData2);
        reportDataList.add(reportData3);
        reportDataList.add(reportData4);
        reportDataList.add(reportData5);
        reportDataList.add(reportData);
        reportDataList.add(reportData2);
        reportDataList.add(reportData3);
        reportDataList.add(reportData4);
        reportDataList.add(reportData5);
        reportDataList.add(reportData);
        reportDataList.add(reportData2);
        reportDataList.add(reportData3);
        reportDataList.add(reportData4);
        reportDataList.add(reportData5);

        JRBeanCollectionDataSource collectionDataSource = new JRBeanCollectionDataSource(reportDataList);

        ReportHeaderAndFooter reportHeaderAndFooter = new ReportHeaderAndFooter();
        reportHeaderAndFooter.setBranchName("MAIN HQ - KL BRANCH");
        reportHeaderAndFooter.setBranchAddress("1st Floor, Kuala Lumpur Main Branch, Maybank Tower, 100, Jalan Tun Perak, Bukit Bintang, 50050 Kuala Lumpur, Federal Territory of Kuala Lumpur");
        reportHeaderAndFooter.setAccountNumber("88009938388");
        reportHeaderAndFooter.setBeginningBalance("11,111.11");
        reportHeaderAndFooter.setEndingBalance("52,3333.27");
        reportHeaderAndFooter.setLedgerBalance("234,838.00");
        reportHeaderAndFooter.setTotalCredit("87,888.00");
        reportHeaderAndFooter.setTotalDebit("87,999.00");

        reportHeaderAndFooter.setCollectionBeanParam(collectionDataSource);

        try {
            new GenerateJasperReport.Builder()
                    .type("PDF")
                    .template(TARGET_TEMPLATE)
                    .target(TARGET_FILE)
                    .process(reportHeaderAndFooter);

        } catch (JRException e) {
            System.out.println("ERRRORRRRR " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
