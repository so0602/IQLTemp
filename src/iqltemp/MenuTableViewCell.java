package iqltemp;

import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.TableViewCellListener;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.component.Cell;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.panel.TableViewCell;
import com.antennasoftware.api.ui.panel.TableViewPanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class MenuTableViewCell extends TableViewCell implements
		TableViewCellListener {
	private IqltempApplication application;
	private DefaultStyle style;
	
	private TablePanel mainPanel;
	private Label titleLabel;
	
	public MenuTableViewCell() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
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
		
		setRowHeight(0, Sizing.PREFERRED, 1);
		setColumnWidth(0, Sizing.PREFERRED, 1);
		
		titleLabel = new Label();
		titleLabel.setForeColor(Color.create(203, 203, 203));
		titleLabel.setFont(style.getBoldFont(14));
		
		mainPanel = new TablePanel();
		mainPanel.setBackColor(Color.create(68, 68, 68));	
		mainPanel.setRowHeight(0, Sizing.PREFERRED, 1);
		mainPanel.setRowHeight(1, Sizing.PIXELS, 1);		
		mainPanel.setColumnWidth(0, Sizing.PIXELS, 12);
		mainPanel.setColumnWidth(1, Sizing.PREFERRED, 1);
				
		mainPanel.add(new Separator());
		mainPanel.add(titleLabel, "hfill=fill,vfill=fill,valign=center");
		mainPanel.startNewRow();
		
		Separator separator = new Separator();
		separator.setBackColor(Color.create(59, 59, 59));
		mainPanel.add(separator, "hfill=fill, vfill=fill, colspan=2");
		
		add(mainPanel, "hfill=fill, vfill=fill");
		
		
		
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
	
	public void populateData(String title, boolean selected){
		titleLabel.setText(title);
		if (selected)
			titleLabel.setForeColor(Color.create(37, 176, 208));
		else 
			titleLabel.setForeColor(Color.create(203, 203, 203));
			
	}	

}
