Examples for Eclipse Communication Framework
============================================

[ECF](http://eclipse.org/ecf) is a framework for building distributed servers, applications, and tools. It provides a 
modular implementation of the `OSGi 4.2 Remote Services` standard, along with support for `REST-based` and `SOAP-based` 
remote services, and asynchronous messaging for remote services. 

This project contains some examples for ECF. This examples demos how use RemoteServices API, REST-based services, Datashare
ans SharedObject APIs and XMPP protocol. More info you can see on my blog: (http://samolisov.blogspot.com) (on Russian).

Examples Set contains:

* `o.e.e.e.bot.habr` -- Jabber Bot for [Habrahabr](http://habrahabr.ru). You should change JABBER-ID and JABBER-PASSWORD in 
the `plugin.xml` on your own jabber id/password.

* `o.e.e.e.datashare.*` -- Datashare API examples (Server and Client). You should change JABBER-* in Launch configs to your
own jabber ids/passwords

* `o.e.e.e.generic.server` -- Provides an instance of ECF Generic Server

* `o.e.e.e.hello` -- Provedes IHello interface which uses in Remote Services Examples

* `o.e.e.e.remoteservices.generic.host/client` -- Remote Services Host/Client via ECF Generic Server

* `o.e.e.e.remoteservices.generic.events.*` -- Distributed EventAdmin via ECF Generic Server

* `o.e.e.e.remoteservices.rest` -- Rest API Example, small Twitter API Client which uses XStream for deserialize 
Java objects from XML

* `o.e.e.e.remoteservices.rosgi.*` -- Remote Services Host/Client via R-OSGi

* `o.e.e.e.rosgi.*` -- OSGi 4.2 Remote Services Host/Client via R-OSGi. This bundles contains Launch configs
for SLP/Zeroconf/Zookeeper discovery providers demo.

* `o.e.e.e.sharedobject.*` -- SharedObject API Example. The `*.xml` bundles uses XStream for serialize/deserialize SharedObject
to/from XML.

