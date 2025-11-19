package com.bluesky.apollo.core;

import com.bluesky.apollo.exception.ApolloException;
import com.bluesky.apollo.model.ItemResponse;
import com.bluesky.apollo.model.PulishItemRequest;
import com.bluesky.apollo.model.ReleaseRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对外提供的易用API
 *
 * @author lantian
 * @date 2025/11/17
 */
public class ApolloConfigServiceCore {
    private final ApolloClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    public ApolloConfigServiceCore(ApolloClient client) {
        this.client = client;
    }

    /*
     * 创建或更新单个配置项（OpenAPI 的 item接口本身会做 create/update 逻辑）
     */
    public void createOrUpdateItem(String appId, String env, String cluster, String namespace,
                                      String key, String value, String comment, String operator) {
        try {
            String path = String.format("/openapi/v1/apps/%s/envs/%s/clusters/%s/namespaces/%s/items/",
                    urlEncode(appId), urlEncode(env), urlEncode(cluster), urlEncode(namespace));
            PulishItemRequest req = new PulishItemRequest(key, value, comment, operator);
            String json = mapper.writeValueAsString(req);
            client.post(path, json);
        } catch (Exception e) {
            throw new ApolloException("createOrUpdateItem failed", e);
        }
    }

    /*
     * 发布命名空间（创建release）
     */
    public void publishNamespace(String appId, String env, String cluster, String namespace,
                                    String releaseTitle, String releaseComment, String releasedBy) {
        try {
            String path = String.format("/openapi/v1/apps/%s/envs/%s/clusters/%s/namespaces/%s/releases",
                    urlEncode(appId), urlEncode(env), urlEncode(cluster), urlEncode(namespace));
            ReleaseRequest req = new ReleaseRequest(releaseTitle, releasedBy, releaseComment);
            String json = mapper.writeValueAsString(req);
            client.post(path, json);
        } catch (Exception e) {
            throw new ApolloException("publishNamespace failed", e);
        }
    }

    /*
     * 一键创建/更新并发布（类似Diamond的publidhSingle）
     */
    public void publishSingle(String appId, String env, String cluster, String namespace,
                                  String key, String value, String comment, String operator) {
        createOrUpdateItem(appId, env, cluster, namespace, key, value, comment, operator);
        publishNamespace(appId, env, cluster, namespace, "Auto release - " + key, comment, operator);
    }

    /**
     * 获取单个配置项
     */
    public String getItem(String appId, String env, String cluster, String namespace, String key) {
        try {
            String path = String.format("/openapi/v1/apps/%s/envs/%s/clusters/%s/namespaces/%s/items/%s",
                    urlEncode(appId), urlEncode(env), urlEncode(cluster), urlEncode(namespace), urlEncode(key));
            String resp = client.get(path);
            ItemResponse item = mapper.readValue(resp, ItemResponse.class);
            return item.getValue();
        } catch (Exception e) {
            throw new ApolloException("getItem failed", e);
        }
    }

    /*
     * 删除单个配置项
     */
    public void deleteItem(String appId, String env, String cluster, String namespace, String key, String operator) {
        try {
            String path = String.format("/openapi/v1/apps/%s/envs/%s/clusters/%s/namespaces/%s/items/%s",
                    urlEncode(appId), urlEncode(env), urlEncode(cluster), urlEncode(namespace), urlEncode(key));
            Map<String, Object> body = new HashMap<>();
            body.put("operator", operator);
            String json = mapper.writeValueAsString(body);
            client.delete(path + "?operator=" + urlEncode(operator));
        } catch (Exception e) {
            throw new ApolloException("deleteItem failed", e);
        }
    }

    /**
     * 获取命名空间下的所有配置项
     */
    public List<ItemResponse> listNamespaceItems(String appId, String env, String cluster, String namespace) {
        try {
            String path = String.format("/openapi/v1/apps/%s/envs/%s/clusters/%s/namespaces/%s/items",
                    urlEncode(appId), urlEncode(env), urlEncode(cluster), urlEncode(namespace));
            String resp = client.get(path);
            return mapper.readValue(resp, new TypeReference<List<ItemResponse>>() {});
        } catch (Exception e) {
            throw new ApolloException("listNnamespaceItems failed", e);
        }
    }
    // getItem, deleteItem, listNamespaceItems ...

    private String urlEncode(String s) {
        try {
            return java.net.URLEncoder.encode(s, "UTF-8");
        } catch (Exception e) {
            return s;
        }
    }
}
