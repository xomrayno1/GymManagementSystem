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

public class ReportAuthor extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String fileName =  "author_"+System.currentTimeMillis()+".xls";
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		Font font = workbook.createFont();
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		font.setBold(true);
		//font.setColor(IndexedColors.RED.getIndex()); 
		font.setFontHeightInPoints((short)10);
		Sheet sheet = workbook.createSheet();
		sheet.setColumnWidth(0, 7000);
		sheet.setColumnWidth(1, 7000);
		sheet.setColumnWidth(2, 10000);
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Tên tác giả");
		row.getCell(0).setCellStyle(cellStyle);
		row.createCell(1).setCellValue("Email");
		row.getCell(1).setCellStyle(cellStyle);
		row.createCell(2).setCellValue("Chi tiết");
		row.getCell(2).setCellStyle(cellStyle);
	}

}
