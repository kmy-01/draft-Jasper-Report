package com.example.demojaspergeneration.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenerateJasperReport {

    public GenerateJasperReport(String templatePath, String targetPath, String reportType) {
    }

    public static class Builder {
        private String templatePath;
        private String targetPath;
        private String reportType;

        /**
         * Set the template path
         * @param templatePath
         */
        public Builder template(String templatePath) {
            this.templatePath = templatePath;
            return this;
        }

        /**
         * Set the target path
         * @param targetPath
         */
        public Builder target(String targetPath) {
            this.targetPath = targetPath;
            return this;
        }

        /**
         * Set the report type
         * @param reportType
         */
        public Builder type(String reportType) {
            this.reportType = reportType;
            return this;
        }

        public void process(Object objHeader) throws JRException, IllegalAccessException {
            Map<String, Object> reportParameter = transformObjDataToMap(objHeader);
            JasperReport jasperReport = JasperCompileManager.compileReport(templatePath);

            JasperPrint print = JasperFillManager.fillReport(jasperReport, reportParameter, new JREmptyDataSource());

            if (reportType.equalsIgnoreCase("PDF"))
                JasperExportManager.exportReportToPdfFile(print, targetPath);

            if (reportType.equalsIgnoreCase("DOCX")) {
                JRDocxExporter docxExporter = new JRDocxExporter();
                docxExporter.setExporterInput(new SimpleExporterInput(print));
                docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(targetPath));
                docxExporter.exportReport();
            }
        }

        private Map<String, Object> transformObjDataToMap(Object objHeader) throws IllegalAccessException {
            Map<String, Object> objectMap = new HashMap<>();
            Field[] fields = objHeader.getClass().getDeclaredFields();

            for(Field field: fields) {
                field.setAccessible(true);
                objectMap.put(field.getName(), field.get(objHeader));
            }

            return objectMap;
        }
    }

}
