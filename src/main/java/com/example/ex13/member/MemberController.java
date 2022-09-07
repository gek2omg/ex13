package com.example.ex13.member;

import com.fasterxml.jackson.core.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {

    @GetMapping("/memberForm")
    public String memberForm() {

        return "memberForm";
    }

    @PostMapping("/api/member")
    @ResponseBody
    public Map<String, String> memberFormProc(@RequestBody Map<String, Object> body) {
        Map<String, String> results = new HashMap<>();

        System.out.println(body.get("append"));

        String name = (String) body.get("name");

        if(name.equals("abc")) {
            results.put("message", "SUCCESS");
            results.put("content", "입력값이 성공적으로 저장 되었습니다.");
        } else {
            results.put("message", "FALSE");
            results.put("content", "처리중 오류가 발생했습니다.");
        }

        return results;
    }
}
