package com.tampro.report;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ReportProduct  extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "product_"+System.currentTimeMillis()+".xls";
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		Font font = workbook.createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short)10);
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		Sheet sheet = workbook.createSheet("Product");
		sheet.setColumnWidth(0, 7500);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 4000);
		sheet.setColumnWidth(4, 8000);
		sheet.setColumnWidth(5, 4000);
		sheet.setColumnWidth(6, 4000);
		sheet.setColumnWidth(7, 4000);
		sheet.setColumnWidth(8, 4000);
		sheet.setColumnWidth(9, 4000);
		sheet.setColumnWidth(10, 12000);		
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Tên sản phẩm");
		row.getCell(0).setCellStyle(cellStyle);
		row.createCell(1).setCellValue("Code");
		row.getCell(1).setCellStyle(cellStyle);
		row.createCell(2).setCellValue("ISBN");
		row.getCell(2).setCellStyle(cellStyle);
		row.createCell(3).setCellValue("Price");
		row.getCell(3).setCellStyle(cellStyle);
		row.createCell(4).setCellValue("Ngày phát hành (yyyy-MM-dd)");
		row.getCell(4).setCellStyle(cellStyle);
		row.createCell(5).setCellValue("Kích cỡ");
		row.getCell(5).setCellStyle(cellStyle);
		row.createCell(6).setCellValue("Số trang");
		row.getCell(6).setCellStyle(cellStyle);
		row.createCell(7).setCellValue("Id Danh Mục");
		row.getCell(7).setCellStyle(cellStyle);
		row.createCell(8).setCellValue("Id Tác giả");
		row.getCell(8).setCellStyle(cellStyle);
		row.createCell(9).setCellValue("Id Nhà xuất bản");
		row.getCell(9).setCellStyle(cellStyle);
		row.createCell(10).setCellValue("Chi tiết");
		row.getCell(10).setCellStyle(cellStyle);
	}

}
