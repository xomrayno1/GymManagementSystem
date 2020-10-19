package com.tampro.report;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ReportPublisher extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName = "publisher_"+System.currentTimeMillis()+".xls";
		response.setHeader("Content-Disposition", "Attachment;filename=\""+fileName+"\"");
		Font font  = workbook.createFont();
		font.setBold(true);
		//font.setColor(IndexedColors.RED.getIndex()); 
		font.setFontHeightInPoints((short)10);
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setFont(font);
		Sheet sheet = workbook.createSheet("Publisher");
		sheet.setColumnWidth(0, 7000);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 7000);
		sheet.setColumnWidth(4, 8000);
		sheet.setColumnWidth(5, 15000);
		Row row = sheet.createRow(0);	
		row.createCell(0).setCellValue("Tên nhà xuất bản");
		row.getCell(0).setCellStyle(cellStyle);
		row.createCell(1).setCellValue("Code");
		row.getCell(1).setCellStyle(cellStyle);
		row.createCell(2).setCellValue("Điện thoại");
		row.getCell(2).setCellStyle(cellStyle);
		row.createCell(3).setCellValue("Email");
		row.getCell(3).setCellStyle(cellStyle);
		row.createCell(4).setCellValue("Website");
		row.getCell(4).setCellStyle(cellStyle);
		row.createCell(5).setCellValue("Địa chỉ");
		row.getCell(5).setCellStyle(cellStyle);
	}

}
