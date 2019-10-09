package configuration;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
 
public abstract class SessionManager {
   
    public static Session getSession() throws HibernateException{
        // Instancia un objeto del tipo Configuration
        Configuration config = new Configuration();
       
        // Registra las clases a mapear en la configuracion
        registerMappers(config);
       
        // Establece las propiedades de configuracion
        config.setProperties(getHibernateProperties() );
        
        // Retorna una sesion de trabajo
        return config.buildSessionFactory().openSession();
    }
   
    private static Properties getHibernateProperties(){
        // Instancia un objeto del tipo Properties.
        Properties props = new Properties();
       
        // Establece el driver de conexión dependiente del RDBMS.
            //para MySQL sería:  props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            //para Postgresql sería:  props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
            //Recordar importar el JDBC
        props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
       
        // Establece la url de conexión, donde al final va el nombre de la BD
            //para Mysql: props.put("hibernate.connection.url", "jdbc:mysql://localhost/testHibernate");
            //para Postgresql: props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/webservice");
        props.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/webservice");
               
        // Establece el usuario.
        props.put("hibernate.connection.username", "postgres");
       
        // Establece la clave.
        props.put("hibernate.connection.password", "12334");
       
        // Establece el dialecto a utilizar. Es necesario determinarlo ya que la implementación
        // de SQL puede variar con cada motor de base de datos.
            // Para MySQL sería: props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            // Para Postgresql sería: props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
         
        // Retorna las propiedades
        return props;
     
    }
   
    // Cada clase mapeada deberá aparecer aquí.
    private static void registerMappers(Configuration config) throws MappingException
    {
        //Clase mapeada Persona
        config.addResource("pojos/Persona.hbm.xml");
    }
 }
