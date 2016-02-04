package inbusiness.space.webapp.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fer on 23/06/2015.
 */
@Configuration
public class MongoDbConfiguration extends AbstractMongoConfiguration {

    @Resource
    private Environment environment;


    public enum TimestampToDateConverter implements Converter<Timestamp, Date> {
        INSTANCE;

        private TimestampToDateConverter() {
        }

        public Date convert(Timestamp source) {
            if (source==null) {
                return null;
            }
            return new Date(source.getTime());
        }
    }

    public enum DateToTimestampConverter implements Converter<Date, Timestamp> {
        INSTANCE;

        private DateToTimestampConverter() {
        }

        public Timestamp convert(Date source) {
            if (source==null) {
                return null;
            }
            return new Timestamp(source.getTime());
        }
    }


    @Bean
    public CustomConversions customConversions() {
        List<Converter> converterList = new ArrayList<>();
        converterList.add(TimestampToDateConverter.INSTANCE);
        converterList.add(DateToTimestampConverter.INSTANCE);
        return  new CustomConversions(converterList);
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(this.mongoDbFactory());
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, this.mongoMappingContext());
        converter.setCustomConversions(this.customConversions());
        converter.setMapKeyDotReplacement(">");
        return converter;
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    protected String getDatabaseName() {
        return environment.getProperty("spring.data.mongodb.database.name"); // "meanmyworld";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(environment.getProperty("spring.data.mongodb.database.host")); // "127.0.0.1"
    }

}
