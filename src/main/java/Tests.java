package com.company;

import org.junit.Test;

import org.junit.Assert;

public class Tests {

    @Test(expected = NumberFormatException.class)
    public void testEmptyString() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testStringWord(){
        Integer.decode("meow");
    }

    @Test(expected = NullPointerException.class)
    public void testNull(){
        Integer.decode(null);
    }

    @Test
    public void testNegative(){
        Assert.assertEquals(-7, Integer.decode("-7").longValue());
    }

    @Test
    public void testPositive(){
        Assert.assertEquals(4, Integer.decode("+4").longValue());
    }

    @Test
    public void testWithoutSign(){
        Assert.assertEquals(55, Integer.decode("55").longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void testSignBetweenNum() {
        Integer.decode("12-3");
    }

    @Test(expected = NumberFormatException.class)
    public void testSignSpaces() {
        Integer.decode("- 12");
    }

    @Test(expected = NumberFormatException.class)
    public void testNumSpaces() {
        Integer.decode("19 0");
    }

    @Test
    public void testHexFormat1(){
        Assert.assertEquals(4779, Integer.decode("0x12AB").longValue());
    }

    @Test
    public void testHexFormat2(){
        Assert.assertEquals(13, Integer.decode("0Xd").longValue());
    }

    @Test
    public void testHexFormat3(){
        Assert.assertEquals(171, Integer.decode("#AB").longValue());
    }

    @Test
    public void testOctalFormat(){
        Assert.assertEquals(59, Integer.decode("073").longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void testDouble1(){
        Integer.decode("155.5");
    }

    @Test(expected = NumberFormatException.class)
    public void testDouble2(){
        Integer.decode("82,6");
    }

    @Test
    public void testIntMinValue(){
        Assert.assertEquals(Integer.MIN_VALUE, Integer.decode("-2147483648").longValue());
    }

    @Test
    public void testIntMaxValue(){
        Assert.assertEquals(Integer.MAX_VALUE, Integer.decode("2147483647").longValue());
    }
}
