package com.usst.cad.homeworkssh.basic.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.usst.cad.homeworkssh.basic.util.JsonUtil;



@SuppressWarnings("serial")
public final class JsonList implements Serializable {
	private List<JsonItem> list = new ArrayList<JsonItem>();

	public JsonItem createItem() {
		JsonItem item = new JsonItem();
		list.add(item);
		return item;
	}

	public void add(JsonItem item) {
		list.add(item);
	}

	@Override
	public String toString() {
		return new ListResult<JsonItem>(list, list.size()).toJson();
	}

	public String toPageString(long size) {
		return new ListResult<JsonItem>(list, size).toJson();
	}
	
	public String toListString(){
		return JsonUtil.parseArray(list);
	}

	public JsonItem getItem(int index) {
		return list.get(index);
	}
	
	public String toPageString(int start, int limit) {
		List<JsonItem> tmp = new ArrayList<JsonItem>();
		for(int i = start ; i < start + limit && i < list.size() ; i ++) {
			tmp.add(list.get(i));
		}
		return new ListResult<JsonItem>(tmp, list.size()).toJson();
	}
	
	public int size() {
		return list.size();
	}
	
	public List<JsonItem> getList() {
		return list;
	}
}
