package kz.halykbank.halykbank.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.halykbank.halykbank.model.User;
import kz.halykbank.halykbank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;
    @GetMapping("/{login}/{password}")
    public ResponseEntity<String> login(@PathVariable(name="login") String login,
                                        @PathVariable(name="password") String password) throws JsonProcessingException {
        Optional<User> optionalUser = userService.getUserByLogin(login);
        Map<String, String> responseBody = new HashMap<>();

        if (!optionalUser.isEmpty() && optionalUser.get().getPassword().equals(password)) {
            responseBody.put("status", "true");
        } else {
            responseBody.put("status", "false");
        }

        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = mapper.writeValueAsString(responseBody);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsonResponse);
    }
}


class MyObject{
    String status;

    public MyObject(String statuse) {
        this.status = status;

    }
}