package com.ada.tool.controller;

import com.ada.api.vo.search.IndexObject;
import com.ada.common.response.TableResultResponse;
import com.ada.tool.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/w/{word}",method = RequestMethod.GET)
    public TableResultResponse<IndexObject> search(@PathVariable String word, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize){
        return luceneService.page(pageNumber,pageSize,word);
    }
}
