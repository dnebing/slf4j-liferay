package org.slf4j.impl;

import org.slf4j.spi.MDCAdapter;

import java.util.Map;

/**
 * This adapter is an empty implementation of the {@link MDCAdapter} interface.
 * Since Liferay logging does not support mapped
 * diagnostic contexts such as JDK14, simple and NOP.
 *
 * @author dnebinger
 */
public class LiferayMDCAdapter implements MDCAdapter {

    public void clear() {
    }

    public String get(String key) {
        return null;
    }

    public void put(String key, String val) {
    }

    public void remove(String key) {
    }

    public Map<String, String> getCopyOfContextMap() {
        return null;
    }

    public void setContextMap(Map<String, String> contextMap) {
        // NOP
    }
}
