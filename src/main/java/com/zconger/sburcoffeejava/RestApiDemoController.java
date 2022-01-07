package com.zconger.sburcoffeejava;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        coffees.addAll(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Blurdgerk"),
                new Coffee("Café Flemtoblaz"),
                new Coffee("Café Gleebovlarts")
        ));
    }

    @GetMapping(value = "/coffees")
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping(value = "/coffees/{id}")
    Optional<Object> getCoffeeById(@PathVariable String id) {
        for (Coffee c: coffees) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    @PostMapping(value = "/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping(value = "/coffees/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;
         for (Coffee c: coffees) {
             if (c.getId().equals(id)) {
                 coffeeIndex = coffees.indexOf(c);
                 coffees.set(coffeeIndex, coffee);
             }
         }
        return coffeeIndex == -1 ? postCoffee(coffee) : coffee;
    }
}
