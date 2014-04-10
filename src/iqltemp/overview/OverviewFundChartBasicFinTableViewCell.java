package iqltemp.overview;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.Utilities.Utilities;

import com.antennasoftware.api.bl.images.Images;
import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.TableViewCellListener;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.component.Cell;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TableViewCell;
import com.antennasoftware.api.ui.panel.TableViewPanel;
import com.antennasoftware.api.ui.platform.Image;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class OverviewFundChartBasicFinTableViewCell extends TableViewCell
		implements TableViewCellListener {
	private int orientation;
	
	private IqltempApplication application;
	private DefaultStyle style;
	
	private OverviewFundamentalsPanel fundamentalsPanel;

	public OverviewFundChartBasicFinTableViewCell() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
	}
	
	public OverviewFundChartBasicFinTableViewCell(int orientation){
		this();
		this.orientation = orientation;
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
		application = (IqltempApplication)getApplication();
		style = application.getStyle();
		
		setBackColor(Color.create(245, 245, 245));
		
		application.log(this.toString(), "onCreate", "Create Row 1: " + this.orientation);
		fundamentalsPanel = new OverviewFundamentalsPanel(this.orientation);
		
		if( orientation == Utilities.SCREEN_ORIENTATION_LANDSCAPE ){
			setRowHeight(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_FCBF_HEIGHT_LANDSCAPE);
			setColumnWidth(0, Sizing.PIXELS, 566);
			setColumnWidth(1, Sizing.PIXELS, 1);
			setColumnWidth(2, Sizing.PIXELS, 290);
			
			add(fundamentalsPanel, "hfill=fill, vfill=fill");
			
			Separator separator = new Separator();
			separator.setBackColor(Color.create(240, 240, 240));
			add(separator, "hfill=fill, vfill=fill");
		}else{
			setRowHeight(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_FCBF_HEIGHT_PORTRAIT);
			
			setColumnWidth(0, Sizing.PIXELS, 625);
			
			add(fundamentalsPanel, "hfill=fill, vfill=fill");
		}
	}

	public void onDeactivate(Container source) {
		// TODO Auto-generated method stub

	}

	public void onInfo(TableViewPanel cell, Cell info, int group, int row) {
		// TODO Auto-generated method stub

	}

	public void onOpen(Container source) {
		// TODO Auto-generated method stub

	}

	public void onCellInfo(TableViewCell cell, Cell info, int group, int row) {
		// TODO Auto-generated method stub

	}

	public void onEditing(TableViewCell cell, boolean editing, boolean animated) {
		// TODO Auto-generated method stub

	}

	public void onFocusGained(TableViewCell cell) {
		// TODO Auto-generated method stub

	}

	public void onFocusLost(TableViewCell cell) {
		// TODO Auto-generated method stub

	}

	public void onPrepareForReuse(TableViewCell cell) {
		// TODO Auto-generated method stub

	}

	public void onSelected(TableViewCell cell, boolean selected) {
		// TODO Auto-generated method stub

	}

	public void destroy() {
		this.removeListener(this);
		// TODO Auto-generated method stub
		super.destroy();
	}

	public void populateData(){
		fundamentalsPanel.populateData();
	}
}
