package gulyas.myCalculator.myCalculator.entity;

import java.util.ArrayList;
import java.util.List;

public class GasStation {		

	public GasStation(String stationCode) {
		
		this.stationCode = stationCode;
		this.items = new ArrayList<CapacityItem>();
		
	}

	String stationCode;
	List<CapacityItem> items;

	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public List<CapacityItem> getItems() {
		return items;
	}
	public void setItems(List<CapacityItem> items) {
		this.items = items;
	}
	
	public void addItem(CapacityItem capacityItem){
		items.add(capacityItem);
	}
	
	public double getFee(){
		double sum = 0;
		for (CapacityItem capacityItem : items) {
			sum+=capacityItem.getItemFee();			
		}
		return sum;
	}
	
	@Override
	public String toString() {
		return "GasStation [stationCode=" + stationCode + ", items=" + items
				+ "]";
	}
	
	

}
