package com.fhoster.test.server;

import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;

import com.fhoster.livetable.client.datasource.proxyDataSource.LivetableServantKey;
import com.fhoster.livetable.servant.LiveTableServant;
import com.fhoster.livetable.servlet.LiveTableServlet;

public class _LivetableServlet extends LiveTableServlet {

    private static final long                       serialVersionUID = -3765475833011093474L;

    private final HashMap<String, LiveTableServant> servantMap       = new HashMap<String, LiveTableServant>();

    @Override
    public void init() {
        this.servantMap.put("lts001", LivetableServantFactory.getLinkLivetableServant());
    }

    public _LivetableServlet() {
        BasicConfigurator.configure();
    }

    @SuppressWarnings("rawtypes")
	@Override
    protected LiveTableServant getServant(final LivetableServantKey servantKey) {
        return this.servantMap.get(servantKey.getKey());
    }

}
