package com.usst.cad.homeworkssh.basic.model.json;

import java.util.ArrayList;
import java.util.List;

import com.usst.cad.homeworkssh.basic.util.JsonUtil;



public class ListResult<T> {
	private List<T> rows;
	private long total;

	public ListResult() {
	}

	public ListResult(List<T> rows, long total) {
		if (rows == null) {
			this.rows = new ArrayList<T>();
		}
		this.rows = rows;
		this.total = total;
	}

	public ListResult(List<T> rows) {
		this.rows = rows;
		this.total = rows.size();
	}

	public List<T> getRoot() {
		return rows;
	}

	public void setRoot(List<T> rows) {
		this.rows = rows;
	}

	public long getTotalItem() {
		return total;
	}

	public void setTotalItem(long total) {
		this.total = total;
	}

	public String toJson() {
		if (rows != null && rows.size() > 0) {
			if (rows.get(0) instanceof JsonEntity) {
				StringBuilder sb = new StringBuilder();
				sb.append("{total:").append(total).append(",");
				sb.append("rows:[");
				boolean first = true;
				for (T item : rows) {
					if (!first) {
						sb.append(",");
					}
					first = false;
					sb.append(((JsonEntity) item).toJson());
				}
				sb.append("]}");
				return sb.toString();
			}
		}
		return JsonUtil.parseObject(this);
	}
}
