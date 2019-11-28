package com.fineframework.spring.app.healthcheck;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ヘルスチェック用コントローラ。
 * <p>
 * ロードバランサ(ELB)の死活監視用途を想定しているが、サーバの起動確認にも使用可能。
 * URL「/healthcheck」にリクエストを投げると、本コントローラが実行され、
 * 200 OKを返却する。
 * TODO ヘルスチェックがSpringに依存する必要はないので、サーブレットフィルタで実装するように修正する。
 * TODO DBの死活監視を実行するように改善する。
 * </p>
 * @author masanii15
 * @since 1.0
 */
@RestController
public class HealthCheckController {

    @RequestMapping("/healthcheck")
    public HealthCkeckRequest healthcheck() {
    	HealthCkeckRequest healthcheck = new HealthCkeckRequest();
    	healthcheck.setStatus("ok!");
    	return healthcheck;
    }
    
    class HealthCkeckRequest {
        private  String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        
    }
}