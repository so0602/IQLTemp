package iqltemp.Utilities;

import com.antennasoftware.api.ui.Device;
import com.antennasoftware.api.ui.Font;
import com.antennasoftware.api.ui.collections.ObjectArray;
import com.antennasoftware.api.ui.control.Label;

final public class Utilities {
	final public static int SCREEN_ORIENTATION_PORTRAIT = 0;
	final public static int SCREEN_ORIENTATION_LANDSCAPE = 1;
	
	public static boolean isPortrait(int orientation){
		boolean isPortrait = true;
		switch( orientation ){
		case Device.SCREEN_ORIENTATION_0_DEGREES:
		case Device.SCREEN_ORIENTATION_180_DEGREES:
			break;
		case Device.SCREEN_ORIENTATION_90_DEGREES:
		case Device.SCREEN_ORIENTATION_270_DEGREES:
			isPortrait = false;
			break;
		}
		return isPortrait;
	}
	
	public static boolean isLandscape(int orientation){
		boolean isLandscape = true;
		switch( orientation ){
		case Device.SCREEN_ORIENTATION_0_DEGREES:
		case Device.SCREEN_ORIENTATION_180_DEGREES:
			isLandscape = false;
			break;
		case Device.SCREEN_ORIENTATION_90_DEGREES:
		case Device.SCREEN_ORIENTATION_270_DEGREES:
			break;
		}
		return isLandscape;
	}
	
	public static boolean addObject(ObjectArray objects, Object object){
		boolean success = objects.contains(object);
		if( !success ){
			objects.add(object);
		}
		return success;
	}
	
	public static boolean removeObject(ObjectArray objects, Object object){
		boolean success = objects.contains(object);
		if( success ){
			objects.remove(object);
		}
		return success;
	}
	
	public static int getLabelHeight(Label label, int maxNumberOfLines, int maxWidth){
		Font font = label.getFont();
		int height = 0;
		int wrappedTextHeight = font.getWrappedTextHeight(label.getText(), maxWidth) + 2;
		if( maxNumberOfLines == 0 ){
			height = wrappedTextHeight;
		}else{
			int fontHeight = (font.getSize() + 2) * maxNumberOfLines;
			height = wrappedTextHeight > fontHeight ? fontHeight : wrappedTextHeight;
		}
		return height;
	}
}
