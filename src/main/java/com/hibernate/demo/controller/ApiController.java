package com.hibernate.demo.controller;

import com.hibernate.demo.entity.api.LoveCalculator;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api")
public class ApiController {

    @GetMapping("/calculator")
    @ResponseBody
    public LoveCalculator calculator(@RequestParam String firstName, @RequestParam String lastName){

        HttpResponse<LoveCalculator> response = Unirest.get("https://love-calculator.p.rapidapi.com/getPercentage")
                .queryString("fname", firstName)
                .queryString("sname", lastName)
                .header("x-rapidapi-key", "160066640amsh1c5bd508ff69839p170e29jsn277e6f29b2fa")
                .header("x-rapidapi-host", "love-calculator.p.rapidapi.com")
                .asObject(LoveCalculator.class);

        return response.getBody();

    }

    @GetMapping("/multiple")
    @ResponseBody
    public List<LoveCalculator> multipleCalculation(){
        List<LoveCalculator> list = new ArrayList<>();
        Map<String, String> nameMap = new HashMap<>();

        //Add the pair to check
        nameMap.put("Michele", "Elena");
        nameMap.put("Mario", "Arturo");
        nameMap.put("Dybala", "Karina");
        nameMap.put("Gigio", "Antonio");
        nameMap.put("Luigi", "Andrea");

        //For each pair create a list of results
        nameMap.forEach((key, value) -> list.add(calculator(key, value)));

        return list;

    }
}
