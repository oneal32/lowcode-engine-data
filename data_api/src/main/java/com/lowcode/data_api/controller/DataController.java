/**
 * @author jianw
 * @date 2022/7/11
 **/
package com.lowcode.data_api.controller;

import com.lowcode.data_api.dto.PreviewDataDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianw
 * @date 2022/7/11
 */
@Controller
@CrossOrigin(
        origins = {"http://localhost:5556"},
        allowCredentials = "true",
        methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.POST}
)
public class DataController {
    private Map<String, String> schemaMap = new HashMap<>();
    private Map<String,String> packagesMap = new HashMap<>();

    @RequestMapping(path = "savePreviewData")
    @ResponseBody
    public Map<String,String> savePreviewData(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody  Map<String,String> requestBody
    ){
        schemaMap.put(requestBody.get("scenarioName"),requestBody.get("schema"));
        packagesMap.put(requestBody.get("scenarioName"), requestBody.get("packages"));
        Map<String,String> result = new HashMap<>();
        result.put("status", "ok");
        return result;
    }


    @RequestMapping(path = "getPreviewData")
    @ResponseBody
    public PreviewDataDto getPreviewData(String scenarioName){
        String scheme = schemaMap.get(scenarioName);
        String packages = packagesMap.get(scenarioName);

        if(scheme!= null && packages != null){
            return new PreviewDataDto(packages, scheme);
        }
        return new PreviewDataDto();
    }
}
