package iqltemp.overview;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.Utilities.Utilities;
import iqltemp.listeners.OnSizeChangeListener;
import iqltemp.models.OverviewBusDesc;

import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.Font;
import com.antennasoftware.api.ui.HorizontalAlignmentType;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.TableViewCellListener;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.collections.ObjectArray;
import com.antennasoftware.api.ui.component.Cell;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.panel.TableViewCell;
import com.antennasoftware.api.ui.panel.TableViewPanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.core.ui.control.ControlActionListener;

public class OverviewBusDescTableViewCell extends TableViewCell implements
		TableViewCellListener, ControlActionListener {
	private int orientation;
	
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
	public boolean isExpand;
	
	private TablePanel leftTablePanel;
	private TablePanel rightTablePanel;
	
	private int incorporatedHeight;
	private int headquartersHeight;
	private int industryHeight;
	private int descriptionHeight;
	
	private int valueMaxWidth;
	private int descMaxWidth;
	
	private ObjectArray onSizeChangeListeners;

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
		
		onSizeChangeListeners = new ObjectArray();
		
		leftTablePanel = new TablePanel();
		rightTablePanel = new TablePanel();
		
		this.setOrientation(this.orientation);
		
		setBackColor(Color.create(245, 245, 245));
		setRowHeight(0, Sizing.PIXELS, 49);
		setRowHeight(1, Sizing.PIXELS, 1);
		setRowHeight(2, Sizing.PIXELS, 16);
		setRowHeight(4, Sizing.PIXELS, 16);
		setRowHeight(6, Sizing.PIXELS, 16);
		
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
		
		{
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
		
		{
			titleLabel = new Label();
			titleLabel.setText("Incorporated");
			titleLabel.setFont(titleFont);
			rightTablePanel.add(titleLabel,"hfill=fill, vfill=fill");
			
			incorporatedLabel = new Label();
			incorporatedLabel.setText("1999");
			incorporatedLabel.setFont(valueFont);
			incorporatedLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
			incorporatedHeight = Utilities.getLabelHeight(incorporatedLabel, 2, valueMaxWidth);
			rightTablePanel.setRowHeight(0, Sizing.PIXELS, incorporatedHeight);
			
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
			headquartersHeight = Utilities.getLabelHeight(headquartersLabel, 3, valueMaxWidth);
			rightTablePanel.setRowHeight(1, Sizing.PIXELS, headquartersHeight);
			
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
			industryHeight = Utilities.getLabelHeight(industryLabel, 2, valueMaxWidth);
			rightTablePanel.setRowHeight(2, Sizing.PIXELS, industryHeight);
			
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
		descrptionLabel.setText("Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Its products and services include iPhone, a handheld product that combines a mobile phone, an iPod, and an Internet communications device; iPad, a multi-purpose mobile device; desktop computers, such as iMac, Mac Pro, and Mac mini; portable computers, including MacBook Pro and MacBook Air; a line of iPod portable digital music and media players; and iCloud, and a cloud service. The company also offers a range of software products, including iOS and OS X operating system software consisting of Final Cut Pro, Logic Stuio, Logic Pro, and its FileMaker Pro database software. It also manufactures the Apple LED Cinema Display and Thunderbolt Display; sells a variety of Apple-branded");
		descrptionLabel.setFont(style.getFont(12));
		descrptionLabel.setBackColor(Colors.Azure);
		descriptionHeight = Utilities.getLabelHeight(descrptionLabel, 0, descMaxWidth);
		add(descrptionLabel,"hfill=fill, vfill=fill, colspan=4");
		setRowHeight(5, Sizing.PIXELS, descriptionHeight);
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
		application.log("OverviewBusDescTableViewCell", "onClick", c + " " + onSizeChangeListeners.size());
		if( c.equals(this.expandButton) ){
			isExpand = !isExpand;
			for( int i = 0; i < onSizeChangeListeners.size(); i++ ){
				OnSizeChangeListener onSizeChangeListener = (OnSizeChangeListener)onSizeChangeListeners.getItem(i);
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
	
	public void addOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener){
		Utilities.addObject(onSizeChangeListeners, onSizeChangeListener);
	}
	
	public void removeOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener){
		Utilities.removeObject(onSizeChangeListeners, onSizeChangeListener);
	}
	
	public int getHeight(){
		int height = 49 + 1 + 16 + 16;
		height += incorporatedHeight + headquartersHeight + industryHeight;
		if( isExpand ){
			height += descriptionHeight + 16;
		}
		return height;
	}
	
	public void populateData(OverviewBusDesc overviewBusDesc){
		websiteLabel.setText(overviewBusDesc.website);
		subsidiariesLabel.setText(overviewBusDesc.subsidaries);
		employeesLabel.setText(overviewBusDesc.employees);
		incorporatedLabel.setText(overviewBusDesc.incorporated);
		headquartersLabel.setText(overviewBusDesc.headquarters);
		industryLabel.setText(overviewBusDesc.inductry);
		descrptionLabel.setText(overviewBusDesc.description);
		
		incorporatedHeight = Utilities.getLabelHeight(incorporatedLabel, 2, valueMaxWidth);
		headquartersHeight = Utilities.getLabelHeight(headquartersLabel, 3, valueMaxWidth);
		industryHeight = Utilities.getLabelHeight(industryLabel, 2, valueMaxWidth);
		
		rightTablePanel.setRowHeight(0, Sizing.PIXELS, incorporatedHeight);
		rightTablePanel.setRowHeight(1, Sizing.PIXELS, headquartersHeight);
		rightTablePanel.setRowHeight(2, Sizing.PIXELS, industryHeight);
		
		descriptionHeight = Utilities.getLabelHeight(descrptionLabel, 0, descMaxWidth);
		setRowHeight(5, Sizing.PIXELS, descriptionHeight);
	}
	
	public void setOrientation(int orientation){
		this.orientation = orientation;
		switch( orientation ){
		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
			setColumnWidth(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			setColumnWidth(1, Sizing.PIXELS, 268);
			setColumnWidth(2, Sizing.PIXELS, 35);
			setColumnWidth(3, Sizing.PIXELS, 268);
			setColumnWidth(4, Sizing.PIXELS, 28);
			setColumnWidth(5, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			
			leftTablePanel.setColumnWidth(0, Sizing.PIXELS, 100);
			leftTablePanel.setColumnWidth(1, Sizing.PIXELS, 168);
			rightTablePanel.setColumnWidth(0, Sizing.PIXELS, 100);
			rightTablePanel.setColumnWidth(1, Sizing.PIXELS, 168);
			
			valueMaxWidth = 168;
			descMaxWidth = 599;
			break;
		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
			setColumnWidth(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			setColumnWidth(1, Sizing.PIXELS, 375);
			setColumnWidth(2, Sizing.PIXELS, 35);
			setColumnWidth(3, Sizing.PIXELS, 386);
			setColumnWidth(4, Sizing.PIXELS, 35);
			setColumnWidth(5, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			
			leftTablePanel.setColumnWidth(0, Sizing.PIXELS, 100);
			leftTablePanel.setColumnWidth(1, Sizing.PIXELS, 275);
			rightTablePanel.setColumnWidth(0, Sizing.PIXELS, 100);
			rightTablePanel.setColumnWidth(1, Sizing.PIXELS, 286);
			
			valueMaxWidth = 286;
			descMaxWidth = 831;
			break;
		}
	}
}
