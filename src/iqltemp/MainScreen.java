package iqltemp;

import iqltemp.Utilities.Utilities;
import iqltemp.listeners.OnDimissScreenListener;
import iqltemp.listeners.OnSelectedListener;
import iqltemp.transactions.TransactionDetailPanel;
import iqltemp.watchlist.AddToWatchlistPanel;

import com.antennasoftware.api.ui.Background;
import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.InputEvent;
import com.antennasoftware.api.ui.Screen;
import com.antennasoftware.api.ui.ScreenListener;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.control.BackgroundButton;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.panel.Panel;
import com.antennasoftware.api.ui.panel.ScrollableHorizontalPanel;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.core.ui.control.ControlActionListener;

public class MainScreen extends Screen implements ScreenListener, OnSelectedListener, ControlActionListener {
	
	private ScrollableHorizontalPanel basePanel;
	private TablePanel hiddenLeftPanel;
	private TablePanel mainPanel;		
	private NavigationPanel navigationPanel;
	private BackgroundButton addToWatchlistButton = new BackgroundButton();
	private BackgroundButton backButton = new BackgroundButton();
	private CompanyPanel comapnyPanel;
	private MenuPanel menuPanel;
	private AddToWatchlistPanel addToWatchlistPanel = new AddToWatchlistPanel();
	
	public ContentPanel contentPanel;
	
	private boolean toggle;
		
	public int orientation;

	public MainScreen() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
		this._I_Screen();
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
		add(basePanel(), "hfill=fill, vfill=fill");
				
		basePanel.add(hiddenLeftPanel(), "vfill=fill");
		basePanel.add(mainPanel(), "vfill=fill");
		basePanel.add(addToWatchlistPanel, " vfill=fill");			
	}

	public void onDeactivate(Container source) {
		// TODO Auto-generated method stub

	}

	public void onOpen(Container source) {
		// TODO Auto-generated method stub

	}

	public void onBeginChangeFromFullScreen(Screen screen, Container container) {
		// TODO Auto-generated method stub

	}

	public void onBeginChangeToFullScreen(Screen screen, Container container) {
		// TODO Auto-generated method stub

	}

	public void onEndChangeFromFullScreen(Screen screen, Container container) {
		// TODO Auto-generated method stub

	}

	public void onEndChangeToFullScreen(Screen screen, Container container) {
		// TODO Auto-generated method stub

	}

	public void onEndOrientationChange(Screen screen, int orientation) {
		// TODO Auto-generated method stub

	}

	public void onInputEvent(Screen screen, InputEvent event) {
		// TODO Auto-generated method stub

	}

	public void onMenuDisplay(Screen screen) {
		// TODO Auto-generated method stub

	}

	public void onOrientationLayoutChange(Screen screen, int orientation) {
		// TODO Auto-generated method stub

	}

	public void onScreenKeyboardVisibilityChange(Screen screen,
			boolean isKeyboardVisible) {
		// TODO Auto-generated method stub

	}

	public void onScreenOrientationChange(Screen screen, int orientation) {
		// TODO Auto-generated method stub

	}

	public void onScreenOrientationChange(Screen screen, int event,
			int orientation) {
		// TODO Auto-generated method stub

	}

	public void onStartOrientationChange(Screen screen, int orientation) {
		// TODO Auto-generated method stub
		this.orientation = orientation;
		
		int _orientation = Utilities.isPortrait(orientation) ? Utilities.SCREEN_ORIENTATION_PORTRAIT : Utilities.SCREEN_ORIENTATION_LANDSCAPE;
		
		this.menuPanel.setOrientation(_orientation);
		this.contentPanel.setOrientation(_orientation);
		this.comapnyPanel.setOrientation(_orientation);
	}

	public void destroy() {
		this.removeListener(this);
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	//================================================================================
    // Private
    //================================================================================
	
	private Panel basePanel() {
		basePanel = new ScrollableHorizontalPanel();
		basePanel.enableBounce(false);
		basePanel.enableScroll(false);
		basePanel.setColumnWidth(0, Sizing.PIXELS, 0);
		basePanel.setColumnWidth(1, Sizing.PERCENTS, 100);
		basePanel.setColumnWidth(2, Sizing.PIXELS, 333);		
		return basePanel;
	}
	
	private Panel hiddenLeftPanel() {
		hiddenLeftPanel = new TablePanel();
		hiddenLeftPanel.setColumnWidth(0, Sizing.PIXELS, 1);
		return hiddenLeftPanel;
	}
	
	private Panel mainPanel() {
		mainPanel = new TablePanel();
		mainPanel.setColumnWidth(0, Sizing.PREFERRED, 0);
		mainPanel.setColumnWidth(1, Sizing.PREFERRED, 1);
		mainPanel.setRowHeight(2, Sizing.PERCENTS, 100);
		
		mainPanel.add(navigationPanel(), "hfill=fill, colspan=2");				
		mainPanel.startNewRow();
		
		comapnyPanel = new CompanyPanel();
		mainPanel.add(comapnyPanel,"hfill=fill, colspan=2");
		mainPanel.startNewRow();
		
		menuPanel = new MenuPanel();
		menuPanel.screen = this;
		mainPanel.add(menuPanel,"hfill=fill,vfill=fill");
		
		contentPanel = new ContentPanel();
		contentPanel.containerScreen = this;
		mainPanel.add(contentPanel,"hfill=fill, vfill=fill");		
		mainPanel.startNewRow();
		
		return mainPanel;
	}
	
	private Panel navigationPanel() {
		navigationPanel = new NavigationPanel();
		navigationPanel.setTitle("APPLE INC.L TRANSACTIONS");
	
		backButton.setForeColor(Colors.White);		
		backButton.addListener(this);		
		backButton.setText("< INDUSTRIES");		
		navigationPanel.addLeftButton(backButton);
		
		addToWatchlistButton.addListener(this);
		addToWatchlistButton.setForeColor(Colors.White);
		addToWatchlistButton.setText("Add To Watchlist >");		
		navigationPanel.addRightButton(addToWatchlistButton);
		return navigationPanel;
	}

	//================================================================================
    // OnSelectedListener
    //================================================================================
	
	public void onSelected(Object obj) {
		// TODO Auto-generated method stub
		Color color = Colors.Black;
		color = color.setAlpha(192);
		Background background = Background.createColorRectangleBackground(color);
		
		TransactionDetailPanel panel = new TransactionDetailPanel();
		panel.addOnDimissScreenListener(new OnDimissScreenListener() {
			public void onDimissScreen() {
				dismissLastFullScreenContainer();
			}
		});
//		this.presentAsFullScreen(panel);
		this.presentAsFullScreen(panel, 35, 35, 175, 155, background);
	}
	
	//================================================================================
    // ControlActionListener
    //================================================================================	
	
	public void onClick(Control c) {
		// TODO Auto-generated method stub
		if( this.addToWatchlistButton.equals(c) ){
			if (toggle) {
				basePanel.reveal(hiddenLeftPanel, ScrollableHorizontalPanel.POSITION_RIGHT);
				//basePanel.refresh();
				toggle = false;
			} else {
				basePanel.reveal(addToWatchlistPanel);
				toggle = true;
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
