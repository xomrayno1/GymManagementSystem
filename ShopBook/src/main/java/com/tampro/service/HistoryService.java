package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.HistoryDAO;
import com.tampro.dto.HistoryDTO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.Paging;
import com.tampro.entity.History;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.User;
import com.tampro.utils.ConvertToDTO;

@Service
public class HistoryService {

	@Autowired
	HistoryDAO<History> historyDAO;
	
	public void add(InvoiceDTO invoiceDTO , String actionName) {
		History history = new History();
		history.setActionName(actionName);
		history.setActiveFlag(1);
		history.setCreateDate(new Date());
		history.setPrice(invoiceDTO.getPrice());
		history.setProductInfo(new ProductInfo(invoiceDTO.getIdProduct()));
		history.setQuantity(invoiceDTO.getQuantity());
		history.setTotalPrice(invoiceDTO.getTotalPrice());
		history.setType(invoiceDTO.getType());
		history.setUpdateDate(new Date());
		history.setUser(new User(invoiceDTO.getUserDTO().getId()));
		historyDAO.add(history);
	}
	public List<HistoryDTO> getAll(HistoryDTO historyDTO , Paging paging){
		Map<String, Object> mapParam = new HashedMap();
		StringBuilder queryStr = new StringBuilder();
		if(historyDTO != null) {
			if(historyDTO.getType() != 0) {
				queryStr.append(" and  model.type = :type ");
				mapParam.put("type", historyDTO.getType());
			}
			if(historyDTO.getDateTo() != null && historyDTO.getDateFrom() != null) {
				queryStr.append(" and  model.createDate between :dateTo and :dateFrom ");
				mapParam.put("dateTo", historyDTO.getDateTo());
				mapParam.put("dateFrom", historyDTO.getDateFrom());
			}
		}
		List<HistoryDTO> list = new ArrayList<HistoryDTO>();
		for(History history : historyDAO.findAll(queryStr.toString(), mapParam, paging)) {
			HistoryDTO dto = ConvertToDTO.convertHistoryEntity(history);
			list.add(dto);
		}
		return list;
	}
}
