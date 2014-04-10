package iqltemp.watchlist;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.Reusable.UIControl.SegmentPanel;
import iqltemp.listeners.OnSegmentSelectedListener;

import com.antennasoftware.api.ui.AbsoluteSize;
import com.antennasoftware.api.ui.Background;
import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.HorizontalAlignmentType;
import com.antennasoftware.api.ui.LineStyle;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.TextClearMode;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.collections.ObjectArray;
import com.antennasoftware.api.ui.component.Cell;
import com.antennasoftware.api.ui.component.Footer;
import com.antennasoftware.api.ui.component.Header;
import com.antennasoftware.api.ui.control.BackgroundButton;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.CellConfig;
import com.antennasoftware.api.ui.control.CellType;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.control.StickyTable;
import com.antennasoftware.api.ui.control.TableView;
import com.antennasoftware.api.ui.control.TableViewActionListener;
import com.antennasoftware.api.ui.control.TableViewCellCreateInfo;
import com.antennasoftware.api.ui.control.TableViewPanelCreateInfo;
import com.antennasoftware.api.ui.control.TextField;
import com.antennasoftware.api.ui.panel.Panel;
import com.antennasoftware.api.ui.panel.StackPanel;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.panel.TableViewCell;
import com.antennasoftware.api.ui.panel.TableViewPanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.core.foundation.data.datasource.ext.DataSource;
import com.antennasoftware.core.ui.control.ControlActionListener;

