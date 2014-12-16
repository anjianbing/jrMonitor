package com.jd.jrjt;

import com.jd.jrjt.util.Base64;
import com.jd.jrjt.util.CompressStringUtil;
import com.jd.jrjt.util.XMLHelper;

/**
 * Created by songyongzhong on 2014/9/20.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("1111111111111111111122222222222222222");
        //String xml="<result><status>1</status><returnValue>UEsDBBQACAAIAEWhNEUAAAAAAAAAAAAAAAALAAAAcmVwb3J0cy54bWyVVN9P01AUfsbE/+HmvuPawcSSriRONETFZOAfcGmPW6Xrnb3tdPw3oslCiCYg/mDOzYAQZAY6wD2YoA8+KU/G+CAG4227jS3tEnxp7znnft937j1frjz2IGegAlhMp2YSixcEjMBUqaabmSS+dvk6RmPK+XOyqrM05KllM4RmiD1JkzguiMOCxL8JQRBG4iMYOaZuT5IcJPHSUnWhuvBi8b1b23Q3ducrle1f++7u59XFehUj5szcsjKE622fVA+Xaxjdc8Aq3mZgTVxJ4rsam73P/FSrkqKOafPuMLJABb0A07qn0u4AiYnR+MXRYQn3tMo3ez+PMtzrjKMb2ripnTINCtJgN1cgnQbCqOlxSJLfecA9XcwD4x2JosDTtgXETgNzjKDL3m1TWb5KkbwdXPHD+Vdfnm+9+bB/0ihVnnq3U64vf0MYZQmbKjIbcuOWRa0kvkMMBhjp7KpF58BsJ/gZB+TWtZia7rEyLzcg6xzrrwZkk49B8T5yzF8GWTVoQnE/rv+RY+0oqBWI4YDybG3vcOeJHAsinzXWoQ0JaFR1cmByO0TKNB9X/pY31o6ipYaHxLgQFyVpiE9GvCQkEmeVValhQAZuQAGMSOFG6e3x8teVnWjhpWpt8z+lIlXqvw8+HZTdR9EqTXf1eKu+/mPlZ6N0VjVmE+4Zvc/Uto4apXffXx5G63ELi9E6cizCLTJojkq8cMKcUrOUGqksqLO91u0YvCeboszua33wvHsTGCMZDsdBK95hfPpgo7L3urkWHLE76289tVQYEF3zYRmLaA6x/YchDOxX9aGtEYdREYVugG+/vqhQ1R9E9KV7r1as82z1Rkz5B1BLBwiya3vGewIAAKMFAABQSwECFAAUAAgACABFoTRFsmt7xnsCAACjBQAACwAAAAAAAAAAAAAAAAAAAAAAwb3J0cy54bWxQSwUGAAAAAAEAAQA5AAAAtAIAAAAA</returnValue></result>";
        String xml="<result><status>1</status>"+
        "<returnValue>UEsDBBQACAAIAEWhNEUAAAAAAAAAAAAAAAALAAAAcmVwb3J0cy54bWyVVN9P01AUfsbE/+HmvuPawcSSriRONETFZOAfcGmPW6Xrnb3tdPw3"+
        "oslCiCYg/mDOzYAQZAY6wD2YoA8+KU/G+CAG4227jS3tEnxp7znnft937j1frjz2IGegAlhMp2YSixcEjMBUqaabmSS+dvk6RmPK+XOyqrM0"+
        "5KllM4RmiD1JkzguiMOCxL8JQRBG4iMYOaZuT5IcJPHSUnWhuvBi8b1b23Q3ducrle1f++7u59XFehUj5szcsjKE622fVA+Xaxjdc8Aq3mZg"+
        "TVxJ4rsam73P/FSrkqKOafPuMLJABb0A07qn0u4AiYnR+MXRYQn3tMo3ez+PMtzrjKMb2ripnTINCtJgN1cgnQbCqOlxSJLfecA9XcwD4x2J"+
        "osDTtgXETgNzjKDL3m1TWb5KkbwdXPHD+Vdfnm+9+bB/0ihVnnq3U64vf0MYZQmbKjIbcuOWRa0kvkMMBhjp7KpF58BsJ/gZB+TWtZia7rEy"+
        "Lzcg6xzrrwZkk49B8T5yzF8GWTVoQnE/rv+RY+0oqBWI4YDybG3vcOeJHAsinzXWoQ0JaFR1cmByO0TKNB9X/pY31o6ipYaHxLgQFyVpiE9G"+
        "vCQkEmeVValhQAZuQAGMSOFG6e3x8teVnWjhpWpt8z+lIlXqvw8+HZTdR9EqTXf1eKu+/mPlZ6N0VjVmE+4Zvc/Uto4apXffXx5G63ELi9E6"+
        "cizCLTJojkq8cMKcUrOUGqksqLO91u0YvCeboszua33wvHsTGCMZDsdBK95hfPpgo7L3urkWHLE76289tVQYEF3zYRmLaA6x/YchDOxX9aGt"+
        "EYdREYVugG+/vqhQ1R9E9KV7r1as82z1Rkz5B1BLBwiya3vGewIAAKMFAABQSwECFAAUAAgACABFoTRFsmt7xnsCAACjBQAACwAAAAAAAAAA"+
        "AAAAAAAAAAAAcmVwb3J0cy54bWxQSwUGAAAAAAEAAQA5AAAAtAIAAAAA</returnValue></result>";

        String base6 = XMLHelper.getBase64Char(xml);
        System.out.println(base6);
        Base64 base64=new Base64();
        byte [] re= base64.decode(base6);
        System.out.println("1111111111111111111111");
        String bxml=new CompressStringUtil().decompress(re);


        System.out.println(bxml);
        System.out.println("3333333333333333==="+bxml);
        System.out.println("XML===="+XMLHelper.getSchoolCheckResult(bxml));

    }



}
