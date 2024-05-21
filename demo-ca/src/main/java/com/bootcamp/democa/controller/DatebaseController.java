package com.bootcamp.democa.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class DatebaseController {

  private final static int[] database = new int[] { 3, 5, -10 };
  private final static HashMap<String, String> database2 = new HashMap<>();

  @GetMapping(value = "/getvalue")
  public String getValue(@RequestParam(value = "a") String a) {

    try {
      int i = Integer.valueOf(a);
      return String.valueOf(database[i]);
    } catch (NumberFormatException n) {
      return "NumberFormat error";
    } catch (ArrayIndexOutOfBoundsException a1) {
      return " the index is out of range of the array size";
    }
  }

  @GetMapping("/database/sorting")

  public void sort() {
    Comparator<Integer> c1 = (a, b) -> {
      if (a > b) {
        return -1;
      }
      return 1;
    };
    int[] newarr = Arrays.stream(database)
        .boxed()
        .sorted(c1)
        .mapToInt(e -> e.intValue())
        .toArray();

    for (int i = 0; i < database.length; i++) {
      database[i] = newarr[i];
    }
  }
  @GetMapping("/database2")
  public HashMap<String, String> add(@RequestParam(value = "a") String a,
      @RequestParam(value = "b") String b) {
        database2.put(a, b);

        return database2;
        

  }

}
