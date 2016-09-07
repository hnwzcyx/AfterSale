package com.usst.cad.homeworkssh.basic.model.constants;

/**
 * 
 * Copyright Envision 系统通用部分常量定义
 * 
 * @version 1.0
 * @data 2012-11-12
 */
public interface AppConstants {
	String EMPTY = "";
	String YES = "是";
	String NO = "否";
	String MONTH="月";
	String YEAR="年";
	String RMB="元";
	String TAI="台";
	String CASCADE_REPLACE = "c";
	String CONTRACT_VERSION = "V";
	String POINT = ".";
	String DOUHAO = ",";
	String FENHAO = ";";
	String LINE = "-";
	String XIEXIAN = "/";
	String SUCCESS_DOWNLOAD_RESULT = "successDownLoad";
	String PLEASE_CHOOSE="---请选择---";
	String CHOOSE_ALL = "全部";
	String SUCCESS="success";
	int SUPPLIER_PORT_FLAG=1;
	String YT = "预投";
	String FYT = "非预投";
	String UNGENERATE = "工作令待生成";
	String HAVE = "有";
	String DELIVERY_TYPE = "滚动";
	String IDENTITY = "A";
	String WEIDAOCHU="未导出";

	interface Contract {
		String CONTRACT_DOWNLOAD_PATH = "/upload/contract/";
		String YearContract_Invaid = "已失效";
		String YearContract_NOT_Invaid = "未生效";
		String YearContract_Effect = "有效中";
		String CONTRACT_APPROVAL = "审批已通过";
		String CONTRACT_UNAPPROVAL = "审批不通过";
		String YT_CONTRACT = "Y";
		String FYT_CONTRACT = "F";
		String HEXIAO_CONTRACT = "H";
	}

	interface Template {
		String FYT_CONTRACT_NOTICE= "/FYT_Contract_Notice.xls";
		String FYT_CONTRACT_APPROVAL= "/FYT_Contract_Approval.xls";
		String YT_CONTRACT_NOTICE="/YT_Contract_Notice.xls";
		String YT_CONTRACT_APPROVAL="/YT_Contract_Approval.xls";
		String YT_ORDER_NOTICE="/YT_Order_Notice.xls";
		String YT_ORDER_APPROVAL="/YT_Order_Approval.xls";
		String BILL_NOTICE="/Bill_Notice.xls";
		String DELIVERY_NOTICE="/Delivery_Notice.xls";
		String SALE_POOL_ANALYSIS="/SALE_Pool_Analysis.xls";
		String saleReportForManagerDataExport="/SaleOrderContractEnquirySummaryforManagers.xls";
		String saleReportForDesignerDataExport="/SaleOrderContractEnquirySummaryforDesigners.xls";
		String saleReportForSupervisorDataExport="/SaleOrderContractEnquirySummaryforSupervisor.xls";
		String supplementPlanExport="/supplementPlanExport.xls";
		String monthDeliveryPlanExport="/monthDeliveryPlanExport.xls";
		String saleDataExportForOrderSkill="/saleDataExportForOrderSkill.xls";
		String IS_DEFAULT = "默认";
		String NOT_DEFAULT = "非默认";
	}

	interface FileCategory {
		String DOC = ".doc";
		String PDF = "pdf";
		String EXCEL = "xlsx";
		String EXCEL03 = "xls";
	}
	
	interface SaleReport {
		String GoodsPlanNO = "YHPlan-";
		String GoodsAdditionNo = "ZBPlan-";
	}

}
