package iqltemp.overview;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.Utilities;

import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.Font;
import com.antennasoftware.api.ui.HorizontalAlignmentType;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class OverviewFundamentalsPanel extends TablePanel implements
		ContainerListener {
	private int orientation;
	
	private IqltempApplication application;
	private DefaultStyle style;
	
	private Label rangeLabel;
	private Label weekHighLowOf52Label;
	private Label openLabel;
	private Label avg3MDailyVolLabel;
	private Label marketCapLabel;
	private Label dividendYieldLabel;
	private Label totalReturnOfWeekLabel;
	private Label totalReturnOfMonthLabel;
	private Label totalReturnOfYearLabel;
	private Label totalReturnOf3YearLabel;

	public OverviewFundamentalsPanel() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
		this._I_TablePanel();
	}
	
	public OverviewFundamentalsPanel(int orientation){
		this.orientation = orientation;
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
		application = (IqltempApplication)getApplication();
		style = application.getStyle();
		
		setBackColor(Color.create(245, 245, 245));
		setRowHeight(0, Sizing.PIXELS, 49);
		setRowHeight(1, Sizing.PIXELS, 1);
		setRowHeight(2, Sizing.PIXELS, 17);
		
		application.log(this.toString(), "onCreate", "Create Row 1: " + this.orientation);
		this.setOrientation(this.orientation);
		
		Separator separator = new Separator();
		separator.setBackColor(Color.create(240, 240, 240));
		add(separator, "hfill=fill, vfill=fill");
		
		Label titleLabel = new Label();
		titleLabel.setText("FUNDAMENTALS");
		titleLabel.setFont(style.getBoldFont(13));
		titleLabel.setBackColor(Color.create(240, 240, 240));
		add(titleLabel, "hfill=fill, vfill=fill, colspan=6");
		startNewRow();
		
		separator = new Separator();
		separator.setBackColor(Color.create(227, 227, 227));
		add(separator, "hfill=fill, vfill=fill, colspan=7");
		startNewRow();
		
		add(new Separator());
		startNewRow();
		
		add(new Separator(), "hfill=fill, vfill=fill, rowspan=8");
		
		{
			add(createTitleLabel("Range"), "hfill=fill, vfill=fill");
			add((rangeLabel = createValueLabel()), "hfill=fill, vfill=fill");
			add(new Separator());
			add(createTitleLabel("Dividend Yield"), "hfill=fill, vfill=fill");
			add((dividendYieldLabel = createValueLabel()), "hfill=fill, vfill=fill");
			startNewRow();
		}
		
		{
			add(createTitleLabel("52 Week High/Low"), "hfill=fill, vfill=fill");
			add((weekHighLowOf52Label = createValueLabel()), "hfill=fill, vfill=fill");
			add(new Separator());
			add(createTitleLabel("1W Total Return"), "hfill=fill, vfill=fill");
			add((totalReturnOfWeekLabel = createValueLabel()), "hfill=fill, vfill=fill");
			startNewRow();
		}
		
		{
			add(createTitleLabel("Open"), "hfill=fill, vfill=fill");
			add((openLabel = createValueLabel()), "hfill=fill, vfill=fill");
			add(new Separator());
			add(createTitleLabel("1M Total Return"), "hfill=fill, vfill=fill");
			add((totalReturnOfMonthLabel = createValueLabel()), "hfill=fill, vfill=fill");
			startNewRow();
		}
		
		{
			add(createTitleLabel("Avg 3M Daily Vol"), "hfill=fill, vfill=fill");
			add((avg3MDailyVolLabel = createValueLabel()), "hfill=fill, vfill=fill");
			add(new Separator());
			add(createTitleLabel("1Y Total Return"), "hfill=fill, vfill=fill");
			add((totalReturnOfYearLabel = createValueLabel()), "hfill=fill, vfill=fill");
			startNewRow();
		}
		
		{
			add(createTitleLabel("Market Cap (mm)"), "hfill=fill, vfill=fill");
			add((marketCapLabel = createValueLabel()), "hfill=fill, vfill=fill");
			add(new Separator());
			add(createTitleLabel("3Y Total Return"), "hfill=fill, vfill=fill");
			add((totalReturnOf3YearLabel = createValueLabel()), "hfill=fill, vfill=fill");
			startNewRow();
		}
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
	
	private Label createTitleLabel(String title){
		Font titleFont = style.getFont(13);
		
		Label titleLabel = new Label();
		titleLabel.setFont(titleFont);
		titleLabel.setText(title);
		return titleLabel;
	}
	
	private Label createValueLabel(){
		Font valueFont = style.getBoldFont(12);
		
		Label valueLabel = new Label();
		valueLabel.setFont(valueFont);
		valueLabel.setHorizontalAlignment(HorizontalAlignmentType.RIGHT);
		
		return valueLabel;
	}
	
	public void setOrientation(int orientation){
		this.orientation = orientation;
		switch( orientation ){
		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
			setColumnWidth(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			setColumnWidth(1, Sizing.PIXELS, 135);
			setColumnWidth(2, Sizing.PIXELS, 150);
			setColumnWidth(3, Sizing.PIXELS, 30);
			setColumnWidth(4, Sizing.PIXELS, 135);
			setColumnWidth(5, Sizing.PIXELS, 149);
			setColumnWidth(6, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			
			break;
		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
			setColumnWidth(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			setColumnWidth(1, Sizing.PIXELS, 135);
			setColumnWidth(2, Sizing.PIXELS, 115);
			setColumnWidth(3, Sizing.PIXELS, 42);
			setColumnWidth(4, Sizing.PIXELS, 135);
			setColumnWidth(5, Sizing.PIXELS, 113);
			setColumnWidth(6, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			
			break;
		}
	}
	
	public void populateData(){
		rangeLabel.setText("48.77 - 49.63");
		weekHighLowOf52Label.setText("35.12 - 49.85");
		openLabel.setText("48.77");
		avg3MDailyVolLabel.setText("5.79M / 4.01M");
		marketCapLabel.setText("24,386.8");
		
		dividendYieldLabel.setText("2.3%");
		totalReturnOfWeekLabel.setText("46.71 (4.52%)");
		totalReturnOfMonthLabel.setText("47.66 (2.41%)");
		totalReturnOfYearLabel.setText("43.93 (11.1%)");
		totalReturnOf3YearLabel.setText("23.91 (116.5%)");
	}

}
