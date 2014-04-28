package iqltemp.overview;

import iqltemp.IqltempApplication;
import iqltemp.Utilities.Utilities;
import iqltemp.listeners.OnSizeChangeListener;
import iqltemp.models.OverviewBusDesc;

import com.antennasoftware.api.ui.AbsoluteSize;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
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

public class OverviewPanel extends TablePanel implements ContainerListener, TableViewActionListener, OnSizeChangeListener {
	private IqltempApplication application;
//	private DefaultStyle style;
	
	public int orientation;

	private StickyTable mainTable;
	
	private OverviewBusDescTableViewCell busDescTableViewCell;
	private int busDescTableViewCellHeight = 0;
	private boolean busDescTableViewCellIsExpand = false;

	public static final int OVERVIEW_GAPWIDTH = 13;
	
	public static final int OVERVIEW_FCBF_HEIGHT_PORTRAIT = 411; // FCBF = Fundamentals Chart and Basic Financials - Portrait
	public static final int OVERVIEW_FCBF_HEIGHT_LANDSCAPE = 383; // FCBF = Fundamentals Chart and Basic Financials - Landscape
	
	public OverviewPanel() {
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
		this.application = (IqltempApplication)getApplication();
//		this.style = application.getStyle();
		
		setRowHeight(0, Sizing.PREFERRED, 1);
		
		mainTable = new StickyTable();
		mainTable.addListener(this);
		mainTable.setNumberOfGroups(1);
		mainTable.setNumberOfCellsInGroup(0, 8);
		add(mainTable, "hfill=fill, vfill=fill");
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
		busDescTableViewCellHeight = 0;
		mainTable.refresh();
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

	public void onAccessory(TableView c, int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onCellConfigure(TableView c, CellConfig cell, int group) {
		// TODO Auto-generated method stub
		cell.setWidth(Sizing.PREFERRED, 1);
		cell.setCouldBeSelected(true);
	}

	public void onCellCreateInfo(TableView c, TableViewCellCreateInfo info,
			int group, int row) {
		// TODO Auto-generated method stub
		TableViewCell cell = null;
		switch( row ){
		case 0:
			cell = new OverviewBusDescTableViewCell();
			break;
		case 1:
			cell = new OverviewFundChartBasicFinTableViewCell(this.orientation);
			break;
		default:
			cell = new OverviewFundChartBasicFinTableViewCell(this.orientation);
			break;
		}
		info.setPanel(cell);
		application.log(this.toString(), "onCellCreateInfo", cell.toString());
	}

	public void onCellInfo(TableView c, TableViewCell cell, Cell info,
			int group, int row) {
		// TODO Auto-generated method stub
		application.log(this.toString(), "onCellInfo", cell.toString());
		if( cell instanceof OverviewBusDescTableViewCell ){
			boolean needReload = busDescTableViewCell == null;
			busDescTableViewCell = (OverviewBusDescTableViewCell)cell;
			busDescTableViewCell.addOnSizeChangeListener(this);
			busDescTableViewCell.setOrientation(this.orientation);
			busDescTableViewCell.populateData(new OverviewBusDesc().randomOverviewBusDesc());
			busDescTableViewCell.isExpand = busDescTableViewCellIsExpand;
			
			if( needReload ){
				c.reload(group, row);
			}else if( busDescTableViewCell.getHeight() != busDescTableViewCellHeight ){
				c.reload(group, row);
			}
		}else if( cell instanceof OverviewFundChartBasicFinTableViewCell ){
			((OverviewFundChartBasicFinTableViewCell)cell).populateData();
		}
	}

	public void onCellSize(TableView c, AbsoluteSize sizeInfo, int group,
			int row) {
		// TODO Auto-generated method stub
		int height = 0;
		switch( row ){
		case 0:
			height = busDescTableViewCellHeight != 0 ? busDescTableViewCellHeight : busDescTableViewCell.getHeight();
			break;
		case 1:
			height = this.orientation == Utilities.SCREEN_ORIENTATION_PORTRAIT ? OVERVIEW_FCBF_HEIGHT_PORTRAIT : OVERVIEW_FCBF_HEIGHT_LANDSCAPE;
			break;
		default:
			height = this.orientation == Utilities.SCREEN_ORIENTATION_PORTRAIT ? OVERVIEW_FCBF_HEIGHT_PORTRAIT : OVERVIEW_FCBF_HEIGHT_LANDSCAPE;
			break;
		}
		sizeInfo.setHeight(height);
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

	public void onSizeChange(TableViewCell cell) {
		// TODO Auto-generated method stub
		if( cell.equals(busDescTableViewCell) ){
			busDescTableViewCellHeight = busDescTableViewCell.getHeight();
			busDescTableViewCellIsExpand = busDescTableViewCell.isExpand;
		}
		mainTable.refresh();
	}
}
