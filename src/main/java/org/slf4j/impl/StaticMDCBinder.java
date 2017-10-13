package org.slf4j.impl;

import org.slf4j.spi.MDCAdapter;

/**
 * This implementation is bound to {@link LiferayMDCAdapter}.
 */
public class StaticMDCBinder {

    /**
     * The unique instance of this class.
     */
    public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

    private StaticMDCBinder() {
    }

    /**
     * Currently this method always returns an instance of
     * {@link StaticMDCBinder}.
     */
    public MDCAdapter getMDCA() {
        return new LiferayMDCAdapter();
    }

    public String getMDCAdapterClassStr() {
        return LiferayMDCAdapter.class.getName();
    }
}
