package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.InvoiceDAO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;
import com.tampro.entity.Invoice;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.User;
import com.tampro.utils.Constant;
import com.tampro.utils.ConvertToDTO;

@Service
public class InvoiceService {
	@Autowired
	InvoiceDAO<Invoice>  invoiceDAO;
	@Autowired
	ProductInStockService productInStockService;
	@Autowired
	HistoryService historyService; 

	
	public List<InvoiceDTO> getAll(InvoiceDTO invoiceDTO , Paging paging){
		Map<String, Object> mapParam = new HashedMap();
		StringBuilder queryStr = new StringBuilder();
		if(invoiceDTO != null) {
			if(invoiceDTO.getDateTo() != null && invoiceDTO.getDateFrom() != null) {
				queryStr.append(" and date(model.createDate) between :dateTo and :dateFrom ");
				mapParam.put("dateTo", invoiceDTO.getDateTo());
				mapParam.put("dateFrom", invoiceDTO.getDateFrom());
			}
		}
		queryStr.append(" and model.type = :type  ");
		mapParam.put("type", invoiceDTO.getType());
		List<InvoiceDTO> list = new ArrayList<InvoiceDTO>();
		for(Invoice invoice : invoiceDAO.findAll(queryStr.toString(), mapParam, paging)) {
			InvoiceDTO dto = ConvertToDTO.convertInvoiceEntity(invoice);
			list.add(dto);
		}
		return list;		
	}
	public InvoiceDTO findById(int id) {
		Invoice invoice = invoiceDAO.findById(Invoice.class, id);
		InvoiceDTO invoiceDTO = ConvertToDTO.convertInvoiceEntity(invoice);
		return invoiceDTO;
	}
	public void add(InvoiceDTO invoiceDTO) throws Exception{		
		Invoice invoice = new Invoice();
		invoice.setActiveFlag(1);
		invoice.setCreateDate(new Date());
		invoice.setId(invoiceDTO.getId());
		invoice.setPrice(invoiceDTO.getPrice());
		invoice.setProductInfo(new ProductInfo(invoiceDTO.getIdProduct()));
		invoice.setQuantity(invoiceDTO.getQuantity());
		invoice.setTotalPrice(invoiceDTO.getTotalPrice());
		invoice.setType(invoiceDTO.getType());
		invoice.setUpdateDate(new Date());
		invoice.setUser(new User(invoiceDTO.getUserDTO().getId()));
		invoiceDAO.add(invoice);
		productInStockService.addOrUpdate(invoiceDTO);
		historyService.add(invoiceDTO, Constant.ACTION_ADD);
	}
	public void update(InvoiceDTO invoiceDTO) throws Exception{
		
		Invoice invoice = new Invoice();
		invoice.setActiveFlag(invoiceDTO.getActiveFlag());
		invoice.setCreateDate(invoiceDTO.getCreateDate());
		invoice.setId(invoiceDTO.getId());
		invoice.setPrice(invoiceDTO.getPrice());
		invoice.setProductInfo(new ProductInfo(invoiceDTO.getIdProduct()));
		invoice.setQuantity(invoiceDTO.getQuantity());
		invoice.setTotalPrice(invoiceDTO.getTotalPrice());
		invoice.setType(invoiceDTO.getType());
		invoice.setUpdateDate(new Date());
		invoiceDAO.update(invoice);
		productInStockService.addOrUpdate(invoiceDTO);
		historyService.add(invoiceDTO, Constant.ACTION_EDIT);
	}


}
