package iqltemp;

import iqltemp.listeners.OnDimissScreenListener;
import iqltemp.listeners.OnSelectedListener;
import iqltemp.transactions.TransactionDetailPanel;

import com.antennasoftware.api.ui.Background;
import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.InputEvent;
import com.antennasoftware.api.ui.Screen;
import com.antennasoftware.api.ui.ScreenListener;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class MainScreen extends Screen implements ScreenListener, OnSelectedListener {
	TablePanel mainPanel;
	
	NavigationPanel navigationPanel;
	CompanyPanel comapnyPanel;
	MenuPanel menuPanel;
	ContentPanel contentPanel;
	
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
		
		mainPanel = new TablePanel();
		mainPanel.setColumnWidth(0, Sizing.PREFERRED, 0);
		mainPanel.setColumnWidth(1, Sizing.PREFERRED, 1);
		mainPanel.setRowHeight(2, Sizing.PERCENTS, 100);
		
		navigationPanel = new NavigationPanel();
		navigationPanel.setTitle("APPLE INC.L TRANSACTIONS");
		mainPanel.add(navigationPanel, "hfill=fill, colspan=2");
		
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
		
		add(mainPanel, "hfill=fill, vfill=fill");
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

}
