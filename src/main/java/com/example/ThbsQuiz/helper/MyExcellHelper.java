package com.example.ThbsQuiz.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.ThbsQuiz.model.Questionss;

public class MyExcellHelper {
	//check if file is excel or not
	public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }
	
	public static List<Questionss> convertExcellToListofProduct(InputStream is){
		List<Questionss> List=new ArrayList<>();
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("data");
			int rowNumber =0;
			Iterator<Row> iterator = sheet.iterator();
			
			while(iterator.hasNext()) {
				Row row = iterator.next();
				if(rowNumber==0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();
				int cid=0;
				
				Questionss p = new Questionss();
				
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					switch(cid) {
					
					
				    case 6:
				        p.setQuestiontitle(cell.getStringCellValue());
				        break;
				    
				    case 2:
				        p.setOption1(cell.getStringCellValue());
				        break;
				    
				    case 3:
				        p.setOption2(cell.getStringCellValue());
				        break;
				    
				    case 4:
				        p.setOption3(cell.getStringCellValue());
				        break;
				    
				    case 5:
				        p.setOption4(cell.getStringCellValue());
				        break;
				    
				    case 7:
				        p.setRightAnswer(cell.getStringCellValue());
				        break;
				    
				    case 1:
				        p.setDifficultyLevel(cell.getStringCellValue());
				        break;
				    
				    case 0:
				        p.setCategory(cell.getStringCellValue());
				        break;
				    }
					cid++;
					
				}
				List.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return List;
		
		
	}
	
}