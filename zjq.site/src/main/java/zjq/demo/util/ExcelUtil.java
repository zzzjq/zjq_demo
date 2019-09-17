package zjq.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author:zhangjq
 * @time:2017年12月26日 下午5:23:40
 * @version:v1.0
 */
public class ExcelUtil {

	private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	
	private final static String XLS = "xls";
	
	private final static String XLSX = "xlsx";
	
	public static List<String[]> readExcel(File file) throws Exception{
		checkFile(file);
		Workbook workbook = getWorkbook(file);
		List<String[]> list = new ArrayList<String[]>();
		try{
			if(null != workbook){
				for(int num = 0; num < workbook.getNumberOfSheets(); num ++){
					Sheet sheet = workbook.getSheetAt(num);
					if(sheet == null){
						continue;
					}
					int firstRow = sheet.getFirstRowNum();
					int lastRow = sheet.getLastRowNum();
					for(int rowNum = firstRow+1; rowNum <= lastRow; rowNum++){
						Row row = sheet.getRow(rowNum);
						if(row == null){
							continue;
						}
						int firstCell = row.getFirstCellNum();
						int lastCell = row.getLastCellNum();
						String[] cells = new String[row.getPhysicalNumberOfCells()];
						for(int cellNum = firstCell; cellNum < lastCell; cellNum++){
							Cell cell = row.getCell(cellNum);
							cells[cellNum] = getCell(cell);
						}
						list.add(cells);
					}
				}
			}
		}
		finally{
			workbook.close();
		}
		return list;
	}
	
	public static List<String[]> readExcel(MultipartFile file) throws Exception{
		checkFile(file);
		Workbook workbook = getWorkbook(file);
		List<String[]> list = new ArrayList<String[]>();
		try{
			if(null != workbook){
				for(int num = 0; num < workbook.getNumberOfSheets(); num ++){
					Sheet sheet = workbook.getSheetAt(num);
					if(sheet == null){
						continue;
					}
					int firstRow = sheet.getFirstRowNum();
					int lastRow = sheet.getLastRowNum();
					for(int rowNum = firstRow+1; rowNum <= lastRow; rowNum++){
						Row row = sheet.getRow(rowNum);
						if(row == null){
							continue;
						}
						int firstCell = row.getFirstCellNum();
						int lastCell = row.getLastCellNum();
						String[] cells = new String[row.getPhysicalNumberOfCells()];
						for(int cellNum = firstCell; cellNum < lastCell; cellNum++){
							Cell cell = row.getCell(cellNum);
							cells[cellNum] = getCell(cell);
						}
						list.add(cells);
					}
				}
			}
		}
		finally{
			workbook.close();
		}
		return list;
	}
	
	private static Workbook getWorkbook(File file){
		String fileName = file.getName();
		Workbook workbook = null;
		if(fileName.endsWith(XLS)){
			try {
				workbook = new HSSFWorkbook(new FileInputStream(file));
			} catch (IOException e) {
				logger.error("文件流异常");
			}
		}
		else if(fileName.endsWith(XLSX)){
			try {
				workbook = new XSSFWorkbook(new FileInputStream(file));
			} catch (IOException e) {
				logger.error("文件流异常");
			}
		}
		return workbook;
	}
	
	private static Workbook getWorkbook(MultipartFile file){
		String fileName = file.getOriginalFilename();
		Workbook workbook = null;
		if(fileName.endsWith(XLS)){
			try {
				workbook = new HSSFWorkbook(file.getInputStream());
			} catch (IOException e) {
				logger.error("文件流异常");
			}
		}
		else if(fileName.endsWith(XLSX)){
			try {
				workbook = new XSSFWorkbook(file.getInputStream());
			} catch (IOException e) {
				logger.error("文件流异常");
			}
		}
		return workbook;
	}
	
	private static String getCell(Cell cell){
		String value = "";
		if(cell == null)
			return value;
		if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		switch (cell.getCellType()){
			case Cell.CELL_TYPE_STRING:
				value = StringUtils.trim(cell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_BLANK:
				value = "";
				break;
			case Cell.CELL_TYPE_FORMULA:
				value = String.valueOf(cell.getCellFormula());
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = String.valueOf(cell.getBooleanCellValue());
				break;
			default:
				value = "";
				break;
		}
		return value;
	}
	
	private static void checkFile(File file) throws Exception{
		if(null == file){
			logger.error("文件为空");
			throw new Exception("文件为空");
		}
		String fileName = file.getName();
		if(!fileName.endsWith(XLS) && !fileName.endsWith(XLSX)){
			logger.error("文件格式有误");
			throw new Exception("文件格式有误");
		}
	}
	
	private static void checkFile(MultipartFile file) throws Exception{
		if(null == file){
			logger.error("文件为空");
			throw new Exception("文件为空");
		}
		String fileName = file.getOriginalFilename();
		if(!fileName.endsWith(XLS) && !fileName.endsWith(XLSX)){
			logger.error("文件格式有误");
			throw new Exception("文件格式有误");
		}
	}
	
	public static void main(String[] args){
		File file = new File("/Users/idealife/zjq/1.xlsx");
		try {
			List<String[]> list = readExcel(file);
			for(String[] str : list){
				for(String s : str){
					System.out.println(s);
				}
			}
		} catch (Exception e) {
		}
	}
}
