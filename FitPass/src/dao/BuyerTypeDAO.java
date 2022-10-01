package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import beans.user.BuyerType;

public class BuyerTypeDAO {
	private HashMap<Long, BuyerType> buyerTypes = new HashMap<Long, BuyerType>();
	private String contextPath;
	
	public BuyerTypeDAO() {}
	
	public BuyerTypeDAO(String contextPath) {
		this.contextPath = contextPath;
		
		loadBuyerTypes();
	}
	
	public HashMap<Long, BuyerType> getAllBuyerTypes() {
		return buyerTypes;
	}
	
	public BuyerType findById(long id) {
		for (BuyerType bType: buyerTypes.values()) {
			if (bType.getId() == id) {
				return bType;
			}
		}
		
		return null;
	}
	
	private void loadBuyerTypes() {
		BufferedReader reader = null;
		try {
			File buyerTypesFile = new File(contextPath + "/storage/buyerTypes.txt");
			reader = new BufferedReader(new FileReader(buyerTypesFile));
			
			String line;
			StringTokenizer stringTokenizer;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0) {
					continue;
				}
				
				stringTokenizer = new StringTokenizer(line, ";", true);
				while (stringTokenizer.hasMoreTokens()) {
					long id = 
							Long.parseLong(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					boolean logicallyDeleted = 
							Boolean.parseBoolean(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					String name = stringTokenizer.nextToken().trim();
					stringTokenizer.nextToken();
					int membershipFeeDiscount = 
							Integer.parseInt(stringTokenizer.nextToken().trim());
					stringTokenizer.nextToken();
					int requiredPoints = 
							Integer.parseInt(stringTokenizer.nextToken().trim());
					
					buyerTypes.put(id, new BuyerType(id, logicallyDeleted, name, 
							membershipFeeDiscount, requiredPoints));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void saveBuyerTypes() {
		BufferedWriter writer = null;
		try {
			File buyerTypesFile = new File(contextPath + "/storage/buyerTypes.txt");
			writer = new BufferedWriter(new FileWriter(buyerTypesFile));
			
			StringBuilder stringBuilder = new StringBuilder();
			for (BuyerType bType: buyerTypes.values()) {
				stringBuilder.append(bType).append("\n");
			}
			
			writer.write(stringBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
