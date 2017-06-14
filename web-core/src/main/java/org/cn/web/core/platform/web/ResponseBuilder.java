package org.cn.web.core.platform.web;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    private Map<String, Object> map;

    public ResponseBuilder(Builder builder) {
        this.map = builder.map;
    }

    public Map<String, Object> getResponse() {
        return map;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        private final String STATUS_CODE = "statusCode";
        private final String MESSAGE = "message";
        private final String RESULT = "result";
        private final String ELAPSED_TIME = "elapsedTime";
        private final String STACK_TRACE = "stackTrace";
        private final long beginTime = System.currentTimeMillis();
        protected Map<String, Object> map = new HashMap<>();

        public Builder setStatusCode(Object statusCode) {
            this.map.put(STATUS_CODE, statusCode);
            return this;
        }

        public Builder setMessage(String message) {
            this.map.put(MESSAGE, message);
            return this;
        }

        public Builder setStackTrace(Object stack) {
            this.map.put(STACK_TRACE, String.valueOf(stack));
            return this;
        }

        public Builder setResult(Object result) {
            this.map.put(RESULT, result);
            return this;
        }

        public Builder addParameter(String key, Object value) {
            if (key == null) {
                key = "";
            }
            this.map.put(key, value);
            return this;
        }

        public ResponseBuilder build() {
            map.put(ELAPSED_TIME, System.currentTimeMillis() - beginTime);
            return new ResponseBuilder(this);
        }

        public String buildJSONString() {
            map.put(ELAPSED_TIME, System.currentTimeMillis() - beginTime);
            return JSON.toJSONString(map);
        }
    }

}
