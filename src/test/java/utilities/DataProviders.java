package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String path=".//Testdata//opencartTestData.xlsx";//taking xlfile from testdata
		ExcelUtility xlutil=new ExcelUtility(path);//creating object xlutility.
		int totalrow=xlutil.getRowCount("Sheet1");
		int totalcol=xlutil.getCellCount("Sheet1", 1);

		String logindata[][]= new String[totalrow][totalcol];

		for(int i=1;i<=totalrow;i++) {
			for(int j=0;j<totalcol;j++) {

				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}	

		}
		
		return logindata; //returning 2d array
	}
}
