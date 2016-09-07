package com.usst.cad.homeworkssh.basic.util;

import java.io.File;
import java.util.Date;

import com.usst.cad.homeworkssh.basic.model.SRMException;
import com.usst.cad.homeworkssh.basic.model.constants.AppConstants;
import com.usst.cad.homeworkssh.basic.model.constants.ErrorMessageConstants;



public final class ParamAssert {
	private ParamAssert() {
	}

	public static void isNotEmptyString(String s, String errorInfo) throws SRMException {
		isTrue(s != null && DataUtil.notEmptyString(s), errorInfo);
	}

	public static void isNotNull(Object o, String errorInfo) throws SRMException {
		isTrue(o != null, errorInfo);
	}

	public static void isNull(Object o, String errorInfo) throws SRMException {
		isTrue(o == null, errorInfo);
	}

	public static void isEqual(Object a, Object b, String errorInfo) throws SRMException {
		isTrue(a.equals(b), errorInfo);
	}

	public static void isNotEqual(Object a, Object b, String errorInfo) throws SRMException {
		isTrue(!a.equals(b), errorInfo);
	}

	public static void isSame(Object a, Object b, String errorInfo) throws SRMException {
		isTrue(a == b, errorInfo);
	}

	public static void isTrue(boolean result, String errorInfo) throws SRMException {
		if (!result) {
			throw new SRMException(errorInfo);
		}
	}
	
	public static void idDateLegaa(Date start,Date current,String errorInfo) throws SRMException {
		if (start.before(current)) {
			throw new SRMException(errorInfo);
		}
	}
	
	public static void isFalse(boolean result, String errorInfo) throws SRMException {
		if (result) {
			throw new SRMException(errorInfo);
		}
	}

	public static void isNotNULLFileDOC(File file, String fileName, String errorInfo) throws SRMException {
		if (file == null) {
			throw new SRMException(errorInfo);
		}
		if (!fileName.toLowerCase().endsWith("doc")) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_DOC);
		}
	}

	public static void isNotNULLFilePDF(File file, String fileName, String errorInfo) throws SRMException {
		if (file == null) {
			throw new SRMException(errorInfo);
		}

		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.PDF)) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_PDF);
		}
	}
	public static void isPDF(File file, String fileName, String errorInfo) throws SRMException {

		if (file != null && !fileName.toLowerCase().endsWith(AppConstants.FileCategory.PDF)) {
			throw new SRMException(errorInfo);
		}
	}
	
	public static void isNotFilePDF(File file, String fileName) throws SRMException {
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.PDF)) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_PDF);
		}
	}

	public static void isFileExcel(File file, String fileName) throws SRMException {
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.EXCEL)) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_EXCEL);
		}
	}

	public static void isNotNULLFileExcel(File file, String fileName, String errorInfo) throws SRMException {
		if (file == null) {
			throw new SRMException(errorInfo);
		}
		if (!fileName.toLowerCase().endsWith(AppConstants.FileCategory.EXCEL)) {
			throw new SRMException(fileName + ErrorMessageConstants.Common.FILE_NOT_EXCEL);
		}
	}

}
