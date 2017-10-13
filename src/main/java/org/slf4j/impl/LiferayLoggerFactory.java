package org.slf4j.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * LiferayLoggerFactory is an implementation of {@link ILoggerFactory} returning
 * the appropriate named {@link LiferayLoggerAdapter} instance.
 */
public class LiferayLoggerFactory implements ILoggerFactory {

    // key: name (String), value: a LiferayLoggerAdapter;
    ConcurrentMap<String, Logger> loggerMap;

    public LiferayLoggerFactory() {
        loggerMap = new ConcurrentHashMap<String, Logger>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.slf4j.ILoggerFactory#getLogger(java.lang.String)
     */
    public Logger getLogger(String name) {
        Logger slf4jLogger = loggerMap.get(name);
        if (slf4jLogger != null) {
            return slf4jLogger;
        } else {
            Log liferayLogger = LogFactoryUtil.getLog(name);

            Logger newInstance = new LiferayLoggerAdapter(liferayLogger, name);
            Logger oldInstance = loggerMap.putIfAbsent(name, newInstance);
            return oldInstance == null ? newInstance : oldInstance;
        }
    }
}
