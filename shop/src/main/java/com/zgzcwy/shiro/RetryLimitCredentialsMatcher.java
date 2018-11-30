package com.zgzcwy.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
  
/** 
 * 验证器，增加了登录次数校验功能 
 */  
public class RetryLimitCredentialsMatcher extends SimpleCredentialsMatcher {  
    private static final Logger log = LoggerFactory.getLogger(RetryLimitCredentialsMatcher.class);  
  
    //集群中可能会导致出现验证多过5次的现象，因为AtomicInteger只能保证单节点并发  
    private Cache<String, AtomicInteger> lgoinRetryCache;  
  
    private int maxRetryCount = 5;  
  
    private String lgoinRetryCacheName;  
  
    public void setMaxRetryCount(int maxRetryCount) {  
        this.maxRetryCount = maxRetryCount;  
    }  
  
    public RetryLimitCredentialsMatcher(CacheManager cacheManager,String lgoinRetryCacheName,Integer maxRetryCount) {  
        this.lgoinRetryCacheName = lgoinRetryCacheName;  
        lgoinRetryCache = cacheManager.getCache(lgoinRetryCacheName);
        this.maxRetryCount=maxRetryCount;
    }  
  
    @Override  
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {  
        String username = (String) token.getPrincipal();  
        //retry count + 1  
        AtomicInteger retryCount = lgoinRetryCache.get(username);  
        if (null == retryCount) {  
            retryCount = new AtomicInteger(0);  
            lgoinRetryCache.put(username, retryCount);  
        }  
        if (retryCount.incrementAndGet() > maxRetryCount) {  
            log.warn("username: " + username + " tried to login more than 5 times in period");  
            throw new ExcessiveAttemptsException("密码尝试次数已超过5次，10分钟后再试"  
            );  
        }  
        boolean matches = super.doCredentialsMatch(token, info);  
        if (matches) {  
            //clear retry data  
            lgoinRetryCache.remove(username);  
        }  
        return matches;  
    }  
}
