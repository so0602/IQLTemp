package iqltemp;

import iqltemp.listeners.OnSelectedListener;
import iqltemp.overview.OverviewPanel;
import iqltemp.transactions.TransactionsPanel;

import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.Screen;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.panel.Panel;
import com.antennasoftware.api.ui.panel.StackPanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class ContentPanel extends StackPanel implements ContainerListener {
	public OverviewPanel overviewPanel;
	public TransactionsPanel transactionsPanel;
	
	public int orientation;
	public Screen containerScreen;
	
	public static final int CONTENTPANELTYPE_OVERVIEW = 0;
	public static final int CONTENTPANELTYPE_TRANSACTIONS = 1;
	
	public ContentPanel() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
		this._I_StackPanel();
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
		
		setBackColor(Colors.Chocolate);
		
		overviewPanel = new OverviewPanel();
		add(overviewPanel);
		
		transactionsPanel = new TransactionsPanel();
		add(transactionsPanel);
		
		select(overviewPanel);
	}

	public void onDeactivate(Container source) {
		// TODO Auto-generated method stub

	}

	public void onOpen(Container source) {
		// TODO Auto-generated method stub
		
		transactionsPanel.addOnSelectedListener((OnSelectedListener)this.containerScreen);
	}

	public void destroy() {
		this.removeListener(this);
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	public void setOrientation(int orientation){
		this.orientation = orientation;
		
		this.transactionsPanel.setOrientation(orientation);
		this.overviewPanel.setOrientation(orientation);
	}
	
	public void switchPanel(int panelType ){
		Panel panel = null;
		
		switch(panelType){
		case CONTENTPANELTYPE_OVERVIEW:
			panel = overviewPanel;
			break;
		case CONTENTPANELTYPE_TRANSACTIONS:
			panel = transactionsPanel;
			break;
		}
		if( panel != null ){
			select(panel);
		}
	}

}
