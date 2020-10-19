package com.tampro.report;

import java.text.SimpleDateFormat;
import java.util.List;
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

import com.tampro.dto.InvoiceDTO;

public class ReportReceipt  extends AbstractXlsView{

	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder fileName = new StringBuilder("report_receipt_");
		String dateString = (String)  model.get("dateString");
		if(dateString != null) {
			fileName.append(dateString);
		}
		fileName.append(".xls");
		List<InvoiceDTO> list = (List<InvoiceDTO>)	model.get("list");
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName.toString()+"\"");
		Sheet sheet = workbook.createSheet();
		sheet.setColumnWidth(0, 2000);
		sheet.setColumnWidth(1, 2000);
		sheet.setColumnWidth(2, 10000);
		sheet.setColumnWidth(3, 6000);
		sheet.setColumnWidth(4, 3000);
		sheet.setColumnWidth(5, 6000);
		sheet.setColumnWidth(6, 8000);
		sheet.setColumnWidth(7, 8000);
		Row row = sheet.createRow(0);
		Font fontHeader = workbook.createFont();
		fontHeader.setBold(true);
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFont(fontHeader);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		row.createCell(0).setCellValue("#");
		row.getCell(0).setCellStyle(cellStyle);
		row.createCell(1).setCellValue("Id");
		row.getCell(1).setCellStyle(cellStyle);
		row.createCell(2).setCellValue("Tên sản phẩm");
		row.getCell(2).setCellStyle(cellStyle);
		row.createCell(3).setCellValue("Đơn giá");
		row.getCell(3).setCellStyle(cellStyle);
		row.createCell(4).setCellValue("Số lượng");
		row.getCell(4).setCellStyle(cellStyle);
		row.createCell(5).setCellValue("Thành tiền");
		row.getCell(5).setCellStyle(cellStyle);
		row.createCell(6).setCellValue("Người Nhập");
		row.getCell(6).setCellStyle(cellStyle);
		row.createCell(7).setCellValue("Ngày Nhập");
		row.getCell(7).setCellStyle(cellStyle);
		
		CellStyle cellStyleContent = workbook.createCellStyle();
		cellStyleContent.setAlignment(HorizontalAlignment.CENTER);
		if(!list.isEmpty()) {
			int rowIndex = 1 ;	
			for(InvoiceDTO invoiceDTO : list) {
				Row	rowContent = sheet.createRow(rowIndex++);			
				rowContent.createCell(0).setCellValue(rowIndex - 1);
				rowContent.getCell(0).setCellStyle(cellStyleContent);
				rowContent.createCell(1).setCellValue(invoiceDTO.getId());
				rowContent.getCell(1).setCellStyle(cellStyleContent);			
				rowContent.createCell(2).setCellValue(invoiceDTO.getProductInfoDTO().getName());
				rowContent.getCell(2).setCellStyle(cellStyleContent);
				rowContent.createCell(3).setCellValue(invoiceDTO.getPrice().toString());
				rowContent.getCell(3).setCellStyle(cellStyleContent);
				rowContent.createCell(4).setCellValue(invoiceDTO.getQuantity());
				rowContent.getCell(4).setCellStyle(cellStyleContent);
				rowContent.createCell(5).setCellValue(invoiceDTO.getTotalPrice().toString());
				rowContent.getCell(5).setCellStyle(cellStyleContent);
				rowContent.createCell(6).setCellValue(invoiceDTO.getUserDTO().getName());
				rowContent.getCell(6).setCellStyle(cellStyleContent);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				rowContent.createCell(7).setCellValue(dateFormat.format(invoiceDTO.getCreateDate()));
				rowContent.getCell(7).setCellStyle(cellStyleContent);
			}
		}
		
	}


}
