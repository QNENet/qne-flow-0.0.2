package com.vaadin.flow.server.osgi;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import jdk.nashorn.internal.ir.annotations.Reference;
import net.qnenet.qLogging.api.QLog;

@Component(immediate = true)
public class QServerOSGi {

	@Reference
	QLog qLog;
	
	private OSGiAccess osgiAccess;

	@Activate
	void activate(Map<String, Object> map) {
		
		osgiAccess = new OSGiAccess();

		qLog.logActivate(this);
	}

	@Deactivate
	void deactivate() {

		qLog.logDeactivate(this);
	}

}
