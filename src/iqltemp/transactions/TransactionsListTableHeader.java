package iqltemp.transactions;


import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;

import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.TableViewCellListener;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.component.Cell;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TableViewCell;
import com.antennasoftware.api.ui.panel.TableViewPanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class TransactionsListTableHeader extends TableViewCell implements
		TableViewCellListener {
	
	private Label titleLabel;

	public TransactionsListTableHeader() {
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
		DefaultStyle style = ((IqltempApplication)getApplication()).getStyle();
		
		setBackColor(Colors.LightGray);
		setRowHeight(0, Sizing.PREFERRED, 1);
		setColumnWidth(0, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_PORTRAIT_START_SEPARATOR_WIDTH);
		setColumnWidth(2, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_PORTRAIT_END_SEPARATOR_WIDTH);
		
		add(new Separator(), null); // Column 0
		
		titleLabel = new Label();
		titleLabel.setFont(style.transactionsHeaderTitleFont);
		add(titleLabel, "hfill=fill, vfill=fill, halign=center"); // Column 1
		
		add(new Separator(), null); // Column 2
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
	
	public void setTitle(String title){
		this.titleLabel.setText(title);
	}
}
