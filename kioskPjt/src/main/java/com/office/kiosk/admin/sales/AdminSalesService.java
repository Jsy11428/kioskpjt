package com.office.kiosk.admin.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import com.office.kiosk.admin.member.IAdminMemberDao;
import com.office.kiosk.franchisee.dto.SearchSalesDto;
import com.office.kiosk.franchisee.sales.FranchiseeSalesDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminSalesService {
	
	@Autowired
	IAdminSalesDao iAdminSalesDao;
	
	@Autowired
	IAdminMemberDao iAdminMemberDao;

	public List<FranchiseeSalesDto> salesList() {
		log.info("salesList()");
			
		return iAdminSalesDao.selectAllSalesInfo();
	}

	public Map<String, Object> getAllSalesInfo() {
		log.info("getAllSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> franchiseeSalesDtos = 
				iAdminSalesDao.selectAllSalesInfoForAjax();
		
		map.put("franchiseeSalesDtos", franchiseeSalesDtos);
		
		return map;
	}

	public Map<String, Object> getSearchSales(SearchSalesDto searchSalesDto) {
		log.info("getSearchSales()");
		
		Map<String, Object> map = new HashMap<>();
		
		String searchValue = searchSalesDto.getSearch_value();
		String searchTerm = searchSalesDto.getSearch_term();
		String searchWord = searchSalesDto.getSearch_word();
		
		List<FranchiseeSalesDto> searchSalesDtos = new ArrayList<>();
		
		switch (searchValue) {
		case "fcs_name":
			
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsName(searchTerm, searchWord);
			
			switch (searchTerm) {
			case "1d":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForOneDay(searchWord);
				
				break;
			
			case "1w":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForOneWeek(searchWord);
				
				break;
				
			case "1m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForOneMonth(searchWord);
				
				break;
			
			case "6m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForSixMonth(searchWord);
				
				break;
				
			case "1y":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsNameForOneYear(searchWord);
				
				break;
			
			case "all":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsName(searchWord);
				
				break;
				
			}
			
			break;
			
		case "fcm_name":
			
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmName(searchTerm, searchWord);
			
			switch (searchTerm) {
			case "1d":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForOneDay(searchWord);
				
				break;
			
			case "1w":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForOneWeek(searchWord);
				
				break;
				
			case "1m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForOneMonth(searchWord);
				
				break;
			
			case "6m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForSixMonth(searchWord);
				
				break;
				
			case "1y":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmNameForOneYear(searchWord);
				
				break;
			
			case "all":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmName(searchWord);
				
				break;
				
			}
			
			break;
			
		case "pm_type":
			
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmType(searchTerm, searchWord);
			
			switch (searchTerm) {
			case "1d":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForOneDay(searchWord);
				
				break;
			
			case "1w":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForOneWeek(searchWord);
				
				break;
				
			case "1m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForOneMonth(searchWord);
				
				break;
			
			case "6m":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForSixMonth(searchWord);
				
				break;
				
			case "1y":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmTypeForOneYear(searchWord);
				
				break;
			
			case "all":
				
				searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmType(searchWord);
				
				break;
				
			}
			
			break;
		}
		
//		if (searchValue == "fcs_name") {
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcsName(searchSalesDto);
//		} else if (searchValue == "fcm_name") {
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByFcmName(searchSalesDto);
//		} else if (searchValue == "pm_type") {
//			searchSalesDtos = iAdminSalesDao.selectSalesInfoByPmType(searchSalesDto);
//		}
		
		
		map.put("searchSalesDtos", searchSalesDtos);
		
		return map;
	}

	public Map<String, Object> getStoreAllSalesInfo() {
		log.info("getStoreAllSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> storeSalesDtos = 
				iAdminSalesDao.selectStoreTotalSales();
		
		map.put("storeSalesDtos", storeSalesDtos);
		
		return map;
	}

	public Map<String, Object> getSelectDateSalesInfo(Map<String, String> currentDate) {
		log.info("getSelectDateSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
		
		List<FranchiseeSalesDto> selectSalesDtos = 
				iAdminSalesDao.selectDateTotalSales(selectDate);
		
		map.put("selectSalesDtos", selectSalesDtos);
		
		return map;
	}

	public Map<String, Object> getFranchiseeAllSalesInfo() {
		log.info("getFranchiseeAllSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> franchiseeSalesDtos = 
				iAdminSalesDao.selectFranchiseeTotalSales();
		
		map.put("franchiseeSalesDtos", franchiseeSalesDtos);
		
		return map;
	}

	public Map<String, Object> getSelectDateFranchiseeSalesInfo(Map<String, String> currentDate) {
		log.info("getSelectDateSalesInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		String year = currentDate.get("year");
        String month = currentDate.get("month");
        String date = currentDate.get("date");

        String selectDate = String.format("%04d-%02d-%02d",
                Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(date));
		
		List<FranchiseeSalesDto> selectFranchiseeSalesDtos = 
				iAdminSalesDao.selectDateFranchiseeTotalSales(selectDate);
		
		map.put("selectFranchiseeSalesDtos", selectFranchiseeSalesDtos);
		
		return map;
	}

	public Map<String, Object> getFranchiseeTotalSalesByInputPeriod(Map<String, String> period) {
		log.info("getFranchiseeTotalSalesByInputPeriod()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> selectFranchiseeSalesDtosByInputFeriod =
				iAdminSalesDao.selectFranchiseeSalesDtosByInputFeriod(period);
		
		map.put("selectFranchiseeSalesDtosByInputFeriod", selectFranchiseeSalesDtosByInputFeriod);
		
		return map;
		
	}

	public Map<String, Object> getStoreTotalSalesByInputPeriod(Map<String, String> period) {
		log.info("getStoreTotalSalesByInputPeriod()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> selectStoreSalesDtosByInputFeriod =
				iAdminSalesDao.selectStoreSalesDtosByInputFeriod(period);
		
		map.put("selectStoreSalesDtosByInputFeriod", selectStoreSalesDtosByInputFeriod);
		
		return map;
	}

	public Map<String, Object> getSalesDetailInfo(int fco_ori_no) {
		log.info("getSalesDetailInfo()");
		
		Map<String, Object> map = new HashMap<>();
		
		List<FranchiseeSalesDto> salesDetailInfo = 
				iAdminSalesDao.selectOrderInfoByOriNo(fco_ori_no);
		
		map.put("salesDetailInfo", salesDetailInfo);
		
		return map;
	}

}
