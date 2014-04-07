package iqltemp.models;

import com.antennasoftware.api.ui.collections.ObjectMap;

public final class OverviewBusDesc {
	public String website;
	public String subsidaries;
	public String employees;
	public String incorporated;
	public String headquarters;
	public String inductry;
	public String description;
	
	public static final String OVERVIEWBUSDESC_WEBSITE = "website";
	public static final String OVERVIEWBUSDESC_SUBSIDIARIES = "subsidiaries";
	public static final String OVERVIEWBUSDESC_EMPLOYEES = "employees";
	public static final String OVERVIEWBUSDESC_INCORPORATED = "incorporated";
	public static final String OVERVIEWBUSDESC_HEADQUARTERS = "headquaters";
	public static final String OVERVIEWBUSDESC_INDUSTRY = "industry";
	public static final String OVERVIEWBUSDESC_DESCRIPTION = "description";
	
	public OverviewBusDesc(){
		super();
	}
	
	public OverviewBusDesc(ObjectMap map){
		super();
		
		website = (String)map.getValue(OVERVIEWBUSDESC_WEBSITE);
		subsidaries = (String)map.getValue(OVERVIEWBUSDESC_SUBSIDIARIES);
		employees = (String)map.getValue(OVERVIEWBUSDESC_EMPLOYEES);
		incorporated = (String)map.getValue(OVERVIEWBUSDESC_INCORPORATED);
		headquarters = (String)map.getValue(OVERVIEWBUSDESC_HEADQUARTERS);
		inductry = (String)map.getValue(OVERVIEWBUSDESC_INDUSTRY);
		description = (String)map.getValue(OVERVIEWBUSDESC_DESCRIPTION);
	}
	
	public OverviewBusDesc randomOverviewBusDesc(){
		OverviewBusDesc overviewBusDesc = new OverviewBusDesc();
		
		overviewBusDesc.website = "www,apple.com";
		overviewBusDesc.subsidaries = "214";
		overviewBusDesc.employees = "97,389";
		overviewBusDesc.incorporated = "1999";
		overviewBusDesc.headquarters = "111 Street, New York USA";
		overviewBusDesc.inductry = "Computer Hardware";
		overviewBusDesc.description = "Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Its products and services include iPhone, a handheld product that combines a mobile phone, an iPod, and an Internet communications device; iPad, a multi-purpose mobile device; desktop computers, such as iMac, Mac Pro, and Mac mini; portable computers, including MacBook Pro and MacBook Air; a line of iPod portable digital music and media players; and iCloud, and a cloud service. The company also offers a range of software products, including iOS and OS X operating system software consisting of Final Cut Pro, Logic Stuio, Logic Pro, and its FileMaker Pro database software. It also manufactures the Apple LED Cinema Display and Thunderbolt Display; sells a variety of Apple-branded";
		
		return overviewBusDesc;
	}
}
