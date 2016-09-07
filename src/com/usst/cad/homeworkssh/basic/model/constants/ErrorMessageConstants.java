package com.usst.cad.homeworkssh.basic.model.constants;

/**
 * 
 * Copyright Envision 系统通用错误常量定义
 * 
 * @version 1.0
 * @data 2012-11-12
 */
public interface ErrorMessageConstants {
	String SEARCH_KEY_NOTEMPTY = "查询条件的类别不能为空";
	String SEARCH_VALUE_NOTEMPTY = "查询内容不能为空";
	String OBJECT_NOT_EXIST = "对象不存在";
	String DELETE_FAILURE = "删除失败";
	String OBJECT_HASEXIST = "记录已存在";
	String OBJECT_CUSTOMER_NAME = "客户名称已存在";
	String JDBCEXCEPTION = "上传文件无效，此文件需要定制！";
	String DATEILLEGAL = "开始时间非法，应该大于当前时间！";
	String DATEILLEGAL1 = "失效日期应该至少大于生效日期一天！";
	String APPROVAL_RESULT = "请选择评审是否审批通过！";
	String OVER_YT_AMOUNT = "已超出剩余的预投数量，需要再次预投！相差台数：";
	String OVER_YT_AMOUNT_ZERO= "无预投数量，需要预投！";
	String BILL_NOT_NULL = "请选择开票信息！";
	String OUT_BILL_AMOUNT = "行本批开票数量已经超过剩余开票数量！";
	String PRODUCTS_INFO_NULL = "该要货计划无产品信息！";
	String GoodsPlan_HasExist = "该月的要货计划已存在！";
	String LESS_FREEZE_AMOUNT="预投数量不足无法解冻,请预投后再解冻;详细信息:";

	interface Common {
		String FILE_NOT_DOC = "文件必须是.doc格式";
		String FILE_NOT_PDF = "文件必须是.pdf格式";
		String FILE_NOT_EXCEL = "文件必须是.xlsx格式";
		String FILE_NOT_FOUND = "文件加载失败，没找到。";
		String FILE_TYPE_NOT_FOUND = "文件类型找不到";
		String EMAIL_ILLEGAL = "Email格式非法";
		String DI = "第";
		String AMOUNT_NULL = "行本批开票数量未填写";
	}

	interface Template {
		String TEMPLATE_NULL = "模板文件不存在!";
		String TYPE_NOTNULL = "模板类型不能为空";
		String NAME_NOTNULL = "模板名不能为空";
		String TEMPLATE_FILE_NOTNULL = "模板文件不能为空";
	}

}
