package iqltemp.overview;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.Utilities.Utilities;

import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class OverviewBasicFinancialsPanel extends TablePanel implements
		ContainerListener {
	private int orientation;
	
	private IqltempApplication application;
	private DefaultStyle style;

	public OverviewBasicFinancialsPanel() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
		this._I_TablePanel();
	}
	
	public OverviewBasicFinancialsPanel(int orientation){
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
		
		this.setOrientation(this.orientation);
		
		Separator separator = new Separator();
		separator.setBackColor(Color.create(240, 240, 240));
		add(separator, "hfill=fill, vfill=fill");
		
		Label titleLabel = new Label();
		titleLabel.setText("BASIC FINANCIALS");
		titleLabel.setFont(style.getBoldFont(13));
		titleLabel.setBackColor(Color.create(240, 240, 240));
		add(titleLabel, "hfill=fill, vfill=fill, colspan=2");
		startNewRow();
		
		separator = new Separator();
		separator.setBackColor(Color.create(227, 227, 227));
		add(separator, "hfill=fill, vfill=fill, colspan=3");
		startNewRow();
		
		add(new Separator());
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
		switch( orientation ){
		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
			setColumnWidth(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			setColumnWidth(1, Sizing.PIXELS, 599);
			setColumnWidth(2, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			
			break;
		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
			setColumnWidth(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			setColumnWidth(1, Sizing.PIXELS, 264);
			setColumnWidth(2, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
			
			break;
		}
	}
}
