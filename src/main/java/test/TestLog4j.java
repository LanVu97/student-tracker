/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.apache.log4j.Logger;

/**
 *
 * @author default
 */
public class TestLog4j {
    private static final Logger _Logger = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args) {
        _Logger.info("abc");
        _Logger.error("err abc");
    }
}
