package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenericUtility {

	public static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	public XSSFSheet sh;

	public void ExcelUtility() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\user\\workspace\\qabibile-test\\src\\main\\resources\\utilities\\details.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		sh = book.getSheet("Sheet1");
	}

	public String readData(int i, int j) {
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		CellType celltype = c.getCellType();
		switch (celltype) {
		case NUMERIC: {
			double a = c.getNumericCellValue();
			return String.valueOf(a);
		}
		case STRING: {
			return c.getStringCellValue();
		}

		}
		return null;

	}

}
