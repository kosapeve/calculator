package gulyas.myCalculator.myCalculator;

import java.util.ArrayList;
import java.util.List;

import gulyas.myCalculator.myCalculator.entity.CapacityItem;
import gulyas.myCalculator.myCalculator.entity.GasStation;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {        
        CsvParser csvp= new CsvParser();
        List<CapacityItem> capacityItems= new ArrayList<CapacityItem>();
        List<String[]> records =csvp.parse("test_data.csv");
        List<String> pointNames= new ArrayList<String>();
        List<GasStation> gasStations = new ArrayList<GasStation>();
        double sum=0;
        
        //Parse CSV
        for (String[] record : records) {
			CapacityItem item= new CapacityItem(record[0], record[1], 
					record[2], record[3], Integer.parseInt(record[4]), 
					Integer.parseInt(record[5]));
			if(!pointNames.contains(record[0])){
			pointNames.add(record[0]);	
			}			
			capacityItems.add(item);					
		}
        
        // Create Points
        for (String stationCode : pointNames) {
			gasStations.add(new GasStation(stationCode));
		}
        
        // Pair station and item
        for (CapacityItem item : capacityItems) {
			for (GasStation gasStation : gasStations) {
				if(gasStation.getStationCode().equals(item.getLocationCode())){
					gasStation.addItem(item);
				}
			}
		}
        
        //Output        
        for (GasStation gasStation : gasStations) {
        	double fee=gasStation.getFee();
        	sum+=fee;
			System.out.println("Pont:"+gasStation.getStationCode()
					+"; Összeg:"+fee);
		}
        System.out.println("Összesen:"+sum);
    
        
    }
    
   
}
