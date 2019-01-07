package org.martseniuk.diploma.bar.service.impl;

import org.martseniuk.diploma.bar.entity.Message;
import org.martseniuk.diploma.bar.repository.BarRepository;
import org.martseniuk.diploma.bar.service.BarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Implementation of bar service.
 *
 * @author Roman_Martseniuk
 */
@Service
public class BarServiceImpl implements BarService {

    private static final Logger LOG = LoggerFactory.getLogger(BarServiceImpl.class);

    private String message;

    @Autowired
    private BarRepository barRepository;

    public BarServiceImpl(@Value("${bar.message}") String message) {
        this.message = message;
    }

    public void updateSetting(String setting) {
        barRepository.save(new Message(setting));
        this.message = setting;
    }

    public String getMessage() {
        return message + " " + getLocalHost();
    }

    private String getLocalHost() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            LOG.error("Unknown host", e);
            return "unknown host";
        }
    }
}
