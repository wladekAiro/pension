package com.wladek.pension.common;

import com.wladek.pension.TestConfiguration;
import com.mysql.jdbc.Driver;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.tool.hbm2ddl.DatabaseMetadata;
import org.hibernate.tool.hbm2ddl.SchemaUpdateScript;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Keeun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class HibernateSchemaGeneratorTest {

    @Autowired DataSource dataSource;
    Configuration cfg;
    MySQL5Dialect dialect = new MySQL5Dialect();

    @Before
    public void setup() {
        cfg = new Configuration();
        cfg.setProperty("hibernate.dialect", MySQL5Dialect.class.getName());
        cfg.setProperty("hibernate.connection.driver_class", Driver.class.getName());
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/pensiondb");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "teresa");
        cfg.setNamingStrategy(new org.hibernate.cfg.ImprovedNamingStrategy());
    }

    @Test
    @Ignore
    public void createSchema() throws SQLException {
        String[] sqls = cfg.generateSchemaCreationScript(dialect);
        for(String sql : sqls) {
            System.out.println(sql);
        }
    }

    @Test
    @Ignore
    public void updateSchema() throws SQLException {
        DatabaseMetadata meta = new DatabaseMetadata(dataSource.getConnection(), dialect, cfg);
        List<SchemaUpdateScript> scripts = cfg.generateSchemaUpdateScriptList(dialect, meta);
        for(SchemaUpdateScript script : scripts) {
            System.out.println(script.getScript());
        }
    }

}
