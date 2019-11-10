package com.ada.tool.dao;

import com.ada.api.vo.search.IndexObject;
import com.ada.common.response.TableResultResponse;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ada
 * @ClassName :LuceneDao
 * @date 2019/11/10 13:53
 * @Description:
 */
public class LuceneDao {
    private final static Logger log = LoggerFactory.getLogger(LuceneDao.class);
    private Directory directory = null;
    private Analyzer analyzer = null;
    private String indexDer = null;

    public Directory getDirectory() throws IOException {
        if (directory == null) {
            File indexRepositroyFile = new File(this.indexDer);
            Path path = indexRepositroyFile.toPath();
            directory = FSDirectory.open(path);
        }
        return directory;
    }

    /* 查询索引 */
    public TableResultResponse<IndexObject> page(Integer pageNumber, Integer pageSize, String keyword) {
        IndexReader indexReader = null;
        TableResultResponse<IndexObject> pageQuery = null;
        List<IndexObject> searchResults = new ArrayList<>();

        try {
            indexReader = DirectoryReader.open(this.getDirectory());
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            Query query = QueryUtil.query(keyword, this.getAnalyzer(), "title", "description");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pageQuery;
    }


}