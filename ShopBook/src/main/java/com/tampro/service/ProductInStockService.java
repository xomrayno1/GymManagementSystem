package com.tampro.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.ProductInStockDAO;
import com.tampro.dto.InvoiceDTO;
import com.tampro.dto.ProductInStockDTO;
import com.tampro.entity.ProductInStock;
import com.tampro.entity.ProductInfo;
import com.tampro.utils.Constant;
import com.tampro.utils.ConvertToDTO;

@Service
public class ProductInStockService {
	@Autowired
	ProductInStockDAO<ProductInStock> productInStockDAO;
	@Autowired
	ProductInfoService productInfoService;
	
	public void addOrUpdate(InvoiceDTO invoiceDTO) {
		if(invoiceDTO.getIdProduct() != 0) {
			ProductInStockDTO productInStockDTO = findByProperty("productInfo.id", invoiceDTO.getIdProduct());
			ProductInStock inStock = null;
			if(productInStockDTO == null) { 
				if(invoiceDTO.getType() == Constant.GOODS_RECEIPT) {
					inStock = new ProductInStock();
					inStock.setActiveFlag(1);
					inStock.setCreateDate(new Date());
					inStock.setProductInfo(new ProductInfo(invoiceDTO.getIdProduct()));
					inStock.setQuantity(invoiceDTO.getQuantity());
					inStock.setUpdateDate(new Date());
					inStock.setPrice(invoiceDTO.getPrice());
					productInStockDAO.add(inStock);
				}
			}else {
				inStock = new ProductInStock();
				if(invoiceDTO.getType() == Constant.GOODS_RECEIPT) {
					inStock.setQuantity(productInStockDTO.getQuantity() + invoiceDTO.getQuantity());
					inStock.setPrice(invoiceDTO.getPrice());					
				}else {
					inStock.setQuantity(productInStockDTO.getQuantity() - invoiceDTO.getQuantity());
				}
				inStock.setUpdateDate(new Date());
				inStock.setProductInfo(new ProductInfo(invoiceDTO.getIdProduct()));
				inStock.setCreateDate(new Date());
				inStock.setActiveFlag(1);
				inStock.setPrice(productInStockDTO.getPrice());
				inStock.setId(productInStockDTO.getId());
				productInStockDAO.update(inStock);
			}
		}
	}
	public void delete(ProductInStockDTO productInStockDTO) {
		ProductInStock inStock = new ProductInStock();
		inStock.setActiveFlag(0);
		inStock.setCreateDate(productInStockDTO.getCreateDate());
		inStock.setId(productInStockDTO.getId());
		inStock.setProductInfo(new ProductInfo(productInStockDTO.getIdProduct()));
		inStock.setQuantity(productInStockDTO.getQuantity());
		inStock.setUpdateDate(new Date());
		productInStockDAO.delete(inStock);
	}
	public ProductInStockDTO findById(int id) {
		ProductInStock inStock = productInStockDAO.findById(ProductInStock.class, id);
		ProductInStockDTO productInStockDTO = ConvertToDTO.convertProductInStockEntity(inStock);
		return productInStockDTO;		
	}
	public ProductInStockDTO findByProperty(String property , Object object) {
		List<ProductInStock> inStocks = productInStockDAO.findByProperty(property, object);
		if(!inStocks.isEmpty()) {
			ProductInStockDTO productInStockDTO = ConvertToDTO.convertProductInStockEntity(inStocks.get(0));
			return productInStockDTO;	
		}
		return null;
	}
}
