package net.qnenet.qLogging.api;

import java.security.GeneralSecurityException;

public interface QLog {

	void info(Object obj, String message);

	void verbose(Object obj, String string);

	void logActivate(Object obj);

	void logDeactivate(Object obj);

	void setVerbose(boolean bValue);
	
	void setActivateDeactivate(boolean bValue);

	void securityException(Object obj, String string, GeneralSecurityException e);

	void error(Object obj, String string);

	void connectFail(Object obj, String message);

	void needCode(Object obj, int i, String string);

}
