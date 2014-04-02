package iqltemp.overview;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.listeners.OnSizeChangeListener;

import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.Font;
import com.antennasoftware.api.ui.HorizontalAlignmentType;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.TableViewCellListener;
import com.antennasoftware.api.ui.VerticalAlignmentType;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.component.Cell;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.RichLabel;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.panel.TableViewCell;
import com.antennasoftware.api.ui.panel.TableViewPanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.core.ui.control.ControlActionListener;

public class OverviewBusDescTableViewCell extends TableViewCell implements
		TableViewCellListener, ControlActionListener {
	
	private IqltempApplication application;
	private DefaultStyle style;
	
	private Label websiteLabel;
	private Label subsidiariesLabel;
	private Label employeesLabel;
	
	private Label incorporatedLabel;
	private Label headquartersLabel;
	private Label industryLabel;
	
	private Label descrptionLabel;
	
	private Button expandButton;
	private boolean isExpand;
	
	public OnSizeChangeListener onSizeChangeListener;

	public OverviewBusDescTableViewCell() {
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
		
		setBackColor(Color.create(245, 245, 245));
		setRowHeight(0, Sizing.PIXELS, 49);
		setRowHeight(1, Sizing.PIXELS, 1);
		setRowHeight(2, Sizing.PIXELS, 16);
		setRowHeight(4, Sizing.PIXELS, 16);
		setRowHeight(5, Sizing.PREFERRED, 1);
		
		setColumnWidth(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
		setColumnWidth(1, Sizing.PIXELS, 268);
		setColumnWidth(2, Sizing.PIXELS, 35);
		setColumnWidth(3, Sizing.PIXELS, 268);
		setColumnWidth(4, Sizing.PIXELS, 28);
		setColumnWidth(5, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
		
		Separator separator = new Separator();
		separator.setBackColor(Color.create(240, 240, 240));
		add(separator, "hfill=fill, vfill=fill");
		
		Label titleLabel = new Label();
		titleLabel.setText("BUSINESS DESCRIPTION");
		titleLabel.setFont(style.getBoldFont(13));
		titleLabel.setBackColor(Color.create(240, 240, 240));
		add(titleLabel, "hfill=fill, vfill=fill, colspan=5");
		startNewRow();
		
		separator = new Separator();
		separator.setBackColor(Color.create(227, 227, 227));
		add(separator, "hfill=fill, vfill=fill, colspan=6");
		startNewRow();
		
		add(new Separator(), "hfill=fill, vfill=fill, colspan=6");
		startNewRow();
		
		add(new Separator(), "hfill=fill, vfill=fill");
		
		Font titleFont = style.getFont(13);
		Font valueFont = style.getBoldFont(12);
		
		TablePanel leftTablePanel = new TablePanel();
		{
			leftTablePanel.setColumnWidth(0, Sizing.PIXELS, 100);
			leftTablePanel.setColumnWidth(1, Sizing.PIXELS, 168);
			
			titleLabel = new Label();
			titleLabel.setText("Website");
			titleLabel.setFont(titleFont);
			leftTablePanel.add(titleLabel);
			
			websiteLabel = new Label();
			websiteLabel.setText("www.apple.com");
			websiteLabel.setFont(valueFont);
			websiteLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
			leftTablePanel.add(websiteLabel, "hfill=fill, vfill=fill");
			leftTablePanel.startNewRow();
			
			titleLabel = new Label();
			titleLabel.setText("Subsidiaries");
			titleLabel.setFont(titleFont);
			leftTablePanel.add(titleLabel);
			
			subsidiariesLabel = new Label();
			subsidiariesLabel.setText("214");
			subsidiariesLabel.setFont(valueFont);
			subsidiariesLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
			leftTablePanel.add(subsidiariesLabel, "hfill=fill, vfill=fill");
			leftTablePanel.startNewRow();
			
			titleLabel = new Label();
			titleLabel.setText("Employees");
			titleLabel.setFont(titleFont);
			leftTablePanel.add(titleLabel);
			
			employeesLabel = new Label();
			employeesLabel.setText("97,389");
			employeesLabel.setFont(valueFont);
			employeesLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
			leftTablePanel.add(employeesLabel, "hfill=fill, vfill=fill");
			leftTablePanel.startNewRow();
		}
		add(leftTablePanel, "hfill=fill, vfill=fill");
		
		add(new Separator(), "hfill=fill, vfill=fill");
		
		TablePanel rightTablePanel = new TablePanel();
		{
			rightTablePanel.setColumnWidth(0, Sizing.PIXELS, 100);
			rightTablePanel.setColumnWidth(1, Sizing.PIXELS, 168);
			
			titleLabel = new Label();
			titleLabel.setText("Incorporated");
			titleLabel.setFont(titleFont);
			rightTablePanel.add(titleLabel,"hfill=fill, vfill=fill");
			
			incorporatedLabel = new Label();
			incorporatedLabel.setText("1999");
			incorporatedLabel.setFont(valueFont);
			incorporatedLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
			
			int fontHeight = (valueFont.getSize() + 2) * 2;
			int wrappedTextHeight = valueFont.getWrappedTextHeight(incorporatedLabel.getText(), 168);
			int height = wrappedTextHeight > fontHeight ? fontHeight : wrappedTextHeight;
			rightTablePanel.setRowHeight(0, Sizing.PIXELS, height);
			
			rightTablePanel.add(incorporatedLabel, "hfill=fill, vfill=fill");
			rightTablePanel.startNewRow();
			
			titleLabel = new Label();
			titleLabel.setText("Headquarters");
			titleLabel.setFont(titleFont);
			rightTablePanel.add(titleLabel,"hfill=fill, vfill=fill");
			
			headquartersLabel = new Label();
			headquartersLabel.setText("111 Street, New York USA");
			headquartersLabel.setFont(valueFont);
			headquartersLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
			
			fontHeight = (valueFont.getSize() + 2) * 3;
			wrappedTextHeight = valueFont.getWrappedTextHeight(headquartersLabel.getText(), 168) + 2;
			height = wrappedTextHeight > fontHeight ? fontHeight : wrappedTextHeight;
			rightTablePanel.setRowHeight(1, Sizing.PIXELS, height);
			
			rightTablePanel.add(headquartersLabel, "hfill=fill, vfill=fill");
			rightTablePanel.startNewRow();
			
			titleLabel = new Label();
			titleLabel.setText("Industry");
			titleLabel.setFont(titleFont);
			rightTablePanel.add(titleLabel,"hfill=fill, vfill=fill");
			
			industryLabel = new Label();
			industryLabel.setText("Computer Hardware");
			industryLabel.setFont(valueFont);
			industryLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
			
			fontHeight = (valueFont.getSize() + 2) * 2;
			wrappedTextHeight = valueFont.getWrappedTextHeight(industryLabel.getText(), 168);
			height = wrappedTextHeight > fontHeight ? fontHeight : wrappedTextHeight;
			rightTablePanel.setRowHeight(2, Sizing.PIXELS, height);
			
			rightTablePanel.add(industryLabel, "hfill=fill, vfill=fill");
			rightTablePanel.startNewRow();
		}
		add(rightTablePanel, "hfill=fill, vfill=fill");
		
		expandButton = new Button();
		expandButton.setText(" ");
		expandButton.addListener(this);
		add(expandButton, "hfill=fill, vfill=fill");
		startNewRow();
		
		add(new Separator(), "hfill=fill, vfill=fill, colspan=6");
		startNewRow();
		
		add(new Separator(), "hfill=fill, vfill=fill");
		
		descrptionLabel = new Label();
		descrptionLabel.setText("Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. ");
		add(descrptionLabel,"hfill=fill, vfill=fill, colspan=4");
		
		//application.log("OverviewBusDescTableCell", strMethod, strLog)
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

	public void onClick(Control c) {
		// TODO Auto-generated method stub
		if( c.equals(this.expandButton) ){
			isExpand = !isExpand;
			if( onSizeChangeListener != null ){
				onSizeChangeListener.onSizeChange(this);
			}
		}
	}

	public void onFocusGained(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusLost(Control c) {
		// TODO Auto-generated method stub
		
	}

}
