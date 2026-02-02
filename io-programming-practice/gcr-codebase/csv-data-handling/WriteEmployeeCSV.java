
import java.io.*;

public class WriteEmployeeCSV{
	
    public static void main(String[] args){
    
    	String filePath="src/CSVDataHandling/employees.csv";
    	
        try (FileWriter writer=new FileWriter(filePath)){
        	
            writer.append("ID,Name,Department,Salary\n");
            
            writer.append("201,Sarthak,IT,60000\n");
            writer.append("202,Sanjh,HR,80000\n");
            writer.append("203,Shivendra,Finance,55000\n");
            writer.append("204,Pragati,Marketing,52000\n");
            writer.append("205,Shivam,Sales,50000\n");
            System.out.println("CSV file written successfully");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
