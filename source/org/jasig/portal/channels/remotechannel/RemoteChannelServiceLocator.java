/**
 * Copyright � 2002 The JA-SIG Collaborative.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. Redistributions of any form whatsoever must retain the following
 *    acknowledgment:
 *    "This product includes software developed by the JA-SIG Collaborative
 *    (http://www.jasig.org/)."
 *
 * THIS SOFTWARE IS PROVIDED BY THE JA-SIG COLLABORATIVE "AS IS" AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE JA-SIG COLLABORATIVE OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package org.jasig.portal.channels.remotechannel;

import org.apache.axis.client.Service;
import org.apache.axis.configuration.XMLStringProvider;
import org.apache.axis.deployment.wsdd.WSDDConstants;
import java.net.URL;
import javax.xml.rpc.ServiceException;

/**
 * RemoteChannelServiceLocator.java was originally generated by
 * WSDL2JAVA from Apache Axis.
 * @author Ken Weiner, kweiner@interactivebusiness.com
 * @version $Revision$
 */
public class RemoteChannelServiceLocator extends Service implements RemoteChannelService {

  // Use to get a proxy class for RemoteChannel - this is just a default value
  private final String RemoteChannel_address = "http://localhost:8080/uPortal/services/RemoteChannel";

  private static final String serviceName = "RemoteChannel";
  private static final String xmlConfiguration =
    "<deployment xmlns=\"http://xml.apache.org/axis/wsdd/\" xmlns:java=\"" + WSDDConstants.URI_WSDD_JAVA + "\">" +
    "  <handler type=\"java:org.apache.axis.handlers.SimpleSessionHandler\" name=\"SessionHandler\"/>" +
    "  <service name=\"" + serviceName + "\">" +
    "    <requestFlow><handler type=\"SessionHandler\"/></requestFlow>" +
    "    <responseFlow><handler type=\"SessionHandler\"/></responseFlow>" +
    "    <typeMapping xmlns:ns=\"http://http.servlet.javax\" qname=\"ns:Cookie\"" +
    "      type=\"java:javax.servlet.http.Cookie\"" +
    "      serializer=\"org.jasig.portal.webservices.ser.CookieSerializerFactory\"" +
    "      deserializer=\"org.jasig.portal.webservices.ser.CookieDeserializerFactory\"" +    
    "      encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"/>" +
    "    <typeMapping xmlns:ns=\"urn:RemoteChannel\" qname=\"ns:ArrayOf_tns3_Cookie\"" +
    "      type=\"java:javax.servlet.http.Cookie[]\"" +
    "      serializer=\"org.apache.axis.encoding.ser.ArraySerializerFactory\"" +
    "      deserializer=\"org.apache.axis.encoding.ser.ArrayDeserializerFactory\"" +    
    "      encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"/>" +    
    "    <typeMapping xmlns:ns=\"urn:RemoteChannel\" qname=\"ns:PortalEvent\"" +
    "      type=\"java:org.jasig.portal.PortalEvent\"" +
    "      serializer=\"org.jasig.portal.webservices.ser.PortalEventSerializerFactory\"" +
    "      deserializer=\"org.jasig.portal.webservices.ser.PortalEventDeserializerFactory\"" +    
    "      encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"/>" +
    "  </service>" +
    "  <transport name=\"http\" pivot=\"java:org.apache.axis.transport.http.HTTPSender\"/>" +
    "</deployment>";
  private static XMLStringProvider configProvider = new XMLStringProvider(xmlConfiguration);

  // Constructor
  public RemoteChannelServiceLocator() {
    super(configProvider);
  }

  public String getRemoteChannelAddress() {
    return RemoteChannel_address;
  }

  public RemoteChannel getRemoteChannel() throws ServiceException {
    URL endpoint;
    try {
      endpoint = new java.net.URL(RemoteChannel_address);
    } catch (java.net.MalformedURLException e) {
      return null; // unlikely as URL was validated in WSDL2Java
    }
    return getRemoteChannel(endpoint);
  }

  public RemoteChannel getRemoteChannel(URL portAddress) throws ServiceException {
    try {
      return new RemoteChannelSoapBindingStub(portAddress, this);
    } catch (org.apache.axis.AxisFault e) {
      return null; // ???
    }
  }
}
