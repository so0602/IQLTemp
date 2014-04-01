package iqltemp.models;

import com.antennasoftware.api.ui.collections.ObjectMap;

public final class Transaction {
	public String date;
	public String type;
	public String buyers;
	public String securites;
	public String target;
	public String size;
	
	public static final String TRANSACTION_DATE = "Date";
	public static final String TRANSACTION_TYPE = "Type";
	public static final String TRANSACTION_BUYERS = "Buyers";
	public static final String TRANSACTION_SECURITES = "Securites";
	public static final String TRANSACTION_TARGET = "Target";
	public static final String TRANSACTION_SIZE = "Size";
	
	public Transaction(){
		super();
	}
	
	public Transaction(ObjectMap map){
		super();
		
		date = (String)map.getValue(TRANSACTION_DATE);
		type = (String)map.getValue(TRANSACTION_TYPE);
		buyers = (String)map.getValue(TRANSACTION_BUYERS);
		securites = (String)map.getValue(TRANSACTION_SECURITES);
		target = (String)map.getValue(TRANSACTION_TARGET);
		size = (String)map.getValue(TRANSACTION_SIZE);
	}
	
	public Transaction randomTransaction(){
		Transaction transaction = new Transaction();
		transaction.date = "Mar 11 2013";
		transaction.type = "Placement";
		transaction.buyers = "Epsilen, LLC";
		transaction.securites = "Class A Common Stock";
		transaction.target = "John Wile & Sans Inc";
		transaction.size = "300.00";
		
		return transaction;
	}
}
