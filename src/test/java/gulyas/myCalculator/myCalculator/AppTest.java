package gulyas.myCalculator.myCalculator;

import gulyas.myCalculator.myCalculator.entity.CapacityGroup;
import gulyas.myCalculator.myCalculator.entity.CapacityItem;
import junit.framework.TestCase;

public class AppTest extends TestCase {
	public void testApp() {
		
		// 70.99 * 0.9 * 0.5 * 5000 = 159727.5
		CapacityItem capacityItem1 = new CapacityItem("KAABA00011GN",
				"2012-12-01", "2012-12-31", "M10", 100000, 5000);

		// 12.83 * 0.2 * 0.5 * 100000= 128300.0
		CapacityItem capacityItem2 = new CapacityItem("KEALGYO03ONN",
				"2012-05-01", "2012-05-31", "M10", 100000, 5000);

		// 21.38 * 0.2 * 1.0 * 100000 = 427600.0
		CapacityItem capacityItem3 = new CapacityItem("GEDRAVAS1IIN",
				"2012-05-01", "2012-05-31", "M0", 100000, 5000);
		// 19.24 * 0.2 * 1.0 * 100000 = 384800.0
		CapacityItem capacityItem4 = new CapacityItem("KETELJCS57EN",
				"2012-05-01", "2012-05-31", "M0", 100000, 5000);			

		assertEquals("Winter test", capacityItem1.getSeasonalPrecent(), 0.9);
		assertEquals("Other season test", capacityItem2.getSeasonalPrecent(),
				0.2);

		assertEquals("M10 test", capacityItem1.getTypePrecent(), 0.5);
		assertEquals("M0 test", capacityItem3.getTypePrecent(), 1.0);

		assertEquals("Location type test1", capacityItem1.getLocationType(),
				"Hazai kilépési");
		assertEquals("Location type test2", capacityItem2.getLocationType(),
				"Hazai tárolói belépési");
		assertEquals("Location type test3", capacityItem3.getLocationType(),
				"Külföldi belépési");
		assertEquals("Location type test4", capacityItem4.getLocationType(),
				"Hazai termelői belépési");

		assertEquals("Fee test1", capacityItem1.getItemFee(), 159727.5);
		assertEquals("Fee test2", capacityItem2.getItemFee(), 128300.0);
		assertEquals("Fee test3", capacityItem3.getItemFee(), 427600.0);
		assertEquals("Fee test4", capacityItem4.getItemFee(), 384800.0);

	}
}
