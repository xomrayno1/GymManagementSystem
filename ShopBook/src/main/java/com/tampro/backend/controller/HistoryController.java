package com.tampro.backend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.dto.HistoryDTO;
import com.tampro.dto.Paging;
import com.tampro.service.HistoryService;
import com.tampro.service.ProductInfoService;

@Controller
@RequestMapping("/manage/history")
public class HistoryController {
	@Autowired
	HistoryService historyService;
	@Autowired
	ProductInfoService productInfoService;
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	@GetMapping(value = {"/list","/list/"})
	public String redirect() {
		return "redirect:/manage/history/list/1";
	}
	@RequestMapping("/list/{page}")
	public String showGoodsReceipt(Model model,@PathVariable("page") int page,@ModelAttribute("searchForm") HistoryDTO historyDTO) {
		Paging paging = new Paging(10);
		paging.setPageIndex(page);
		List<HistoryDTO> list = historyService.getAll(historyDTO, paging);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", paging);
		return "manage/history-list";
	}
	

}
