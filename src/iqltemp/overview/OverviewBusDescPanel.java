package iqltemp.overview;

import iqltemp.DefaultStyle;
import iqltemp.IqltempApplication;

import com.antennasoftware.api.ui.Background;
import com.antennasoftware.api.ui.Color;
import com.antennasoftware.api.ui.Colors;
import com.antennasoftware.api.ui.Container;
import com.antennasoftware.api.ui.ContainerListener;
import com.antennasoftware.api.ui.HorizontalAlignmentType;
import com.antennasoftware.api.ui.Sizing;
import com.antennasoftware.api.ui.VerticalAlignmentType;
import com.antennasoftware.api.ui.Widget;
import com.antennasoftware.api.ui.control.Button;
import com.antennasoftware.api.ui.control.Control;
import com.antennasoftware.api.ui.control.Label;
import com.antennasoftware.api.ui.control.RichLabel;
import com.antennasoftware.api.ui.control.Separator;
import com.antennasoftware.api.ui.panel.HorizontalPanel;
import com.antennasoftware.api.ui.panel.TablePanel;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.core.ui.control.ControlActionListener;

public class OverviewBusDescPanel extends TablePanel implements
		ContainerListener, ControlActionListener {
	private IqltempApplication application;
	private DefaultStyle style;
	
	private RichLabel websiteLabel;
	private RichLabel subsidiariesLabel;
	private RichLabel employeesLabel;
	
	private RichLabel incorporatedLabel;
	private RichLabel headquartersLabel;
	private RichLabel industryLabel;
	
	private Label descrptionLabel;
	
	private Button expandButton;
	public boolean isExpand;

	public OverviewBusDescPanel() {
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
		setRowHeight(2, Sizing.PIXELS, 16);
		setRowHeight(4, Sizing.PIXELS, 16);
		setRowHeight(5, Sizing.PREFERRED, 1);
		
		setColumnWidth(0, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
		setColumnWidth(1, Sizing.PIXELS, 268);
		setColumnWidth(2, Sizing.PIXELS, 35);
		setColumnWidth(3, Sizing.PIXELS, 268);
		setColumnWidth(4, Sizing.PIXELS, 28);
		setColumnWidth(5, Sizing.PIXELS, OverviewPanel.OVERVIEW_GAPWIDTH);
		
		Separator separator = new Separator();
		separator.setBackColor(Color.create(240, 240, 240));
		add(separator, "hfill=fill, vfill=fill");
		
		Label titleLabel = new Label();
		titleLabel.setText("BUSINESS DESCRIPTION");
		titleLabel.setFont(style.getBoldFont(13));
		titleLabel.setBackColor(Color.create(240, 240, 240));
		add(titleLabel, "hfill=fill, vfill=fill, colspan=5");
		startNewRow();
		
		separator = new Separator();
		separator.setBackColor(Color.create(227, 227, 227));
		add(separator, "hfill=fill, vfill=fill, colspan=6");
		startNewRow();
		
		add(new Separator(), "hfill=fill, vfill=fill, colspan=6");
		startNewRow();
		
		add(new Separator());
		
		TablePanel leftTablePanel = new TablePanel();
		{
			leftTablePanel.setColumnWidth(0, Sizing.PIXELS, 100);
			
			titleLabel = new Label();
			titleLabel.setText("Website");
			titleLabel.setFont(style.getFont(13));
			leftTablePanel.add(titleLabel);
			
			websiteLabel = new RichLabel();
			websiteLabel.setText("www.apple.com");
			websiteLabel.setFont(style.getBoldFont(12));
			leftTablePanel.add(websiteLabel, "hfill=fill, vfill=fill");
			leftTablePanel.startNewRow();
			
			titleLabel = new Label();
			titleLabel.setText("Subsidiaries");
			titleLabel.setFont(style.getFont(13));
			leftTablePanel.add(titleLabel);
			
			subsidiariesLabel = new RichLabel();
			subsidiariesLabel.setText("214");
			subsidiariesLabel.setFont(style.getBoldFont(12));
			leftTablePanel.add(subsidiariesLabel, "hfill=fill, vfill=fill");
			leftTablePanel.startNewRow();
			
			titleLabel = new Label();
			titleLabel.setText("Employees");
			titleLabel.setFont(style.getFont(13));
			leftTablePanel.add(titleLabel);
			
			employeesLabel = new RichLabel();
			employeesLabel.setText("97,389");
			employeesLabel.setFont(style.getBoldFont(12));
			leftTablePanel.add(employeesLabel, "hfill=fill, vfill=fill");
			leftTablePanel.startNewRow();
		}
		add(leftTablePanel, "hfill=fill, vfill=fill");
		
		add(new Separator());
		
		TablePanel rightTablePanel = new TablePanel();
		{
			rightTablePanel.setColumnWidth(0, Sizing.PIXELS, 100);
			
			titleLabel = new Label();
			titleLabel.setText("Incorporated");
			titleLabel.setFont(style.getFont(13));
			titleLabel.setVerticalAlignment(VerticalAlignmentType.TOP);
			rightTablePanel.add(titleLabel,"hfill=fill, vfill=fill");
			
			incorporatedLabel = new RichLabel();
			incorporatedLabel.setText("1999");
			incorporatedLabel.setFont(style.getBoldFont(12));
			incorporatedLabel.setNumberOfLines(2);
			incorporatedLabel.setWidthType(Sizing.PIXELS, 168);
			
			rightTablePanel.add(incorporatedLabel, "hfill=fill, vfill=fill");
			rightTablePanel.startNewRow();
			
			titleLabel = new Label();
			titleLabel.setText("Headquarters");
			titleLabel.setFont(style.getFont(13));
			titleLabel.setVerticalAlignment(VerticalAlignmentType.TOP);
			rightTablePanel.add(titleLabel,"hfill=fill, vfill=fill");
			
			headquartersLabel = new RichLabel();
			headquartersLabel.setText("111 Street, New York USA");
			headquartersLabel.setFont(style.getBoldFont(12));
			headquartersLabel.setNumberOfLines(3);
			headquartersLabel.setWidthType(Sizing.PIXELS, 168);
			rightTablePanel.add(headquartersLabel, "hfill=fill, vfill=fill");
			rightTablePanel.startNewRow();
			
			titleLabel = new Label();
			titleLabel.setText("Industry");
			titleLabel.setFont(style.getFont(13));
			titleLabel.setVerticalAlignment(VerticalAlignmentType.TOP);
			rightTablePanel.add(titleLabel,"hfill=fill, vfill=fill");
			
			industryLabel = new RichLabel();
			industryLabel.setText("Computer Hardware");
			industryLabel.setFont(style.getBoldFont(12));
			industryLabel.setNumberOfLines(2);
			industryLabel.setWidthType(Sizing.PIXELS, 168);
			rightTablePanel.add(industryLabel, "hfill=fill, vfill=fill");
			rightTablePanel.startNewRow();
		}
		add(rightTablePanel, "hfill=fill, vfill=fill");
		
		expandButton = new Button();
		expandButton.setText(" ");
		expandButton.addListener(this);
		add(expandButton, "hfill=fill, vfill=fill");
		startNewRow();
		
		add(new Separator(), "hfill=fill, vfill=fill, colspan=6");
		startNewRow();
		
		add(new Separator());
		
		descrptionLabel = new Label();
		descrptionLabel.setText("Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. Apple Inc., together with subsidiaries, designs, manufactures, and markets mobile communication and media devices, personal computing products, and portable digital music players worldwide. ");
		descrptionLabel.setVisible(isExpand);
		add(descrptionLabel,"hfill=fill, vfill=fill, colspan=4");
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

	public void onClick(Control c) {
		// TODO Auto-generated method stub
		if( c.equals(this.expandButton) ){
			isExpand = !isExpand;
			descrptionLabel.setVisible(isExpand);
		}
	}

	public void onFocusGained(Control c) {
		// TODO Auto-generated method stub
		
	}

	public void onFocusLost(Control c) {
		// TODO Auto-generated method stub
		
	}

}
