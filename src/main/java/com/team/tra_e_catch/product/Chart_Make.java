package com.team.tra_e_catch.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Chart_Make {
	Map<String,Object> list = new HashMap<String,Object>();	
	Map<String,Object> data = new HashMap<String,Object>();
	Map<String,Object> map1 = new HashMap<String,Object>();
	Map<String,Object> map 	= new HashMap<String,Object>();
	List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
	List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
	
	public void C_Make(List<Map<String,Object>> exe) {
		int i = 0;
		//값 넣는곳 하나당 하나씩		
		for(String s : exe.get(0).keySet()) {
			map1 = new HashMap<String, Object>();
			map1.put("id", "");
			map1.put("label", s);
			map1.put("pattern", "");
			map1.put("type", i==0?"string":"number");
			list1.add(map1);
			i++;
		}
		map.put("cols",list1);
		
		for(Map<String, Object> exex:exe) {
			data = new HashMap<String,Object>();
			list1 = new ArrayList<Map<String,Object>>();
			for(String s : exex.keySet()) {
				map1 = new HashMap<String, Object>();
				map1.put("v", s.equals("결제일자")?s:exex.get(s));
				map1.put("f", exex.get(s));
				list1.add(map1);
			}
			data.put("c", list1);	
			list2.add(data);
		}
		map.put("rows", list2);
	}
}
