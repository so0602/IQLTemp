package iqltemp;

import com.antennasoftware.api.ui.Font;
import com.antennasoftware.api.ui.collections.ObjectMap;
import com.antennasoftware.api.ui.styles.ContainerStyleListener;
import com.antennasoftware.api.ui.styles.Style;

public class DefaultStyle extends Style implements ContainerStyleListener {
	private ObjectMap fonts;
	
	public Font transactionsTitleFont;
	public Font transactionsListTitleFont;
	public Font transactionsHeaderTitleFont;

	public DefaultStyle() {
		this.addListener(this);
		// TODO Auto-generated constructor stub
	}

	public void onStyleCreation(Style style) {
		// TODO Auto-generated method stub
		fonts = new ObjectMap();
		
		transactionsTitleFont = getBoldFont(16);
		transactionsListTitleFont = getFont(11);
		transactionsHeaderTitleFont = getFont(12);
	}

	protected void destroy() {
		this.removeListener(this);
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	public Font getFont(int fontSize, boolean isBold){
		String fontFamily = getFont().getFamily();
		String key = fontFamily + ":" + fontSize + ":" + (isBold ? "Bold" : "Normal");
		Font font = (Font)fonts.getValue(key);
		if( font == null ){
			font = new Font();
			font.setFamily(fontFamily);
			font.setSize(fontSize);
			if( isBold ){
				font.setBold();
			}
			fonts.putValue(key, font);
		}
		return font;
	}
	
	public Font getFont(int fontSize){
		return getFont(fontSize, false);
	}
	
	public Font getBoldFont(int fontSize){
		return getFont(fontSize, true);
	}

}
