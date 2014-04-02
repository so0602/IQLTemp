package iqltemp;


import iqltemp.gen.IQLTemp;
import com.antennasoftware.api.ui.ApplicationListener;
import com.antennasoftware.api.application.services.ErrorSourceListener;
import com.antennasoftware.api.application.services.Log;
import com.antennasoftware.api.ui.collections.PushedData;
import com.antennasoftware.api.ui.styles.StyleReceptor;
import com.antennasoftware.api.application.services.ErrorSource;
import com.antennasoftware.api.application.error.Error;

public class IqltempApplication extends IQLTemp implements ApplicationListener,
		ErrorSourceListener {
	
	private Log log = null;
	private DefaultStyle style = null;
	
	public IqltempApplication() {
		super();
		this.addListener(this);
	}

	public void onApplicationStyleSetup(StyleReceptor _style) {
		style = new DefaultStyle();
		_style.applyVisualStyle(style);
	}

	public void onDayChanged() {
	}

	public void onDeselect() {
	}

	public void onLoggedIn() {
	}

	public void onLoggedOut(int code) {
	}

	public void onLoginCompleted(String message) {
	}

	public void onLoginFailed(int error, String message) {
	}

	public void onLoginStarting() {
	}

	public void onSelect() {
	}

	public void onSleep() {
	}

	public void onStart(PushedData pushedData) {
		MainScreen screen = new MainScreen();
		screen.push(1, false);
	}

	public void onStop() {
	}

	public void onUserChanged() {
	}

	public void onUserInactivity() {
	}

	public void onWakeUp() {
	}

	public void onError(ErrorSource source, Error error) {
	}
	
	public void log(String strClass, String strMethod, String strLog){
		if( log == null ){
			log = getLog();
		}
		log.log(Log.INFO, "[" + strClass + "::" + strMethod + "] - " + strLog);
	}
	
	public DefaultStyle getStyle(){
		return style;
	}
}