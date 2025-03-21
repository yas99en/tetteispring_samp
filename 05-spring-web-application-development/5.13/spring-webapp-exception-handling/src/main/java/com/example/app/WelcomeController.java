package com.example.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class WelcomeController {
    @GetMapping
    public String root(Model model) {
        return "index";
    }

    // 5.13.3 ステータスコードを使用して遷移先を指定する際の設定例
    @GetMapping("internal-server-error")
    public ResponseEntity<Void> internalServerError(Model model) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 5.13.3 デフォルトの遷移先を指定する際の設定例
    @PostMapping("teapot")
    public String teapot(Model model) {
        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
    }

    // 5.13.3 型階層を意識した遷移先の指定例
    @GetMapping("exception-type-hierarchy")
    public String exceptionTypeHierarchy(Model model) throws IOException {
        throw new FileNotFoundException();
    }

    // 5.13.5 共通的な例外ハンドラの実装例
    @GetMapping("common-exception-handler-throughout-app")
    public String commonExceptionHandlerThroughoutApp(Model model) {
        throw new ArithmeticException();
    }

    // 5.13.6 @ResponseStatusを付与した例外クラスの作成例
    @GetMapping("response-status")
    public String responseStatus(Model model) {
        throw new ResourceNotFoundException();
    }
}
