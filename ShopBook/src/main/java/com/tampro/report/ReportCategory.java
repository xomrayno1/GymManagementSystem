package com.tampro.report;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ReportCategory extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Font font = workbook.createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short)10);
		//font.setColor(IndexedColors.RED.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setFont(font);
		String fileName  = "category_"+System.currentTimeMillis()+".xls";
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		Sheet sheet = workbook.createSheet("category");
		sheet.setColumnWidth(0, 7500);
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(2, 7500);
		Row row = sheet.createRow(0);
		row.createCell(0).setCellStyle(cellStyle);
		row.getCell(0).setCellValue("Tên danh mục");
		row.createCell(1).setCellStyle(cellStyle);
		row.getCell(1).setCellValue("Code");
		row.createCell(2).setCellStyle(cellStyle);
		row.getCell(2).setCellValue("Id Danh Mục Cha");
	}

}
