package com.tampro.report;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.tampro.dto.OrderDTO;
import com.tampro.service.OrderService;
import com.tampro.service.UserService;



public class ReportOrder  extends AbstractXlsView {
	@Autowired
	OrderService orderService;
	@Autowired
	UserService userService;

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String dateString = (String) model.get("dateString");
		String fileName  = "report_order_"+dateString+System.currentTimeMillis()+".xls";
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		Font font = workbook.createFont(); //font header
		font.setBold(true);
		font.setFontHeightInPoints((short)14);
		CellStyle cellStyle = workbook.createCellStyle(); //cellStyle header
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setFont(font);
		Sheet sheet = workbook.createSheet("order");
		sheet.setColumnWidth(0, 2000);
		sheet.setColumnWidth(1, 3000);
		sheet.setColumnWidth(2, 6000);
		sheet.setColumnWidth(3, 6000);
		sheet.setColumnWidth(4, 6000);
		sheet.setColumnWidth(5, 6000);
		sheet.setColumnWidth(6, 6000);
		sheet.setColumnWidth(7, 7000);
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("#");
		row.getCell(0).setCellStyle(cellStyle);
		row.createCell(1).setCellValue("Mã đơn hàng");
		row.getCell(1).setCellStyle(cellStyle);
		row.createCell(2).setCellValue("Tình trạng");
		row.getCell(2).setCellStyle(cellStyle);
		row.createCell(3).setCellValue("Người nhận");
		row.getCell(3).setCellStyle(cellStyle);
		row.createCell(4).setCellValue("Địa chỉ giao hàng");
		row.getCell(4).setCellStyle(cellStyle);
		row.createCell(5).setCellValue("Điện thoại khách");
		row.getCell(5).setCellStyle(cellStyle);
		row.createCell(6).setCellValue("Tổng tiền");
		row.getCell(6).setCellStyle(cellStyle);
		row.createCell(7).setCellValue("Ngày mua");
		row.getCell(7).setCellStyle(cellStyle);
		List<OrderDTO> list  = (List<OrderDTO>) model.get("listOrder");
		Font fontContent = workbook.createFont(); //font content
		font.setFontHeightInPoints((short)10);
		font.setBold(true);
		CellStyle style = workbook.createCellStyle(); //cellStyle content
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFont(fontContent);
		if(!list.isEmpty()) {
			int rowIndex = 1;
			BigDecimal totalPrice = new BigDecimal(0);
			for(OrderDTO item : list) {			
				row = sheet.createRow(rowIndex++);
				row.createCell(0).setCellValue(rowIndex - 1);
				row.getCell(0).setCellStyle(style);
				row.createCell(1).setCellValue(item.getId());
				row.getCell(1).setCellStyle(style);
				row.createCell(2).setCellValue(item.getDisplay());
				row.getCell(2).setCellStyle(style);
				row.createCell(3).setCellValue(item.getShipmentDetails().getName());
				row.getCell(3).setCellStyle(style);
				row.createCell(4).setCellValue(item.getShipmentDetails().getProvince());
				row.getCell(4).setCellStyle(style);
				row.createCell(5).setCellValue(item.getShipmentDetails().getPhone());
				row.getCell(5).setCellStyle(style);
				row.createCell(6).setCellValue(item.getSubTotal().toString());
				row.getCell(6).setCellStyle(style);
				row.createCell(7).setCellValue(item.getCreateDate().toString());
				row.getCell(7).setCellStyle(style);
				totalPrice = totalPrice.add(item.getSubTotal());
			}
			row = sheet.createRow(rowIndex+1);
			row.createCell(1).setCellValue("Tổng tiền : ");
			DecimalFormat decimalFormat = new DecimalFormat("#,###");
			row.createCell(6).setCellValue(decimalFormat.format(totalPrice));
		}
	} 

}
