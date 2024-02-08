package com.alexsobiek.terranova.network;

import com.alexsobiek.terranova.network.api.INetwork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Network implements INetwork {
    private static final Logger LOGGER = LoggerFactory.getLogger(Network.class);


    public static Logger getLogger() {
        return LOGGER;
    }
}
