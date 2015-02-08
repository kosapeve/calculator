package gulyas.myCalculator.myCalculator;

import java.util.ArrayList;
import java.util.List;

import gulyas.myCalculator.myCalculator.entity.CapacityItem;
import gulyas.myCalculator.myCalculator.entity.CapacityGroup;

public class App {
	public static void main(String[] args) {
		CsvParser csvp = new CsvParser();
		List<CapacityItem> capacityItems = new ArrayList<CapacityItem>();
		List<String[]> records = csvp.parse("test_data.csv");
		List<String> pointNames = new ArrayList<String>();
		List<CapacityGroup> capacitiesByLocation = new ArrayList<CapacityGroup>();
		double pointSum = 0;

		List<String> types = new ArrayList<String>();
		List<CapacityGroup> capacitiesByType = new ArrayList<CapacityGroup>();

		// Parse CSV
		for (String[] record : records) {
			CapacityItem item = new CapacityItem(record[0], record[1],
					record[2], record[3], Integer.parseInt(record[4]),
					Integer.parseInt(record[5]));
			if (!pointNames.contains(record[0])) {
				pointNames.add(record[0]);
			}
			capacityItems.add(item);
		}

		// Create Points
		for (String stationCode : pointNames) {
			capacitiesByLocation.add(new CapacityGroup(stationCode));
		}

		// Pair station and item
		for (CapacityItem item : capacityItems) {
			for (CapacityGroup gasStation : capacitiesByLocation) {
				if (gasStation.getIdentifier().equals(item.getLocationCode())) {
					gasStation.addItem(item);
				}
			}
		}

		// Output-1
		System.out.println("------Alapfeladat------");
		for (CapacityGroup gasStation : capacitiesByLocation) {
			double fee = gasStation.getFee();
			pointSum += fee;
			System.out.println("Pont:" + gasStation.getIdentifier()
					+ "; Összeg:" + fee);
		}
		System.out.println("Összesen:" + pointSum);

		// Collect types
		for (CapacityItem capacityItem : capacityItems) {
			if (!types.contains(capacityItem.getType())) {
				types.add(capacityItem.getType());
			}
		}

		// Create Types
		for (String type : types) {
			capacitiesByType.add(new CapacityGroup(type));
		}

		// Pair type and item
		for (CapacityItem item : capacityItems) {
			for (CapacityGroup capacityGroup : capacitiesByType) {
				if (capacityGroup.getIdentifier().equals(item.getType())) {
					capacityGroup.addItem(item);
				}
			}
		}

		// Output-2
		System.out.println("--------1.Bónusz feladat-----------");
		for (CapacityGroup capacityGroup : capacitiesByType) {
			double fee = capacityGroup.getFee();
			System.out.println("Kapacitástípus:"
					+ capacityGroup.getIdentifier() + "; Összeg:" + fee);
		}
	}
}
