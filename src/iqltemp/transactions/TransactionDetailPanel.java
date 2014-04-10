package iqltemp.transactions;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.NavigationPanel;
import iqltemp.Utilities.Utilities;
import iqltemp.listeners.OnDimissScreenListener;

import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.Font;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.collections.ObjectArray;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.ScrollableTablePanel;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.core.ui.control.ControlActionListener;

public class TransactionDetailPanel extends TablePanel implements
		ContainerListener, ControlActionListener {

	private NavigationPanel navigationPanel;
	private Button doneButton;
	
	private IqltempApplication application = (IqltempApplication)getApplication();
	private DefaultStyle style = application.getStyle();
	
	private Label summaryLabel;
	private Label typeLabel;
	private Label featureLabel;
	private Label announcedDateLabel;
	private Label closedDateLabel;
	private Label targetsLabel;
	private Label buyersLabel;
	private Label sellersLabel;
	private Label sizeLabel;
	private Label currencyLabel;
	private Label synopsisLabel;
	
	private ObjectArray onDimissScreenListeners;
	
	public TransactionDetailPanel() {
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
		
		onDimissScreenListeners = new ObjectArray();
		
		setColumnWidth(0, Sizing.PERCENTS, 100);
		setRowHeight(1, Sizing.PREFERRED, 1);
		
		doneButton = new Button();
		doneButton.setText("DONE");
		doneButton.addListener(this);
		
		navigationPanel = new NavigationPanel();
		navigationPanel.setNavigationStyle(NavigationPanel.NAVIGATION_STYLE_WHITE);
//		navigationPanel.setNavigationStyle(NavigationPanel.NAVIGATION_STYLE_DEBUG);
		navigationPanel.addRightButton(doneButton);
		navigationPanel.setTitle("MERGERS & ACQUISITIONS");
		add(navigationPanel, "hfill=fill, vfill=fill");
		startNewRow();
		
		ScrollableTablePanel scrollableTablePanel = new ScrollableTablePanel();
		scrollableTablePanel.setBackColor(Colors.White);
		{
			scrollableTablePanel.setHGap(15);
			scrollableTablePanel.setVGap(5);
			
			scrollableTablePanel.setColumnWidth(0, Sizing.PIXELS, 160);
			scrollableTablePanel.setColumnWidth(1, Sizing.PREFERRED, 1);
			
			int row = 0;
			scrollableTablePanel.setRowHeight(row, Sizing.PIXELS, 15);
			scrollableTablePanel.add(new Separator(),"colspan=2"); 
			scrollableTablePanel.startNewRow(); // Column 0
			
			addRow(scrollableTablePanel, summaryLabel = new Label(), "Deal Summary", true);
			summaryLabel.setText("Announced");
			summaryLabel.setForeColor(Colors.Aqua);
			
			scrollableTablePanel.add(new Separator(),"colspan=2");
			row = scrollableTablePanel.startNewRow(); // Column 2
			scrollableTablePanel.setRowHeight(row - 1, Sizing.PIXELS, 10);
			
			addRow(scrollableTablePanel, typeLabel = new Label(), "Transaction Type:", false);
			typeLabel.setText("Mergers & Acquisitions");
			
			addRow(scrollableTablePanel, featureLabel = new Label(), "Primary Feature:", false);
			featureLabel.setText("Acquisition of Equity skake");
			
			addRow(scrollableTablePanel, announcedDateLabel = new Label(), "Announced Date:", false);
			announcedDateLabel.setText("Aug 16-2013");
			
			addRow(scrollableTablePanel, closedDateLabel = new Label(), "Closed Date:", false);
			closedDateLabel.setText("Oct 16-2013");
			
			addRow(scrollableTablePanel, targetsLabel = new Label(), "Targets:", false);
			targetsLabel.setText("Travel Assets of John Wile & Sons, Inc.");
			
			addRow(scrollableTablePanel, buyersLabel = new Label(), "Buyers:", false);
			buyersLabel.setText("Apple Inc.");
			
			addRow(scrollableTablePanel, sellersLabel = new Label(), "Sellers:", false);
			sellersLabel.setText("John Wiley & Sons Inc.");
			
			addRow(scrollableTablePanel, sizeLabel = new Label(), "Size:", false);
			sizeLabel.setText("$22.00mm");
			
			currencyLabel = new Label();
			currencyLabel.setFont(style.getFont(13));
			currencyLabel.setText("Currency: USD");
			currencyLabel.setForeColor(Colors.DarkGray);
			scrollableTablePanel.add(currencyLabel, "colspan=2");
			row = scrollableTablePanel.startNewRow();
			
			scrollableTablePanel.setRowHeight(row, Sizing.PIXELS, 11); // vGap * 2 + 1
			Separator separator = new Separator();
			separator.setBackColor(Color.create(197, 197, 197));
			scrollableTablePanel.add(separator, "hfill=fill, vfill=fill, colspan=2");
			row = scrollableTablePanel.startNewRow();
			
			Label titleLabel = new Label();
			titleLabel.setFont(style.getFont(16));
			titleLabel.setText("Synopsis");
			scrollableTablePanel.add(titleLabel, "colspan=2");
			scrollableTablePanel.startNewRow();
			
			synopsisLabel = new Label();
			synopsisLabel.setFont(style.getFont(14));
			synopsisLabel.setText("Apple Inc. (Apple) designs, manufactures and markets mobile communication and media devices, personal computers, and portable digital music players, and sells a variety of related software, services, peripherals, networking solutions, and third-party digital content and applications, The Company's products and sservices include iPhone, iPad, Mac, iPod, Apple TV, a portfolio of consumer and professional software applications, the iOS and OS X operating ystems, iCloud, and a variety of accessory, service and support offerings. In March 2013, the Company acquired a Silicon Valley startup, WiFiSlam, which makes mapping applications for smart phones. Effective July 19, 2013, Apple Inc acquired Locationary Inc. Effective August 28, 2013, Apple Inc acquired AlgoTrim AB, a Malmo-based developer of prepackaged software. In Novement 2013, Apple Inc bought PrimeSense Ltd. Effective December 2, 2013, Apple inc acquired Topsy Labs Inc. In February 2014, Apple Inc acquired Burstly Inc.");
			scrollableTablePanel.add(synopsisLabel, "colspan=2");
			scrollableTablePanel.startNewRow();
		}
		
		add(scrollableTablePanel,"hfill=fill, vfill=fill");

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
	
	private int addRow(ScrollableTablePanel panel, Label descLabel, String title, boolean titleIsBold){
		Font boldFont = style.getBoldFont(14);
		Font font = style.getFont(14);
		
		Label label = new Label();
		label.setFont(titleIsBold ? boldFont : font);
		label.setText(title);
		panel.add(label);
		
		descLabel.setFont(boldFont);
		panel.add(descLabel);
		return panel.startNewRow();
	}

	public void onClick(Control c) {
		// TODO Auto-generated method stub
		if( c.equals(this.doneButton) && this.onDimissScreenListeners != null ){
			for( int i = 0; i < onDimissScreenListeners.size(); i++ ){
				OnDimissScreenListener onDimissScreenListener = (OnDimissScreenListener)onDimissScreenListeners.getItem(i);
				onDimissScreenListener.onDimissScreen();
			}
		}
	}

	public void onFocusGained(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusLost(Control c) {
		// TODO Auto-generated method stub
		
	}

	public boolean addOnDimissScreenListener(OnDimissScreenListener onDimissScreenListener){
		return Utilities.addObject(onDimissScreenListeners, onDimissScreenListener);
	}
	
	public void removeOnDimissScreenListener(OnDimissScreenListener onDimissScreenListener){
		Utilities.removeObject(onDimissScreenListeners, onDimissScreenListener);
	}
}
