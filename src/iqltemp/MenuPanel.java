package iqltemp;

import com.antennasoftware.api.ui.AbsoluteSize;
import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.LineStyle;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.collections.ObjectArray;
import com.antennasoftware.api.ui.component.Cell;
import com.antennasoftware.api.ui.component.Footer;
import com.antennasoftware.api.ui.component.Header;
import com.antennasoftware.api.ui.control.CellConfig;
import com.antennasoftware.api.ui.control.CellType;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.control.StickyTable;
import com.antennasoftware.api.ui.control.TableView;
import com.antennasoftware.api.ui.control.TableViewActionListener;
import com.antennasoftware.api.ui.control.TableViewCellCreateInfo;
import com.antennasoftware.api.ui.control.TableViewPanelCreateInfo;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.panel.TableViewCell;
import com.antennasoftware.api.ui.panel.TableViewPanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class MenuPanel extends TablePanel implements ContainerListener, TableViewActionListener {	
	
	private StickyTable stkTable;
	private ObjectArray dataSources;	
	private int selectedRow;
	
	public static final int COMPANY_MENU_OVERVIEW = 0;
	public static final int COMPANY_MENU_OWNERSHIP = 1;
	public static final int COMPANY_MENU_PROFESSIONALS = 2;
	public static final int COMPANY_MENU_DEVELOPMENTS = 3;
	public static final int COMPANY_MENU_NEWS = 4;
	public static final int COMPANY_MENU_QUICKCOMPS = 5;
	public static final int COMPANY_MENU_TRANSACTIONS = 6;
	public static final int COMPANY_MENU_RESEARCH = 7;
	public static final int COMPANY_MENU_FILINGS = 8;
	public static final int COMPANY_MENU_TRANSCRIPTS = 9;	
	
	public int orientation;
	
	public MainScreen screen;
	
	public MenuPanel() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
		this._I_TablePanel();
	}

	public void applyVisualStyle(Widget source, StyleReceptor style) {
		// TODO Auto-generated method stub

	}

	public void onActivate(Container source) {
		// TODO Auto-generated method stub

	}

	public void onClose(Container source) {
		// TODO Auto-generated method stub

	}

	public void onCreate(Container source) {
		// TODO Auto-generated method stub
		
		dataSources = new ObjectArray();
		dataSources.add("Overview");
		dataSources.add("Ownership");
		dataSources.add("Professionals");
		dataSources.add("Developments");
		dataSources.add("News");
		dataSources.add("Quick Comps");
		dataSources.add("Transactions");
		dataSources.add("Research");
		dataSources.add("Filings");
		dataSources.add("Transcripts");
		
		setBackColor(Colors.DarkGray);
		setColumnWidth(0, Sizing.PIXELS, 143);
		
		stkTable = new StickyTable();
		stkTable.setBackColor(Color.create(68, 68, 68));
		stkTable.setGridLineStyle(LineStyle.NONE);
		stkTable.addListener(this);
		stkTable.setNumberOfGroups(1);
		stkTable.setNumberOfCellsInGroup(0,dataSources.size());
		
		add(stkTable, "hfill=fill, vfill=fill");

		//stkTable.refresh();
	}

	public void onDeactivate(Container source) {
		// TODO Auto-generated method stub

	}

	public void onOpen(Container source) {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		this.removeListener(this);
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	public void setOrientation(int orientation){
		switch( orientation ){
		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
			setColumnWidth(0, Sizing.PIXELS, 143);
			break;
		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
			setColumnWidth(0, Sizing.PIXELS, 167);
			break;
		}
	}


	public void onAccessory(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	
	public void onCellConfigure(TableView c, CellConfig cell, int group) {
		// TODO Auto-generated method stub
		cell.setHeight(Sizing.PIXELS, 48);
		cell.setWidth(Sizing.PREFERRED, 1);
		cell.setCouldBeSelected(true);
	}

	public void onCellCreateInfo(TableView c, TableViewCellCreateInfo info,
			int group, int row) {
		// TODO Auto-generated method stub
		info.setPanel(new MenuTableViewCell());
	}

	public void onCellInfo(TableView c, TableViewCell cell, Cell info,
			int group, int row) {
		// TODO Auto-generated method stub
		MenuTableViewCell tableViewCell = (MenuTableViewCell) cell;
		tableViewCell.populateData((String)dataSources.getItem(row),(row==selectedRow));
			
		tableViewCell.refresh();
	}	

	public void onCellSize(TableView c, AbsoluteSize sizeInfo, int group,
			int row) {
		// TODO Auto-generated method stub
		sizeInfo.setHeight(48);
	}

	public void onCellType(TableView c, CellType type, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onEditAction(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onEditEnd(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onEditStart(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onEnterKey(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		onSelection(group,row);		
	}

	public void onFooterConfigure(TableView c, CellConfig cell, int group) {
		// TODO Auto-generated method stub
		
	}

	public void onFooterCreateInfo(TableView c, TableViewPanelCreateInfo info,
			int group) {
		// TODO Auto-generated method stub
		
	}

	public void onFooterEnterKey(TableView c, int group) {
		// TODO Auto-generated method stub
		
	}

	public void onFooterInfo(TableView c, TableViewPanel cell, Footer info,
			int group) {
		// TODO Auto-generated method stub
		
	}

	public void onHeaderConfigure(TableView c, CellConfig cell, int group) {
		// TODO Auto-generated method stub
		
	}

	public void onHeaderCreateInfo(TableView c, TableViewPanelCreateInfo info,
			int group) {
		// TODO Auto-generated method stub
		
	}

	public void onHeaderEnterKey(TableView c, int group) {
		// TODO Auto-generated method stub
		
	}

	public void onHeaderInfo(TableView c, TableViewPanel cell, Header info,
			int group) {
		// TODO Auto-generated method stub
		
	}

	public void onMove(TableView c, int group, int row, int toGroup, int toRow) {
		// TODO Auto-generated method stub
		
	}

	public void onSelectionChanged(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onSelection(int group, int row){
		selectedRow=row;
		stkTable.refresh();
		
		switch (row) {
		case COMPANY_MENU_OVERVIEW:
			screen.contentPanel.switchPanel(ContentPanel.CONTENTPANELTYPE_OVERVIEW);
			break;
		case COMPANY_MENU_TRANSACTIONS:
			screen.contentPanel.switchPanel(ContentPanel.CONTENTPANELTYPE_TRANSACTIONS);
			break;			
		default:
			break;
		}
	}

	public void onClick(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusGained(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusLost(Control c) {
		// TODO Auto-generated method stub
		
	}	


}
