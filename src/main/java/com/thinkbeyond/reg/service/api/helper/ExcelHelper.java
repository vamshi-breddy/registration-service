package com.thinkbeyond.reg.service.api.helper;

import com.thinkbeyond.reg.service.api.constants.UserConstants;
import com.thinkbeyond.reg.service.api.entity.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    
    public static boolean checkExcelFormat(MultipartFile file){

        String contentType = file.getContentType();

        if (contentType.equals(UserConstants.CONTENT_TYPE)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static List<User> convertExcelToList(InputStream inputStream){
        List<User> list = new ArrayList<>();

        try {
              XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheetAt = workbook.getSheetAt(0);
            int rowNumber = 0;
            Iterator<Row> iterator = sheetAt.iterator();
            while(iterator.hasNext()){
                Row row = iterator.next();
                if(rowNumber == 0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid = 0;

                User user = new User();
                while (cells.hasNext()){
                    Cell cell = cells.next();

                    switch (cid)
                    {
                        case 0 :
                            user.setId((int)cell.getNumericCellValue());
                            break;
                        case 1:
                            user.setName(cell.getStringCellValue());
                            break;
                        case 2 :
                            user.setEmail((cell.getStringCellValue()));
                            break;
                        case 3 :
                            user.setExperience((int) cell.getNumericCellValue());
                            break;
                        case 4 :
                            user.setDomains(cell.getStringCellValue());
                            break;
                        default :
                            break;
                    }
                    cid++;

                }
                list.add(user);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
