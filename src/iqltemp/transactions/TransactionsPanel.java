package iqltemp.transactions;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.Utilities.Utilities;
import iqltemp.listeners.OnSelectedListener;
import iqltemp.models.Transaction;

import com.antennasoftware.api.ui.AbsoluteSize;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.collections.ObjectArray;
import com.antennasoftware.api.ui.collections.ObjectMap;
import com.antennasoftware.api.ui.component.Cell;
import com.antennasoftware.api.ui.component.Footer;
import com.antennasoftware.api.ui.component.Header;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.CellConfig;
import com.antennasoftware.api.ui.control.CellType;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.control.StickyTable;
import com.antennasoftware.api.ui.control.TableView;
import com.antennasoftware.api.ui.control.TableViewActionListener;
import com.antennasoftware.api.ui.control.TableViewCellCreateInfo;
import com.antennasoftware.api.ui.control.TableViewPanelCreateInfo;
import com.antennasoftware.api.ui.panel.StackPanel;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.panel.TableViewCell;
import com.antennasoftware.api.ui.panel.TableViewPanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class TransactionsPanel extends TablePanel implements ContainerListener, TableViewActionListener {
	private IqltempApplication application;
	private DefaultStyle style;
	
	private Label titleLabel;
	private Button switchButton;
	private Button filterByButton;
	
	private StackPanel stackPanel;
	private TablePanel listPanel;
	private TablePanel listTitlePanel;
	private StickyTable listTable;
	
	private TablePanel gridPanel;
	
	private ObjectArray dataSources;
	private ObjectArray onSelectedListeners;
	
	public static final int TITLE_PANEL_HEIGHT = 44;
	public static final int LIST_HEADER_PANEL_HEIGHT = 38;
	public static final int LIST_HEADER_PANEL_PORTRAIT_START_SEPARATOR_WIDTH = 13;
	public static final int LIST_HEADER_PANEL_PORTRAIT_DATE_WIDTH = 92;
	public static final int LIST_HEADER_PANEL_PORTRAIT_TYPE_WIDTH = 108;
	public static final int LIST_HEADER_PANEL_PORTRAIT_BUYERS_WIDTH = 237;
	public static final int LIST_HEADER_PANEL_PORTRAIT_SECURITIES_WIDTH = 162;
	public static final int LIST_HEADER_PANEL_PORTRAIT_END_SEPARATOR_WIDTH = 13;
	public static final int LIST_HEADER_PANEL_LANDSCAPE_START_SEPARATOR_WIDTH = 13;
	public static final int LIST_HEADER_PANEL_LANDSCAPE_DATE_WIDTH = 100;
	public static final int LIST_HEADER_PANEL_LANDSCAPE_TYPE_WIDTH = 180;
	public static final int LIST_HEADER_PANEL_LANDSCAPE_BUYERS_WIDTH = 320;
	public static final int LIST_HEADER_PANEL_LANDSCAPE_SECURITIES_WIDTH = 231;
	public static final int LIST_HEADER_PANEL_LANDSCAPE_END_SEPARATOR_WIDTH = 13;
	
	public int orientation;
	
	public TransactionsPanel() {
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
		onSelectedListeners = new ObjectArray();
		
		application = (IqltempApplication)getApplication();
		style = application.getStyle();
		
		dataSources = new ObjectArray();
		
		for( int i = 0; i < 3; i++ ){
			ObjectMap map = new ObjectMap();
			String title = null;
			switch( i ){
			case 0:
				title = "LATEST";
				break;
			case 1:
				title = "THIS WEEK";
				break;
			case 2:
				title = "LAST WEEK";
				break;
			}
			map.putValue("Title", title);
			
			ObjectArray array = new ObjectArray();
			for( int j = 0; j < 5; j++ ){
				ObjectMap _map = new ObjectMap();
				_map.putValue(Transaction.TRANSACTION_DATE, "Mar 11-2013");
				_map.putValue(Transaction.TRANSACTION_TYPE, "Placement");
				_map.putValue(Transaction.TRANSACTION_BUYERS, "Epsilen, LLC");
				_map.putValue(Transaction.TRANSACTION_TARGET, "John Wile & Sans Inc");
				_map.putValue(Transaction.TRANSACTION_SECURITES, "Class A Common Stock");
				_map.putValue(Transaction.TRANSACTION_SIZE, "300.00");
				
				Transaction transaction = new Transaction(_map);
				array.add(transaction);
			}
			map.putValue("Array", array);
			dataSources.add(map);
		}
		
		setRowHeight(0, Sizing.PIXELS, TITLE_PANEL_HEIGHT);
		setRowHeight(1, Sizing.PREFERRED, 1);
		setColumnWidth(0, Sizing.PREFERRED, 1);
		
		TablePanel titlePanel = new TablePanel();
		{
			titlePanel.setBackColor(Colors.LightGray);
			titlePanel.setRowHeight(0, Sizing.PIXELS, TITLE_PANEL_HEIGHT);
			titlePanel.setColumnWidth(0, Sizing.PIXELS, 10);
			titlePanel.setColumnWidth(2, Sizing.PREFERRED, 1);
			titlePanel.setColumnWidth(4, Sizing.PIXELS, 10);
			titlePanel.setColumnWidth(6, Sizing.PIXELS, 10);
			
			titlePanel.add(new Separator()); //column 0
			
			titleLabel = new Label();
			titleLabel.setText("TRANSACTIONS");
			titleLabel.setFont(style.transactionsTitleFont);
			titlePanel.add(titleLabel, "hfill=fill, vfill=fill");  //column 1
			
			titlePanel.add(new Separator()); //column 2
			
			switchButton = new Button();
			switchButton.setText("Filter");
			switchButton.addListener(this);
			titlePanel.add(switchButton); //column 3
			
			titlePanel.add(new Separator()); //column 4
			
			filterByButton = new Button();
			filterByButton.setText("FILTER BY");
			titlePanel.add(filterByButton); //column 5
			
			titlePanel.add(new Separator()); //column 6
		}
		add(titlePanel, "hfill=fill, vfill=fill");
		startNewRow();
		
		stackPanel = new StackPanel();
		stackPanel.setBackColor(Colors.DarkBlue);
		{
			{
				listPanel = new TablePanel();
				{
					listPanel.setRowHeight(0, Sizing.PIXELS, LIST_HEADER_PANEL_HEIGHT);
					listPanel.setBackColor(Colors.White);
					
					listTitlePanel = new TablePanel();
					this.setOrientation(this.orientation);
					
					listTitlePanel.add(new Separator()); //column 0
					
					Label dateLabel = new Label();
					dateLabel.setText("DATE");
					dateLabel.setFont(style.transactionsListTitleFont);
					listTitlePanel.add(dateLabel); //column 1
					
					Label typeLabel = new Label();
					typeLabel.setText("TYPE");
					typeLabel.setFont(style.transactionsListTitleFont);
					listTitlePanel.add(typeLabel); //column 2
					
					Label buyersLabel = new Label();
					buyersLabel.setText("BUYERS/\nTARGET");
					buyersLabel.setFont(style.transactionsListTitleFont);
					listTitlePanel.add(buyersLabel); //column 3
					
					Label securitiesLabel = new Label();
					securitiesLabel.setText("SECURITIES/\nSIZE($MM)");
					securitiesLabel.setFont(style.transactionsListTitleFont);
					listTitlePanel.add(securitiesLabel); //column 4
					
					listTitlePanel.add(new Separator()); //column 5
					listPanel.add(listTitlePanel);
					listPanel.startNewRow();
					
					listTable = new StickyTable();
					listTable.addListener(this);
					listTable.setNumberOfGroups(dataSources.size());
					for( int i = 0; i < dataSources.size(); i++ ){
						ObjectMap map = (ObjectMap)dataSources.getItem(i);
						ObjectArray array = (ObjectArray)map.getValue("Array");
						listTable.setNumberOfCellsInGroup(i, array.size());
					}
					listPanel.add(listTable, "hfill=fill, vfill=fill");
					
				}
				stackPanel.add(listPanel);
			}
			{
				gridPanel = new TablePanel();
				stackPanel.add(gridPanel);
			}
			stackPanel.select(listPanel);
		}
		
		add(stackPanel, "hfill=fill, vfill=fill");
		startNewRow();
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
		this.orientation = orientation;
		switch( orientation ){
		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
			listTitlePanel.setColumnWidth(0, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_START_SEPARATOR_WIDTH);
			listTitlePanel.setColumnWidth(1, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_DATE_WIDTH);
			listTitlePanel.setColumnWidth(2, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_TYPE_WIDTH);
			listTitlePanel.setColumnWidth(3, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_BUYERS_WIDTH);
			listTitlePanel.setColumnWidth(4, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_SECURITIES_WIDTH);
			listTitlePanel.setColumnWidth(5, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_END_SEPARATOR_WIDTH);
			break;
		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
			listTitlePanel.setColumnWidth(0, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_START_SEPARATOR_WIDTH);
			listTitlePanel.setColumnWidth(1, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_DATE_WIDTH);
			listTitlePanel.setColumnWidth(2, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_TYPE_WIDTH);
			listTitlePanel.setColumnWidth(3, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_BUYERS_WIDTH);
			listTitlePanel.setColumnWidth(4, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_SECURITIES_WIDTH);
			listTitlePanel.setColumnWidth(5, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_END_SEPARATOR_WIDTH);
			break;
		}
		listTable.refresh();
	}

	public void onClick(Control c) {
		// TODO Auto-generated method stub
		if( this.switchButton.equals(c) ){
			if( this.switchButton.getText().equals("Filter") ){
				stackPanel.select(gridPanel);
				this.switchButton.setText("Grid");
			}else{
				stackPanel.select(listPanel);
				this.switchButton.setText("Filter");
			}
		}
	}

	public void onFocusGained(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusLost(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onAccessory(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onCellConfigure(TableView c, CellConfig cell, int group) {
		// TODO Auto-generated method stub
		cell.setHeight(Sizing.PREFERRED, 0);
		cell.setWidth(Sizing.PREFERRED, 0);
		cell.setCouldBeSelected(true);
	}

	public void onCellCreateInfo(TableView c, TableViewCellCreateInfo info,
			int group, int row) {
		// TODO Auto-generated method stub
		if( c.equals(this.listTable) ){
			info.setPanel(new TransactionsListTableViewCell());
		}
	}

	public void onCellInfo(TableView c, TableViewCell _cell, Cell info,
			int group, int row) {
		// TODO Auto-generated method stub
		if( c.equals(this.listTable) ){
			ObjectMap map = (ObjectMap)this.dataSources.getItem(group);
			ObjectArray array = (ObjectArray)map.getValue("Array");
			Transaction transaction = (Transaction)array.getItem(row);
			
			TransactionsListTableViewCell cell = (TransactionsListTableViewCell)_cell;
			cell.setOrientation(this.orientation);
			cell.populateData(transaction);
			cell.refresh();
		}
	}

	public void onCellSize(TableView c, AbsoluteSize sizeInfo, int group,
			int row) {
		// TODO Auto-generated method stub
		if( c.equals(this.listTable) ){
			sizeInfo.setSize(1000, 67);
		}
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
		if( c.equals(this.listTable) && this.onSelectedListeners != null ){
			ObjectMap map = (ObjectMap)this.dataSources.getItem(group);
			ObjectArray array = (ObjectArray)map.getValue("Array");
			Transaction transaction = (Transaction)array.getItem(row);
			for( int i = 0; i < onSelectedListeners.size(); i++ ){
				OnSelectedListener onSelectedListener = (OnSelectedListener)onSelectedListeners.getItem(i);
				onSelectedListener.onSelected(transaction);
			}
		}
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
		cell.setHeight(Sizing.PIXELS, 26);
		cell.setWidth(Sizing.PERCENTS, 100);
	}

	public void onHeaderCreateInfo(TableView c, TableViewPanelCreateInfo info,
			int group) {
		// TODO Auto-generated method stub
		if( c.equals(this.listTable) ){
			info.setPanel(new TransactionsListTableHeader());
		}
	}

	public void onHeaderEnterKey(TableView c, int group) {
		// TODO Auto-generated method stub
		
	}

	public void onHeaderInfo(TableView c, TableViewPanel cell, Header info,
			int group) {
		// TODO Auto-generated method stub
		if( c.equals(this.listTable) ){
			ObjectMap _map = (ObjectMap)this.dataSources.getItem(group);
			String title = (String)_map.getValue("Title");
			
			TransactionsListTableHeader header = (TransactionsListTableHeader)cell;
			header.setTitle(title);
			header.refresh();
		}
	}

	public void onMove(TableView c, int group, int row, int toGroup, int toRow) {
		// TODO Auto-generated method stub
		
	}

	public void onSelectionChanged(TableView c, int group, int row) {
		// TODO Auto-generated method stub		
	}
	
	public boolean addOnSelectedListener(OnSelectedListener onSelectedListener){
		return Utilities.addObject(onSelectedListeners, onSelectedListener);
	}
	
	public void removeOnSelectedListener(OnSelectedListener onSelectedListener){
		Utilities.removeObject(onSelectedListeners, onSelectedListener);
	}
}
