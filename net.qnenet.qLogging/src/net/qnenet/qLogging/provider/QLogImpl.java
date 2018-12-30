package net.qnenet.qLogging.provider;

import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.Map;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import net.qnenet.qLogging.api.QLog;

@Component(immediate=true)
public class QLogImpl implements QLog {
	
//	@Reference
//	QSystemInitialize init;

	private boolean verbose = false;
	private boolean activateDeactivate = false;
	

	
	@Activate
	void activate(Map<String, Object> map) {
		
		Security.addProvider(new BouncyCastleProvider());
		

		logActivate(this);
	}

	@Deactivate
	void deactivate() {
		logDeactivate(this);
	}
	



	@Override
	public void info(Object obj, String message) {
//		System.out.println("[INFO] " + message + " : " + obj.getClass().getSimpleName() );
		System.out.println("[INFO] " + obj.getClass().getSimpleName() + " : " + message);
	}
	
	@Override
	public void error(Object obj, String message) {
//		System.out.println("[ERROR] " + message + " : " + obj.getClass().getSimpleName() );
		System.out.println("ERROR] " + obj.getClass().getSimpleName() + " : " + message);
	}

	@Override
	public void connectFail(Object obj, String message) {
		System.out.println("[CONNECT FAIL] " + message + " : " + obj.getClass().getSimpleName() );
	}

	
	@Override
	public void needCode(Object obj, int lineNumber, String message) {
		System.out.println("[NEED CODE] " + message + " : " + obj.getClass().getSimpleName() + "line number -> " + lineNumber);
	}

	@Override
	public void logActivate(Object obj) {
		
		setActivateDeactivate(true);
		setVerbose(true);

		if (activateDeactivate) {
			info(obj, "Hello");
		}
	}

	@Override
	public void logDeactivate(Object obj) {
		if (activateDeactivate) {
			info(obj, "Goodbye");
		}
	}

	@Override
	public void verbose(Object obj, String message) {
		if (verbose) {
			System.out.println("[INFO] " + obj.getClass().getSimpleName() + " -> " + message);
		}
	}

	@Override
	public void setVerbose(boolean bValue) {
		verbose = bValue;
	}

	@Override
	public void setActivateDeactivate(boolean bValue) {
		activateDeactivate = bValue;

	}

	@Override
	public void securityException(Object obj, String message, GeneralSecurityException e) {
		System.out.println("[ERROR] " + obj.getClass().getSimpleName() + " -> " + message);
		e.printStackTrace();
	}




}
