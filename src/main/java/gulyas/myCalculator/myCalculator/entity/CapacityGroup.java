package gulyas.myCalculator.myCalculator.entity;

import java.util.ArrayList;
import java.util.List;

public class CapacityGroup {

	public CapacityGroup(String identifier) {

		this.identifier = identifier;
		this.items = new ArrayList<CapacityItem>();

	}

	String identifier;
	List<CapacityItem> items;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<CapacityItem> getItems() {
		return items;
	}

	public void setItems(List<CapacityItem> items) {
		this.items = items;
	}

	public void addItem(CapacityItem capacityItem) {
		items.add(capacityItem);
	}

	public double getFee() {
		double sum = 0;
		for (CapacityItem capacityItem : items) {
			sum += capacityItem.getItemFee();
		}
		return sum;
	}

	@Override
	public String toString() {
		return "CapacityGroup [identifier=" + identifier + ", items=" + items
				+ "]";
	}

}
