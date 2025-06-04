package com.yikes.simpleredis;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {
    private final RedisService redisService;

    @PostMapping("/set")
    public ResponseEntity<String> setValue(@RequestParam String key, @RequestParam String value) {
        redisService.setValue(key, value);
        return ResponseEntity.ok("Saved to Redis");
    }

    @GetMapping("/get")
    public ResponseEntity<String> getValue(@RequestParam String key) {
        String value = redisService.getValue(key);
        return ResponseEntity.ok(value != null ? value : "Not Found");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteValue(@RequestParam String key) {
        redisService.deleteValue(key);
        return ResponseEntity.ok("Deleted from Redis");
    }
}