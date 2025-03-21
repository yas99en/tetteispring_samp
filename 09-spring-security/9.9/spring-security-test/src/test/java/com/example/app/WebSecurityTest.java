package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.config.AppConfig;
import com.example.config.WebMvcConfig;
import com.example.config.WebSecurityConfig;
import com.example.domain.model.Message;
import com.example.domain.service.account.MessageService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
// 9.9.1.3. staticメソッドのインポート staticメソッドのインポート例
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;

//　9.9.1.2. Spring Securityのサーブレットフィルタの追加 Spring SecurityのBeanを登録するコンフィギュレーションクラスの指定例
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class, WebSecurityConfig.class, WebMvcConfig.class })
@WebAppConfiguration
class WebSecurityTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;
    
    @Autowired
	MessageService service;

    // 9.9.1.2. Spring Securityのサーブレットフィルタの追加 Spring Securityのサーブレットフィルタの追加例
    @BeforeEach
    public void setUpMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        		// Spring Securityのサーブレットフィルタを追加
                .apply(springSecurity())
                .build();
    }

    // 9.9.2.1. フォーム認証のテスト 認証が成功するパターンのテストケース実装例
    @Test
    void testFormLogin() throws Exception {
        mockMvc.perform(
            formLogin().user("general").password("general"))
            .andExpect(status().isFound()).andExpect(redirectedUrl("/menu"))
            .andExpect(authenticated().withRoles("GENERAL"));
    }

    // 9.9.2.2. ログアウトのテスト ログアウト処理のテストケース実装例
    @WithMockUser
    @Test
    void testLogout() throws Exception {
        mockMvc.perform(logout())
            .andExpect(status().isFound()).andExpect(redirectedUrl("/logout"))
            .andExpect(unauthenticated());
    }
    
	// 9.9.3.1. アノテーションを使用した認証情報のセットアップ @WithMockUserの使用例
	@WithMockUser(username = "admin", roles = "ADMIN")
	@Test // 管理者ユーザーなので認可エラーは発生しない
	void testCreateByAdminRole() {
		Message createdMessage = service.create("Message1");
		assertEquals("Message1",createdMessage.getText());
	}
    
    // 9.9.3.1. アノテーションを使用した認証情報のセットアップ @WithUserDetailsの使用例
	@WithUserDetails("general")
	@Test
	void testCreateByUserRole() {
		 assertThrows(AccessDeniedException.class, () -> { // ロール不足により認可エラーが発生する
			 service.create("Message2");
		 });
	}
	
	// 9.9.3.1. アノテーションを使用した認証情報のセットアップ @WithAnonymousUserの使用例
	@WithAnonymousUser
	@Test
	void testAnonymous() {
		// テスト対象クラスでは匿名ユーザーによるメソッド実行ができないため認証エラーになる
		 assertThrows(AccessDeniedException.class, () -> {
			 service.create("Message3");
		 });
	}
	
    // 9.9.3.2. RequestPostProcessorを使用した認証情報のセットアップ RequestPostProcessorの使用例
    @Test
    void testPostMessageByAdminRole() throws Exception {
        mockMvc.perform(get("/admin").with(user("admin").roles("ADMIN")))
                .andExpect(status().isOk());
    }

    // 9.9.4. CSRFトークンチェック対象のリクエストに対するテスト 有効なCSRFトークン値を送信するための実装例
    @WithMockUser
    @Test
    void testCheckCSRF() throws Exception {
        mockMvc.perform(post("/accounts").with(csrf()))
                .andExpect(status().isOk());
    }

}
