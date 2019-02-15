package com.hlc.apespace.user.mq;

import com.hlc.apespace.user.UserApplication;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
    *@ClassName JJwtTest
    *@Description todo
    *@Author Liang
    *@Date 2019/2/14 11:27
    *@Version 1.0
**/
@SpringBootTest(classes = UserApplication.class)
@RunWith(SpringRunner.class)
public class JJwtTest {

    @Test
    public void buildTest1() {
        JwtBuilder builder = Jwts.builder().setId("99")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "apespace");
        System.out.println(builder.compact());
    }

    @Test
    public void buildTest2() {
        long now = System.currentTimeMillis();
        long expira = now + (1 * 60 * 1000);
        JwtBuilder builder = Jwts.builder().setId("99")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "apespace")
                .setExpiration(new Date(expira));
        System.out.println(builder.compact());
    }

    @Test
    public void buildTest3() {
        long now = System.currentTimeMillis();
        long expira = now + (1 * 60 * 1000);
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("name","test");
        map.put("id",123456);

        JwtBuilder builder = Jwts.builder().setId("99")
                .setSubject("小白")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "apespace")
                .setExpiration(new Date(expira))
                .claim("isAdmin","false")
                .claim("role","develop");
        System.out.println(builder.compact());
    }


    @Test
    public void pareTest1() {
        String str = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5OSIsInN1YiI6IuWwj-eZvSIsImlhdCI6MTU1MDExNTIzNH0.L-Ua9EV4MuH9zDHvlFGjK-Wr4DObqceYfzJOKoYZQos";
        Claims claims = Jwts.parser().setSigningKey("apespace").parseClaimsJws(str).getBody();
        System.out.println("id: "+claims.getId());
        System.out.println("Subject: "+claims.getSubject());
        System.out.println("IssuedAt: "+claims.getIssuedAt());
    }


    @Test
    public void pareTest3() {
        String str = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5OSIsInN1YiI6IuWwj-eZvSIsImlhdCI6MTU1MDEyMTY3OSwiZXhwIjoxNTUwMTIxNzM5LCJpc0FkbWluIjoiZmFsc2UiLCJyb2xlIjoiZGV2ZWxvcCJ9.wFd5eoiBAgOzWEDO5EuNrvOgzonAyy4jtUNKaHI_cao";
        Claims claims = Jwts.parser().setSigningKey("apespace").parseClaimsJws(str).getBody();
        System.out.println("id: "+claims.getId());
        System.out.println("Subject: "+claims.getSubject());
        System.out.println("IssuedAt: "+claims.getIssuedAt());
        System.out.println("isAdmin: "+claims.get("isAdmin"));
        System.out.println("role: "+claims.get("role"));
        System.out.println("name: "+claims.get("name"));
    }

}
