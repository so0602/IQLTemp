package iqltemp.Reusable.UIControl;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;
import iqltemp.listeners.OnSegmentSelectedListener;

import com.antennasoftware.api.ui.Background;
import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.HorizontalAlignmentType;
import com.antennasoftware.api.ui.Screen;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.collections.ObjectArray;
import com.antennasoftware.api.ui.control.BackgroundButton;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.platform.Image;
import com.antennasoftware.api.ui.styles.BackgroundButtonStyle;
import com.antennasoftware.api.ui.styles.SelectableControlStyle;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.core.foundation.config.Element;
import com.antennasoftware.core.ui.control.ControlActionListener;

public class SegmentPanel extends TablePanel implements ContainerListener,ControlActionListener {

//	private RadioGroup rGroup = new RadioGroup();
	private IqltempApplication application = (IqltempApplication)getApplication();
	private DefaultStyle style = application.getStyle();	
	private int width;
	
	public ObjectArray dataSources;
	private OnSegmentSelectedListener listener;
	private ObjectArray buttonArray = new ObjectArray();
	
	public SegmentPanel() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
		this._I_TablePanel();
	}
	
	public SegmentPanel(ObjectArray objectArray,int width,OnSegmentSelectedListener listener) {
		this.listener = listener;
		this.dataSources = objectArray;
		this.width = width;
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
		setColumnWidth(0, Sizing.PIXELS, 12);
		add(new Separator());
		for (int i = 0; i < dataSources.size();i++) {
			setColumnWidth(i+1, Sizing.PIXELS, (width-24)/dataSources.size());
			BackgroundButton backgroundButton = backgroundButton((String)dataSources.getItem(i));			
			add(backgroundButton, "hfill=fill,vfill=fill,valign=center");
			buttonArray.add(backgroundButton);					
		}
		refreshSegmentControl((BackgroundButton)buttonArray.getItem(0));
		//setColumnWidth(1, Sizing.PIXELS, width-24);		
		//setColumnWidth(2, Sizing.PIXELS, 12);
		
		//add(rGroup(), "hfill=fill,vfill=fill");
		//add(new Separator());
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
	
	//================================================================================
    // Private
    //================================================================================
	
//	private RadioGroup rGroup() {
//		rGroup.setBackColor(Colors.Red);
//		for (int i = 0; i < dataSources.size();i++) {
//			rGroup.addButton(toolBarButton((String)dataSources.getItem(i), null, null));
//		}
//					
//		return rGroup;
//	}

	private BackgroundButton backgroundButton(String title) {
		BackgroundButton backgroundButton = new BackgroundButton();
		backgroundButton.setText(title);
		backgroundButton.addListener(this);
		backgroundButton.setHorizontalTextAlignment(HorizontalAlignmentType.CENTER);
		backgroundButton.setFont(style.getFont(13));
		
		return backgroundButton;		
	}
	
	private void refreshSegmentControl(BackgroundButton selectedButton) {
		for (int i = 0; i < buttonArray.size(); i++) {
			BackgroundButton button = (BackgroundButton)buttonArray.getItem(i);
			if (button==selectedButton) {
				button.setForeColor(Colors.White);
				button.setBackColor(Color.create(34, 190, 220));
			} else {
				button.setForeColor(Color.create(34, 190, 220));
				button.setBackground(Background.createColorRectangleBackground(Colors.Transparent));
			}
		}
	}
	
//	private ToolBarButton toolBarButton(String title, Image defaultImage, Image selectedImage) {
//	ToolBarButton newButton = new ToolBarButton();
//	newButton.setText(title);
//	newButton.setVerticalSpacing(6);
//	newButton.setLeftSpacing(8);
//	newButton.setRightSpacing(8);
//	newButton.setFont(style.getFont(13));
//	newButton.setForeColor(Color.create(34, 190, 220));
//	newButton.setSelectedForeColor(Colors.White);
//	newButton.setFocusedForeColor(Colors.White);		
//	newButton.setBackground(Background.createColorRectangleBackground(Colors.Transparent));
//	newButton.setSelectedBackground(Background.createColorRectangleBackground(Color.create(34, 190, 220)));
//	newButton.setFocusedBackground(Background.createColorRectangleBackground(Color.create(34, 190, 220)));			
//
//	return newButton;		
//}		

	//================================================================================
    // ControlActionListener
    //================================================================================	
	
	public void onClick(Control c) {
		// TODO Auto-generated method stub
		refreshSegmentControl((BackgroundButton)c);
		listener.onSegmentSelected(c);
	}

	public void onFocusGained(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusLost(Control c) {
		// TODO Auto-generated method stub
		
	}		
	
	
}
