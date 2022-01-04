package com.zconger.sburcoffeejava;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();
}
