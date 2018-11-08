/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.server.blocklyprop.config;


import com.adamlewis.guice.persist.jooq.JooqPersistModule;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.parallax.server.blocklyprop.db.utils.DataSourceSetup;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.jooq.SQLDialect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author Michel
 */
public class PersistenceModule extends AbstractModule {

    /**
     * Application logging connector
     */
    private final Logger LOG = LoggerFactory.getLogger(PersistenceModule.class);

    
    /**
     * Application configuration settings
     */
    private final Configuration configuration;
    
    
    /**
     * Class constructor.
     * 
     * Set the local copy of the application configuration
     * 
     * @param configuration 
     */
    PersistenceModule(Configuration configuration) {
        LOG.info("Init persistence module");
        
        this.configuration = configuration;
        
        LOG.info("Configuration URL: {}", configuration.getString("cloudsession.baseurl"));
    }

    
    /**
     * Configure the injector
     */
    @Override
    protected void configure() {
            LOG.info("Installing new JooQPersist module");
            install(new JooqPersistModule());
            
            // Bind the DataSource interface to the PoolingDataSource implementation,
            // which is provided below.
            LOG.info("Binding Data source to Pooling Data source as EagerSingleton");
            bind(DataSource.class).to(PoolingDataSource.class).asEagerSingleton();
    }

    
    /**
     * Construct a pooling data source.
     * 
     * This is somewhat equivalent to a factory method
     * 
     * @return an instance of a PoolingDataSource
     * 
     * @throws ClassNotFoundException 
     */
    @Provides
    PoolingDataSource dataSource() throws ClassNotFoundException {

        PoolingDataSource ds = DataSourceSetup.connect(configuration);
        try {
            ds.getConnection();
        } catch (SQLException ex) {
            LOG.error("SQL exception detected while contacting database.");
            LOG.error("Message is: {}", ex.getMessage());
//            Logger.getLogger(PersistenceModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }

    @Provides
    public SQLDialect dialect() {
        return SQLDialect.valueOf(configuration.getString("database.dialect"));
    }

}
