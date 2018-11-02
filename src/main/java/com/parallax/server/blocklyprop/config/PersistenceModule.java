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

//import java.util.logging.Level;
//import java.util.logging.Logger;
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

    private final Configuration configuration;

    PersistenceModule(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    protected void configure() {
        try {
        install(new JooqPersistModule());
//        install(new JooqPersistModule());
        bind(DataSource.class).to(PoolingDataSource.class).asEagerSingleton();
        }
        catch (Exception ex) {
            LOG.error("Trapped an unhandled exception while binding to database connection.");
        }
    }

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
