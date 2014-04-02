package iqltemp;

import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.HorizontalAlignmentType;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.collections.ObjectArray;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.Panel;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class NavigationPanel extends TablePanel implements ContainerListener {
	private Label titleLabel;
	private TablePanel leftButtonPanel;
	private TablePanel rightButtonPanel;
	
	private ObjectArray leftButtons;
	private ObjectArray rightButtons;
	
	public String title;
	
	private int navigationStyle;
	public static final int NAVIGATION_STYLE_DEBUG = -1;
	public static final int NAVIGATION_STYLE_BLACK = 0; //Default
	public static final int NAVIGATION_STYLE_WHITE = 1;
	
	public NavigationPanel() {
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
		
		setBackColor(Colors.Red);
		setRowHeight(0, Sizing.PIXELS, 43);
		setRowHeight(1, Sizing.PIXELS, 1);
		setColumnWidth(0, Sizing.PREFERRED, 0);
		setColumnWidth(1, Sizing.PERCENTS, 20);
		setColumnWidth(2, Sizing.PERCENTS, 60);
		setColumnWidth(3, Sizing.PERCENTS, 20);
		setColumnWidth(4, Sizing.PREFERRED, 0);
		
		add(new Separator()); // Column 0
		
		leftButtonPanel = new TablePanel();
		add(leftButtonPanel, "hfill=fill, vfill=fill, halign=center"); // Column 1
		
		titleLabel = new Label();
		titleLabel.setText(title);
		titleLabel.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
		add(titleLabel,"hfill=fill,halign=center");  // Column 2
		
		rightButtonPanel = new TablePanel();
		add(rightButtonPanel, "hfill=fill, vfill=fill, halign=center"); // Column 3
		
		add(new Separator());  // Column 4
		
		startNewRow();
		
		Separator separator = new Separator();
		separator.setBackColor(Color.create(197, 197, 197));
		add(separator, "hfill=fill, vfill=fill, colspan=5");
		
		setNavigationStyle(NAVIGATION_STYLE_DEBUG);
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
	
	public void setTitle(String title){
		this.title = title;
		if( this.titleLabel != null ){
			this.titleLabel.setText(title);
		}
	}
	
	public void addLeftButton(Button button){
		if( leftButtons == null ){
			leftButtons = new ObjectArray();
		}
		leftButtons.add(button);
		
		leftButtonPanel.add(button,"halign=center");
	}
	
	public void addRightButton(Button button){
		if( rightButtons == null ){
			rightButtons = new ObjectArray();
		}
		rightButtons.add(button);
		
		rightButtonPanel.add(button,"halign=center");
	}
	
	public void setNavigationStyle(int navigationStyle){
		this.navigationStyle = navigationStyle;
		switch( navigationStyle ){
		case NAVIGATION_STYLE_DEBUG:
			titleLabel.setBackColor(Colors.Red);
			leftButtonPanel.setBackColor(Colors.LightBlue);
			rightButtonPanel.setBackColor(Colors.LightBlue);
			break;
		case NAVIGATION_STYLE_BLACK:
			setBackColor(Colors.Black);
			titleLabel.setForeColor(Colors.CadetBlue);
			break;
		case NAVIGATION_STYLE_WHITE:
			setBackColor(Color.create(239, 239, 239));
			titleLabel.setForeColor(Colors.Black);
			break;
		}
	}

}
