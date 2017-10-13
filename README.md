# README

The slf4j-liferay project provides and SLF4J binding to the Liferay core logging.  Yeah, I know,
Liferay logging is itself a bridge over top of log4j, so why do we need an SLF4J binding to
Liferay logging then?

Well, I'm working on trying to add OSGi Subsystems support to Liferay, but the reference
implementation from Apache Aries has an OSGi dependency on SLF4J, so this in turn will require
some sort of SLF4J binding so the Subsystems can log stuff.

Well, since Subsystems logging, to me, is part of the core Liferay OSGi container, I want them
to log where Liferay would end up logging all OSGi messages, and that's the Liferay log.

And that's why I needed an SLF4J binding for the Liferay logging facilities.

To use this guy, just build the jar and drop it in the Liferay deploy folder.

It will install but will not be active until you drop the slf4j-api-1.7.12 jar into the Liferay deploy folder too.

