package com.doge.blog.utils;

import com.doge.blog.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Administrator
 * @date : 2017/5/26 0026
 * @Description:
 */
public class RuntimeContext {

    private static final Logger logger = LoggerFactory.getLogger(RuntimeContext.class);

    private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
    private static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();
    private static ThreadLocal<User> users = new ThreadLocal<User>();

    public static void clean(){
        request.remove();
        response.remove();
        users.remove();
    }

    /**
     * 获取当前线程的request
     */
    public static HttpServletRequest currentRequest(){
        return request.get();
    }

    /**
     * 设置当前线程的request
     */
    public static void currentRequest(HttpServletRequest req){
        request.set(req);
    }

    /**
     * 获取当前线程的response
     */
    public static HttpServletResponse currentResponse(){
        return response.get();
    }

    /**
     * 设置当前线程的response
     */
    public static void currentResponse(HttpServletResponse resp){
        response.set(resp);
    }

    public static Long currentUserId(){
        return users.get() == null ? users.get().getId() : null;
    }

    public static String currentUserName(){
        return users.get() == null ? users.get().getNickname() : null;
    }

    public static User currentUser(){
        return users.get();
    }

    public static void currentUser(User u){
        users.set(u);
//        System.out.println(u);
    }

}

//public class RuntimeContext {
//    private static final Logger logger = LoggerFactory.getLogger(RuntimeContext.class);
//
//    private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
//    private static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();
//    private static ThreadLocal<User> users = new ThreadLocal<User>();
//
//
//    public static void clear() {
//        request.remove();
//        response.remove();
//        users.remove();
//    }
//    /**
//     * @return 获取本线程的request
//     */
//    public static HttpServletRequest currentRequest() {
//        return request.get();
//    }
//    /**
//     * @return 设置本线程的request
//     */
//    public static void currentRequest(HttpServletRequest req) {
//        request.set(req);
//    }
//    public static HttpServletResponse currentResponse() {
//        return response.get();
//    }
//
//    public static void currentResponse(HttpServletResponse req) {
//        response.set(req);
//    }
//    public static Long currentUserId() {
//        return users.get() != null ? users.get().getId() : null;
//    }
//
//    public static String currentUserName() {
//        return users.get() != null ? users.get().getUsername() : null;
//    }
//
//
//    public static User currentUser() {
//        return users.get();
//    }
//
//    public static void currentUser(User u) {
//        users.set(u);
//    }
//}
