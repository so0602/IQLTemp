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
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;

public class NavigationPanel extends TablePanel implements ContainerListener {
	private Label titleLabel;
	private TablePanel leftButtonPanel;
	private TablePanel rightButtonPanel;
	
	private ObjectArray leftButtons;
	private ObjectArray rightButtons;
	
	public String title;
	
	//private int navigationStyle;
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
		
		setBackColor(Colors.Black);
		setRowHeight(0, Sizing.PIXELS, 44);
		setColumnWidth(0, Sizing.PERCENTS, 25);
		setColumnWidth(1, Sizing.PERCENTS, 50);
		setColumnWidth(2, Sizing.PERCENTS, 25);
		
		leftButtonPanel = new TablePanel();
		leftButtonPanel.setColumnWidth(0, Sizing.PIXELS, 12);
		leftButtonPanel.setColumnWidth(1, Sizing.PREFERRED, 1);		
		leftButtonPanel.setRowHeight(0, Sizing.PREFERRED, 1);	
		add(leftButtonPanel, "hfill=fill, vfill=fill"); // Column 0
		
		titleLabel = new Label();
		titleLabel.setText(title);
		titleLabel.setHorizontalAlignment(HorizontalAlignmentType.CENTER);
		add(titleLabel,"hfill=fill,halign=center");  // Column 1
		
		rightButtonPanel = new TablePanel();
		rightButtonPanel.setColumnWidth(0, Sizing.PREFERRED, 1);		
		rightButtonPanel.setColumnWidth(1, Sizing.PIXELS, 12);												
		rightButtonPanel.setRowHeight(0, Sizing.PREFERRED, 1);
		add(rightButtonPanel, "hfill=fill, vfill=fill"); // Column 2		
		
		setNavigationStyle(NAVIGATION_STYLE_BLACK);
		
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
		leftButtonPanel.add(new Separator());		
		leftButtonPanel.add(button,"halign=left, valign=center");
	}
	
	public void addRightButton(Button button){
		if( rightButtons == null ){
			rightButtons = new ObjectArray();
		}
		rightButtons.add(button);			
		rightButtonPanel.add(button,"halign=right, valign=center");
		rightButtonPanel.add(new Separator());		
	}
	
	
	public void setNavigationStyle(int navigationStyle){
		//this.navigationStyle = navigationStyle;
		switch( navigationStyle ){
		case NAVIGATION_STYLE_DEBUG:
			titleLabel.setBackColor(Colors.Red);
			leftButtonPanel.setBackColor(Colors.LightBlue);
			rightButtonPanel.setBackColor(Colors.Blue);
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
