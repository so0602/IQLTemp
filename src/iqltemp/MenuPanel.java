package iqltemp;

import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.core.ui.control.ControlActionListener;

public class MenuPanel extends TablePanel implements ContainerListener, ControlActionListener {
	public Button overviewButton;
	public Button transactionsButton;
	
	public int orientation;
	
	public MainScreen screen;
	
	public MenuPanel() {
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

		setBackColor(Colors.DarkGray);
		setColumnWidth(0, Sizing.PIXELS, 143);
		
		overviewButton = new Button();
		overviewButton.setText("Overview");
		overviewButton.addListener(this);
		add(overviewButton, "hfill=fill, vfill=fill");
		startNewRow();
		
		transactionsButton = new Button();
		transactionsButton.setText("Transactions");
		transactionsButton.addListener(this);
		add(transactionsButton, "hfill=fill, vfill=fill");
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
		switch( orientation ){
		case Utilities.SCREEN_ORIENTATION_PORTRAIT:
			setColumnWidth(0, Sizing.PIXELS, 143);
			break;
		case Utilities.SCREEN_ORIENTATION_LANDSCAPE:
			setColumnWidth(0, Sizing.PIXELS, 167);
			break;
		}
	}

	public void onClick(Control c) {
		// TODO Auto-generated method stub
		if( c.equals(this.overviewButton) ){
			screen.contentPanel.switchPanel(ContentPanel.CONTENTPANELTYPE_OVERVIEW);
		}else if( c.equals(this.transactionsButton) ){
			screen.contentPanel.switchPanel(ContentPanel.CONTENTPANELTYPE_TRANSACTIONS);
		}
	}

	public void onFocusGained(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusLost(Control c) {
		// TODO Auto-generated method stub
		
	}

}
