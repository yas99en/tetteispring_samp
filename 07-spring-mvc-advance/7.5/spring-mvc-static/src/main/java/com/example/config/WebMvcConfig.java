package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.example")
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp();
	}
	
	// 7.5.2.2. HTTPのキャッシュ制御
	// 7.5.2.4. VersionResourceResolverの適用例
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// リクエストパスとリソースの物理的な格納場所をマッピング
		registry.addResourceHandler("/static/**")
				.addResourceLocations("classpath:/static/")
				// 有効期間を秒単位で指定 (604800=7日)
				.setCachePeriod(604800) 
				// ResourceResolverやResourceTransformerの実行結果をキャッシュするか指定する。キャッシュする場合はtrueを指定する。 
				// 変更を頻繁に行なうローカルの開発環境では、falseを指定するのが望ましい。
				.resourceChain(true)
				// VersionResourceResolverを追加し、addContentVersionStrategyメソッドの引数に対象リソースのパターンを指定する。 
				// この設定だと、/static/配下のすべてのリソースがバージョン付きの公開パスでアクセス可能になる。 
				// なお、VersionResourceResolverを追加するとCssLinkResourceTransformerも自動で追加される。
				.addResolver(new VersionResourceResolver()
						.addContentVersionStrategy("/**"));
	}
	
	
}
