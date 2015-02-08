package gulyas.myCalculator.myCalculator.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class CapacityItem {

	String locationCode;
	Date validityStart;
	Date validityEnd;
	String type;
	int quantityPerDay;
	int quantityPerHour;

	String locationType;
	double price;

	public CapacityItem(String locationCode, String validityStart,
			String validityEnd, String type, int quantityPerDay,
			int quantityPerHour) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
			Number priceNumber;

			this.locationCode = locationCode;
			this.validityStart = sdf.parse(validityStart);
			this.validityEnd = sdf.parse(validityEnd);
			this.type = type;
			this.quantityPerDay = quantityPerDay;
			this.quantityPerHour = quantityPerHour;

			this.locationType = getPropertiValue("points.properties",
					locationCode);
			priceNumber = format.parse(getPropertiValue("cost.properties",
					locationType));
			this.price = priceNumber.doubleValue();

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getValidityStart() {
		return validityStart;
	}

	public void setValidityStart(Date validityStart) {
		this.validityStart = validityStart;
	}

	public Date getValidityEnd() {
		return validityEnd;
	}

	public void setValidityEnd(Date validityEnd) {
		this.validityEnd = validityEnd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantityPerDay() {
		return quantityPerDay;
	}

	public void setQuantityPerDay(int quantityPerDay) {
		this.quantityPerDay = quantityPerDay;
	}

	public int getQuantityPerHour() {
		return quantityPerHour;
	}

	public void setQuantityPerHour(int quantityPerHour) {
		this.quantityPerHour = quantityPerHour;
	}

	public String getLocationType() {
		return this.locationType;
	}

	public double getPrice() {
		return this.price;
	}

	public double getTypePrecent() {
		double typePrecent = 0;
		if (type.equals("M0")) {
			typePrecent = 1;
		} else if (type.equals("M10")) {
			typePrecent = 0.5;
		}
		return typePrecent;
	}

	private double getQuantity() {
		if (locationType.equals("Hazai kilépési")) {
			return getQuantityPerHour();
		}
		return getQuantityPerDay();
	}

	public double getSeasonalPrecent() {
		double seasonalPrecent = 0;
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(validityStart);
		int startMonth = calendarStart.get(Calendar.MONTH) + 1;

		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.setTime(validityEnd);
		int endMonth = calendarStart.get(Calendar.MONTH) + 1;

		if ((startMonth == 12 || startMonth == 1 || startMonth == 2 || startMonth == 3)
				&& (endMonth == 12 || startMonth == 1 || startMonth == 2 || startMonth == 3)) {
			seasonalPrecent = 0.9;
		} else {
			seasonalPrecent = 0.2;
		}
		return seasonalPrecent;
	}

	public double getItemFee() {
		
		double fee = getPrice() * getSeasonalPrecent() * getTypePrecent()
				* getQuantity();		
		return Math.round(fee*10.0)/10.;
	}

	private String getPropertiValue(String propName, String key) {
		try {
			File file = new File(propName);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			return properties.getProperty(key);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "ERROR";
		} catch (IOException e) {
			e.printStackTrace();
			return "ERROR";
		}

	}

	@Override
	public String toString() {
		return "CapacityItem [locationCode=" + locationCode
				+ ", validityStart=" + validityStart + ", validityEnd="
				+ validityEnd + ", type=" + type + ", quantityPerDay="
				+ quantityPerDay + ", quantityPerHour=" + quantityPerHour
				+ ", locationType=" + locationType + ", price=" + price + "]";
	}

}
