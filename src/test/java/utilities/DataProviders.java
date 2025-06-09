package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;



public class DataProviders {

    @DataProvider(name = "LoginData")
	public String [] [] getData() throws IOException{
	
		String path = ".\\testData\\Login_openCart.xlsx";
		
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalRow = xlutil.getRowCount("Sheet1");
		int totalCols = xlutil.getCellCount("Sheet1", 1);
		
		
	    String loginData [] [] = new String [totalRow] [totalCols] ;
	
	    for(int i=1;i<totalRow;i++) {
	    	
	    	for(int j=0;j<totalCols;j++) {
	    	
	    		loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);
	    	}
	    	
	    }
	        
	    
		return loginData;}

}
