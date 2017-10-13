package org.slf4j.impl;

import com.liferay.portal.kernel.log.Log;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

import java.io.Serializable;

/**
 * A wrapper over {@link Log com.liferay.portal.kernel.log.Log} in
 * conforming to the {@link Logger} interface.
 */
public final class LiferayLoggerAdapter extends MarkerIgnoringBase implements LocationAwareLogger, Serializable {

    final transient Log _log;

    /**
     * Following the pattern discussed in pages 162 through 168 of "The complete
     * log4j manual".
     */
    final static String FQCN = LiferayLoggerAdapter.class.getName();

    // Does the log4j version in use recognize the TRACE level?
    // The trace level was introduced in log4j 1.2.12.
    final boolean traceCapable;

    // WARN: LiferayLoggerAdapter constructor should have only package access so
    // that
    // only LiferayLoggerFactory be able to create one.
    LiferayLoggerAdapter(Log logger, final String name) {
        this._log = logger;
        this.name = name;
        traceCapable = isTraceCapable();
    }

    private boolean isTraceCapable() {
        try {
            _log.isTraceEnabled();
            return true;
        } catch (NoSuchMethodError e) {
            return false;
        }
    }

    /**
     * Is this logger instance enabled for the TRACE level?
     * 
     * @return True if this Logger is enabled for level TRACE, false otherwise.
     */
    public boolean isTraceEnabled() {
        if (traceCapable) {
            return _log.isTraceEnabled();
        } else {
            return _log.isDebugEnabled();
        }
    }

    /**
     * Log a message object at level TRACE.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void trace(String msg) {
        _log.trace(msg);
    }

    /**
     * Log a message at level TRACE according to the specified format and
     * argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for level TRACE.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void trace(String format, Object arg) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            _log.trace(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level TRACE according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the TRACE level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void trace(String format, Object arg1, Object arg2) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            _log.trace(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level TRACE according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the TRACE level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arguments
     *          an array of arguments
     */
    public void trace(String format, Object... arguments) {
        if (isTraceEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            _log.trace(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at level TRACE with an accompanying message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void trace(String msg, Throwable t) {
        _log.trace(msg, t);
    }

    /**
     * Is this logger instance enabled for the DEBUG level?
     * 
     * @return True if this Logger is enabled for level DEBUG, false otherwise.
     */
    public boolean isDebugEnabled() {
        return _log.isDebugEnabled();
    }

    /**
     * Log a message object at level DEBUG.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void debug(String msg) {
        _log.debug(msg);
    }

    /**
     * Log a message at level DEBUG according to the specified format and
     * argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for level DEBUG.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void debug(String format, Object arg) {
        if (_log.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            _log.debug(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level DEBUG according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the DEBUG level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void debug(String format, Object arg1, Object arg2) {
        if (_log.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            _log.debug(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level DEBUG according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the DEBUG level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arguments an array of arguments
     */
    public void debug(String format, Object... arguments) {
        if (_log.isDebugEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, arguments);
            _log.debug(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at level DEBUG with an accompanying message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void debug(String msg, Throwable t) {
        _log.debug(msg, t);
    }

    /**
     * Is this logger instance enabled for the INFO level?
     * 
     * @return True if this Logger is enabled for the INFO level, false otherwise.
     */
    public boolean isInfoEnabled() {
        return _log.isInfoEnabled();
    }

    /**
     * Log a message object at the INFO level.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void info(String msg) {
        _log.info(msg);
    }

    /**
     * Log a message at level INFO according to the specified format and argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void info(String format, Object arg) {
        if (_log.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            _log.info(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at the INFO level according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void info(String format, Object arg1, Object arg2) {
        if (_log.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            _log.info(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level INFO according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the INFO level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void info(String format, Object... argArray) {
        if (_log.isInfoEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            _log.info(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at the INFO level with an accompanying
     * message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void info(String msg, Throwable t) {
        _log.info(msg, t);
    }

    /**
     * Is this logger instance enabled for the WARN level?
     * 
     * @return True if this Logger is enabled for the WARN level, false otherwise.
     */
    public boolean isWarnEnabled() {
        return _log.isWarnEnabled();
    }

    /**
     * Log a message object at the WARN level.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void warn(String msg) {
        _log.warn(msg);
    }

    /**
     * Log a message at the WARN level according to the specified format and
     * argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void warn(String format, Object arg) {
        if (_log.isWarnEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            _log.warn(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at the WARN level according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void warn(String format, Object arg1, Object arg2) {
        if (_log.isWarnEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            _log.warn(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level WARN according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the WARN level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void warn(String format, Object... argArray) {
        if (_log.isWarnEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            _log.warn(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at the WARN level with an accompanying
     * message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void warn(String msg, Throwable t) {
        _log.warn(msg, t);
    }

    /**
     * Is this logger instance enabled for level ERROR?
     * 
     * @return True if this Logger is enabled for level ERROR, false otherwise.
     */
    public boolean isErrorEnabled() {
        return _log.isErrorEnabled();
    }

    /**
     * Log a message object at the ERROR level.
     * 
     * @param msg
     *          - the message object to be logged
     */
    public void error(String msg) {
        _log.error(msg);
    }

    /**
     * Log a message at the ERROR level according to the specified format and
     * argument.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg
     *          the argument
     */
    public void error(String format, Object arg) {
        if (_log.isErrorEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg);
            _log.error(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at the ERROR level according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param arg1
     *          the first argument
     * @param arg2
     *          the second argument
     */
    public void error(String format, Object arg1, Object arg2) {
        if (_log.isErrorEnabled()) {
            FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
            _log.error(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log a message at level ERROR according to the specified format and
     * arguments.
     * 
     * <p>
     * This form avoids superfluous object creation when the logger is disabled
     * for the ERROR level.
     * </p>
     * 
     * @param format
     *          the format string
     * @param argArray
     *          an array of arguments
     */
    public void error(String format, Object... argArray) {
        if (_log.isErrorEnabled()) {
            FormattingTuple ft = MessageFormatter.arrayFormat(format, argArray);
            _log.error(ft.getMessage(), ft.getThrowable());
        }
    }

    /**
     * Log an exception (throwable) at the ERROR level with an accompanying
     * message.
     * 
     * @param msg
     *          the message accompanying the exception
     * @param t
     *          the exception (throwable) to log
     */
    public void error(String msg, Throwable t) {
        _log.error(msg, t);
    }

    public void log(Marker marker, String callerFQCN, int level, String msg, Object[] argArray, Throwable t) {
        switch (level) {
        case LocationAwareLogger.TRACE_INT:
            _log.trace(msg, t);
            break;
        case LocationAwareLogger.DEBUG_INT:
            _log.debug(msg, t);
            break;
        case LocationAwareLogger.INFO_INT:
            _log.info(msg, t);
            break;
        case LocationAwareLogger.WARN_INT:
            _log.warn(msg, t);
            break;
        case LocationAwareLogger.ERROR_INT:
            _log.error(msg, t);
            break;
        default:
            throw new IllegalStateException("Level number " + level + " is not recognized.");
        }
    }

}
