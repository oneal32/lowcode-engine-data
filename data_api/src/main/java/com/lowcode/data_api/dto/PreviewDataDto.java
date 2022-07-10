/**
 * @author jianw
 * @date 2022/7/11
 **/
package com.lowcode.data_api.dto;

/**
 * @author jianw
 * @date 2022/7/11
 */
public class PreviewDataDto {
    private String packages;
    private String schema;

    public PreviewDataDto() {
    }

    public PreviewDataDto(String packages, String schema) {
        this.packages = packages;
        this.schema   = schema;
    }

    public String getPackages() {
        return packages;
    }

    public PreviewDataDto setPackages(String packages) {
        this.packages = packages;
        return this;
    }

    public String getSchema() {
        return schema;
    }

    public PreviewDataDto setSchema(String schema) {
        this.schema = schema;
        return this;
    }
}
