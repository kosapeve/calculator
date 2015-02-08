package gulyas.myCalculator.myCalculator;

import java.util.List;

import gulyas.myCalculator.myCalculator.entity.CapacityItem;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        CsvParser csvp= new CsvParser();
        List<String[]> records =csvp.parse("asd.csv");
        for (String[] record : records) {
			
		}
        
        CapacityItem capacityItem= new CapacityItem("KAABA00011GN", 
        	"2012-12-01", "2012-12-31", "M10", 100000, 5000);
        
        CapacityItem capacityItem2= new CapacityItem("KAABA00011GN", 
            	"2012-05-01", "2012-05-31", "M10", 100000, 5000);
        
        CapacityItem capacityItem3= new CapacityItem("GEDRAVAS1IIN", 
            	"2012-05-01", "2012-05-31", "M10", 100000, 5000);
        
        System.out.println(capacityItem.getItemFee());
        System.out.println(capacityItem2.getItemFee());
        System.out.println(capacityItem3.getItemFee());
        
    }
    
   
}
