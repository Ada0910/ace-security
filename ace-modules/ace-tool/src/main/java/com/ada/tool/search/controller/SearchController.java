package com.ada.tool.search.controller;

import com.ada.api.vo.search.IndexObject;
import com.ada.common.response.ObjectRestResponse;
import com.ada.common.response.TableResultResponse;
import com.ada.tool.search.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ada
 * @ClassName :SearchController
 * @date 2019/11/10 13:21
 * @Description:
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private LuceneService luceneService;

    @RequestMapping(value = "/w/{word}", method = RequestMethod.GET)
    public TableResultResponse<IndexObject> search(@PathVariable String word, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize) {
        return luceneService.page(pageNumber, pageSize, word);
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ObjectRestResponse createIndexObject(@RequestBody IndexObject indexObject) {
        luceneService.save(indexObject);
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/index", method = RequestMethod.DELETE)
    public ObjectRestResponse removeIndexObject(@RequestBody IndexObject indexObject) {
        luceneService.delete(indexObject);
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/index", method = RequestMethod.PATCH)
    public ObjectRestResponse batchCreateIndexObject(@RequestBody List<IndexObject> indexObjects) {
        for (IndexObject object : indexObjects) {
            luceneService.save(object);
        }
        return new ObjectRestResponse();
    }

    @RequestMapping(value = "/index", method = RequestMethod.PUT)
    public ObjectRestResponse updateIndexObject(@RequestBody IndexObject indexObject) {
        luceneService.update(indexObject);
        return new ObjectRestResponse();
    }
}
