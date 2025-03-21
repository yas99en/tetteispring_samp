package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("accounts")
public class AccountController {

    // 5.4.1 リクエストパスの指定例
    @RequestMapping("me/email")
    public String showEmail(Model model) {
        return "account/email";
    }

    // 5.4.1 リクエストパスの複数指定例
    @RequestMapping({ "me/email2", "my/email2" })
    public String showEmail2(Model model) {
        return "account/email2";
    }

    // 5.4.2 URIテンプレート形式のパスパターンの指定例
    @RequestMapping("{accountId}")
    public String showAccount(@PathVariable String accountId, Model model) {
        model.addAttribute("accountId", accountId);
        return "account/profile";
    }

    // 5.4.3 HTTPメソッドの指定例
    @RequestMapping(path = "http-method-demo/{accountId}", method = RequestMethod.GET)
    public String showAccount2(@PathVariable String accountId, Model model) {
        model.addAttribute("accountId", accountId);
        return "account/profile2";
    }

    // 5.4.3 HTTPメソッドの複数指定例
    @GetMapping("http-method-demo2/{accountId}")
    public String showAccount3(@PathVariable String accountId, Model model) {
        model.addAttribute("accountId", accountId);
        return "account/profile3";
    }

    // 5.4.4 リクエストパラメータを使用したリクエストマッピングの指定例
    @RequestMapping(path = "create", method = { RequestMethod.GET, RequestMethod.POST }, params = "form")
    public String form(Model model) {
        model.addAttribute(new AccountCreateForm());
        return "account/form";
    }

    @PostMapping(path = "create", params = "confirm")
    public String confirm(@Validated AccountCreateForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "account/form";
        }
        return "account/confirm";
    }

    @PostMapping(path = "create", params = "redo")
    public String redo(AccountCreateForm form) {
        return "account/form";
    }

    @PostMapping(path = "create", params = "create")
    public String create(@Validated AccountCreateForm form, BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "account/form";
        }
        return "redirect:/accounts/create?complete";
    }

    @GetMapping(path = "create", params = "complete")
    public String complete() {
        return "account/complete";
    }

    // 5.4.5 リクエストヘッダーの指定例
    @PostMapping(path = "request-header-demo/create", headers = "X-Migration=true")
    @ResponseBody
    public Account postMigrationAccount(@Validated @RequestBody Account account) {
        return account;
    }

    // 5.4.6 Content-Typeの指定例
    @PostMapping(path = "content-type-demo/create", consumes = "application/json")
    @ResponseBody
    public Account postAccount(@Validated @RequestBody Account account) {
        return account;
    }

    // 5.4.7 Acceptの指定例
    @PostMapping(path = "accept-demo/create", produces = "application/json")
    @ResponseBody
    public Account postAccountAccept(@Validated @RequestBody Account account) {
        return account;
    }
}
