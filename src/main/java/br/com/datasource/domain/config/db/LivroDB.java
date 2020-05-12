package br.com.datasource.domain.config.db;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.datasource.domain.model.book.Livro;
import br.com.datasource.domain.repository.book.Livros;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "livroEntityManagerFactory", transactionManagerRef = "livroTransactionManager", basePackageClasses = { Livros.class })
public class LivroDB {
	
	@Bean(name = "livroDataSource")
	@ConfigurationProperties(prefix = "spring.livro.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "livroEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean livroEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("livroDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		return builder.dataSource(dataSource).properties(properties).packages(Livro.class).persistenceUnit("datasource02PU").build();
	}

	@Bean(name = "livroTransactionManager")
	public PlatformTransactionManager livroTransactionManager(@Qualifier("livroEntityManagerFactory") EntityManagerFactory livroEntityManagerFactory) {
		return new JpaTransactionManager(livroEntityManagerFactory);
	}

}
