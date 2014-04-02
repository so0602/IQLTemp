package iqltemp;

import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.HorizontalAlignmentType;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class CompanyPanel extends TablePanel implements ContainerListener {
	public int orientation;
	private Label companyNameLabel;
	private Label updateTimeLabel;
	private Label currencyLabel;
	private Label priceLabel;
	private Label priceTitleLabel;
	private Label changeLabel;
	private Label changeTitleLabel;
	private Label changePercentLabel;
	private Label changePercentTitleLabel;
	private Button tenQButton;
	private Button tenKButton;
	private Button proxyButton;
	
	public CompanyPanel() {
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
		setBackColor(Color.create(44, 45, 46));
//		setBackColor(Colors.CompanyNavBarBG);
		
		setRowHeight(0, Sizing.PIXELS, 30);
		setRowHeight(1, Sizing.PIXELS, 30);
		
		setOrientation(this.orientation);
		
		add(new Separator(),"rowspan=2");
		
		companyNameLabel = new Label();
		companyNameLabel.setForeColor(Colors.White);
		add(companyNameLabel,"hfill=fill, vfill=fill, colspan=2");
		
		Separator separator = new Separator();
		separator.setBackColor(Color.create(69, 70, 71));
		add(separator, "hfill=fill, vfill=fill, rowspan=2");
		
		add(new Separator(),"rowspan=2");
		
		priceLabel = new Label();
		priceLabel.setForeColor(Colors.White);
		add(priceLabel,"hfill=fill, vfill=fill");
		
		changeLabel = new Label();
		changeLabel.setForeColor(Color.create(0, 188, 223));
		changeLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
		add(changeLabel,"hfill=fill, vfill=fill");
		
		changePercentLabel = new Label();
		changePercentLabel.setForeColor(Color.create(0, 188, 223));
		changePercentLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
		add(changePercentLabel,"hfill=fill, vfill=fill");
		
		add(new Separator(),"rowspan=2");
		
		separator = new Separator();
		separator.setBackColor(Color.create(69, 70, 71));
		add(separator, "hfill=fill, vfill=fill, rowspan=2");
		
		add(new Separator(),"rowspan=2");
		
		tenQButton = new Button();
		tenQButton.setText("10Q");
		add(tenQButton, "hfill=fill, rowspan=2");
		
		add(new Separator(),"rowspan=2");
		
		tenKButton = new Button();
		tenKButton.setText("10K");
		add(tenKButton, "hfill=fill, rowspan=2");
		
		add(new Separator(),"rowspan=2");
		
		proxyButton = new Button();
		proxyButton.setText("Proxy");
		add(proxyButton, "hfill=fill, rowspan=2");
		
		startNewRow();
		
		updateTimeLabel = new Label();
		updateTimeLabel.setForeColor(Color.create(124, 126, 125));
		add(updateTimeLabel,"hfill=fill, vfill=fill");
		
		currencyLabel = new Label();
		currencyLabel.setForeColor(Color.create(124, 126, 125));
		add(currencyLabel,"hfill=fill, vfill=fill");
		
		priceTitleLabel = new Label();
		priceTitleLabel.setForeColor(Color.create(124, 126, 125));
		add(priceTitleLabel,"hfill=fill, vfill=fill");
		
		changeTitleLabel = new Label();
		changeTitleLabel.setForeColor(Color.create(124, 126, 125));
		changeTitleLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
		add(changeTitleLabel,"hfill=fill, vfill=fill");
		
		changePercentTitleLabel = new Label();
		changePercentTitleLabel.setForeColor(Color.create(124, 126, 125));
		changePercentTitleLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
		add(changePercentTitleLabel,"hfill=fill, vfill=fill");
		
		companyNameLabel.setText("NasdaqGS: AAPL");
		priceLabel.setText("549.03");
		changeLabel.setText("16.8571");
		changePercentLabel.setText("+3.1%");
		updateTimeLabel.setText("Updated 1:06PM");
		currencyLabel.setText("All Currency in USD");
		priceTitleLabel.setText("Price (USD)");
		changeTitleLabel.setText("Change");
		changePercentTitleLabel.setText("Change %");
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
		
		switch( orientation ){
		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
			setColumnWidth(0, Sizing.PIXELS, 14); // Separator
			setColumnWidth(1, Sizing.PIXELS, 100); // Update time
			setColumnWidth(2, Sizing.PIXELS, 115); // Currency
			setColumnWidth(3, Sizing.PIXELS, 1); // Separator (Line)
			setColumnWidth(4, Sizing.PIXELS, 15); // Separator
			setColumnWidth(5, Sizing.PIXELS, 100); // Price
			setColumnWidth(6, Sizing.PIXELS, 100); // Change
			setColumnWidth(7, Sizing.PIXELS, 86); // Change %
			setColumnWidth(8, Sizing.PIXELS, 16); // Separator
			setColumnWidth(9, Sizing.PIXELS, 1); // Separator (Line)
			setColumnWidth(10, Sizing.PIXELS, 10); // Separator
			setColumnWidth(11, Sizing.PIXELS, 60); // 10Q
			setColumnWidth(12, Sizing.PIXELS, 10); // Separator
			setColumnWidth(13, Sizing.PIXELS, 60); // 10K
			setColumnWidth(14, Sizing.PIXELS, 10); // Separator
			setColumnWidth(15, Sizing.PIXELS, 60); // Proxy
			setColumnWidth(16, Sizing.PIXELS, 18); // Separator
			break;
		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
			setColumnWidth(0, Sizing.PIXELS, 18); // Separator
			setColumnWidth(1, Sizing.PIXELS, 128); // Update time
			setColumnWidth(2, Sizing.PIXELS, 133); // Currency
			setColumnWidth(3, Sizing.PIXELS, 1); // Separator (Line)
			setColumnWidth(4, Sizing.PIXELS, 21); // Separator
			setColumnWidth(5, Sizing.PIXELS, 140); // Price
			setColumnWidth(6, Sizing.PIXELS, 150); // Change
			setColumnWidth(7, Sizing.PIXELS, 125); // Change %
			setColumnWidth(8, Sizing.PIXELS, 21); // Separator
			setColumnWidth(9, Sizing.PIXELS, 1); // Separator (Line)
			setColumnWidth(10, Sizing.PIXELS, 68); // Separator
			setColumnWidth(11, Sizing.PIXELS, 60); // 10Q
			setColumnWidth(12, Sizing.PIXELS, 10); // Separator
			setColumnWidth(13, Sizing.PIXELS, 60); // 10K
			setColumnWidth(14, Sizing.PIXELS, 10); // Separator
			setColumnWidth(15, Sizing.PIXELS, 60); // Proxy
			setColumnWidth(16, Sizing.PIXELS, 18); // Separator
			break;
		}
	}

}