public class AddToWatchlistPanel extends TablePanel implements
		ContainerListener, ControlActionListener, TableViewActionListener {

	private IqltempApplication application = (IqltempApplication)getApplication();
	private DefaultStyle style = application.getStyle();
	
	private TablePanel topPanel;
	private TablePanel segmentPanel;
	private StackPanel stacktPanel;	
	private TextField textField;
	private BackgroundButton addButton;
	private BackgroundButton editButton;
	private BackgroundButton myWatchlistButton;
	private BackgroundButton sharedWatchlistButton;
	private TablePanel myWatchlistPanel;
	private StickyTable myWatchlistTable;
	private TablePanel sharedWatchlistPanel;	
	private StickyTable sharedWatchlistTable;

	private ObjectArray segmentObjectArray = new ObjectArray();
	private ObjectArray myWatchlistDataSources;
	private ObjectArray sharedWatchlistDataSources;

	
	public AddToWatchlistPanel() {
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
		setBackColor(Color.create(81, 81, 81));
		
		// 3 columns | 3 rows
		setColumnWidth(0, Sizing.PIXELS, 12);
		setColumnWidth(1, Sizing.PIXELS, 309);
		setColumnWidth(2, Sizing.PIXELS, 12);
		setRowHeight(0, Sizing.PIXELS, 43);
		setRowHeight(1, Sizing.PIXELS, 1);
		setRowHeight(2, Sizing.PIXELS, 39);
		setRowHeight(3, Sizing.PIXELS, 1);
		setRowHeight(4, Sizing.PREFERRED, 1);
	
		// Column 1
		add(new Separator(), "hfill=fill");					
		add(topPanel(), "hfill=fill,vfill=fill,colspan=2");		
		startNewRow();
		
		// Column 2
		Separator separator = new Separator();
		separator.setBackColor(Color.create(59, 59, 59));
		add(separator, "hfill=fill,colspan=3");
		startNewRow();
		
		// Column 3	
		add(segmentPanel(), "hfill=fill,vfill=fill,colspan=3");
		startNewRow();
		
		// Column 4
		separator = new Separator();
		separator.setBackColor(Color.create(59, 59, 59));
		add(separator, "hfill=fill,colspan=3");
		startNewRow();
		
		// Column 5
		add(stackPanel(), "hfill=fill,vfill=fill,colspan=3");			
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

	//================================================================================
    // Private
    //================================================================================	
	
	private Panel topPanel() {
		topPanel = new TablePanel();
		topPanel.setRowHeight(0, Sizing.PIXELS, 43);
		topPanel.setColumnWidth(0, Sizing.PIXELS, 230);
		topPanel.setColumnWidth(1, Sizing.PIXELS, 38);
		topPanel.setColumnWidth(2, Sizing.PIXELS, 38);
		
		// textField
		textField = new TextField();
		textField.setClearMode(TextClearMode.CLEAR_MODE_WHILE_EDITING);
		textField.setTextHint("Create Watchlist");
		topPanel.add(textField, "hfill=fill,valign=center");
		// addButton
		addButton = new BackgroundButton();
		addButton.setText("ADD");
		topPanel.add(addButton, "hfill=fill,vfill=fill,valign=center");
		// editButton
		editButton = new BackgroundButton();
		editButton.setText("EDIT");
		editButton.setHorizontalTextAlignment(HorizontalAlignmentType.CENTER);
		editButton.setForeColor(Colors.White);
		editButton.setFont(style.getFont(12));
		topPanel.add(editButton, "hfill=fill,vfill=fill,valign=center");		
		return topPanel;
	}
	
	private Panel segmentPanel() {
		segmentObjectArray.add("MY WATCHLIST");
		segmentObjectArray.add("SHARED WATCHLIST");		
		segmentPanel = new SegmentPanel(segmentObjectArray,333,(OnSegmentSelectedListener)this);
		segmentPanel.setRowHeight(0, Sizing.PIXELS, 39);
		
		
		return segmentPanel;
	}
	
	private StackPanel stackPanel() {
		stacktPanel = new StackPanel();		
		myWatchlistPanel = new TablePanel();
		myWatchlistPanel.setRowHeight(0, Sizing.PREFERRED, 1);
		myWatchlistPanel.setColumnWidth(0, Sizing.PIXELS, 333);		
		sharedWatchlistPanel = new TablePanel();
		sharedWatchlistPanel.setRowHeight(0, Sizing.PREFERRED, 1);
		sharedWatchlistPanel.setColumnWidth(0, Sizing.PIXELS, 333);		
		myWatchlistTable = new StickyTable();
		myWatchlistTable.setGridLineStyle(LineStyle.NONE);
		sharedWatchlistTable = new StickyTable();
		sharedWatchlistTable.setGridLineStyle(LineStyle.NONE);
		
		myWatchlistPanel.add(myWatchlistTable);
		sharedWatchlistPanel.add(sharedWatchlistTable);
		stacktPanel.add(myWatchlistPanel);
		stacktPanel.add(sharedWatchlistPanel);
		stacktPanel.select(myWatchlistPanel);
		
		// debug
		myWatchlistTable.setBackColor(Colors.Blue);
		sharedWatchlistTable.setBackColor(Colors.Red);
		
		return stacktPanel;
	}
	
	//================================================================================
    // TableViewActionListener
    //================================================================================
	
	public void onAccessory(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onCellConfigure(TableView c, CellConfig cell, int group) {
		// TODO Auto-generated method stub
		
	}

	public void onCellCreateInfo(TableView c, TableViewCellCreateInfo info,
			int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onCellInfo(TableView c, TableViewCell cell, Cell info,
			int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onCellSize(TableView c, AbsoluteSize sizeInfo, int group,
			int row) {
		// TODO Auto-generated method stub
		
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

	//================================================================================
    // ControlActionListener
    //================================================================================	
	
	public void onClick(Control c) {
		// TODO Auto-generated method stub
		if (c==myWatchlistButton)
			stacktPanel.select(myWatchlistPanel);
		else if (c==sharedWatchlistButton)
			stacktPanel.select(sharedWatchlistPanel);			
					
	}

	public void onFocusGained(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusLost(Control c) {
		// TODO Auto-generated method stub
		
	}
	
	//================================================================================
    // OnSegmentSelectedListener
    //================================================================================	
	
	public void onSegmentSelected(Object obj)
	{
		BackgroundButton button = (BackgroundButton)obj;
		if (button.getText()==segmentObjectArray.getItem(0)) {
			stacktPanel.select(myWatchlistPanel);
		} else {
			stacktPanel.select(sharedWatchlistPanel);
		}
	}

}
