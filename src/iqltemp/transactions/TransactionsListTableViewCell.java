package iqltemp.transactions;

import iqltemp.Utilities;
import iqltemp.models.Transaction;

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

public class TransactionsListTableViewCell extends TableViewCell implements
		TableViewCellListener {
	private int orientation;
	
	private Label dateLabel;
	private Label typeLabel;
	private Label buyersLabel;
	private Label securitiesLabel;
	private Label targetLabel;
	private Label sizeLabel;

	public TransactionsListTableViewCell() {
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
		
		this.setOrientation(this.orientation);
		setBackColor(Colors.White);
		
		add(new Separator(), null);
		
		dateLabel = new Label();
		add(dateLabel, "hfill=fill, vfill=fill");
		
		typeLabel = new Label();
		add(typeLabel, "hfill=fill, vfill=fill");
		
		buyersLabel = new Label();
		add(buyersLabel, "hfill=fill, vfill=fill");
		
		securitiesLabel = new Label();
		add(securitiesLabel, "hfill=fill, vfill=fill");
		
		add(new Separator(), null);
		
		startNewRow();
		
		add(new Separator(), null);
		add(new Separator(), null);
		add(new Separator(), null);
		
		targetLabel = new Label();
		add(targetLabel, "hfill=fill, vfill=fill");
		
		sizeLabel = new Label();
		add(sizeLabel, "hfill=fill, vfill=fill");
		
		add(new Separator(), null);
		
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

	public void populateData(Transaction transaction){
		dateLabel.setText(transaction.date);
		typeLabel.setText(transaction.type);
		buyersLabel.setText(transaction.buyers);
		securitiesLabel.setText(transaction.securites);
		targetLabel.setText(transaction.target);
		sizeLabel.setText(transaction.size);
	}
	
	public void setOrientation(int orientation){
		this.orientation = orientation;
		switch( orientation ){
		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
			setColumnWidth(0, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_PORTRAIT_START_SEPARATOR_WIDTH);
			setColumnWidth(1, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_PORTRAIT_DATE_WIDTH);
			setColumnWidth(2, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_PORTRAIT_TYPE_WIDTH);
			setColumnWidth(3, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_PORTRAIT_BUYERS_WIDTH);
			setColumnWidth(4, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_PORTRAIT_SECURITIES_WIDTH);
			setColumnWidth(5, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_PORTRAIT_END_SEPARATOR_WIDTH);
			break;
		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
			setColumnWidth(0, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_LANDSCAPE_START_SEPARATOR_WIDTH);
			setColumnWidth(1, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_LANDSCAPE_DATE_WIDTH);
			setColumnWidth(2, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_LANDSCAPE_TYPE_WIDTH);
			setColumnWidth(3, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_LANDSCAPE_BUYERS_WIDTH);
			setColumnWidth(4, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_LANDSCAPE_SECURITIES_WIDTH);
			setColumnWidth(5, Sizing.PIXELS, TransactionsPanel.LIST_HEADER_PANEL_LANDSCAPE_END_SEPARATOR_WIDTH);
			break;
		}
	}
}
