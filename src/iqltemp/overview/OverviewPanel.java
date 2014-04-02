package iqltemp.overview;

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
import com.antennasoftware.core.ui.control.ControlActionListener;

public class OverviewPanel extends TablePanel implements ContainerListener, TableViewActionListener {
	public int orientation;

	private StickyTable mainTable;
	
	private OverviewBusDescPanel busDescPanel;

	public static final int OVERVIEW_GAPWIDTH = 13;
	
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
//		busDescPanel = new OverviewBusDescPanel();
//		add(busDescPanel, "hfill=fill, vfill=fill");
//		startNewRow();
		
		mainTable = new StickyTable();
		mainTable.addListener(this);
		mainTable.setNumberOfGroups(1);
		mainTable.setNumberOfCellsInGroup(0, 1);
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
//		switch( orientation ){
//		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
//			listTitlePanel.setColumnWidth(0, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_START_SEPARATOR_WIDTH);
//			listTitlePanel.setColumnWidth(1, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_DATE_WIDTH);
//			listTitlePanel.setColumnWidth(2, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_TYPE_WIDTH);
//			listTitlePanel.setColumnWidth(3, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_BUYERS_WIDTH);
//			listTitlePanel.setColumnWidth(4, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_SECURITIES_WIDTH);
//			listTitlePanel.setColumnWidth(5, Sizing.PIXELS, LIST_HEADER_PANEL_PORTRAIT_END_SEPARATOR_WIDTH);
//			break;
//		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
//			listTitlePanel.setColumnWidth(0, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_START_SEPARATOR_WIDTH);
//			listTitlePanel.setColumnWidth(1, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_DATE_WIDTH);
//			listTitlePanel.setColumnWidth(2, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_TYPE_WIDTH);
//			listTitlePanel.setColumnWidth(3, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_BUYERS_WIDTH);
//			listTitlePanel.setColumnWidth(4, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_SECURITIES_WIDTH);
//			listTitlePanel.setColumnWidth(5, Sizing.PIXELS, LIST_HEADER_PANEL_LANDSCAPE_END_SEPARATOR_WIDTH);
//			break;
//		}
//		listTable.refresh();
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
		cell.setHeight(Sizing.PREFERRED, 0);
		cell.setWidth(Sizing.PREFERRED, 0);
		cell.setCouldBeSelected(false);
		
	}

	public void onCellCreateInfo(TableView c, TableViewCellCreateInfo info,
			int group, int row) {
		// TODO Auto-generated method stub
		info.setPanel(new OverviewBusDescTableViewCell());
	}

	public void onCellInfo(TableView c, TableViewCell cell, Cell info,
			int group, int row) {
		// TODO Auto-generated method stub
		
	}

	public void onCellSize(TableView c, AbsoluteSize sizeInfo, int group,
			int row) {
		// TODO Auto-generated method stub
		
		sizeInfo.setSize(1000, 300);
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
}