package com.board.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.constant.Method;
import com.board.paging.Criteria;

@Controller
public class UiUtils {

	public String showMessageWithRedirect(@RequestParam(value = "message", required = false) String message,
										  @RequestParam(value = "redirectUri", required = false) String redirectUri,
										  @RequestParam(value = "method", required = false) Method method,
										  @RequestParam(value = "params", required = false) Map<String, Object> params, Model model) {

		model.addAttribute("message", message);
		/*
		 * redirect uri
		 * 1. 게시글작성
		 * 2. 게시글 등록완료 메세지
		 * 3. 게시글 리스트페이지로 이동
		 */
		model.addAttribute("redirectUri", redirectUri);
		model.addAttribute("method", method);
		/*
		 * params
		 * view로 전달할 파라미터
		 * map을 이용하여 어떤페이지에 따라 달라질 파라미터 개수를 처리
		 */
		model.addAttribute("params", params);

		return "utils/message-redirect";
	}
	
	public Map<String, Object> getPagingParams(Criteria criteria) {

		Map<String, Object> params = new LinkedHashMap<>();
		params.put("currentPageNo", criteria.getCurrentPageNo());
		params.put("recordsPerPage", criteria.getRecordsPerPage());
		params.put("pageSize", criteria.getPageSize());
		params.put("searchType", criteria.getSearchType());
		params.put("searchKeyword", criteria.getSearchKeyword());

		return params;
	}

}