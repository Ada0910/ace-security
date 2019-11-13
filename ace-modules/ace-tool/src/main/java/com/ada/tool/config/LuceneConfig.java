package com.ada.tool.config;

import com.ada.tool.search.dao.LuceneDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @ClassName:LuceneConfig
 * @author: Ada
 * @date 2019/11/13 16:17
 * @Description:
 */
@Configuration
public class LuceneConfig {

    @Value("${search.lucence.path}")
    private String lucencePath;

    @Bean
    public LuceneDao luceneUtil() throws IOException {
        LuceneDao luceneDao = new LuceneDao();
        luceneDao.setIndexDer(lucencePath);
        return luceneDao;
    }
}
